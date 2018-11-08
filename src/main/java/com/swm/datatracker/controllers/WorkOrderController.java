package com.swm.datatracker.controllers;

import com.swm.datatracker.respositories.WorkOrderRepository;
import com.swm.datatracker.services.WorkOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkOrderController {
    private WorkOrderRepository workOrderRepository;
    private WorkOrderService workOrderService;

    public WorkOrderController(WorkOrderService service, WorkOrderRepository workOrderRepository){
        this.workOrderRepository = workOrderRepository;
        this.workOrderService = service;
    }

    // Controller for static test page //
    @GetMapping("/index")
    public String staticPage() {
        return "static";
    }


}
