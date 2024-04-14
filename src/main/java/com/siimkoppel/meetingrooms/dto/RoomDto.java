package com.siimkoppel.meetingrooms.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoomDto {
    private Long id;
    private String roomName;
    private int roomNumber;
    private boolean booked;
}
