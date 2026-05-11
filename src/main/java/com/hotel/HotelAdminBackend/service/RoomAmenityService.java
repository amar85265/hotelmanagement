package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.RoomAmenityRequest;
import com.hotel.HotelAdminBackend.dto.RoomAmenityResponse;

import java.util.List;

public interface RoomAmenityService {

    RoomAmenityResponse createRoomAmenity(
            RoomAmenityRequest request);

    List<RoomAmenityResponse> getAmenitiesByRoomType(
            Integer roomTypeId);

    RoomAmenityResponse updateRoomAmenity(
            RoomAmenityRequest request);

    void deleteRoomAmenity(
            Integer roomTypeId,
            Integer amenityId);
}