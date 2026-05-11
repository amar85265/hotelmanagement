package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.PaymentRequest;
import com.hotel.HotelAdminBackend.dto.PaymentResponse;

import java.util.List;

public interface PaymentService {

    PaymentResponse createPayment(PaymentRequest request);

    List<PaymentResponse> getAllPayments();

    PaymentResponse getPaymentById(Integer id);

    PaymentResponse updatePayment(Integer id, PaymentRequest request);

    void deletePayment(Integer id);
}