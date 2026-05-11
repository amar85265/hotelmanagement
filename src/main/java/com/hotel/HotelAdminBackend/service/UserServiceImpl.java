package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.UserRequest;
import com.hotel.HotelAdminBackend.dto.UserResponse;
import com.hotel.HotelAdminBackend.model.User;
import com.hotel.HotelAdminBackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // ✅ CREATE USER
    @Override
    public UserResponse createUser(UserRequest request) {

        // 🔥 Check duplicate email
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        User user = User.builder()
                .roleId(request.getRoleId())
                .email(request.getEmail())
                .passwordHash(request.getPassword())
                .isActive(request.getIsActive() != null ? request.getIsActive() : true) // ✅ FIX HERE
                .createdAt(LocalDateTime.now())
                .createdDate(LocalDateTime.now())
                .build();

        user = userRepository.save(user);
        return mapToResponse(user);
    }

    // ✅ GET BY ID
    @Override
    public UserResponse getUserById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return mapToResponse(user);
    }

    // ✅ GET ALL
    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ✅ UPDATE USER
    @Override
    public UserResponse updateUser(Integer id, UserRequest request) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setRoleId(request.getRoleId());
        user.setEmail(request.getEmail());
        user.setPasswordHash(request.getPassword());
        user.setIsActive(request.getIsActive() != null ? request.getIsActive() : user.getIsActive());
        user.setModifiedDate(LocalDateTime.now());

        userRepository.save(user);
        return mapToResponse(user);
    }

    // ✅ DELETE USER
    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    // 🔄 MAPPING METHOD
    private UserResponse mapToResponse(User user) {
        return UserResponse.builder()
                .userId(user.getUserId())
                .roleId(user.getRoleId())
                .email(user.getEmail())
                .isActive(user.getIsActive() != null ? user.getIsActive() : true) // ✅ FIX
                .createdAt(user.getCreatedAt())
                .lastLogin(user.getLastLogin() != null ? user.getLastLogin() : user.getCreatedAt()) // ✅ FIX
                .build();
    }
}