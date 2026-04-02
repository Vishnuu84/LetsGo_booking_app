package com.example.letsgo.service;

import com.example.letsgo.model.Booking;
import com.example.letsgo.repository.BookingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookingService {
    // Requirement 5: Logging for user actions and system events
    private static final Logger logger = LoggerFactory.getLogger(BookingService.class);

    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {
        logger.info("Processing new booking for User ID: {}", booking.getUser().getId());
        booking.setStatus("CONFIRMED");
        Booking savedBooking = bookingRepository.save(booking);
        logger.info("Booking successful! Booking ID: {}", savedBooking.getId());
        return savedBooking;
    }

    public void cancelBooking(Long bookingId) {
        logger.info("Attempting to cancel Booking ID: {}", bookingId);
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setStatus("CANCELLED");
        bookingRepository.save(booking);
        logger.info("Booking ID: {} has been cancelled.", bookingId);
    }

    public List<Booking> getHistory(Long userId) {
        return bookingRepository.findByUserId(userId);
    }
}