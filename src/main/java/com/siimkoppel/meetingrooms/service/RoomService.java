package com.siimkoppel.meetingrooms.service;

import com.siimkoppel.meetingrooms.dto.RoomDto;

import java.time.LocalDateTime;
import java.util.List;


public interface RoomService {
    RoomDto createRoom(RoomDto room);
    RoomDto getRoomById(Long id);

    RoomDto bookRoom(RoomDto roomDto,LocalDateTime bookedFrom, LocalDateTime bookedTo);

    List<RoomDto> getAllRooms();
}
