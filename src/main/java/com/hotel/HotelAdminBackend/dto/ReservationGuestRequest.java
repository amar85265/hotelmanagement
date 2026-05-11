package com.hotel.HotelAdminBackend.dto;

import lombok.Data;

@Data
public class ReservationGuestRequest {

    private Integer reservationId;

    private Integer guestId;
}