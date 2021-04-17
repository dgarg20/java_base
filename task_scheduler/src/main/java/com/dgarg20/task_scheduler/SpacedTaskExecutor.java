package com.dgarg20.task_scheduler;

/**
 * Created by Deepanshu Garg on 22/12/20.
 */
public class SpacedTaskExecutor implements TaskExecutor{
    @Override
    public void execute(Task task) throws InterruptedException {
        TaskSchedulerImpl taskScheduler = TaskSchedulerImpl.getInstance();
        System.out.println("Spaced Task " + task);
        //int random = 10;
        //Thread.sleep(10* 60 * 1000);
        task.setStartTime(task.getStartTime().plusMinutes(task.getDuration().toMillis()));
        taskScheduler.insert(task);
    }
}
