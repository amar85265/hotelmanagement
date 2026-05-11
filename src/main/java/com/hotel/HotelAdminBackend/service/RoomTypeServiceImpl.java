package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.RoomTypeRequest;
import com.hotel.HotelAdminBackend.dto.RoomTypeResponse;
import com.hotel.HotelAdminBackend.model.RoomType;
import com.hotel.HotelAdminBackend.repository.RoomTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomTypeServiceImpl implements RoomTypeService {

    private final RoomTypeRepository repository;

    @Override
    public RoomTypeResponse create(RoomTypeRequest request) {
        RoomType entity = new RoomType();
        entity.setTypeName(request.getTypeName());
        entity.setAccessibilityFeatures(request.getAccessibilityFeatures());
        entity.setDescription(request.getDescription());
        entity.setCreatedBy(request.getCreatedBy());
        entity.setCreatedDate(LocalDateTime.now());

        RoomType saved = repository.save(entity);

        return mapToResponse(saved);
    }

    @Override
    public List<RoomTypeResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public RoomTypeResponse getById(Integer id) {
        RoomType entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("RoomType not found"));

        return mapToResponse(entity);
    }

    @Override
    public RoomTypeResponse update(Integer id, RoomTypeRequest request) {
        RoomType entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("RoomType not found"));

        entity.setTypeName(request.getTypeName());
        entity.setAccessibilityFeatures(request.getAccessibilityFeatures());
        entity.setDescription(request.getDescription());
        entity.setModifiedBy(request.getCreatedBy());
        entity.setModifiedDate(LocalDateTime.now());

        return mapToResponse(repository.save(entity));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    private RoomTypeResponse mapToResponse(RoomType entity) {
        return RoomTypeResponse.builder()
                .roomTypeId(entity.getRoomTypeId())
                .typeName(entity.getTypeName())
                .accessibilityFeatures(entity.getAccessibilityFeatures())
                .description(entity.getDescription())
                .isActive(entity.getIsActive())
                .createdDate(entity.getCreatedDate())
                .build();
    }
}