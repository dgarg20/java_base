package com.dgarg20.splitwise.models;

/**
 * Created by Deepanshu Garg on 03/09/21.
 */

public class UserShare {
    private User user;
    private float share;

    public UserShare(User user, float share){
        this.user = user;
        this.share = share;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public float getShare() {
        return share;
    }

    public void setShare(float share) {
        this.share = share;
    }
}
