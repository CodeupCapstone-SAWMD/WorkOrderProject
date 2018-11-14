package com.swm.datatracker.controllers;

import com.swm.datatracker.models.Status;

import com.swm.datatracker.models.WorkOrder;
import com.swm.datatracker.respositories.StatusRepository;
import com.swm.datatracker.respositories.WorkOrderRepository;
import com.swm.datatracker.services.WorkOrderService;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.swm.datatracker.respositories.StatusRepository;
import org.springframework.stereotype.Controller;


@Controller
public class StatusController {

    private StatusRepository statusRepository;
  
    @Autowired
    private WorkOrderRepository workOrderRepository;

    @Autowired
    private WorkOrderService workOrderService;

    public StatusController(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

//    @PostMapping("/admin/status/{id}/increment") public String incrementStatus(@RequestParam long id) {
//        WorkOrder workOrder = workOrderRepository.findOne(id);
//        System.out.println(id);
//        long currentStatusId = workOrder.getStatus().getId();
//        Status currentStatus = workOrder.getStatus();
//        currentStatus.setId(currentStatusId+1);
//        workOrder.setStatus(currentStatus);
//        workOrderService.edit(workOrder);
//        return "admin/profile";
//    }

    @PostMapping("/admin/status/{id}/increment")
    public String increment(@PathVariable long id, @RequestParam(name = "inc") int inc){
        WorkOrder workOrder = workOrderService.findOne(id);
//        System.out.println(workOrderService.findOne(id));
        long currentStatusId = workOrder.getStatus().getId();
        if (currentStatusId < 5){
            currentStatusId+=1;
        workOrder.setStatus(statusRepository.findOne(currentStatusId));
//        System.out.println(workOrder.getStatus().getId());
        workOrderService.edit(workOrder);
        }
        return "redirect:/admin/profile";
    }

    @PostMapping("/admin/status/{id}/decrement")
    public String decrement(@PathVariable long id, @RequestParam(name = "dec") int dec){
        WorkOrder workOrder = workOrderService.findOne(id);
//        System.out.println(workOrderService.findOne(id));
        long currentStatusId = workOrder.getStatus().getId();
        if(currentStatusId >2) {
            currentStatusId-=1;
            workOrder.setStatus(statusRepository.findOne(currentStatusId));
//        System.out.println(workOrder.getStatus().getId());
            workOrderService.edit(workOrder);
        }
        return "redirect:/admin/profile";
    }

}
