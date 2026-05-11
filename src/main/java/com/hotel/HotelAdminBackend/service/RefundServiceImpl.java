package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.RefundRequest;
import com.hotel.HotelAdminBackend.dto.RefundResponse;
import com.hotel.HotelAdminBackend.model.Refund;
import com.hotel.HotelAdminBackend.repository.RefundRepository;
import com.hotel.HotelAdminBackend.service.RefundService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RefundServiceImpl implements RefundService {

    private final RefundRepository refundRepository;

    @Override
    public RefundResponse createRefund(RefundRequest request) {

        Refund refund = Refund.builder()
                .paymentId(request.getPaymentId())
                .refundAmount(request.getRefundAmount())
                .refundDate(LocalDateTime.now())
                .refundReason(request.getRefundReason())
                .refundMethodId(request.getRefundMethodId())
                .processedByUserId(request.getProcessedByUserId())
                .refundStatus(request.getRefundStatus())
                .build();

        Refund savedRefund = refundRepository.save(refund);

        return mapToResponse(savedRefund);
    }

    @Override
    public List<RefundResponse> getAllRefunds() {
        return refundRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public RefundResponse getRefundById(Integer refundId) {

        Refund refund = refundRepository.findById(refundId)
                .orElseThrow(() -> new RuntimeException("Refund not found"));

        return mapToResponse(refund);
    }

    @Override
    public RefundResponse updateRefund(Integer refundId, RefundRequest request) {

        Refund refund = refundRepository.findById(refundId)
                .orElseThrow(() -> new RuntimeException("Refund not found"));

        refund.setPaymentId(request.getPaymentId());
        refund.setRefundAmount(request.getRefundAmount());
        refund.setRefundReason(request.getRefundReason());
        refund.setRefundMethodId(request.getRefundMethodId());
        refund.setProcessedByUserId(request.getProcessedByUserId());
        refund.setRefundStatus(request.getRefundStatus());

        Refund updatedRefund = refundRepository.save(refund);

        return mapToResponse(updatedRefund);
    }

    @Override
    public void deleteRefund(Integer refundId) {

        Refund refund = refundRepository.findById(refundId)
                .orElseThrow(() -> new RuntimeException("Refund not found"));

        refundRepository.delete(refund);
    }

    private RefundResponse mapToResponse(Refund refund) {

        return RefundResponse.builder()
                .refundId(refund.getRefundId())
                .paymentId(refund.getPaymentId())
                .refundAmount(refund.getRefundAmount())
                .refundDate(refund.getRefundDate())
                .refundReason(refund.getRefundReason())
                .refundMethodId(refund.getRefundMethodId())
                .processedByUserId(refund.getProcessedByUserId())
                .refundStatus(refund.getRefundStatus())
                .build();
    }
}