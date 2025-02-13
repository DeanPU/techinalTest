package com.example.techinalTest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class CarBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100, unique = true)
    private String name;

    @Column(nullable = false, length = 50)
    private String country;

    @Column(nullable = false)
    private Integer foundedYear;

    @Column(nullable = false)
    private String description;
}
