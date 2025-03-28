package com.stringboot.BaoVeRung.dto;

import java.time.LocalDateTime;

public class ScheduleDTO {
    private int eventId;
    private String eventName;
    private String slogan;
    private String taskName;
    private String taskDescription;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String img;

    // Constructor dùng trong JPQL
    public ScheduleDTO(int eventId,String eventName, String slogan, String taskName, String taskDescription, LocalDateTime startTime, LocalDateTime endTime, String img) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.slogan = slogan;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.startTime = startTime;
        this.endTime = endTime;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    // Getters và Setters
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
