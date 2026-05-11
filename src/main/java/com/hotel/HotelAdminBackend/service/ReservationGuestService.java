package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.ReservationGuestRequest;
import com.hotel.HotelAdminBackend.dto.ReservationGuestResponse;

import java.util.List;

public interface ReservationGuestService {

    ReservationGuestResponse addGuestToReservation(
            ReservationGuestRequest request);

    List<ReservationGuestResponse>
    getGuestsByReservation(Integer reservationId);

    ReservationGuestResponse updateReservationGuest(
            Integer id,
            ReservationGuestRequest request);

    void deleteReservationGuest(Integer id);
}