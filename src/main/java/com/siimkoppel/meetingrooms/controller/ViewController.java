package com.siimkoppel.meetingrooms.controller;

import com.siimkoppel.meetingrooms.viewmodel.RoomViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

    @GetMapping("/home")
    public ModelAndView renderHomeView() {
        RoomViewModel roomViewModel = new RoomViewModel("My Room", 123);
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("roomName", roomViewModel.roomName());
        modelAndView.addObject("roomNumber", roomViewModel.roomNumber());
        return modelAndView;
    }
}