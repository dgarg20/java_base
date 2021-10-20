package com.dgarg20.dropwizardcrud.repositories;

import com.dgarg20.dropwizardcrud.entities.User;
import org.hibernate.SessionFactory;

import java.util.List;

public interface CrudDbRepository {


     List<User> getAll();

     User getById(int id);

     User getByName(String name);

    long createUser(User user);

//    long updateLoginDetails();

    long updateUser(User user);

    long deleteUser(User user);


}
