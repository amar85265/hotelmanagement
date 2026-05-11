package com.hotel.HotelAdminBackend.repository;

import com.hotel.HotelAdminBackend.model
        .Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
}