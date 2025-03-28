package com.stringboot.BaoVeRung.controller;

import com.stringboot.BaoVeRung.dto.ScheduleDTO;
import com.stringboot.BaoVeRung.entity.Event;
import com.stringboot.BaoVeRung.entity.Schedule;
import com.stringboot.BaoVeRung.service.EventService;
import com.stringboot.BaoVeRung.service.ScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/schedules")
public class ScheduleController {
    private ScheduleService scheduleService;
    private EventService eventService;
    public ScheduleController(ScheduleService scheduleService, EventService eventService) {
        this.scheduleService = scheduleService;
        this.eventService = eventService;
    }

    @GetMapping("/list-schedule")
    public String listSchedule(Model model) {
        List<Event> events = eventService.findAll();
        model.addAttribute("events",events);
        return "schedule";
    }
    @GetMapping("/schedule")
    public String detailEvent(@RequestParam("id") int id, Model model) {
        List<ScheduleDTO> schedule = scheduleService.findByEvent_EventId(id);
        model.addAttribute("schedules",schedule);
        return "schedule-detail";
    }

    @GetMapping("/schedule-form-insert")
    public String formInsert(Model model) {
        Schedule schedule = new Schedule();
        model.addAttribute("schedule",schedule);
        return "schedule-form-insert";
    }
    @PostMapping("/save")
    public String save(Schedule schedule) {
        scheduleService.save( schedule);
        return "redirect:/schedules/list-schedule";
    }

    @GetMapping("/schedule-form-update")
    public String formUpdate(Model model) {
        Schedule schedule = new Schedule();
        model.addAttribute("schedule",schedule);
        return "schedule-form-update";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        scheduleService.deleteById(id);
        return "redirect:/schedules/list-schedule";
    }

}
