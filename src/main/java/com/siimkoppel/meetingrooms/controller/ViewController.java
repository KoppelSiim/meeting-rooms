package com.siimkoppel.meetingrooms.controller;

import com.siimkoppel.meetingrooms.dto.RoomDto;
import com.siimkoppel.meetingrooms.service.RoomService;
import com.siimkoppel.meetingrooms.viewmodel.RoomViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ViewController {
    private final RoomService roomService;

    public ViewController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/home")
    public ModelAndView renderHomeView() {
        List<RoomDto> allRooms = roomService.getAllRooms();
        List<RoomViewModel> roomViewModels = allRooms
                .stream()
                .map(roomDto -> new RoomViewModel(roomDto.getId(), roomDto.getRoomName(), roomDto.getRoomNumber()))
                .collect(Collectors.toList());
        ModelAndView homeViewModel = new ModelAndView("home");
        homeViewModel.addObject("roomViewModels", roomViewModels);
        return homeViewModel;

    }

    @GetMapping("/addroom")
    public ModelAndView addRoomView() {
        return new ModelAndView("addroom");
    }

    @GetMapping("/book/{id}")
    public ModelAndView bookRoomView(@PathVariable Long id) {
        RoomDto dto = roomService.getRoomById(id);
        RoomViewModel roomViewModel = new RoomViewModel(dto.getId(), dto.getRoomName(), dto.getRoomNumber());
        ModelAndView bookRoomModel = new ModelAndView("bookroom");
        bookRoomModel.addObject("room", roomViewModel);
        return bookRoomModel;
    }

    @GetMapping("/freerooms")
    public ModelAndView showFreeRooms() {
        List<RoomDto> allRooms = roomService.getAllRooms();
        List<RoomDto> nonBookedRooms = allRooms.stream()
                .filter(roomDto -> !roomDto.isBooked())
                .toList();
        List<RoomViewModel> roomViewModels = nonBookedRooms
                .stream()
                .map(roomDto -> new RoomViewModel(roomDto.getId(), roomDto.getRoomName(), roomDto.getRoomNumber()))
                .collect(Collectors.toList());
        ModelAndView freeRoomsModel = new ModelAndView("free");
        freeRoomsModel.addObject("roomViewModels", roomViewModels);
        return freeRoomsModel;
    }

}