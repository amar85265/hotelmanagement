package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.PaymentBatchRequest;
import com.hotel.HotelAdminBackend.dto.PaymentBatchResponse;
import com.hotel.HotelAdminBackend.model.PaymentBatch;
import com.hotel.HotelAdminBackend.model.User;
import com.hotel.HotelAdminBackend.repository.PaymentBatchRepository;
import com.hotel.HotelAdminBackend.repository.UserRepository;
import com.hotel.HotelAdminBackend.service.PaymentBatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentBatchServiceImpl implements PaymentBatchService {

    private final PaymentBatchRepository paymentBatchRepository;
    private final UserRepository userRepository;

    @Override
    public PaymentBatchResponse createPaymentBatch(PaymentBatchRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        PaymentBatch paymentBatch = PaymentBatch.builder()
                .paymentDate(request.getPaymentDate())
                .totalAmount(request.getTotalAmount())
                .paymentMethod(request.getPaymentMethod())
                .user(user)
                .build();

        PaymentBatch saved = paymentBatchRepository.save(paymentBatch);

        return mapToResponse(saved);
    }

    @Override
    public List<PaymentBatchResponse> getAllPaymentBatches() {

        return paymentBatchRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentBatchResponse getPaymentBatchById(Integer id) {

        PaymentBatch paymentBatch = paymentBatchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment Batch not found"));

        return mapToResponse(paymentBatch);
    }

    @Override
    public PaymentBatchResponse updatePaymentBatch(Integer id, PaymentBatchRequest request) {

        PaymentBatch paymentBatch = paymentBatchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment Batch not found"));

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        paymentBatch.setPaymentDate(request.getPaymentDate());
        paymentBatch.setTotalAmount(request.getTotalAmount());
        paymentBatch.setPaymentMethod(request.getPaymentMethod());
        paymentBatch.setUser(user);

        PaymentBatch updated = paymentBatchRepository.save(paymentBatch);

        return mapToResponse(updated);
    }

    @Override
    public void deletePaymentBatch(Integer id) {

        PaymentBatch paymentBatch = paymentBatchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment Batch not found"));

        paymentBatchRepository.delete(paymentBatch);
    }

    private PaymentBatchResponse mapToResponse(PaymentBatch paymentBatch) {

        return PaymentBatchResponse.builder()
                .paymentBatchId(paymentBatch.getPaymentBatchId())
                .userId(paymentBatch.getUser().getUserId())
                .paymentDate(paymentBatch.getPaymentDate())
                .totalAmount(paymentBatch.getTotalAmount())
                .paymentMethod(paymentBatch.getPaymentMethod())
                .build();
    }
}