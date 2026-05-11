package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.CancellationRequest;
import com.hotel.HotelAdminBackend.dto.CancellationResponse;

import java.util.List;

public interface CancellationService {

    CancellationResponse createCancellation(CancellationRequest request);

    List<CancellationResponse> getAllCancellations();

    CancellationResponse getCancellationById(Integer id);

    CancellationResponse updateCancellation(Integer id,
                                            CancellationRequest request);

    void deleteCancellation(Integer id);
}