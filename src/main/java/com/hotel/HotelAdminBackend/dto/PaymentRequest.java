package com.hotel.HotelAdminBackend.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRequest {

    private Integer reservationId;

    private Integer paymentBatchId;

    private BigDecimal amount;
}