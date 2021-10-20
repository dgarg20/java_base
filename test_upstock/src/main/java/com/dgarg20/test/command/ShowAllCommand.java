package com.dgarg20.test.command;

import com.dgarg20.test.model.Command;


public class ShowAllCommand extends CommandExecutor{
    @Override
    public boolean validate(Command command) {
        return false;
    }

    @Override
    public void execute(Command command) {

    }
}
