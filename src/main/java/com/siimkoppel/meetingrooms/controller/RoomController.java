package com.siimkoppel.meetingrooms.controller;

import com.siimkoppel.meetingrooms.dto.RoomDto;
import com.siimkoppel.meetingrooms.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
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

    @PostMapping("/addroom")
    public ResponseEntity<RoomDto> addRoom(@RequestBody RoomDto roomDto) {
        return new ResponseEntity<>(roomService.createRoom(roomDto), HttpStatus.CREATED);
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
