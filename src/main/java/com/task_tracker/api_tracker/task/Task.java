package com.task_tracker.api_tracker.task;

import jakarta.persistence.*;

import java.time.Instant;

@Entity()
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 125)
    private String title;

    @Column(length = 2000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TaskStatus status = TaskStatus.TODO;

    @Column(updatable = false, nullable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant updatedAt;


    @PrePersist
    void onCreate(){
        Instant now = Instant.now();

        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    void onUpdate(){
        Instant now = Instant.now();
        this.updatedAt = now;
    }


//    Getters/Setters

    public long getId(){
        return  this.id;
    }

    public String getTitle(){
        return  this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }


    public String getDescription(){
        return  this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public TaskStatus getStatus() { return status; }
    public void setStatus(TaskStatus status) { this.status = status; }

    public Instant getCreatedAt() {return this.createdAt;}
    public Instant getUpdatedAt() {return  this.updatedAt;}

}
