package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.CountryRequest;
import com.hotel.HotelAdminBackend.dto.CountryResponse;

import java.util.List;

public interface CountryService {

    CountryResponse createCountry(CountryRequest request);

    CountryResponse getCountryById(Integer id);

    List<CountryResponse> getAllCountries();

    CountryResponse updateCountry(Integer id, CountryRequest request);

    void deleteCountry(Integer id);
}