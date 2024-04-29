package com.siimkoppel.meetingrooms.service.impl;

import com.siimkoppel.meetingrooms.dto.RoomDto;
import com.siimkoppel.meetingrooms.entity.Room;
import com.siimkoppel.meetingrooms.mapper.RoomMapper;
import com.siimkoppel.meetingrooms.repository.RoomRepository;
import com.siimkoppel.meetingrooms.service.RoomService;
import org.springframework.stereotype.Service;

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
        Room room = roomRepository.
                findById(id).
                orElseThrow(()->new RuntimeException("Room does not exist"));
        return RoomMapper.mapToRoomDto(room);
    }

    @Override
    public RoomDto bookRoom(RoomDto roomDto) {
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
