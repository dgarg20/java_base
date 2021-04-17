package com.dgarg20.java_base.application_manager.managed;

import com.dgarg20.java_base.application_manager.configurations.ServiceConfiguration;
import com.google.inject.Inject;
import io.dropwizard.lifecycle.Managed;

public class ManagedExecutorService implements Managed {
    private ServiceConfiguration serviceConfiguration;

    @Inject
    public void ManagedExecutorService(ServiceConfiguration serviceConfiguration){
        this.serviceConfiguration = serviceConfiguration;
    }

    @Override
    public void start() throws Exception {

    }

    @Override
    public void stop() throws Exception {

    }
}
