package com.hotel.HotelAdminBackend.repository;

import com.hotel.HotelAdminBackend.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository
        extends JpaRepository<Reservation, Integer> {
}