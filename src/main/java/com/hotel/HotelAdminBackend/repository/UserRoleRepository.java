package com.hotel.HotelAdminBackend.repository;

import com.hotel.HotelAdminBackend.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
}