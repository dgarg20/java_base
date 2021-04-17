package com.dgarg20.java_base.application_manager.configurations;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import lombok.*;
import org.hibernate.SessionFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;



@NoArgsConstructor
@Getter
@AllArgsConstructor
public class ServiceConfiguration extends Configuration {
    private String serviceName;

    @JsonProperty("dataSource")
    private DataSourceFactory dataSourceConfig;

    /*@Valid
    @NotNull
    private SwaggerBundleConfiguration swaggerBundleConfiguration;*/

    @Valid
    @NotNull
    private String oorFileName;

    @JsonProperty("swagger")
    private SwaggerBundleConfiguration swaggerBundleConfiguration;

    @Setter
    private SessionFactory sessionFactory;
}
