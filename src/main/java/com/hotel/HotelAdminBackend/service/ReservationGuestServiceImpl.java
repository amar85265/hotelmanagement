package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.ReservationGuestRequest;
import com.hotel.HotelAdminBackend.dto.ReservationGuestResponse;
import com.hotel.HotelAdminBackend.model.Guest;
import com.hotel.HotelAdminBackend.model.Reservation;
import com.hotel.HotelAdminBackend.model.ReservationGuest;
import com.hotel.HotelAdminBackend.repository.GuestRepository;
import com.hotel.HotelAdminBackend.repository.ReservationGuestRepository;
import com.hotel.HotelAdminBackend.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationGuestServiceImpl
        implements ReservationGuestService {

    private final ReservationGuestRepository reservationGuestRepository;

    private final ReservationRepository reservationRepository;

    private final GuestRepository guestRepository;

    @Override
    public ReservationGuestResponse addGuestToReservation(
            ReservationGuestRequest request) {

        Reservation reservation = reservationRepository
                .findById(request.getReservationId())
                .orElseThrow(() ->
                        new RuntimeException("Reservation not found"));

        Guest guest = guestRepository
                .findById(request.getGuestId())
                .orElseThrow(() ->
                        new RuntimeException("Guest not found"));

        ReservationGuest reservationGuest = ReservationGuest.builder()
                .reservation(reservation)
                .guest(guest)
                .build();

        ReservationGuest savedReservationGuest =
                reservationGuestRepository.save(reservationGuest);

        return mapToResponse(savedReservationGuest);
    }

    @Override
    public List<ReservationGuestResponse> getGuestsByReservation(
            Integer reservationId) {

        List<ReservationGuest> reservationGuests =
                reservationGuestRepository
                        .findByReservationReservationId(reservationId);

        return reservationGuests.stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public ReservationGuestResponse updateReservationGuest(
            Integer id,
            ReservationGuestRequest request) {

        ReservationGuest existingReservationGuest =
                reservationGuestRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Reservation Guest not found"));

        Reservation reservation = reservationRepository
                .findById(request.getReservationId())
                .orElseThrow(() ->
                        new RuntimeException("Reservation not found"));

        Guest guest = guestRepository
                .findById(request.getGuestId())
                .orElseThrow(() ->
                        new RuntimeException("Guest not found"));

        existingReservationGuest.setReservation(reservation);
        existingReservationGuest.setGuest(guest);

        ReservationGuest updatedReservationGuest =
                reservationGuestRepository
                        .save(existingReservationGuest);

        return mapToResponse(updatedReservationGuest);
    }

    @Override
    public void deleteReservationGuest(Integer id) {

        ReservationGuest reservationGuest =
                reservationGuestRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Reservation Guest not found"));

        reservationGuestRepository.delete(reservationGuest);
    }

    private ReservationGuestResponse mapToResponse(
            ReservationGuest reservationGuest) {

        Guest guest = reservationGuest.getGuest();

        return ReservationGuestResponse.builder()
                .reservationGuestId(
                        reservationGuest.getReservationGuestId())
                .reservationId(
                        reservationGuest.getReservation()
                                .getReservationId())
                .guestId(
                        guest.getGuestId())
                .guestName(
                        guest.getFirstName() + " "
                                + guest.getLastName())
                .guestEmail(
                        guest.getEmail())
                .build();
    }
}