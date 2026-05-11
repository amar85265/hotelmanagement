package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.RoomTypeRequest;
import com.hotel.HotelAdminBackend.dto.RoomTypeResponse;

import java.util.List;

public interface RoomTypeService {

    RoomTypeResponse create(RoomTypeRequest request);

    List<RoomTypeResponse> getAll();

    RoomTypeResponse getById(Integer id);

    RoomTypeResponse update(Integer id, RoomTypeRequest request);

    void delete(Integer id);
}