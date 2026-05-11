package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.AmenityRequest;
import com.hotel.HotelAdminBackend.dto.AmenityResponse;

import java.util.List;

public interface AmenityService {

    AmenityResponse createAmenity(AmenityRequest request);

    AmenityResponse getAmenityById(Integer id);

    List<AmenityResponse> getAllAmenities();

    List<AmenityResponse> getActiveAmenities();

    AmenityResponse updateAmenity(Integer id, AmenityRequest request);

    void deleteAmenity(Integer id);
}