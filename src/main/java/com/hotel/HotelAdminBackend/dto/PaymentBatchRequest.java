package com.hotel.HotelAdminBackend.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentBatchRequest {

    private Integer userId;

    private LocalDateTime paymentDate;

    private BigDecimal totalAmount;

    private String paymentMethod;
}