package com.hotel.HotelAdminBackend.repository;

import com.hotel.HotelAdminBackend.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    // check duplicate room number
    boolean existsByRoomNumber(String roomNumber);
}