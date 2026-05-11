package com.hotel.HotelAdminBackend.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class RoomTypeResponse {
    private Integer roomTypeId;
    private String typeName;
    private String accessibilityFeatures;
    private String description;
    private Boolean isActive;
    private LocalDateTime createdDate;
}