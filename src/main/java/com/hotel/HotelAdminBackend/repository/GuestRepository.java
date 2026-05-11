package com.hotel.HotelAdminBackend.repository;

import com.hotel.HotelAdminBackend.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository
        extends JpaRepository<Guest, Integer> {
}