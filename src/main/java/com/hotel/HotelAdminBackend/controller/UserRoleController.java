package com.hotel.HotelAdminBackend.controller;

import com.hotel.HotelAdminBackend.dto.UserRoleRequest;
import com.hotel.HotelAdminBackend.dto.UserRoleResponse;
import com.hotel.HotelAdminBackend.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class UserRoleController {

    private final UserRoleService service;

    @PostMapping
    public UserRoleResponse createRole(@RequestBody UserRoleRequest request) {
        return service.createRole(request);
    }

    @GetMapping
    public List<UserRoleResponse> getAllRoles() {
        return service.getAllRoles();
    }

    @GetMapping("/{id}")
    public UserRoleResponse getRoleById(@PathVariable Integer id) {
        return service.getRoleById(id);
    }

    @PutMapping("/{id}")
    public UserRoleResponse updateRole(
            @PathVariable Integer id,
            @RequestBody UserRoleRequest request) {

        return service.updateRole(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteRole(@PathVariable Integer id) {

        service.deleteRole(id);

        return "Role deleted successfully";
    }
}