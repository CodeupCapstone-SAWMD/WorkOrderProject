package com.swm.datatracker.controllers;

import com.swm.datatracker.services.WorkOrderRepo;
import com.swm.datatracker.services.WorkOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WorkOrderController {
    private WorkOrderRepo workOrderRepo;
    private WorkOrderService workOrderService;

    public WorkOrderController(WorkOrderService service, WorkOrderRepo workOrderRepo){
        this.workOrderRepo = workOrderRepo;
        this.workOrderService = service;
    }

    // Controller for static test page //
    @GetMapping("/")
    public String staticPage() {
        return "static";
    }
    
}
