package com.hotel.HotelAdminBackend.repository;

import com.hotel.HotelAdminBackend.model.ReservationGuest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationGuestRepository
        extends JpaRepository<ReservationGuest, Integer> {

    List<ReservationGuest>
    findByReservationReservationId(Integer reservationId);
}