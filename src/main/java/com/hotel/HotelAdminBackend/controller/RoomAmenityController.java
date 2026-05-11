package com.hotel.HotelAdminBackend.controller;

import com.hotel.HotelAdminBackend.dto.RoomAmenityRequest;
import com.hotel.HotelAdminBackend.dto.RoomAmenityResponse;
import com.hotel.HotelAdminBackend.service.RoomAmenityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-amenities")
@RequiredArgsConstructor
public class RoomAmenityController {

    private final RoomAmenityService roomAmenityService;

    @PostMapping
    public RoomAmenityResponse createRoomAmenity(
            @RequestBody RoomAmenityRequest request) {

        return roomAmenityService
                .createRoomAmenity(request);
    }

    @GetMapping("/{roomTypeId}")
    public List<RoomAmenityResponse>
    getAmenitiesByRoomType(
            @PathVariable Integer roomTypeId) {

        return roomAmenityService
                .getAmenitiesByRoomType(roomTypeId);
    }

    @PutMapping
    public RoomAmenityResponse updateRoomAmenity(
            @RequestBody RoomAmenityRequest request) {

        return roomAmenityService
                .createRoomAmenity(request);
    }

    @DeleteMapping
    public String deleteRoomAmenity(
            @RequestParam Integer roomTypeId,
            @RequestParam Integer amenityId) {

        roomAmenityService.deleteRoomAmenity(
                roomTypeId,
                amenityId);

        return "Room amenity deleted successfully";
    }
}