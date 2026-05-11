package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.PaymentBatchRequest;
import com.hotel.HotelAdminBackend.dto.PaymentBatchResponse;

import java.util.List;

public interface PaymentBatchService {

    PaymentBatchResponse createPaymentBatch(PaymentBatchRequest request);

    List<PaymentBatchResponse> getAllPaymentBatches();

    PaymentBatchResponse getPaymentBatchById(Integer id);

    PaymentBatchResponse updatePaymentBatch(Integer id, PaymentBatchRequest request);

    void deletePaymentBatch(Integer id);
}