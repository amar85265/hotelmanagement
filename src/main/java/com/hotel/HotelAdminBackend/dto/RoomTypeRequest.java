package com.hotel.HotelAdminBackend.dto;

import lombok.Data;

@Data
public class RoomTypeRequest {
    private String typeName;
    private String accessibilityFeatures;
    private String description;
    private String createdBy;
}