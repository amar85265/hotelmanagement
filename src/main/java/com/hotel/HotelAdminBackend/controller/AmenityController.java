package com.hotel.HotelAdminBackend.controller;

import com.hotel.HotelAdminBackend.dto.AmenityRequest;
import com.hotel.HotelAdminBackend.dto.AmenityResponse;
import com.hotel.HotelAdminBackend.service.AmenityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/amenities")
@RequiredArgsConstructor
public class AmenityController {

    private final AmenityService amenityService;

    @PostMapping
    public AmenityResponse createAmenity(
            @RequestBody AmenityRequest request) {

        return amenityService.createAmenity(request);
    }

    @GetMapping("/{id}")
    public AmenityResponse getAmenityById(
            @PathVariable Integer id) {

        return amenityService.getAmenityById(id);
    }

    @GetMapping
    public List<AmenityResponse> getAllAmenities() {

        return amenityService.getAllAmenities();
    }

    @GetMapping("/active")
    public List<AmenityResponse> getActiveAmenities() {

        return amenityService.getActiveAmenities();
    }

    @PutMapping("/{id}")
    public AmenityResponse updateAmenity(
            @PathVariable Integer id,
            @RequestBody AmenityRequest request) {

        return amenityService.updateAmenity(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteAmenity(
            @PathVariable Integer id) {

        amenityService.deleteAmenity(id);

        return "Amenity deleted successfully";
    }
}