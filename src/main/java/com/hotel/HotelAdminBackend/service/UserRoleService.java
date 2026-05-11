package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.UserRoleRequest;
import com.hotel.HotelAdminBackend.dto.UserRoleResponse;

import java.util.List;

public interface UserRoleService {

    UserRoleResponse createRole(UserRoleRequest request);

    List<UserRoleResponse> getAllRoles();

    UserRoleResponse getRoleById(Integer id);

    UserRoleResponse updateRole(Integer id, UserRoleRequest request);

    void deleteRole(Integer id);
}