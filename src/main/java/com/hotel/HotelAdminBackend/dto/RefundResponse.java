package com.hotel.HotelAdminBackend.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefundResponse {

    private Integer refundId;

    private Integer paymentId;

    private BigDecimal refundAmount;

    private LocalDateTime refundDate;

    private String refundReason;

    private Integer refundMethodId;

    private Integer processedByUserId;

    private String refundStatus;
}