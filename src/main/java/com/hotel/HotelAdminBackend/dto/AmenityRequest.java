package com.hotel.HotelAdminBackend.dto;

import lombok.Data;

@Data
public class AmenityRequest {

    private String name;

    private String description;

    private Boolean isActive;

    private String createdBy;

    private String modifiedBy;
}