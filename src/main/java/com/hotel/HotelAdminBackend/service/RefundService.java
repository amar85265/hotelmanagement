package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.RefundRequest;
import com.hotel.HotelAdminBackend.dto.RefundResponse;

import java.util.List;

public interface RefundService {

    RefundResponse createRefund(RefundRequest request);

    List<RefundResponse> getAllRefunds();

    RefundResponse getRefundById(Integer refundId);

    RefundResponse updateRefund(Integer refundId, RefundRequest request);

    void deleteRefund(Integer refundId);
}