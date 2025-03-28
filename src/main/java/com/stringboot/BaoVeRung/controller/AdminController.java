package com.stringboot.BaoVeRung.controller;

import com.stringboot.BaoVeRung.entity.Event;
import com.stringboot.BaoVeRung.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/admin")
@Controller
public class AdminController {
    private EventService eventService;
    public AdminController(EventService eventService) {
        this.eventService = eventService;
    }
    @GetMapping("")
    public String index() {
        return "admin-home";
    }

    @GetMapping("/events/list-event")
    public String event(Model model) {
        List<Event> events = eventService.findAll();
        model.addAttribute("events", events);
        return "admin-event";
    }

    @GetMapping("/schedules/list-schedule")
    public String schedule() {
        return "admin-schedule";
    }


    @GetMapping("/blogs/list-blog")
    public String blog() {
        return "admin-blog";
    }


    @GetMapping("/donates/list-donate")
    public String donate() {
        return "admin-donate";
    }

}
