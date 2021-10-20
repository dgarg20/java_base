package com.dgarg20.test.repository;

import com.dgarg20.test.exception.UserNotFound;
import com.dgarg20.test.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;



@Data
@AllArgsConstructor
public class UserRepository {
    private Map<String, User> users;
    private static UserRepository userRepository;
    private AtomicInteger id = new AtomicInteger(1);

    private UserRepository(){
        users = new HashMap<>();
    }

    public void addUser(String name){
        users.put("u" + id.get(), new User(name, "u" + id.get()));
        id.incrementAndGet();
    }

    public User getUser(String id) throws Exception{
        if(users.containsKey(id)) {
            return users.get(id);
        }
        throw new UserNotFound();
    }


    public static UserRepository getInstance(){
        if( userRepository== null){
            UserRepository userRepository = new UserRepository();
        }
        return userRepository;
    }
}
