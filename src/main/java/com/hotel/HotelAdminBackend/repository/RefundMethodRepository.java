package com.hotel.HotelAdminBackend.repository;

import com.hotel.HotelAdminBackend.model.RefundMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefundMethodRepository
        extends JpaRepository<RefundMethod, Integer> {
}