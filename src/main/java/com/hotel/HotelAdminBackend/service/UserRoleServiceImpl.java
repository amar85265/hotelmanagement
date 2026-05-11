package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.UserRoleRequest;
import com.hotel.HotelAdminBackend.dto.UserRoleResponse;
import com.hotel.HotelAdminBackend.entity.UserRole;
import com.hotel.HotelAdminBackend.repository.UserRoleRepository;
import com.hotel.HotelAdminBackend.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository repository;

    @Override
    public UserRoleResponse createRole(UserRoleRequest request) {

        UserRole role = UserRole.builder()
                .roleName(request.getRoleName())
                .isActive(request.getIsActive())
                .description(request.getDescription())
                .build();

        UserRole saved = repository.save(role);

        return mapToResponse(saved);
    }

    @Override
    public List<UserRoleResponse> getAllRoles() {

        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public UserRoleResponse getRoleById(Integer id) {

        UserRole role = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        return mapToResponse(role);
    }

    @Override
    public UserRoleResponse updateRole(Integer id, UserRoleRequest request) {

        UserRole role = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        role.setRoleName(request.getRoleName());
        role.setIsActive(request.getIsActive());
        role.setDescription(request.getDescription());

        UserRole updated = repository.save(role);

        return mapToResponse(updated);
    }

    @Override
    public void deleteRole(Integer id) {

        repository.deleteById(id);
    }

    private UserRoleResponse mapToResponse(UserRole role) {

        return UserRoleResponse.builder()
                .roleId(role.getRoleId())
                .roleName(role.getRoleName())
                .isActive(role.getIsActive())
                .description(role.getDescription())
                .build();
    }
}