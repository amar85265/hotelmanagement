package com.hotel.HotelAdminBackend.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private Integer roleId;

    @Column(unique = true)
    private String email;

    private String passwordHash;

    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime lastLogin = LocalDateTime.now();
    private Boolean isActive;

    private String createdBy;

    private LocalDateTime createdDate;

    private String modifiedBy;

    private LocalDateTime modifiedDate;
}