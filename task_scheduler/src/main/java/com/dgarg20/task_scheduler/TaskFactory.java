package com.dgarg20.task_scheduler;

/**
 * Created by Deepanshu Garg on 22/12/20.
 */
public class TaskFactory {
    public static TaskExecutor getTaskExecutor(Task task) {
        if(task.getTaskType() == TaskType.SingleExecution) {
            return new SingleExecutionTask();
        }
        else
            return new SpacedTaskExecutor();
    }
}
