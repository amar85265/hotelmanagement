package com.hotel.HotelAdminBackend.repository;

import com.hotel.HotelAdminBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    // 🔍 Find user by email (used for duplicate check / login)
    Optional<User> findByEmail(String email);

    // 🔍 Check if email already exists (clean way)
    boolean existsByEmail(String email);
}