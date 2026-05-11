package com.hotel.HotelAdminBackend.repository;

import com.hotel.HotelAdminBackend.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepository extends JpaRepository<RoomType, Integer> {
}