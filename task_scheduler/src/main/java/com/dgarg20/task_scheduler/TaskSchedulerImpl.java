package com.dgarg20.task_scheduler;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by Deepanshu Garg on 22/12/20.
 */


public class TaskSchedulerImpl {
    static TaskSchedulerImpl taskScheduler = null;
    private TaskSchedulerImpl(){
        tasks = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if(o1.getStartTime().isBefore(o2.getStartTime())){
                    return 1;
                }
                else {
                    return -1;
                }
            }
        });

    }
    Queue<Task> tasks = null;
    //@Override
    public void execute(Task task) {
        System.out.println("task execution started" + task.getDuration() + " " +  task.getTaskMeta());
        Thread t = new Thread(task);
        t.start();
    }

   // @Override
    public void insert(Task task) {
        System.out.println("Inserting new Task " + task);
        synchronized (this) {
            tasks.add(task);
        }
    }

    //@Override
    public void findTask() throws InterruptedException {
        System.out.println("Find Task ");
        while (true) {
            if (!tasks.isEmpty()) {
                Task task = tasks.element();
                if (task.getStartTime().isBefore(LocalDateTime.now())) {
                    tasks.poll();
                    execute(task);
                } else {
                    Thread.sleep(100);
                }
            }
        }
    }

    public static TaskSchedulerImpl getInstance(){
        if(taskScheduler == null) {
            taskScheduler = new TaskSchedulerImpl();
        }
        return taskScheduler;
    }
}
