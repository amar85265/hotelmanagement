package com.hotel.HotelAdminBackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Room{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId

    @Column(unique = true, nullable = false)
    private String roomNumber;

    private Integer roomTypeId;

    private BigDecimal price;

    private String bedType;

    private String viewType;

    private String status

    private Boolean isActive = true;

    private String createdBy

    private LocalDateTime createdDate;

    private String modifiedBy;

    private LocalDateTime modifiedDate
}