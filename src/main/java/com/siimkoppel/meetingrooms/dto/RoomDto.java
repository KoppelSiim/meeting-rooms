package com.siimkoppel.meetingrooms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class RoomDto {
    private Long id;
    private String roomName;
    private int roomNumber;
    private boolean booked;
    private LocalDateTime bookedFrom;
    private LocalDateTime bookedTo;
}