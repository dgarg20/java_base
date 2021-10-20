package com.dgarg20.test.command;

import com.dgarg20.test.model.Command;


public abstract class CommandExecutor {


    public abstract boolean validate(Command command);

    public abstract void execute(Command command);
}
