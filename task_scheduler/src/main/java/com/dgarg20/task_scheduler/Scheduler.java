package com.dgarg20.task_scheduler;

/**
 * Created by Deepanshu Garg on 22/12/20.
 */
public interface Scheduler {
    void execute(Task task);
    void insert(Task task);
    void findTask() throws InterruptedException;
}
