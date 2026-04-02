package com.example.letsgo.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "users") // Matches your SQL table name
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String email;
    private String role; // "USER" or "ADMIN"
}