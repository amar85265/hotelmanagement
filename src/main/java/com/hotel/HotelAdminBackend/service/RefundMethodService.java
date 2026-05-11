package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.RefundMethodRequest;
import com.hotel.HotelAdminBackend.dto.RefundMethodResponse;

import java.util.List;

public interface RefundMethodService {

    RefundMethodResponse createRefundMethod(
            RefundMethodRequest request);

    List<RefundMethodResponse> getAllRefundMethods();

    RefundMethodResponse getRefundMethodById(Integer id);

    RefundMethodResponse updateRefundMethod(
            Integer id,
            RefundMethodRequest request);

    void deleteRefundMethod(Integer id);
}