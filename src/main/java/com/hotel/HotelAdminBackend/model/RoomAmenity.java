package com.hotel.HotelAdminBackend.model;

import com.hotel.HotelAdminBackend.model.Amenity;
import com.hotel.HotelAdminBackend.model.RoomType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "room_amenities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomAmenity {

    @EmbeddedId
    private com.hotel.HotelAdminBackend.model.RoomAmenityId id;

    @ManyToOne
    @MapsId("roomTypeId")
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;

    @ManyToOne
    @MapsId("amenityId")
    @JoinColumn(name = "amenity_id")
    private Amenity amenity;
}