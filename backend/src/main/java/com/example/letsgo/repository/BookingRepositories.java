package com.example.letsgo.repository;

import com.example.letsgo.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    // This fetches the "Booking History" for a specific user
    List<Booking> findByUserId(Long userId);
}