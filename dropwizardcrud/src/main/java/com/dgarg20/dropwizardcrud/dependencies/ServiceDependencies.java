package com.dgarg20.dropwizardcrud.dependencies;

import com.dgarg20.dropwizardcrud.controller.CrudResources;
import com.dgarg20.dropwizardcrud.repositories.CrudDbRepository;
import com.dgarg20.dropwizardcrud.repositories.CrudDbRepositoryImpl;
import com.dgarg20.dropwizardcrud.services.CrudService;
import com.dgarg20.dropwizardcrud.services.CrudServiceImpl;
import com.google.inject.AbstractModule;

public class ServiceDependencies extends AbstractModule {
    protected void configure() {
        bind(CrudDbRepository.class).to(CrudDbRepositoryImpl.class);
        bind(CrudService.class).to(CrudServiceImpl.class);
        bind(CrudResources.class).to(CrudResources.class).asEagerSingleton();
    }
}
