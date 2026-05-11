package com.hotel.HotelAdminBackend.controller;

import com.hotel.HotelAdminBackend.dto.RoomRequest;
import com.hotel.HotelAdminBackend.dto.RoomResponse;
import com.hotel.HotelAdminBackend.service.RoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    // ✅ CREATE ROOM
    @PostMapping
    public RoomResponse createRoom(@Valid @RequestBody RoomRequest request) {
        return roomService.createRoom(request);
    }

    // ✅ GET ALL ROOMS
    @GetMapping
    public List<RoomResponse> getAllRooms() {
        return roomService.getAllRooms();
    }

    // ✅ GET ROOM BY ID
    @GetMapping("/{id}")
    public RoomResponse getRoomById(@PathVariable Integer id) {
        return roomService.getRoomById(id);
    }

    // ✅ UPDATE ROOM
    @PutMapping("/{id}")
    public RoomResponse updateRoom(@PathVariable Integer id,
                                   @Valid @RequestBody RoomRequest request) {
        return roomService.updateRoom(id, request);
    }

    // ✅ DELETE ROOM (soft delete)
    @DeleteMapping("/{id}")
    public String deleteRoom(@PathVariable Integer id) {
        roomService.deleteRoom(id);
        return "Room deleted successfully";
    }
}