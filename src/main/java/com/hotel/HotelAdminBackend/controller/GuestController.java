package com.hotel.HotelAdminBackend.controller;

import com.hotel.HotelAdminBackend.dto.GuestRequest;
import com.hotel.HotelAdminBackend.dto.GuestResponse;
import com.hotel.HotelAdminBackend.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
@RequiredArgsConstructor
public class GuestController {

    private final GuestService guestService;

    @PostMapping
    public GuestResponse createGuest(
            @RequestBody GuestRequest request) {

        return guestService.createGuest(request);
    }

    @GetMapping("/{id}")
    public GuestResponse getGuestById(
            @PathVariable Integer id) {

        return guestService.getGuestById(id);
    }

    @GetMapping
    public List<GuestResponse> getAllGuests() {

        return guestService.getAllGuests();
    }

    @PutMapping("/{id}")
    public GuestResponse updateGuest(
            @PathVariable Integer id,
            @RequestBody GuestRequest request) {

        return guestService.updateGuest(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteGuest(
            @PathVariable Integer id) {

        guestService.deleteGuest(id);

        return "Guest deleted successfully";
    }
}