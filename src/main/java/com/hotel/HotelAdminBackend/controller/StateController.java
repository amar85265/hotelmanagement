package com.hotel.HotelAdminBackend.controller;

import com.hotel.HotelAdminBackend.dto.StateRequest;
import com.hotel.HotelAdminBackend.dto.StateResponse;
import com.hotel.HotelAdminBackend.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/states")
@RequiredArgsConstructor
public class StateController {

    private final StateService stateService;

    @PostMapping
    public StateResponse createState(@RequestBody StateRequest request) {

        return stateService.createState(request);
    }

    @GetMapping
    public List<StateResponse> getAllStates() {

        return stateService.getAllStates();
    }

    @GetMapping("/{id}")
    public StateResponse getStateById(@PathVariable Integer id) {

        return stateService.getStateById(id);
    }

    @PutMapping("/{id}")
    public StateResponse updateState(
            @PathVariable Integer id,
            @RequestBody StateRequest request) {

        return stateService.updateState(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteState(@PathVariable Integer id) {

        stateService.deleteState(id);

        return "State deleted successfully";
    }
}