package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.PaymentRequest;
import com.hotel.HotelAdminBackend.dto.PaymentResponse;
import com.hotel.HotelAdminBackend.model.Payment;
import com.hotel.HotelAdminBackend.model.PaymentBatch;
import com.hotel.HotelAdminBackend.model.Reservation;
import com.hotel.HotelAdminBackend.repository.PaymentBatchRepository;
import com.hotel.HotelAdminBackend.repository.PaymentRepository;
import com.hotel.HotelAdminBackend.repository.ReservationRepository;
import com.hotel.HotelAdminBackend.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final ReservationRepository reservationRepository;
    private final PaymentBatchRepository paymentBatchRepository;

    @Override
    public PaymentResponse createPayment(PaymentRequest request) {

        Reservation reservation = reservationRepository.findById(request.getReservationId())
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        PaymentBatch paymentBatch = paymentBatchRepository.findById(request.getPaymentBatchId())
                .orElseThrow(() -> new RuntimeException("Payment batch not found"));

        Payment payment = Payment.builder()
                .amount(request.getAmount())
                .reservation(reservation)
                .paymentBatch(paymentBatch)
                .build();

        Payment saved = paymentRepository.save(payment);

        return mapToResponse(saved);
    }

    @Override
    public List<PaymentResponse> getAllPayments() {

        return paymentRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentResponse getPaymentById(Integer id) {

        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        return mapToResponse(payment);
    }

    @Override
    public PaymentResponse updatePayment(Integer id, PaymentRequest request) {

        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        Reservation reservation = reservationRepository.findById(request.getReservationId())
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        PaymentBatch paymentBatch = paymentBatchRepository.findById(request.getPaymentBatchId())
                .orElseThrow(() -> new RuntimeException("Payment batch not found"));

        payment.setAmount(request.getAmount());
        payment.setReservation(reservation);
        payment.setPaymentBatch(paymentBatch);

        Payment updated = paymentRepository.save(payment);

        return mapToResponse(updated);
    }

    @Override
    public void deletePayment(Integer id) {

        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        paymentRepository.delete(payment);
    }

    private PaymentResponse mapToResponse(Payment payment) {

        return PaymentResponse.builder()
                .paymentId(payment.getPaymentId())
                .reservationId(payment.getReservation().getReservationId())
                .paymentBatchId(payment.getPaymentBatch().getPaymentBatchId())
                .amount(payment.getAmount())
                .build();
    }
}