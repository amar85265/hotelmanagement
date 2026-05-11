package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.UserRequest;
import com.hotel.HotelAdminBackend.dto.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserRequest request);

    UserResponse getUserById(Integer id);

    List<UserResponse> getAllUsers();

    UserResponse updateUser(Integer id, UserRequest request);

    void deleteUser(Integer id);
}