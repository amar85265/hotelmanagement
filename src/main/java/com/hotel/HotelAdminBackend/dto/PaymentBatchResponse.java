package com.hotel.HotelAdminBackend.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class PaymentBatchResponse {

    private Integer paymentBatchId;

    private Integer userId;

    private LocalDateTime paymentDate;

    private BigDecimal totalAmount;

    private String paymentMethod;
}