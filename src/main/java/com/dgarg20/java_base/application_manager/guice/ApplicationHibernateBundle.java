package com.dgarg20.java_base.application_manager.guice;

import com.dgarg20.java_base.application_manager.configurations.ServiceConfiguration;
import com.dgarg20.java_base.entities.BaseEntity;
import com.google.common.collect.ImmutableList;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.SessionFactoryFactory;
import org.hibernate.annotations.Entity;
import org.reflections.Reflections;

import java.util.Set;


/**
 * Created by Deepanshu Garg on 29/11/20.
 */
public class ApplicationHibernateBundle extends HibernateBundle<ServiceConfiguration> {
    private static Reflections reflections = new Reflections();

    public ApplicationHibernateBundle() {
        super(getEntities(), new SessionFactoryFactory());
    }

    @Override
    public DataSourceFactory getDataSourceFactory(ServiceConfiguration serviceConfiguration) {
        return null;
    }

    private static ImmutableList<Class<?>> getEntities() {
        Set<Class<?>> entityClasses = reflections.getTypesAnnotatedWith(Entity.class);
        return ImmutableList.copyOf(entityClasses);
    }


    private static String getEntitiesPackageName() {
        return BaseEntity.class.getPackage().getName();
    }
}
