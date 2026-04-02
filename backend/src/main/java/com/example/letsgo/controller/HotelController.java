package com.example.letsgo.controller;

import com.example.letsgo.model.Hotel;
import com.example.letsgo.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private static final Logger logger = LoggerFactory.getLogger(HotelController.class);

    @Autowired
    private HotelService hotelService;

    // Requirement: Search hotels based on location
    @GetMapping("/search")
    public ResponseEntity<List<Hotel>> searchHotels(@RequestParam String location) {
        logger.info("Received API request to search hotels in: {}", location); // [cite: 55]
        List<Hotel> hotels = hotelService.searchHotelsByLocation(location);
        return ResponseEntity.ok(hotels);
    }

    // Requirement: View hotel details
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelDetails(@PathVariable Long id) {
        logger.info("Received API request for hotel details ID: {}", id);
        return ResponseEntity.ok(hotelService.getHotelById(id));
    }
}