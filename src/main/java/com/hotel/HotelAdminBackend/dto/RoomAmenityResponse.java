package com.hotel.HotelAdminBackend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomAmenityResponse {

    private Integer roomTypeId;

    private String roomTypeName;

    private Integer amenityId;

    private String amenityName;
}