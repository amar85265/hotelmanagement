package com.hotel.HotelAdminBackend.dto;

import lombok.Data;

@Data
public class UserRoleRequest {

    private String roleName;
    private Boolean isActive;
    private String description;
}