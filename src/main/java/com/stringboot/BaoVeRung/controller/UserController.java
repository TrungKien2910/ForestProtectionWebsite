package com.stringboot.BaoVeRung.controller;

import com.stringboot.BaoVeRung.entity.User;
import com.stringboot.BaoVeRung.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list-user")
    public String listUser(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "user";
    }

    @GetMapping("/user-form-insert")
    public String formInsert(Model model) {
        User user = new User();
        model.addAttribute("user",user);
        return "user-form-insert";
    }
    @PostMapping("/save")
    public String save(User user) {
        userService.save(user);
        return "redirect:/users/list-user";
    }

    @GetMapping("/user-form-update")
    public String formUpdate(Model model) {
        User user = new User();
        model.addAttribute("user",user);
        return "user-form-update";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        userService.deleteById(id);
        return "redirect:/users/list-user";
    }

}
