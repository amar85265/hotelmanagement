package com.hotel.HotelAdminBackend.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AmenityResponse {

    private Integer amenityId;

    private String name;

    private String description;

    private Boolean isActive;

    private String createdBy;

    private LocalDateTime createdDate;

    private String modifiedBy;

    private LocalDateTime modifiedDate;
}