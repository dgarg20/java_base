package com.dgarg20.splitwise.repositories;

import com.dgarg20.splitwise.exceptions.InvalidUserException;
import com.dgarg20.splitwise.models.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Deepanshu Garg on 03/09/21.
 */
public class UserRepository {
    private static UserRepository userRepository;
    private Map<String, User> userMap;


    private UserRepository(){
        this.userMap = new HashMap<String, User>();
    }

    public static UserRepository getInstance(){
        if(userRepository == null){
            synchronized (UserRepository.class){
                userRepository = new UserRepository();
            }
        }
        return userRepository;
    }

    public User getUser(String userId) throws RuntimeException{
        if(userMap.containsKey(userId))
            return userMap.get(userId);
        throw new InvalidUserException();
    }

    public void addUser(String userId, String name){
        userMap.put(userId, new User(name, userId));
    }
}
