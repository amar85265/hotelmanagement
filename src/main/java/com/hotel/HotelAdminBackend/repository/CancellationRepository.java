package com.hotel.HotelAdminBackend.repository;

import com.hotel.HotelAdminBackend.model.Cancellation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancellationRepository extends JpaRepository<Cancellation, Integer> {
}