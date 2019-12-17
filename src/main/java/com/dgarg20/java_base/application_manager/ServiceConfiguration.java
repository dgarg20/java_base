package com.dgarg20.java_base.application_manager;

import com.dgarg20.java_base.entities.DataSourceConfig;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ServiceConfiguration extends Configuration {
    private String serviceName;

    @JsonProperty("database")
    private DataSourceConfig dataSourceConfig;

    /*@Valid
    @NotNull
    private SwaggerBundleConfiguration swaggerBundleConfiguration;*/

    @Valid
    @NotNull
    private String oorFileName;

    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;



}
