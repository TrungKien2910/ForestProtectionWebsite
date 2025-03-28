package com.stringboot.BaoVeRung.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "event_participants")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Integer participantId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
     User user;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
     Event event;

    @Column(nullable = false, updatable = false)
     LocalDateTime registrationDate = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
     Status status = Status.CONFIRMED;

    public enum Status {
        CONFIRMED, CANCELED
    }

    // Getters, Setters, Constructors
}
