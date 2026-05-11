package com.hotel.HotelAdminBackend.repository;

import com.hotel.HotelAdminBackend.model.PaymentBatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentBatchRepository extends JpaRepository<PaymentBatch, Integer> {
}