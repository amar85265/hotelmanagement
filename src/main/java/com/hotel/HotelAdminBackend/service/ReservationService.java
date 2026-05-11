package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.ReservationRequest;
import com.hotel.HotelAdminBackend.dto.ReservationResponse;

import java.util.List;

public interface ReservationService {

    ReservationResponse createReservation(
            ReservationRequest request);

    ReservationResponse getReservationById(
            Integer id);

    List<ReservationResponse> getAllReservations();

    ReservationResponse updateReservation(
            Integer id,
            ReservationRequest request);

    void deleteReservation(
            Integer id);
}