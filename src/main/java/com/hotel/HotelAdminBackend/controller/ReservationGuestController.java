package com.hotel.HotelAdminBackend.controller;

import com.hotel.HotelAdminBackend.dto.ReservationGuestRequest;
import com.hotel.HotelAdminBackend.dto.ReservationGuestResponse;
import com.hotel.HotelAdminBackend.service.ReservationGuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation-guests")
@RequiredArgsConstructor
public class ReservationGuestController {

    private final ReservationGuestService
            reservationGuestService;

    @PostMapping
    public ReservationGuestResponse
    addGuestToReservation(
            @RequestBody
            ReservationGuestRequest request) {

        return reservationGuestService
                .addGuestToReservation(request);
    }

    @GetMapping("/{reservationId}")
    public List<ReservationGuestResponse>
    getGuestsByReservation(
            @PathVariable Integer reservationId) {

        return reservationGuestService
                .getGuestsByReservation(reservationId);
    }

    @PutMapping("/{id}")
    public ReservationGuestResponse
    updateReservationGuest(
            @PathVariable Integer id,
            @RequestBody
            ReservationGuestRequest request) {

        return reservationGuestService
                .updateReservationGuest(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteReservationGuest(
            @PathVariable Integer id) {

        reservationGuestService
                .deleteReservationGuest(id);

        return "Reservation guest deleted successfully";
    }
}