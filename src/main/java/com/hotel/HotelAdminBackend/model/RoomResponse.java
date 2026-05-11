package com.hotel.HotelAdminBackend.model;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class RoomResponse {

    private Integer roomId;
    private String roomNumber;
    private BigDecimal price;
    private String status;
}
