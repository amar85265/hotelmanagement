package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.RoomRequest;
import com.hotel.HotelAdminBackend.dto.RoomResponse;

import java.util.List;

public interface RoomService {

    RoomResponse createRoom(RoomRequest request);

    List<RoomResponse> getAllRooms();

    RoomResponse getRoomById(Integer id);

    RoomResponse updateRoom(Integer id, RoomRequest request);

    void deleteRoom(Integer id);
}