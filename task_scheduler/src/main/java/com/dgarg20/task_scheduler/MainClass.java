    package com.dgarg20.task_scheduler;

    /**
     * Created by Deepanshu Garg on 22/12/20.
     */
    public class MainClass {
        TaskSchedulerImpl taskScheduler;

        public static void main(String[] args) throws InterruptedException {
            TaskSchedulerImpl taskScheduler = TaskSchedulerImpl.getInstance();
            while(true) {
                Task t = new Task(1, "job 1", TaskType.SingleExecution, 10);
                taskScheduler.insert(t);
                Task t2 = new Task(2, "job 2", TaskType.SingleExecution, 1);
                taskScheduler.insert(t2);
                Task t3 = new Task(3, "job 3", TaskType.SingleExecution, 60);
                taskScheduler.insert(t3);
                Task t4 = new Task(4, "job 4", TaskType.SpacedExecution, 30);
                taskScheduler.insert(t4);
                taskScheduler.findTask();
            }
        }
    }
