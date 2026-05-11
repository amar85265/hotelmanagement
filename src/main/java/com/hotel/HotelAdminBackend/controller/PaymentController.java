package com.hotel.HotelAdminBackend.controller;

import com.hotel.HotelAdminBackend.dto.PaymentRequest;
import com.hotel.HotelAdminBackend.dto.PaymentResponse;
import com.hotel.HotelAdminBackend.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public PaymentResponse createPayment(
            @RequestBody PaymentRequest request) {

        return paymentService.createPayment(request);
    }

    @GetMapping
    public List<PaymentResponse> getAllPayments() {

        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public PaymentResponse getPaymentById(
            @PathVariable Integer id) {

        return paymentService.getPaymentById(id);
    }

    @PutMapping("/{id}")
    public PaymentResponse updatePayment(
            @PathVariable Integer id,
            @RequestBody PaymentRequest request) {

        return paymentService.updatePayment(id, request);
    }

    @DeleteMapping("/{id}")
    public String deletePayment(
            @PathVariable Integer id) {

        paymentService.deletePayment(id);

        return "Payment deleted successfully";
    }
}