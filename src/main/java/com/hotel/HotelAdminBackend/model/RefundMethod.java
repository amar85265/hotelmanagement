package com.hotel.HotelAdminBackend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "refund_methods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefundMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "method_id")
    private Integer methodId;

    @Column(name = "method_name")
    private String methodName;

    @Column(name = "is_active")
    private Boolean isActive;
}