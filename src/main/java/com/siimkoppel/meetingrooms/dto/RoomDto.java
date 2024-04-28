package com.siimkoppel.meetingrooms.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    private Long id;
    private String roomName;
    @NotNull(message = "Please enter room number")
    private Integer roomNumber;
    private boolean booked;
    private LocalDateTime bookedFrom;
    private LocalDateTime bookedTo;

    public RoomDto(String roomName, Integer roomNumber) {
        this.roomName = roomName;
        this.roomNumber = roomNumber;
    }
}