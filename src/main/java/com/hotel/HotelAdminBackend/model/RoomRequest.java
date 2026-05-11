package com.hotel.HotelAdminBackend.model;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class RoomRequest {

    private String roomNumber;
    private Integer roomTypeId;
    private BigDecimal price;
    private String bedType;
    private String viewType;
    private String status;
}