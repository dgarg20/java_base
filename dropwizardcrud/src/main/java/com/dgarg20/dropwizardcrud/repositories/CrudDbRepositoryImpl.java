package com.dgarg20.dropwizardcrud.repositories;

import com.dgarg20.dropwizardcrud.entities.User;
import com.google.inject.Inject;
import org.hibernate.SessionFactory;

import java.util.List;

public class CrudDbRepositoryImpl implements CrudDbRepository {

    @Inject
    private SessionFactory sf;

    public List<User> getAll() {
        return null;
    }

    public User getById(int id) {
        return null;
    }

    public User getByName(String name) {
        return null;
    }

    public long createUser(User user) {
        return 0;
    }

    public long updateUser(User user) {
        return 0;
    }

    public long deleteUser(User user) {
        return 0;
    }
}
