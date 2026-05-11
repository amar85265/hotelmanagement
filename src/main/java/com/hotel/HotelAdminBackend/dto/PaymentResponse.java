package com.hotel.HotelAdminBackend.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PaymentResponse {

    private Integer paymentId;

    private Integer reservationId;

    private Integer paymentBatchId;

    private BigDecimal amount;
}