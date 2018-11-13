package com.swm.datatracker.controllers;

import com.swm.datatracker.models.Status;
import com.swm.datatracker.models.User;
import com.swm.datatracker.models.UserRole;
import com.swm.datatracker.respositories.StatusRepository;
import com.swm.datatracker.respositories.UserRepository;
import com.swm.datatracker.respositories.WorkOrderRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    private WorkOrderRepository workOrderRepository;
    private StatusRepository statusRepository;
    private UserRepository userRepository;

    public AdminController(WorkOrderRepository workOrderRepository, StatusRepository statusRepository) {
        this.workOrderRepository = workOrderRepository;
        this.statusRepository = statusRepository;
    }

    @GetMapping("/admin/home")
    public String adminHome(Model vModel) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        vModel.addAttribute("user", currentUser);
        return "admin/home";
    }

    @GetMapping("/admin/work-orders")
    public String adminWorkOrders(Model vModel) {

        return "admin/work-orders";
    }

    @GetMapping("/admin/profile")
    public String adminProfile(Model vModel) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Status submitted = statusRepository.findOne(1L);
        Status pendingAssignment = statusRepository.findOne(2L);
        Status processing = statusRepository.findOne(3L);
        Status reviewed = statusRepository.findOne(4L);
        Status complete = statusRepository.findOne(5L);
        Status canceled = statusRepository.findOne(6L);

        vModel.addAttribute("canceledOrders", workOrderRepository.findAllByStatus(canceled));
        vModel.addAttribute("inReview", workOrderRepository.findAllByStatus(reviewed));
        vModel.addAttribute("processingOrders", workOrderRepository.findAllByStatus(processing));
        vModel.addAttribute("pendingAssignmentOrders", workOrderRepository.findAllByStatus(pendingAssignment));
        vModel.addAttribute("submittedOrders", workOrderRepository.findAllByStatus(submitted));
        vModel.addAttribute("completeOrders", workOrderRepository.findAllByStatus(complete));
        vModel.addAttribute("allOrders", workOrderRepository.findAll());
        vModel.addAttribute("user", user);
        return "admin/profile";
    }

    @GetMapping("/admin/view-users")
    public String editPermissions(Model vModel) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

//        UserRole admin = userRepository.findAllByUserRoleContains(1);
//        vModel.addAttribute("admins", userRepository.findAllByUserRole(admin));
//        vModel.addAttribute("employees", userRepository.findAllByUserRole(employee));
//        vModel.addAttribute("customers", userRepository.findAllByUserRole(customer));
        vModel.addAttribute("allUsers", userRepository.findAll());

        return "view-users";
    }
}
