package com.siimkoppel.meetingrooms.service;

import com.siimkoppel.meetingrooms.dto.RoomDto;

import java.util.List;


public interface RoomService {
    RoomDto createRoom(RoomDto room);
    RoomDto getRoomById(Long id);

    RoomDto bookRoom(Long id);

    List<RoomDto> getAllRooms();
}
