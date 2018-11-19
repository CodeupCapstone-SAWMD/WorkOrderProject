package com.swm.datatracker.controllers;

import com.swm.datatracker.models.Status;
import com.swm.datatracker.models.User;
import com.swm.datatracker.models.UserRole;
import com.swm.datatracker.respositories.StatusRepository;
import com.swm.datatracker.respositories.UserRepository;
import com.swm.datatracker.respositories.WorkOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WorkOrderRepository workOrderRepository;


    @GetMapping("/emp/profile")
    public String empProfile(Model vModel) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

//        Status submitted = statusRepository.findOne(1L);
//        Status pendingAssignment = statusRepository.findOne(2L);
        Status processing = statusRepository.findOne(3L);
        Status reviewed = statusRepository.findOne(4L);
        Status completed = statusRepository.findOne(5L);
        Status cancelled = statusRepository.findOne(6L);
        vModel.addAttribute("user", user);

//        vModel.addAttribute("submitted", workOrderRepository.findAllByEmployeeAndStatus(user, submitted));
//        vModel.addAttribute("pending", workOrderRepository.findAllByEmployeeAndStatus(user, pendingAssignment));
        vModel.addAttribute("processing", workOrderRepository.findAllByEmployeeAndStatus(user, processing));
        vModel.addAttribute("reviewed", workOrderRepository.findAllByEmployeeAndStatus(user, reviewed));
        vModel.addAttribute("completed", workOrderRepository.findAllByEmployeeAndStatus(user, completed));
        vModel.addAttribute("cancelled", workOrderRepository.findAllByEmployeeAndStatus(user, cancelled));
        vModel.addAttribute("allOrders", workOrderRepository.findAllByEmployee(user));

        return "emp/profile";
    }

    @GetMapping("/emp/edit")
    public String getEditEmp(Model vModel) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        vModel.addAttribute("updatedUser", user);
        return "emp/edit";
    }

    @PostMapping("/emp/edit/{id}")
    public String postEditEmp(@ModelAttribute User newInfo, @PathVariable long id, Model vModel) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserRole ur = user.getRole();
        newInfo.setRole(ur);
        newInfo.setPassword(user.getPassword());
        userRepository.save(newInfo);

        return "emp/profile";
    }
}

