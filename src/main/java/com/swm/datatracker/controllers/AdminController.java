package com.swm.datatracker.controllers;

import com.swm.datatracker.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin/home")
    public String adminHome(Model vModel) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        vModel.addAttribute("user", currentUser);
        return "/admin/home";
    }

    @GetMapping("/admin/work-orders")
    public String adminWorkOrders(Model vModel) {

        return "/admin/work-orders";
    }
}
