package com.hotel.HotelAdminBackend.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedbackResponse {

    private Integer feedbackId;

    private Integer reservationId;

    private Integer guestId;

    private Integer rating;

    private String comment;

    private LocalDateTime feedbackDate;
}