package com.hotel.HotelAdminBackend.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationRequest {

    private Integer userId;

    private Integer roomId;

    private LocalDate bookingDate;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private Integer numberOfGuests;

    private String status;

    private String createdBy;

    private String modifiedBy;
}