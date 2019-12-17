package com.dgarg20.java_base.application_manager;

import com.google.inject.*;

import javax.inject.Named;

public class ApplicationModule extends AbstractModule {
/*
    public void configure(Binder binder) {

    }*/

    @Override
    protected void configure() {

    }

   /* @Provides
    @Named("oorFile")
    @Singleton
    public String getOORFile(final Provider<ServiceConfiguration> serviceConfigurationProvider){
        return serviceConfigurationProvider.get().getOorFileName();
    }*/
}
