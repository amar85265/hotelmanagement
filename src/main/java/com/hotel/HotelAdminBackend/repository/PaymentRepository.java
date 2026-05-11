package com.hotel.HotelAdminBackend.repository;

import com.hotel.HotelAdminBackend.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}