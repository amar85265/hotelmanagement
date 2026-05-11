package com.hotel.HotelAdminBackend.controller;

import com.hotel.HotelAdminBackend.dto.RefundMethodRequest;
import com.hotel.HotelAdminBackend.dto.RefundMethodResponse;
import com.hotel.HotelAdminBackend.service.RefundMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/refund-methods")
@RequiredArgsConstructor
public class RefundMethodController {

    private final RefundMethodService refundMethodService;

    @PostMapping
    public RefundMethodResponse createRefundMethod(
            @RequestBody RefundMethodRequest request) {

        return refundMethodService.createRefundMethod(request);
    }

    @GetMapping
    public List<RefundMethodResponse> getAllRefundMethods() {

        return refundMethodService.getAllRefundMethods();
    }

    @GetMapping("/{id}")
    public RefundMethodResponse getRefundMethodById(
            @PathVariable Integer id) {

        return refundMethodService.getRefundMethodById(id);
    }

    @PutMapping("/{id}")
    public RefundMethodResponse updateRefundMethod(
            @PathVariable Integer id,
            @RequestBody RefundMethodRequest request) {

        return refundMethodService.updateRefundMethod(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteRefundMethod(
            @PathVariable Integer id) {

        refundMethodService.deleteRefundMethod(id);

        return "Refund Method deleted successfully";
    }
}