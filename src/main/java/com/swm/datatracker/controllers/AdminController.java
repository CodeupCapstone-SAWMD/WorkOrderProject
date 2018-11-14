package com.swm.datatracker.controllers;

import com.swm.datatracker.models.Status;
import com.swm.datatracker.models.User;
import com.swm.datatracker.models.WorkOrder;
import com.swm.datatracker.respositories.StatusRepository;
import com.swm.datatracker.respositories.WorkOrderRepository;
import com.swm.datatracker.services.WorkOrderService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    private WorkOrderRepository workOrderRepository;
    private WorkOrderService workOrderService;

    private StatusRepository statusRepository;

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

//    @GetMapping("/admin/status/{id}/increment")
//    public String incrementStatus(@PathVariable long id) {
//        WorkOrder workOrder = workOrderRepository.findOne(id);
//        long currentStatusId = workOrder.getStatus().getId();
//        Status currentStatus = workOrder.getStatus();
//        currentStatus.setId(currentStatusId+1);
//        workOrder.setStatus(currentStatus);
//        workOrderService.edit(workOrder);
//        return "redirect:/admin/profile";
//    }

    @GetMapping("/admin/status/{id}/decrement")
    public String decrementStatus(@PathVariable long id) {
        WorkOrder workOrder = workOrderRepository.findOne(id);
        long currentStatusId = workOrder.getStatus().getId();
        Status currentStatus = workOrder.getStatus();
        currentStatus.setId(currentStatusId+1);
        workOrder.setStatus(currentStatus);
        workOrderService.edit(workOrder);
        return "redirect:/admin/profile";
    }

//    @PostMapping("/inventory/{id}/decrement")
//    public String decrement(@PathVariable long id, @RequestParam(name = "dec") int dec){
//        Inventory item = inventorySvc.findOne(id);
//        long currentQuantity = item.getQuantity();
//        item.setQuantity(currentQuantity - dec);
//        inventorySvc.edit(item);
//        return "redirect:/inventory";
//    }
//
//    @PostMapping("/inventory/{id}/increment")
//    public String increment(@PathVariable long id, @RequestParam(name = "inc") int inc){
//        Inventory item = inventorySvc.findOne(id);
//        long currentQuantity = item.getQuantity();
//        item.setQuantity(currentQuantity + inc);
//        inventorySvc.edit(item);
//        System.out.println(inventorySvc.findOne(id).getQuantity());
//        return "redirect:/inventory";
//    }

}
