package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.ReservationRequest;
import com.hotel.HotelAdminBackend.dto.ReservationResponse;
import com.hotel.HotelAdminBackend.model.Reservation;
import com.hotel.HotelAdminBackend.model.Room;
import com.hotel.HotelAdminBackend.model.User;
import com.hotel.HotelAdminBackend.repository.ReservationRepository;
import com.hotel.HotelAdminBackend.repository.RoomRepository;
import com.hotel.HotelAdminBackend.repository.UserRepository;
import com.hotel.HotelAdminBackend.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl
        implements ReservationService {

    private final ReservationRepository reservationRepository;

    private final UserRepository userRepository;

    private final RoomRepository roomRepository;

    @Override
    public ReservationResponse createReservation(
            ReservationRequest request) {

        User user = userRepository.findById(
                        request.getUserId())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Room room = roomRepository.findById(
                        request.getRoomId())
                .orElseThrow(() ->
                        new RuntimeException("Room not found"));

        if (request.getCheckOutDate()
                .isBefore(request.getCheckInDate())) {

            throw new RuntimeException(
                    "Check-out date must be after check-in date");
        }

        Reservation reservation = Reservation.builder()
                .user(user)
                .room(room)
                .bookingDate(request.getBookingDate())
                .checkInDate(request.getCheckInDate())
                .checkOutDate(request.getCheckOutDate())
                .numberOfGuests(request.getNumberOfGuests())
                .status(request.getStatus())
                .createdBy(request.getCreatedBy())
                .modifiedBy(request.getModifiedBy())
                .build();

        Reservation saved =
                reservationRepository.save(reservation);

        return mapToResponse(saved);
    }

    @Override
    public ReservationResponse getReservationById(
            Integer id) {

        Reservation reservation =
                reservationRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Reservation not found"));

        return mapToResponse(reservation);
    }

    @Override
    public List<ReservationResponse> getAllReservations() {

        return reservationRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public ReservationResponse updateReservation(
            Integer id,
            ReservationRequest request) {

        Reservation reservation =
                reservationRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Reservation not found"));

        User user = userRepository.findById(
                        request.getUserId())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Room room = roomRepository.findById(
                        request.getRoomId())
                .orElseThrow(() ->
                        new RuntimeException("Room not found"));

        reservation.setUser(user);
        reservation.setRoom(room);
        reservation.setBookingDate(request.getBookingDate());
        reservation.setCheckInDate(request.getCheckInDate());
        reservation.setCheckOutDate(request.getCheckOutDate());
        reservation.setNumberOfGuests(
                request.getNumberOfGuests());
        reservation.setStatus(request.getStatus());
        reservation.setModifiedBy(request.getModifiedBy());

        Reservation updated =
                reservationRepository.save(reservation);

        return mapToResponse(updated);
    }

    @Override
    public void deleteReservation(Integer id) {

        Reservation reservation =
                reservationRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Reservation not found"));

        reservationRepository.delete(reservation);
    }

    private ReservationResponse mapToResponse(
            Reservation reservation) {

        return ReservationResponse.builder()
                .reservationId(
                        reservation.getReservationId())
                .userId(
                        reservation.getUser().getUserId())
                .userEmail(
                        reservation.getUser().getEmail())
                .roomId(
                        reservation.getRoom().getRoomId())
                .roomNumber(
                        reservation.getRoom().getRoomNumber())
                .bookingDate(
                        reservation.getBookingDate())
                .checkInDate(
                        reservation.getCheckInDate())
                .checkOutDate(
                        reservation.getCheckOutDate())
                .numberOfGuests(
                        reservation.getNumberOfGuests())
                .status(
                        reservation.getStatus())
                .createdBy(
                        reservation.getCreatedBy())
                .createdDate(
                        reservation.getCreatedDate())
                .modifiedBy(
                        reservation.getModifiedBy())
                .modifiedDate(
                        reservation.getModifiedDate())
                .build();
    }
}