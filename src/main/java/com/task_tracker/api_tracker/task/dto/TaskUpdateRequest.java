package com.task_tracker.api_tracker.task.dto;

import com.task_tracker.api_tracker.task.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TaskUpdateRequest {

    @Size(max = 120, message = "Title Max in 120 message")
    private String title;

    @Size(max = 2000, message = "Description max in 2000")
    private String description;

    private TaskStatus status;

    public String getTitle(){return this.title;}
    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public TaskStatus getStatus() { return status; }
    public void setStatus(TaskStatus status) { this.status = status; }
}
