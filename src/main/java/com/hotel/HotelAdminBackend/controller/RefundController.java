package com.hotel.HotelAdminBackend.controller;

import com.hotel.HotelAdminBackend.dto.RefundRequest;
import com.hotel.HotelAdminBackend.dto.RefundResponse;
import com.hotel.HotelAdminBackend.service.RefundService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/refunds")
@RequiredArgsConstructor
public class RefundController {

    private final RefundService refundService;

    @PostMapping
    public RefundResponse createRefund(@RequestBody RefundRequest request) {
        return refundService.createRefund(request);
    }

    @GetMapping
    public List<RefundResponse> getAllRefunds() {
        return refundService.getAllRefunds();
    }

    @GetMapping("/{refundId}")
    public RefundResponse getRefundById(@PathVariable Integer refundId) {
        return refundService.getRefundById(refundId);
    }

    @PutMapping("/{refundId}")
    public RefundResponse updateRefund(
            @PathVariable Integer refundId,
            @RequestBody RefundRequest request) {

        return refundService.updateRefund(refundId, request);
    }

    @DeleteMapping("/{refundId}")
    public String deleteRefund(@PathVariable Integer refundId) {

        refundService.deleteRefund(refundId);

        return "Refund deleted successfully";
    }
}