package com.hotel.HotelAdminBackend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedbackRequest {

    private Integer reservationId;

    private Integer guestId;

    private Integer rating;

    private String comment;
}