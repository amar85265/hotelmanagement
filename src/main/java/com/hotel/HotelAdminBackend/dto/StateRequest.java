package com.hotel.HotelAdminBackend.dto;

import lombok.Data;

@Data
public class StateRequest {

    private String stateName;

    private Integer countryId;

    private Boolean isActive;
}