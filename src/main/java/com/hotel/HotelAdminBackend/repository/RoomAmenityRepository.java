package com.hotel.HotelAdminBackend.repository;

import com.hotel.HotelAdminBackend.model.RoomAmenity;
import com.hotel.HotelAdminBackend.model.RoomAmenityId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomAmenityRepository
        extends JpaRepository<RoomAmenity, RoomAmenityId> {

    List<RoomAmenity> findByRoomTypeRoomTypeId(Integer roomTypeId);
}