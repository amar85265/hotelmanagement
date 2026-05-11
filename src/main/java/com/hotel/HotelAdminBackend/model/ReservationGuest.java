package com.hotel.HotelAdminBackend.model;

import com.hotel.HotelAdminBackend.model.Guest;
import com.hotel.HotelAdminBackend.model.Reservation;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reservation_guests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationGuest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_guest_id")
    private Integer reservationGuestId;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;
}