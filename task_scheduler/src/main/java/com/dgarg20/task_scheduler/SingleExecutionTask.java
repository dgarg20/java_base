package com.dgarg20.task_scheduler;

/**
 * Created by Deepanshu Garg on 22/12/20.
 */
public class SingleExecutionTask implements TaskExecutor{

    @Override
    public void execute(Task task) {
        System.out.println("Single Task " + task);

    }
}
