package com.siimkoppel.meetingrooms.controller;

import com.siimkoppel.meetingrooms.dto.RoomDto;
import com.siimkoppel.meetingrooms.service.RoomService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/welcome")
    public ResponseEntity<String> welcomeMessage() {
        String message = "Welcome to my meeting rooms application";
        return ResponseEntity.ok(message);
    }

    @GetMapping("/rooms")
    public ResponseEntity<List<RoomDto>> getAllRooms() {
        List<RoomDto> rooms = roomService.getAllRooms();
        return ResponseEntity.ok(rooms);
    }

    @PostMapping("/addroom")
    public ResponseEntity<String> handleFormSubmission(
            @RequestParam @NotBlank(message = "Please enter a room name") String roomName,
            @RequestParam @Positive(message = "Room number must be positive" ) int roomNumber
    ) {
        RoomDto dto = new RoomDto(roomName, roomNumber);
        roomService.createRoom(dto);
        return new ResponseEntity<>("Added a new room to database", HttpStatus.CREATED);
    }

    @PostMapping("/book/{id}")
    public ResponseEntity<RoomDto> bookRoomById(@PathVariable Long id) {
        RoomDto bookedRoomDto = roomService.bookRoom(id);
        return new ResponseEntity<>(bookedRoomDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDto> getRoomById(@PathVariable Long id) {
        RoomDto roomDto = roomService.getRoomById(id);
        return ResponseEntity.ok(roomDto);
    }

}
