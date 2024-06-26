package com.siimkoppel.meetingrooms.controller;

import com.siimkoppel.meetingrooms.dto.RoomDto;
import com.siimkoppel.meetingrooms.service.RoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class RoomControllerTest {

    @Mock
    private RoomService roomService;
    @InjectMocks
    private RoomController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllRooms_returns_allRooms() {

        List<RoomDto> expectedRooms = Arrays.asList(
                new RoomDto("Room 1", 1),
                new RoomDto("Room 2", 2),
                new RoomDto("Room 3", 3)
        );
        when(roomService.getAllRooms()).thenReturn(expectedRooms);

        ResponseEntity<List<RoomDto>> responseEntity = controller.getAllRooms();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedRooms, responseEntity.getBody());
    }

    @Test
    public void getRoomById_returnsRoomWhenFound() {
        RoomDto expectedRoomDto = new RoomDto("Room", 1);
        Long expectedRoomId = 1L;
        when(roomService.getRoomById(expectedRoomId)).thenReturn(expectedRoomDto);

        ResponseEntity<RoomDto> responseEntity = controller.getRoomById(expectedRoomId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedRoomDto, responseEntity.getBody());
        verify(roomService, times(1)).getRoomById(expectedRoomId);
    }

    @Test
    public void getRoomById_returnsNotFoundWhenRoomDoesNotExist() {

        Long nonExistentRoomId = 1000L;
        when(roomService.getRoomById(nonExistentRoomId)).thenReturn(null);

        ResponseEntity<RoomDto> responseEntity = controller.getRoomById(nonExistentRoomId);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }

    @Test
    public void createRoomCreatesRoom() {
        // Setup: Create RoomDto objects
        RoomDto roomDto = new RoomDto("Saal", 244);
        RoomDto savedRoomDto = new RoomDto("Saal", 244);

        // Mock Setup: Mock the behavior of createRoom method
        when(roomService.createRoom(any(RoomDto.class)))
                .thenReturn(savedRoomDto);

        // Method Call: Call the method under test
        RoomDto result = roomService.createRoom(roomDto);

        // Assertion: Verify the behavior of the method under test
        assertEquals(savedRoomDto, result);
    }

    @Test
    public void bookRoomBooksRoom() {
        RoomDto roomDto = new RoomDto(
                1L,
                "Koosolek", 10, true,
                LocalDateTime.of(2024, 5, 9, 6, 30, 40),
                LocalDateTime.of(2024, 9, 9, 6, 30, 40));

        RoomDto bookedRoomDto = new RoomDto(
                1L,
                "Koosolek", 10, true,
                LocalDateTime.of(2024, 5, 9, 6, 30, 40),
                LocalDateTime.of(2024, 9, 9, 6, 30, 40));

        // Mocking the behavior of roomService.bookRoom for specific arguments
        when(roomService.bookRoom(eq(roomDto),
                eq(LocalDateTime.of(2024, 5, 9, 6, 30, 40)),
                eq(LocalDateTime.of(2024, 9, 9, 6, 30, 40))))
                .thenReturn(bookedRoomDto);

        RoomDto result = roomService.bookRoom(
                roomDto,
                LocalDateTime.of(2024, 5, 9, 6, 30, 40),
                LocalDateTime.of(2024, 9, 9, 6, 30, 40)
        );

        assertEquals(bookedRoomDto, result);
    }

}
