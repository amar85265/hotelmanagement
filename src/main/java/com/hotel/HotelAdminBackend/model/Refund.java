package com.hotel.HotelAdminBackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "refunds")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Refund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "refund_id")
    private Integer refundId;

    @Column(name = "payment_id")
    private Integer paymentId;

    @Column(name = "refund_amount")
    private BigDecimal refundAmount;

    @Column(name = "refund_date")
    private LocalDateTime refundDate;

    @Column(name = "refund_reason")
    private String refundReason;

    @Column(name = "refund_method_id")
    private Integer refundMethodId;

    @Column(name = "processed_by_user_id")
    private Integer processedByUserId;

    @Column(name = "refund_status")
    private String refundStatus;
}