package com.dgarg20.splitwise.models;

import java.util.List;

/**
 * Created by Deepanshu Garg on 03/09/21.
 */
public class Command {
    private String command;
    private List<String> parameters;

    public Command(String command, List<String> parameters) {
        this.command = command;
        this.parameters = parameters;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
