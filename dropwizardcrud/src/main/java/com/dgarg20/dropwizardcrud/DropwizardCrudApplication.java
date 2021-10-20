package com.dgarg20.dropwizardcrud;

import com.dgarg20.dropwizardcrud.controller.CrudResources;
import com.dgarg20.dropwizardcrud.controller.HealthCheckDropwizardCrud;
import com.dgarg20.dropwizardcrud.dependencies.ServiceDependencies;
import com.dgarg20.dropwizardcrud.services.CrudService;
import com.dgarg20.dropwizardcrud.services.CrudServiceImpl;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import lombok.extern.slf4j.Slf4j;

import org.skife.jdbi.v2.DBI;

import javax.sql.DataSource;


@Slf4j
public class DropwizardCrudApplication extends Application<DropwizardCrudConfiguration> {
    private static final String SQL = "sql";

    public static void main(String[] args)throws Exception{
        new DropwizardCrudApplication().run(args);
        log.info("Application Started...");
    }

    public void initialize(Bootstrap<DropwizardCrudConfiguration> bootstrap){
        bootstrap.addBundle(new SwaggerBundle<DropwizardCrudConfiguration>() {

            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(DropwizardCrudConfiguration configuration) {
                return configuration.getSwaggerBundleConfiguration();
            }
        });

        GuiceBundle.Builder<DropwizardCrudConfiguration> guiceBundleBuilder = GuiceBundle.newBuilder();

        GuiceBundle<DropwizardCrudConfiguration> guiceBundle = guiceBundleBuilder
                .addModule(new ServiceDependencies())
                //the below register the resource with the jerssey
                .enableAutoConfig(getClass().getPackage().getName())
                .setConfigClass(DropwizardCrudConfiguration.class)
                .build(Stage.DEVELOPMENT);
        bootstrap.addBundle(guiceBundle);



        final HibernateBundle<DropwizardCrudConfiguration> hibernateBundle = new HibernateBundle<DropwizardCrudConfiguration>() {
            public PooledDataSourceFactory getDataSourceFactory(DropwizardCrudConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        };

        bootstrap.addBundle(hibernateBundle);
    }


    public void run(DropwizardCrudConfiguration configuration, Environment environment) throws Exception {

        // Datasource configuration
        final DataSource dataSource = configuration.getDataSourceFactory().build(environment.metrics(), SQL);

        DBI dbi = new DBI(dataSource);

//        Injector injector = Guice.createInjector(new ServiceDependencies());
        final HealthCheckDropwizardCrud hcdc = new HealthCheckDropwizardCrud();
        environment.healthChecks().register("", hcdc);

        // Register resources
        environment.jersey().register(CrudResources.class);
    }
}
