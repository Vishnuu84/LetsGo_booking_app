package com.example.letsgo.service;

import com.example.letsgo.model.Hotel;
import com.example.letsgo.repository.HotelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HotelService {

    // Requirement: Logging for system actions [cite: 54, 56]
    private static final Logger logger = LoggerFactory.getLogger(HotelService.class);

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> searchHotelsByLocation(String location) {
        logger.info("Searching for hotels in location: {}", location); // [cite: 55]
        return hotelRepository.findByLocationContaining(location);
    }

    public Hotel getHotelById(Long id) {
        logger.info("Fetching details for hotel ID: {}", id);
        return hotelRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Hotel not found with id: " + id)); // Caught by GlobalExceptionHandler [cite: 50]
    }
}