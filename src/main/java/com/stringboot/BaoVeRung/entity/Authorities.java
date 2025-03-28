package com.stringboot.BaoVeRung.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Table(name = "Authorities")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Authorities {
    @Id
    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
     User user;

    @Column(nullable = false)
     String authority;

    // Getters, Setters, Constructors
}
