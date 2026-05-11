package com.hotel.HotelAdminBackend.controller;

import com.hotel.HotelAdminBackend.dto.CountryRequest;
import com.hotel.HotelAdminBackend.dto.CountryResponse;
import com.hotel.HotelAdminBackend.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @PostMapping
    public CountryResponse createCountry(@RequestBody CountryRequest request) {
        return countryService.createCountry(request);
    }

    @GetMapping("/{id}")
    public CountryResponse getCountry(@PathVariable Integer id) {
        return countryService.getCountryById(id);
    }

    @GetMapping
    public List<CountryResponse> getAllCountries() {
        return countryService.getAllCountries();
    }

    @PutMapping("/{id}")
    public CountryResponse updateCountry(@PathVariable Integer id,
                                         @RequestBody CountryRequest request) {
        return countryService.updateCountry(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteCountry(@PathVariable Integer id) {
        countryService.deleteCountry(id);
        return "Country deleted successfully";
    }
}