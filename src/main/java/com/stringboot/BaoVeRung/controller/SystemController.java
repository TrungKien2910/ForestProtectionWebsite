package com.stringboot.BaoVeRung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/system")
@Controller
public class SystemController {
    @GetMapping("/list-system")
    public String system() {
        return "admin-system";
    }

}
