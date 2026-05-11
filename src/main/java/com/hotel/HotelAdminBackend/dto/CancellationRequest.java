package com.hotel.HotelAdminBackend.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CancellationRequest {

    private Integer reservationId;

    private LocalDateTime cancellationDate;

    private String reason;

    private BigDecimal cancellationFee;

    private String cancellationStatus;

    private String createdBy;

    private LocalDateTime createdDate;

    private String modifiedBy;

    private LocalDateTime modifiedDate;
}