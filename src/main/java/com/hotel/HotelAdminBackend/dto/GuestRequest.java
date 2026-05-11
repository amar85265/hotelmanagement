package com.hotel.HotelAdminBackend.dto;

import lombok.Data;

@Data
public class GuestRequest {

    private Integer userId;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String ageGroup;

    private String address;

    private Integer countryId;

    private Integer stateId;

    private String createdBy;

    private String modifiedBy;
}