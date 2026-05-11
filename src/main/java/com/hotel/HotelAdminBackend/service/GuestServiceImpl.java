package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.GuestRequest;
import com.hotel.HotelAdminBackend.dto.GuestResponse;
import com.hotel.HotelAdminBackend.model.*;
import com.hotel.HotelAdminBackend.repository.*;
import com.hotel.HotelAdminBackend.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestServiceImpl implements GuestService {

    private final GuestRepository guestRepository;

    private final UserRepository userRepository;

    private final CountryRepository countryRepository;

    private final StateRepository stateRepository;

    @Override
    public GuestResponse createGuest(
            GuestRequest request) {

        User user = userRepository.findById(
                        request.getUserId())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Country country = countryRepository.findById(
                        request.getCountryId())
                .orElseThrow(() ->
                        new RuntimeException("Country not found"));

        State state = stateRepository.findById(
                        request.getStateId())
                .orElseThrow(() ->
                        new RuntimeException("State not found"));

        Guest guest = Guest.builder()
                .user(user)
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .ageGroup(request.getAgeGroup())
                .address(request.getAddress())
                .country(country)
                .state(state)
                .createdBy(request.getCreatedBy())
                .modifiedBy(request.getModifiedBy())
                .build();

        Guest saved = guestRepository.save(guest);

        return mapToResponse(saved);
    }

    @Override
    public GuestResponse getGuestById(Integer id) {

        Guest guest = guestRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Guest not found"));

        return mapToResponse(guest);
    }

    @Override
    public List<GuestResponse> getAllGuests() {

        return guestRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public GuestResponse updateGuest(
            Integer id,
            GuestRequest request) {

        Guest guest = guestRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Guest not found"));

        User user = userRepository.findById(
                        request.getUserId())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Country country = countryRepository.findById(
                        request.getCountryId())
                .orElseThrow(() ->
                        new RuntimeException("Country not found"));

        State state = stateRepository.findById(
                        request.getStateId())
                .orElseThrow(() ->
                        new RuntimeException("State not found"));

        guest.setUser(user);
        guest.setFirstName(request.getFirstName());
        guest.setLastName(request.getLastName());
        guest.setEmail(request.getEmail());
        guest.setPhone(request.getPhone());
        guest.setAgeGroup(request.getAgeGroup());
        guest.setAddress(request.getAddress());
        guest.setCountry(country);
        guest.setState(state);
        guest.setModifiedBy(request.getModifiedBy());

        Guest updated = guestRepository.save(guest);

        return mapToResponse(updated);
    }

    @Override
    public void deleteGuest(Integer id) {

        Guest guest = guestRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Guest not found"));

        guestRepository.delete(guest);
    }

    private GuestResponse mapToResponse(Guest guest) {

        return GuestResponse.builder()
                .guestId(guest.getGuestId())
                .userId(guest.getUser().getUserId())
                .firstName(guest.getFirstName())
                .lastName(guest.getLastName())
                .email(guest.getEmail())
                .phone(guest.getPhone())
                .ageGroup(guest.getAgeGroup())
                .address(guest.getAddress())
                .countryId(
                        guest.getCountry().getCountryId())
                .countryName(
                        guest.getCountry().getCountryName())
                .stateId(
                        guest.getState().getStateId())
                .stateName(
                        guest.getState().getStateName())
                .createdBy(guest.getCreatedBy())
                .createdDate(guest.getCreatedDate())
                .modifiedBy(guest.getModifiedBy())
                .modifiedDate(guest.getModifiedDate())
                .build();
    }
}