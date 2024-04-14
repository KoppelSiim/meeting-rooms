package com.siimkoppel.meetingrooms.mapper;

import com.siimkoppel.meetingrooms.dto.RoomDto;
import com.siimkoppel.meetingrooms.entity.Room;

public class RoomMapper {

    public static Room mapToRoom(RoomDto roomDto) {

        return new Room(roomDto.getId(), roomDto.getRoomName(), roomDto.getRoomNumber(), roomDto.isBooked());
    }

    public static RoomDto mapToRoomDto(Room room) {
        return new RoomDto(room.getId(), room.getRoomName(), room.getRoomNumber(), room.isBooked());
    }
}
