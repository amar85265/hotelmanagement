package com.hotel.HotelAdminBackend.repository;

import com.hotel.HotelAdminBackend.model.Refund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefundRepository extends JpaRepository<Refund, Integer> {
}