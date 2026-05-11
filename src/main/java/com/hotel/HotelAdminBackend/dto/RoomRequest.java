package com.hotel.HotelAdminBackend.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RoomRequest {

    @NotBlank(message = "Room number is required")
    private String roomNumber;

    @NotNull(message = "Room type ID is required")
    private Integer roomTypeId;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    private BigDecimal price;

    @NotBlank(message = "Bed type is required")
    private String bedType;

    @NotBlank(message = "View type is required")
    private String viewType;

    @NotBlank(message = "Status is required")
    private String status;
}