package com.dgarg20.task_scheduler;

import lombok.*;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Created by Deepanshu Garg on 22/12/20.
 */


@NoArgsConstructor
@Getter
@Setter
public class Task implements Runnable {
    private int taskId;
    private String taskMeta;
    private TaskType taskType;
    private Duration duration;
    private LocalDateTime startTime;

    Task(int id, String meta, TaskType taskType, int durationInSec) {
        this.taskId = id;
        this.taskMeta = meta;
        this.taskType = taskType;
        this.duration = Duration.ofSeconds(durationInSec);
        startTime = LocalDateTime.now().plusSeconds(durationInSec);
    }

    @SneakyThrows
    @Override
    public void run() {
        TaskFactory.getTaskExecutor(this).execute(this);
    }
}
