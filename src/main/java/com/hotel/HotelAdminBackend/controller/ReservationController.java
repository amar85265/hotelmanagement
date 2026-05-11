package com.hotel.HotelAdminBackend.controller;

import com.hotel.HotelAdminBackend.dto.ReservationRequest;
import com.hotel.HotelAdminBackend.dto.ReservationResponse;
import com.hotel.HotelAdminBackend.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public ReservationResponse createReservation(
            @RequestBody ReservationRequest request) {

        return reservationService
                .createReservation(request);
    }

    @GetMapping("/{id}")
    public ReservationResponse getReservationById(
            @PathVariable Integer id) {

        return reservationService
                .getReservationById(id);
    }

    @GetMapping
    public List<ReservationResponse> getAllReservations() {

        return reservationService.getAllReservations();
    }

    @PutMapping("/{id}")
    public ReservationResponse updateReservation(
            @PathVariable Integer id,
            @RequestBody ReservationRequest request) {

        return reservationService
                .updateReservation(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteReservation(
            @PathVariable Integer id) {

        reservationService.deleteReservation(id);

        return "Reservation deleted successfully";
    }
}