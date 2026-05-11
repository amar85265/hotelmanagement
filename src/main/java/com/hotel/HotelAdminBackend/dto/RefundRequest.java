package com.hotel.HotelAdminBackend.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefundRequest {

    private Integer paymentId;

    private BigDecimal refundAmount;

    private String refundReason;

    private Integer refundMethodId;

    private Integer processedByUserId;

    private String refundStatus;
}