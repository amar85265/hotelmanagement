package com.hotel.HotelAdminBackend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRoleResponse {

    private Integer roleId;
    private String roleName;
    private Boolean isActive;
    private String description;
}