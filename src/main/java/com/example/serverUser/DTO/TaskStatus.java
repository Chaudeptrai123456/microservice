package com.example.serverUser.DTO;

import java.io.Serializable;

public class TaskStatus implements Serializable {
    private String taskId;
    private String taskName;
    private float percentageComplete;
    private Status status;
    public enum Status{
        SUBMITTED,STARTED,RUNNING,FINISHED,TERMINATED;
    }

    public TaskStatus(String taskId, String taskName, float percentageComplete, Status status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.percentageComplete = percentageComplete;
        this.status = status;
    }
}
