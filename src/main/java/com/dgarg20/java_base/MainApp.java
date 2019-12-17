package com.dgarg20.java_base;

import com.dgarg20.java_base.application_manager.healthcheck.ApplicationHealthCheck;
import com.dgarg20.java_base.application_manager.ApplicationModule;
import com.dgarg20.java_base.application_manager.ServiceConfiguration;
import com.dgarg20.java_base.application_manager.filters.RequestFilter;
import com.dgarg20.java_base.application_manager.healthcheck.RotationHealthCheck;
import com.dgarg20.java_base.resource.ExpenseResource;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;

import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import io.swagger.v3.oas.integration.SwaggerConfiguration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;


import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class MainApp extends Application<ServiceConfiguration> {

    /**lombok plugin used if don't want it import "import org.slf4j.Logger;"
     *
     */
    //private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public static void main(String[] args)throws Exception {
        MDC.put("trans.id", UUID.randomUUID().toString());
        final MainApp mainApp = new MainApp();
        mainApp.run(args);
    }

    public void initialize(Bootstrap<ServiceConfiguration> bootstrap){
        super.initialize(bootstrap);
        GuiceBundle<ServiceConfiguration> guiceBundle = GuiceBundle.<ServiceConfiguration>newBuilder()
                .addModule(new ApplicationModule())
                .setConfigClass(ServiceConfiguration.class)
                .enableAutoConfig(getClass().getPackage().getName())
                //enableGuiceEnforcer(false)   to be used with dropwizard juicer.
                .build();
        bootstrap.addBundle(guiceBundle);

        bootstrap.addBundle(new SwaggerBundle<ServiceConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(ServiceConfiguration configuration) {
                return configuration.swaggerBundleConfiguration;
            }
        });
    }


    public void run(final ServiceConfiguration serviceConfiguration, final Environment environment) throws Exception {

        // Loading MainApp
        environment.jersey().register(new OpenApiResource()
                .openApiConfiguration(getSwaggerConfiguration()));

        //Its Used to tell jackson that all json's received will be in snake case to map them to json class
        environment.getObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        //Registering the health check
        environment.healthChecks().register("application_check" ,new ApplicationHealthCheck());
        //environment.healthChecks().register("rotation" ,new RotationHealthCheck());
        environment.jersey().register("com.dgarg20.java_base.application_manager.filters");
        //Injector injector = Guice.createInjector(new ApplicationModule());
        //final ExpenseResource expenseResource = injector.getInstance(ExpenseResource.class);
        final ExpenseResource expenseResource = new ExpenseResource();
        environment.jersey().register(expenseResource);
    }

    private SwaggerConfiguration getSwaggerConfiguration() {
        OpenAPI oas = new OpenAPI();
        Info info = new Info()
                .title("Java Simple Application")
                .description("RESTful greetings for you.")
                .termsOfService("http://localhost:8001/terms")
                .contact(new Contact().email("dgarg20@gmail.com"));

        oas.info(info);
        return new SwaggerConfiguration()
                .openAPI(oas)
                .prettyPrint(true)
                .resourcePackages(Stream.of("com.dagrg20.java_base")
                        .collect(Collectors.toSet()));
    }
}
