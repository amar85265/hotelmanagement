package com.hotel.HotelAdminBackend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RefundMethodResponse {

    private Integer methodId;

    private String methodName;

    private Boolean isActive;
}