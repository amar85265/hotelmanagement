package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.RoomAmenityRequest;
import com.hotel.HotelAdminBackend.dto.RoomAmenityResponse;
import com.hotel.HotelAdminBackend.model.*;
import com.hotel.HotelAdminBackend.repository.AmenityRepository;
import com.hotel.HotelAdminBackend.repository.RoomAmenityRepository;
import com.hotel.HotelAdminBackend.repository.RoomTypeRepository;
import com.hotel.HotelAdminBackend.service.RoomAmenityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomAmenityServiceImpl
        implements RoomAmenityService {

    private final RoomAmenityRepository roomAmenityRepository;

    private final RoomTypeRepository roomTypeRepository;

    private final AmenityRepository amenityRepository;

    @Override
    public RoomAmenityResponse createRoomAmenity(
            RoomAmenityRequest request) {

        RoomType roomType = roomTypeRepository.findById(
                        request.getRoomTypeId())
                .orElseThrow(() ->
                        new RuntimeException("Room Type not found"));

        Amenity amenity = amenityRepository.findById(
                        request.getAmenityId())
                .orElseThrow(() ->
                        new RuntimeException("Amenity not found"));

        RoomAmenityId id = new RoomAmenityId(
                request.getRoomTypeId(),
                request.getAmenityId());

        if (roomAmenityRepository.existsById(id)) {
            throw new RuntimeException(
                    "Mapping already exists");
        }

        RoomAmenity roomAmenity = RoomAmenity.builder()
                .id(id)
                .roomType(roomType)
                .amenity(amenity)
                .build();

        RoomAmenity saved =
                roomAmenityRepository.save(roomAmenity);

        return mapToResponse(saved);
    }

    @Override
    public List<RoomAmenityResponse>
    getAmenitiesByRoomType(Integer roomTypeId) {

        return roomAmenityRepository
                .findByRoomTypeRoomTypeId(roomTypeId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public RoomAmenityResponse updateRoomAmenity(
            RoomAmenityRequest request) {

        RoomAmenityId id = new RoomAmenityId(
                request.getRoomTypeId(),
                request.getAmenityId());

        RoomAmenity existing =
                roomAmenityRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Room amenity mapping not found"));

        RoomType roomType = roomTypeRepository.findById(
                        request.getRoomTypeId())
                .orElseThrow(() ->
                        new RuntimeException("Room Type not found"));

        Amenity amenity = amenityRepository.findById(
                        request.getAmenityId())
                .orElseThrow(() ->
                        new RuntimeException("Amenity not found"));

        existing.setRoomType(roomType);
        existing.setAmenity(amenity);

        RoomAmenity updated =
                roomAmenityRepository.save(existing);

        return mapToResponse(updated);
    }

    @Override
    public void deleteRoomAmenity(
            Integer roomTypeId,
            Integer amenityId) {

        RoomAmenityId id =
                new RoomAmenityId(roomTypeId, amenityId);

        RoomAmenity existing =
                roomAmenityRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Room amenity mapping not found"));

        roomAmenityRepository.delete(existing);
    }

    private RoomAmenityResponse mapToResponse(
            RoomAmenity roomAmenity) {

        return RoomAmenityResponse.builder()
                .roomTypeId(
                        roomAmenity.getRoomType().getRoomTypeId())
                .roomTypeName(
                        roomAmenity.getRoomType().getTypeName())
                .amenityId(
                        roomAmenity.getAmenity().getAmenityId())
                .amenityName(
                        roomAmenity.getAmenity().getName())
                .build();
    }
}