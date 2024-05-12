package com.siimkoppel.meetingrooms.service.impl;

import com.siimkoppel.meetingrooms.dto.RoomDto;
import com.siimkoppel.meetingrooms.entity.Room;
import com.siimkoppel.meetingrooms.mapper.RoomMapper;
import com.siimkoppel.meetingrooms.repository.RoomRepository;
import com.siimkoppel.meetingrooms.service.RoomService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public RoomDto createRoom(RoomDto roomDto) {
        Room room = RoomMapper.mapToRoom(roomDto);
        Room savedRoom = roomRepository.save(room);
        return RoomMapper.mapToRoomDto(savedRoom);
    }

    @Override
    public RoomDto getRoomById(Long id) {
        Room room = roomRepository.findById(id).orElse(null);
        if (room != null) {
            return RoomMapper.mapToRoomDto(room);
        } else {
            return null;
        }
    }

    @Override
    public RoomDto bookRoom(RoomDto roomDto, LocalDateTime bookedFrom, LocalDateTime bookedTo) {

        LocalDateTime currentTime = LocalDateTime.now();

        if (bookedFrom.isBefore(currentTime)) {
            throw new IllegalArgumentException("Booking start time cannot be in the past.");
        }

        if (bookedTo.isBefore(bookedFrom)) {
            throw new IllegalArgumentException("Booking end time cannot be before start time.");
        }

        roomDto.setBookedFrom(bookedFrom);
        roomDto.setBookedTo(bookedTo);
        roomDto.setBooked(true);
        Room room = RoomMapper.mapToRoom(roomDto);
        Room updatedRoom = roomRepository.save(room);
        return RoomMapper.mapToRoomDto(updatedRoom);
    }

    @Override
    public List<RoomDto> getAllRooms() {
        List<Room> rooms = roomRepository.findAll();
        return rooms.stream()
                .map(RoomMapper::mapToRoomDto)
                .collect(Collectors.toList());
    }
}
