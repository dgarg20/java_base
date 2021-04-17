package com.dgarg20.java_base.service;

import com.dgarg20.java_base.driver.DriverClass;

import java.util.List;

/**
 * Created by Deepanshu Garg on 16/12/20.
 */
public interface GroupService {
    void addUser(List<Integer> userIds, String currentUser, int groupId)throws Exception;
    public void createGroup(String name, String currentUserName) throws Exception;
}
