package com.example.letsgo.controller;

import com.example.letsgo.model.Booking;
import com.example.letsgo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity<Booking> bookRoom(@RequestBody Booking booking) {
        return ResponseEntity.ok(bookingService.createBooking(booking));
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity<String> cancel(@PathVariable Long id) {
        bookingService.cancelBooking(id);
        return ResponseEntity.ok("Booking cancelled successfully");
    }

    @GetMapping("/history/{userId}")
    public ResponseEntity<List<Booking>> getHistory(@PathVariable Long userId) {
        return ResponseEntity.ok(bookingService.getHistory(userId));
    }
}