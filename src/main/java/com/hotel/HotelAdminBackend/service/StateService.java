package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.StateRequest;
import com.hotel.HotelAdminBackend.dto.StateResponse;

import java.util.List;

public interface StateService {

    StateResponse createState(StateRequest request);

    List<StateResponse> getAllStates();

    StateResponse getStateById(Integer id);

    StateResponse updateState(Integer id, StateRequest request);

    void deleteState(Integer id);
}