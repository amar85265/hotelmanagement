package com.hotel.HotelAdminBackend.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GuestResponse {

    private Integer guestId;

    private Integer userId;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String ageGroup;

    private String address;

    private Integer countryId;

    private String countryName;

    private Integer stateId;

    private String stateName;

    private String createdBy;

    private LocalDateTime createdDate;

    private String modifiedBy;

    private LocalDateTime modifiedDate;
}