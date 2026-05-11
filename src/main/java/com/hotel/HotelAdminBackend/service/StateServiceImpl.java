package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.StateRequest;
import com.hotel.HotelAdminBackend.dto.StateResponse;
import com.hotel.HotelAdminBackend.model.Country;
import com.hotel.HotelAdminBackend.model.State;
import com.hotel.HotelAdminBackend.repository.CountryRepository;
import com.hotel.HotelAdminBackend.repository.StateRepository;
import com.hotel.HotelAdminBackend.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StateServiceImpl implements StateService {

    private final StateRepository stateRepository;
    private final CountryRepository countryRepository;

    @Override
    public StateResponse createState(StateRequest request) {

        Country country = countryRepository.findById(request.getCountryId())
                .orElseThrow(() -> new RuntimeException("Country not found"));

        State state = State.builder()
                .stateName(request.getStateName())
                .country(country)
                .isActive(request.getIsActive())
                .build();

        State saved = stateRepository.save(state);

        return mapToResponse(saved);
    }

    @Override
    public List<StateResponse> getAllStates() {

        return stateRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public StateResponse getStateById(Integer id) {

        State state = stateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("State not found"));

        return mapToResponse(state);
    }

    @Override
    public StateResponse updateState(Integer id, StateRequest request) {

        State state = stateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("State not found"));

        Country country = countryRepository.findById(request.getCountryId())
                .orElseThrow(() -> new RuntimeException("Country not found"));

        state.setStateName(request.getStateName());
        state.setCountry(country);
        state.setIsActive(request.getIsActive());

        State updated = stateRepository.save(state);

        return mapToResponse(updated);
    }

    @Override
    public void deleteState(Integer id) {

        stateRepository.deleteById(id);
    }

    private StateResponse mapToResponse(State state) {

        return StateResponse.builder()
                .stateId(state.getStateId())
                .stateName(state.getStateName())
                .countryId(state.getCountry().getCountryId())
                .countryName(state.getCountry().getCountryName())
                .isActive(state.getIsActive())
                .build();
    }
}