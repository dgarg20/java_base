package com.dgarg20.dropwizardcrud;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@Data
public class DropwizardCrudConfiguration extends Configuration {
    private static final String DATABASE = "database";


    @Valid
    @NotNull
    @JsonProperty(DATABASE)
    private DataSourceFactory dataSourceFactory;

    @Valid
    @NotNull
    private SwaggerBundleConfiguration swaggerBundleConfiguration;

    /*private DataSourceFactory dataSourceFactory = new DataSourceFactory();


    private SwaggerBundleConfiguration swc;

    public DataSourceFactory getDataSourceFactory() {
        return dataSourceFactory;
    }

    @JsonProperty(DATABASE)
    public void setDataSourceFactory(final DataSourceFactory dataSourceFactory) {
        this.dataSourceFactory = dataSourceFactory;
    }


    public SwaggerBundleConfiguration getSwaggerBundle(){
        return null;
    }*/
}
