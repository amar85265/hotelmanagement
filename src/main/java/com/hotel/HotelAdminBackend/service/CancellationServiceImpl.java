package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.CancellationRequest;
import com.hotel.HotelAdminBackend.dto.CancellationResponse;
import com.hotel.HotelAdminBackend.model.Cancellation;
import com.hotel.HotelAdminBackend.model.Reservation;
import com.hotel.HotelAdminBackend.repository.CancellationRepository;
import com.hotel.HotelAdminBackend.repository.ReservationRepository;
import com.hotel.HotelAdminBackend.service.CancellationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CancellationServiceImpl implements CancellationService {

    private final CancellationRepository cancellationRepository;
    private final ReservationRepository reservationRepository;

    @Override
    public CancellationResponse createCancellation(
            CancellationRequest request) {

        Reservation reservation = reservationRepository
                .findById(request.getReservationId())
                .orElseThrow(() ->
                        new RuntimeException("Reservation not found"));

        Cancellation cancellation = Cancellation.builder()
                .reservation(reservation)
                .cancellationDate(request.getCancellationDate())
                .reason(request.getReason())
                .cancellationFee(request.getCancellationFee())
                .cancellationStatus(request.getCancellationStatus())
                .createdBy(request.getCreatedBy())
                .createdDate(request.getCreatedDate())
                .modifiedBy(request.getModifiedBy())
                .modifiedDate(request.getModifiedDate())
                .build();

        Cancellation saved =
                cancellationRepository.save(cancellation);

        return mapToResponse(saved);
    }

    @Override
    public List<CancellationResponse> getAllCancellations() {

        return cancellationRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CancellationResponse getCancellationById(Integer id) {

        Cancellation cancellation = cancellationRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Cancellation not found"));

        return mapToResponse(cancellation);
    }

    @Override
    public CancellationResponse updateCancellation(
            Integer id,
            CancellationRequest request) {

        Cancellation cancellation =
                cancellationRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Cancellation not found"));

        Reservation reservation = reservationRepository
                .findById(request.getReservationId())
                .orElseThrow(() ->
                        new RuntimeException("Reservation not found"));

        cancellation.setReservation(reservation);
        cancellation.setCancellationDate(request.getCancellationDate());
        cancellation.setReason(request.getReason());
        cancellation.setCancellationFee(request.getCancellationFee());
        cancellation.setCancellationStatus(request.getCancellationStatus());
        cancellation.setCreatedBy(request.getCreatedBy());
        cancellation.setCreatedDate(request.getCreatedDate());
        cancellation.setModifiedBy(request.getModifiedBy());
        cancellation.setModifiedDate(request.getModifiedDate());

        Cancellation updated =
                cancellationRepository.save(cancellation);

        return mapToResponse(updated);
    }

    @Override
    public void deleteCancellation(Integer id) {

        Cancellation cancellation =
                cancellationRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Cancellation not found"));

        cancellationRepository.delete(cancellation);
    }

    private CancellationResponse mapToResponse(
            Cancellation cancellation) {

        return CancellationResponse.builder()
                .cancellationId(cancellation.getCancellationId())
                .reservationId(
                        cancellation.getReservation().getReservationId())
                .cancellationDate(cancellation.getCancellationDate())
                .reason(cancellation.getReason())
                .cancellationFee(cancellation.getCancellationFee())
                .cancellationStatus(cancellation.getCancellationStatus())
                .createdBy(cancellation.getCreatedBy())
                .createdDate(cancellation.getCreatedDate())
                .modifiedBy(cancellation.getModifiedBy())
                .modifiedDate(cancellation.getModifiedDate())
                .build();
    }
}