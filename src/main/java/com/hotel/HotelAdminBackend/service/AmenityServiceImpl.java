package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.AmenityRequest;
import com.hotel.HotelAdminBackend.dto.AmenityResponse;
import com.hotel.HotelAdminBackend.model
        .Amenity;
import com.hotel.HotelAdminBackend.repository.AmenityRepository;
import com.hotel.HotelAdminBackend.service.AmenityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AmenityServiceImpl implements AmenityService {

    private final AmenityRepository amenityRepository;

    @Override
    public AmenityResponse createAmenity(AmenityRequest request) {

        amenityRepository.findByNameIgnoreCase(request.getName())
                .ifPresent(a -> {
                    throw new RuntimeException("Amenity already exists");
                });

        Amenity amenity = Amenity.builder()
                .name(request.getName())
                .description(request.getDescription())
                .isActive(request.getIsActive())
                .createdBy(request.getCreatedBy())
                .modifiedBy(request.getModifiedBy())
                .build();

        Amenity saved = amenityRepository.save(amenity);

        return mapToResponse(saved);
    }

    @Override
    public AmenityResponse getAmenityById(Integer id) {

        Amenity amenity = amenityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Amenity not found"));

        return mapToResponse(amenity);
    }

    @Override
    public List<AmenityResponse> getAllAmenities() {

        return amenityRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<AmenityResponse> getActiveAmenities() {

        return amenityRepository.findByIsActiveTrue()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public AmenityResponse updateAmenity(Integer id, AmenityRequest request) {

        Amenity amenity = amenityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Amenity not found"));

        amenity.setName(request.getName());
        amenity.setDescription(request.getDescription());
        amenity.setIsActive(request.getIsActive());
        amenity.setModifiedBy(request.getModifiedBy());

        Amenity updated = amenityRepository.save(amenity);

        return mapToResponse(updated);
    }

    @Override
    public void deleteAmenity(Integer id) {

        Amenity amenity = amenityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Amenity not found"));

        amenityRepository.delete(amenity);
    }

    private AmenityResponse mapToResponse(Amenity amenity) {

        return AmenityResponse.builder()
                .amenityId(amenity.getAmenityId())
                .name(amenity.getName())
                .description(amenity.getDescription())
                .isActive(amenity.getIsActive())
                .createdBy(amenity.getCreatedBy())
                .createdDate(amenity.getCreatedDate())
                .modifiedBy(amenity.getModifiedBy())
                .modifiedDate(amenity.getModifiedDate())
                .build();
    }
}