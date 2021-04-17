package com.dgarg20.java_base.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Deepanshu Garg on 17/12/20.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddUsersToGroupRequest {
    private List<Integer> userList;
}
