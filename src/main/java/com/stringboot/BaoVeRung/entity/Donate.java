package com.stringboot.BaoVeRung.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "donate")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Donate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Integer donationId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
     User user;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
     Event event;

    @Column(nullable = false)
     BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
     DonationType donationType = DonationType.MONEY;

    @Column(nullable = false, updatable = false)
     LocalDateTime donationDate = LocalDateTime.now();

    public enum DonationType {
        MONEY
    }

    // Getters, Setters, Constructors
}
