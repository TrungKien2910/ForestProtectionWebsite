package com.stringboot.BaoVeRung.controller;

import com.stringboot.BaoVeRung.entity.Event;
import com.stringboot.BaoVeRung.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {
    private EventService eventService;
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/list-event")
    public String listEvent(Model model) {
        List<Event> events = eventService.findAll();
        model.addAttribute("events",events);
        System.out.println(events);
        return "event";
    }
    @GetMapping("/event")
        public String detailEvent(@RequestParam("id") int id, Model model) {
        Event event = eventService.findById(id);
        model.addAttribute("event",event);
        return "event-detail";
    }



    @GetMapping("/event-form-insert")
    public String formInsert(Model model) {
        Event event = new Event();
        model.addAttribute("event",event);
        return "event-form-insert";
    }
    @PostMapping("/save")
    public String save(Event event) {
        eventService.save( event);
        return "redirect:/events/list-event";
    }

    @GetMapping("/event-form-update")
    public String formUpdate(Model model) {
        Event event = new Event();
        model.addAttribute("event",event);
        return "event-form-update";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        eventService.deleteById(id);
        return "redirect:/events/list-event";
    }

}
