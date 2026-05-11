package com.hotel.HotelAdminBackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RoomAmenityId implements Serializable {

    @Column(name = "room_type_id")
    private Integer roomTypeId;

    @Column(name = "amenity_id")
    private Integer amenityId;
}