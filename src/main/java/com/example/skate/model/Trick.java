package com.example.skate.model;

import jakarta.persistence.*; // map this class as a table in the database

@Entity // Marks this class as a JPA entity (represents a DB table)
public class Trick {

    @Id // Marks this field as primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the ID value
    private Long id; // Unique identifier for each trick

    private String name; // Name of the trick
    private String stance; // Stance of the trick
    private String difficulty; // Difficulty level of the trick

    // Getter to retrieve trick ID
    public Long getId() { return id; }
    // Setter to assign trick ID
    public void setId(Long id) { this.id = id; }

    // Getter method to retrieve the trick name
    public String getName() { return name; }
    // Setter method to set the trick name
    public void setName(String name) { this.name = name; }

    // Getter method to retrieve the trick stance
    public String getStance() { return stance; }
    // Setter method to set the trick stance
    public void setStance(String stance) { this.stance = stance; }

    // Getter method to retrieve the trick difficulty
    public String getDifficulty() { return difficulty; }
    // Setter method to set the trick difficulty
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }
}
