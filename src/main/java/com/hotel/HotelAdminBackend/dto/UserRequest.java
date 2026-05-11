package com.hotel.HotelAdminBackend.dto;

import lombok.Data;

@Data
public class UserRequest {

    private Integer roleId;
    private String email;
    private String password; // plain password
    private Boolean isActive;
}