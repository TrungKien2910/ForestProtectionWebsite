package com.stringboot.BaoVeRung.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;


@Entity
@Table(name = "schedule")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Integer scheduleId;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
     Event event;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
     User user;

    @Column(nullable = false)
     String taskName;

    @Column(columnDefinition = "TEXT")
     String taskDescription;

    @Column(nullable = false)
     LocalDateTime startTime;

    @Column(nullable = false)
     LocalDateTime endTime;

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", event=" + (event != null ? event.getEventId() : "null") +
                ", user=" + (user != null ? user.getUserId() : "null") +
                '}';
    }
    // Getters, Setters, Constructors

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
