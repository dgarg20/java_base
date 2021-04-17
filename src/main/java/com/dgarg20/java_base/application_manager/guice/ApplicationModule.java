package com.dgarg20.java_base.application_manager.guice;

import com.dgarg20.java_base.application_manager.configurations.ServiceConfiguration;
import com.dgarg20.java_base.service.ExpenseService;
import com.dgarg20.java_base.service.ExpenseServiceImpl;
import com.dgarg20.java_base.service.GroupService;
import com.dgarg20.java_base.service.GroupServiceIMpl;
import com.google.inject.*;
import io.dropwizard.db.DataSourceFactory;
import org.hibernate.SessionFactory;

public class ApplicationModule extends AbstractModule {
/*
    public void configure(Binder binder) {

    }*/

    @Override
    protected void configure() {
        bind(ExpenseService.class).to(ExpenseServiceImpl.class);
        bind(GroupService.class).to(GroupServiceIMpl.class);
    }

   /* @Provides
    @Named("oorFile")
    @Singleton
    public String getOORFile(final Provider<ServiceConfiguration> serviceConfigurationProvider){
        return serviceConfigurationProvider.get().getOorFileName();
    }*/


   @Provides
    public DataSourceFactory getDataSourceConfig(Provider<ServiceConfiguration> serviceConfigurationProvider){
       return serviceConfigurationProvider.get().getDataSourceConfig();
   }

   @Provides
    public SessionFactory getSessionFactory(Provider<ServiceConfiguration> serviceConfigurationProvider){
       return serviceConfigurationProvider.get().getSessionFactory();
   }
}
