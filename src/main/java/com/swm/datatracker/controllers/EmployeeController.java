package com.swm.datatracker.controllers;

import com.swm.datatracker.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @GetMapping("/emp/profile")
    public String empProfile(Model vModel) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        vModel.addAttribute("user", user);
        return "/emp/profile";
    }
}

