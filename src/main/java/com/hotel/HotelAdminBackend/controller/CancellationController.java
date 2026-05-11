package com.hotel.HotelAdminBackend.controller;

import com.hotel.HotelAdminBackend.dto.CancellationRequest;
import com.hotel.HotelAdminBackend.dto.CancellationResponse;
import com.hotel.HotelAdminBackend.service.CancellationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cancellations")
@RequiredArgsConstructor
public class CancellationController {

    private final CancellationService cancellationService;

    @PostMapping
    public CancellationResponse createCancellation(
            @RequestBody CancellationRequest request) {

        return cancellationService.createCancellation(request);
    }

    @GetMapping
    public List<CancellationResponse> getAllCancellations() {

        return cancellationService.getAllCancellations();
    }

    @GetMapping("/{id}")
    public CancellationResponse getCancellationById(
            @PathVariable Integer id) {

        return cancellationService.getCancellationById(id);
    }

    @PutMapping("/{id}")
    public CancellationResponse updateCancellation(
            @PathVariable Integer id,
            @RequestBody CancellationRequest request) {

        return cancellationService.updateCancellation(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteCancellation(
            @PathVariable Integer id) {

        cancellationService.deleteCancellation(id);

        return "Cancellation deleted successfully";
    }
}