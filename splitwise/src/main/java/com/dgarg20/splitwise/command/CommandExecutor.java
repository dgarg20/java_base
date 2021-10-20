package com.dgarg20.splitwise.command;

import com.dgarg20.splitwise.models.Command;

/**
 * Created by Deepanshu Garg on 03/09/21.
 */

public abstract class CommandExecutor {

    public boolean validate(){
        return true;
    }

    public abstract void execute(Command command);

}
