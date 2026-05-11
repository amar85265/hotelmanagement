package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.RefundMethodRequest;
import com.hotel.HotelAdminBackend.dto.RefundMethodResponse;
import com.hotel.HotelAdminBackend.model.RefundMethod;
import com.hotel.HotelAdminBackend.repository.RefundMethodRepository;
import com.hotel.HotelAdminBackend.service.RefundMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RefundMethodServiceImpl
        implements RefundMethodService {

    private final RefundMethodRepository refundMethodRepository;

    @Override
    public RefundMethodResponse createRefundMethod(
            RefundMethodRequest request) {

        RefundMethod refundMethod = RefundMethod.builder()
                .methodName(request.getMethodName())
                .isActive(request.getIsActive())
                .build();

        RefundMethod saved =
                refundMethodRepository.save(refundMethod);

        return mapToResponse(saved);
    }

    @Override
    public List<RefundMethodResponse> getAllRefundMethods() {

        return refundMethodRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public RefundMethodResponse getRefundMethodById(Integer id) {

        RefundMethod refundMethod =
                refundMethodRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Refund method not found"));

        return mapToResponse(refundMethod);
    }

    @Override
    public RefundMethodResponse updateRefundMethod(
            Integer id,
            RefundMethodRequest request) {

        RefundMethod refundMethod =
                refundMethodRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Refund method not found"));

        refundMethod.setMethodName(request.getMethodName());
        refundMethod.setIsActive(request.getIsActive());

        RefundMethod updated =
                refundMethodRepository.save(refundMethod);

        return mapToResponse(updated);
    }

    @Override
    public void deleteRefundMethod(Integer id) {

        RefundMethod refundMethod =
                refundMethodRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Refund method not found"));

        refundMethodRepository.delete(refundMethod);
    }

    private RefundMethodResponse mapToResponse(
            RefundMethod refundMethod) {

        return RefundMethodResponse.builder()
                .methodId(refundMethod.getMethodId())
                .methodName(refundMethod.getMethodName())
                .isActive(refundMethod.getIsActive())
                .build();
    }
}