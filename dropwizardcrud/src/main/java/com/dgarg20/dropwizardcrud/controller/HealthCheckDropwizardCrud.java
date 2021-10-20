package com.dgarg20.dropwizardcrud.controller;

import com.codahale.metrics.health.HealthCheck;
import com.dgarg20.dropwizardcrud.services.CrudService;
import com.google.inject.Inject;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j

public class HealthCheckDropwizardCrud extends HealthCheck {
    private static final String HEALTHY = "The Dropwizard blog Service is healthy for read and write";
    private static final String UNHEALTHY = "The Dropwizard blog Service is not healthy. ";

    private final CrudService crudService;
    @Inject
    public HealthCheckDropwizardCrud(CrudService crudService){
        this.crudService = crudService;
    }


    protected Result check() throws Exception {
        String mySqlHealthStatus = null;
        if (mySqlHealthStatus == null) {
            return Result.healthy(HEALTHY);
        } else {
            return Result.unhealthy(UNHEALTHY , mySqlHealthStatus);
        }

    }
}
