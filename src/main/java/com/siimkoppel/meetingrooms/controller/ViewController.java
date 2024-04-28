package com.siimkoppel.meetingrooms.controller;

import com.siimkoppel.meetingrooms.dto.RoomDto;
import com.siimkoppel.meetingrooms.service.RoomService;
import com.siimkoppel.meetingrooms.viewmodel.RoomViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
                .map(roomDto -> new RoomViewModel(roomDto.getRoomName(), roomDto.getRoomNumber()))
                .collect(Collectors.toList());
        ModelAndView homeViewModel = new ModelAndView("home");
        homeViewModel.addObject("roomViewModels", roomViewModels);
        return homeViewModel;

    }
    @GetMapping("/addroom")
    public ModelAndView addRoomView() {
        return new ModelAndView("addroom");
    }

}