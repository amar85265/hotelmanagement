package com.hotel.HotelAdminBackend.dto;

import lombok.Data;

@Data
public class RefundMethodRequest {

    private String methodName;

    private Boolean isActive;
}