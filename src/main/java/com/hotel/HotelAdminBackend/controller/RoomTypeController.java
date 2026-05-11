package com.hotel.HotelAdminBackend.controller;

import com.hotel.HotelAdminBackend.dto.RoomTypeRequest;
import com.hotel.HotelAdminBackend.dto.RoomTypeResponse;
import com.hotel.HotelAdminBackend.service.RoomTypeService;
import lombok.RequiredArgsConstructor;   
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-types")
@RequiredArgsConstructor
public class RoomTypeController {

    private final RoomTypeService service;

    @PostMapping
    public RoomTypeResponse create(@RequestBody RoomTypeRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<RoomTypeResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public RoomTypeResponse getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public RoomTypeResponse update(@PathVariable Integer id,
                                   @RequestBody RoomTypeRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}