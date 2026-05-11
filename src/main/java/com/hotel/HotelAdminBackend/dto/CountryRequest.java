package com.hotel.HotelAdminBackend.dto;

import lombok.Data;

@Data
public class CountryRequest {

    private String countryName;
    private String countryCode;
    private Boolean isActive;
}
