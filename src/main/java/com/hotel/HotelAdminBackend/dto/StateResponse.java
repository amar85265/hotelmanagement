package com.hotel.HotelAdminBackend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StateResponse {

    private Integer stateId;

    private String stateName;

    private Integer countryId;

    private String countryName;

    private Boolean isActive;
}