package com.hotel.HotelAdminBackend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CountryResponse {

    private Integer countryId;
    private String countryName;
    private String countryCode;
    private Boolean isActive;
}