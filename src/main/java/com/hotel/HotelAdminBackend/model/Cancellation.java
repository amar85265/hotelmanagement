package com.hotel.HotelAdminBackend.model;

import com.hotel.HotelAdminBackend.model.Reservation;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "cancellations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cancellation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cancellation_id")
    private Integer cancellationId;

    @Column(name = "cancellation_date")
    private LocalDateTime cancellationDate;

    @Column(name = "reason")
    private String reason;

    @Column(name = "cancellation_fee")
    private BigDecimal cancellationFee;

    @Column(name = "cancellation_status")
    private String cancellationStatus;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;
}