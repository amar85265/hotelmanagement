package com.hotel.HotelAdminBackend.controller;

import com.hotel.HotelAdminBackend.dto.PaymentBatchRequest;
import com.hotel.HotelAdminBackend.dto.PaymentBatchResponse;
import com.hotel.HotelAdminBackend.service.PaymentBatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment-batches")
@RequiredArgsConstructor
public class PaymentBatchController {

    private final PaymentBatchService paymentBatchService;

    @PostMapping
    public PaymentBatchResponse createPaymentBatch(
            @RequestBody PaymentBatchRequest request) {

        return paymentBatchService.createPaymentBatch(request);
    }

    @GetMapping
    public List<PaymentBatchResponse> getAllPaymentBatches() {

        return paymentBatchService.getAllPaymentBatches();
    }

    @GetMapping("/{id}")
    public PaymentBatchResponse getPaymentBatchById(
            @PathVariable Integer id) {

        return paymentBatchService.getPaymentBatchById(id);
    }

    @PutMapping("/{id}")
    public PaymentBatchResponse updatePaymentBatch(
            @PathVariable Integer id,
            @RequestBody PaymentBatchRequest request) {

        return paymentBatchService.updatePaymentBatch(id, request);
    }

    @DeleteMapping("/{id}")
    public String deletePaymentBatch(
            @PathVariable Integer id) {

        paymentBatchService.deletePaymentBatch(id);

        return "Payment Batch deleted successfully";
    }
}