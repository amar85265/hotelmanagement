package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.RoomRequest;
import com.hotel.HotelAdminBackend.dto.RoomResponse;
import com.hotel.HotelAdminBackend.exception.ResourceNotFoundException;
import com.hotel.HotelAdminBackend.model.Room;
import com.hotel.HotelAdminBackend.repository.RoomRepository;
import com.hotel.HotelAdminBackend.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    public RoomResponse createRoom(RoomRequest request) {

        if (roomRepository.existsByRoomNumber(request.getRoomNumber())) {
            throw new RuntimeException("Room number already exists");
        }

        validateStatus(request.getStatus());

        Room room = new Room();
        room.setRoomNumber(request.getRoomNumber());
        room.setRoomTypeId(request.getRoomTypeId());
        room.setPrice(request.getPrice());
        room.setBedType(request.getBedType());
        room.setViewType(request.getViewType());
        room.setStatus(request.getStatus());
        room.setCreatedDate(LocalDateTime.now());
        room.setIsActive(true);

        return map(roomRepository.save(room));
    }

    @Override
    public List<RoomResponse> getAllRooms() {
        return roomRepository.findAll()
                .stream()
                .filter(Room::getIsActive) // ignore deleted
                .map(this::map)
                .collect(Collectors.toList());
    }

    @Override
    public RoomResponse getRoomById(Integer id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found"));

        return map(room);
    }

    @Override
    public RoomResponse updateRoom(Integer id, RoomRequest request) {

        validateStatus(request.getStatus());

        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found"));

        room.setRoomNumber(request.getRoomNumber());
        room.setRoomTypeId(request.getRoomTypeId());
        room.setPrice(request.getPrice());
        room.setBedType(request.getBedType());
        room.setViewType(request.getViewType());
        room.setStatus(request.getStatus());
        room.setModifiedDate(LocalDateTime.now());

        return map(roomRepository.save(room));
    }

    @Override
    public void deleteRoom(Integer id) {

        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found"));

        // soft delete
        room.setIsActive(false);
        room.setModifiedDate(LocalDateTime.now());
        roomRepository.save(room);
    }

    // 🔁 mapping
    private RoomResponse map(Room room) {
        RoomResponse res = new RoomResponse();
        res.setRoomId(room.getRoomId());
        res.setRoomNumber(room.getRoomNumber());
        res.setRoomTypeId(room.getRoomTypeId());
        res.setPrice(room.getPrice());
        res.setBedType(room.getBedType());
        res.setViewType(room.getViewType());
        res.setStatus(room.getStatus());
        res.setIsActive(room.getIsActive());
        res.setCreatedDate(room.getCreatedDate());
        res.setModifiedDate(room.getModifiedDate());
        return res;
    }

    // ✅ validation
    private void validateStatus(String status) {
        if (!List.of("Available", "Occupied", "Under Maintenance").contains(status)) {
            throw new RuntimeException("Invalid status");
        }
    }
}