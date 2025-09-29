package com.example.thendral.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MoodEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mood;
    private String journal;
    private LocalDateTime timestamp;
    @ManyToOne
    private User user;
    // getters and setters
}
