package com.example.letsgo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "rooms")
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // Links many rooms to one hotel
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    private String roomType;
    private Double pricePerNight;
    private Boolean isAvailable;
}