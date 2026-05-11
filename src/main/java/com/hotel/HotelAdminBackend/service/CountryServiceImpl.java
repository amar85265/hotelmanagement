package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.CountryRequest;
import com.hotel.HotelAdminBackend.dto.CountryResponse;
import com.hotel.HotelAdminBackend.model.Country;
import com.hotel.HotelAdminBackend.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public CountryResponse createCountry(CountryRequest request) {

        if (countryRepository.existsByCountryCode(request.getCountryCode())) {
            throw new RuntimeException("Country code already exists");
        }

        Country country = Country.builder()
                .countryName(request.getCountryName())
                .countryCode(request.getCountryCode())
                .isActive(request.getIsActive() != null ? request.getIsActive() : true)
                .build();

        country = countryRepository.save(country);
        return mapToResponse(country);
    }

    @Override
    public CountryResponse getCountryById(Integer id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found"));

        return mapToResponse(country);
    }

    @Override
    public List<CountryResponse> getAllCountries() {
        return countryRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CountryResponse updateCountry(Integer id, CountryRequest request) {

        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found"));

        country.setCountryName(request.getCountryName());
        country.setCountryCode(request.getCountryCode());
        country.setIsActive(request.getIsActive() != null ? request.getIsActive() : country.getIsActive());

        countryRepository.save(country);
        return mapToResponse(country);
    }

    @Override
    public void deleteCountry(Integer id) {
        countryRepository.deleteById(id);
    }

    private CountryResponse mapToResponse(Country country) {
        return CountryResponse.builder()
                .countryId(country.getCountryId())
                .countryName(country.getCountryName())
                .countryCode(country.getCountryCode())
                .isActive(country.getIsActive() != null ? country.getIsActive() : true)
                .build();
    }
}