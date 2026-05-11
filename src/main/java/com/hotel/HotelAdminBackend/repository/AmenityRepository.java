package com.hotel.HotelAdminBackend.repository;

import com.hotel.HotelAdminBackend.model.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AmenityRepository extends JpaRepository<Amenity, Integer> {

    Optional<Amenity> findByNameIgnoreCase(String name);

    List<Amenity> findByIsActiveTrue();
}