package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.GuestRequest;
import com.hotel.HotelAdminBackend.dto.GuestResponse;

import java.util.List;

public interface GuestService {

    GuestResponse createGuest(
            GuestRequest request);

    GuestResponse getGuestById(
            Integer id);

    List<GuestResponse> getAllGuests();

    GuestResponse updateGuest(
            Integer id,
            GuestRequest request);

    void deleteGuest(
            Integer id);
}