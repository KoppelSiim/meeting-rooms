package com.siimkoppel.meetingrooms.service;

import com.siimkoppel.meetingrooms.dto.RoomDto;


public interface RoomService {
    RoomDto createRoom(RoomDto room);
    RoomDto getRoomById(Long id);

    RoomDto bookRoom(Long id);
}
