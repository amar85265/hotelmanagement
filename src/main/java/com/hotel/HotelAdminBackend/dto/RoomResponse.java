package com.hotel.HotelAdminBackend.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class RoomResponse {

    private Integer roomId;
    private String roomNumber;
    private Integer roomTypeId;
    private BigDecimal price;
    private String bedType;
    private String viewType;
    private String status;
    private Boolean isActive;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}