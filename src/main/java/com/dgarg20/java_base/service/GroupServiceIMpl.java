package com.dgarg20.java_base.service;

import com.dgarg20.java_base.driver.DriverClass;
import com.dgarg20.java_base.dtos.Group;
import com.dgarg20.java_base.dtos.User;
import com.dgarg20.java_base.exceptions.TempException;

import java.util.*;

/**
 * Created by Deepanshu Garg on 16/12/20.
 */
public class GroupServiceIMpl implements GroupService{
    DriverClass driver = DriverClass.getInstance();
    @Override
    public void addUser(List<Integer> userIds, String currentUser, int groupId)throws Exception {
        List<User> users = new ArrayList<>();
        for (int id: userIds) {
            Optional<User> user = driver.getUserById(id);
            if(user.isPresent()){
                users.add(user.get());
            }
        }

        if(users.isEmpty()){
            throw new TempException("Users not found");
        }
        Optional<Group> group = driver.getGroupByIdAndAdmin(groupId, currentUser);
        if(group.isPresent()){
            group.get().addUsers(users);
        }else {
            throw new TempException("Group Not found not found");
        }
    }

    @Override
    public void createGroup(String name, String currentUserName) throws Exception{
        Optional<User> currentUser = driver.getUserByName(currentUserName);
        if(!currentUser.isPresent()){
            throw new TempException("Users not found");
        }
        Group group = new Group(name, driver.getNextGroupId(), new LinkedList<>(), currentUser.get());
        group.addUsers(Arrays.asList(currentUser.get()));
        driver.getGroups().add(group);
        driver.setNextGroupId(driver.getNextGroupId() + 1);
    }
}
