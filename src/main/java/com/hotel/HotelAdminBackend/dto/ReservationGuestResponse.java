package com.hotel.HotelAdminBackend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservationGuestResponse {

    private Integer reservationGuestId;

    private Integer reservationId;

    private Integer guestId;

    private String guestName;

    private String guestEmail;
}