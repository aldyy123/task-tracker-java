package com.task_tracker.api_tracker.task.dto;

import com.task_tracker.api_tracker.task.Task;
import com.task_tracker.api_tracker.task.TaskStatus;

import java.time.Instant;

public class TaskResponse {
    private Long id;
    private String description;
    private String title;
    private TaskStatus status;
    private Instant createdAt;
    private Instant updatedAt;


    public static TaskResponse from(Task t){
        TaskResponse r = new TaskResponse();
        r.description = t.getDescription();
        r.title = t.getTitle();
        r.id = t.getId();
        r.status = t.getStatus();
        r.updatedAt = t.getUpdatedAt();
        r.createdAt = t.getCreatedAt();
        return r;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public TaskStatus getStatus() { return status; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
}
