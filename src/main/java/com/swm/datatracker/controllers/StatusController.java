package com.swm.datatracker.controllers;

import com.swm.datatracker.models.Inventory;
import com.swm.datatracker.models.Status;

import com.swm.datatracker.models.WorkOrder;
import com.swm.datatracker.respositories.StatusRepository;
import com.swm.datatracker.respositories.WorkOrderRepository;
import com.swm.datatracker.services.InventoryService;
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

    @Autowired
    private InventoryService inventorySvc;


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
        return "redirect:/workorders";
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
        return "redirect:/workorders";
    }


    /**
     * 1) create a post mapping URL to cancel the work order by changing the status to cancel
     * 2) the path variable "{id}" is a long id and find the work order by id number
     * 3) set the work order status to 5; since findOne() takes an integer id, cast the integer as a long
     * 4) get the work order quantity and store in a primitive (long/int) type variable;
     * 5) get the work order's inventory id and store in a primitive type variable;
     * 6) find the inventory item by id via the inventory services/repo;
     * 7) set the item's quantity to the current quantity plus the quantity to be returned;
     * 8) edit the work order in the list of work orders; redirect the admin back to the profile
     *
     */


    @PostMapping("/admin/status/{id}/cancel")
    public String cancelWorkOrder(@PathVariable long id){
        WorkOrder workOrder = workOrderService.findOne(id);
//        System.out.println(workOrderService.findOne(id));
        workOrder.setStatus(statusRepository.findOne(5L));
//        System.out.println(workOrder.getStatus().getId());
        long returnQuantity = workOrder.getRequestedQuantity();
        long itemID = workOrder.getInventory().getId();
        Inventory item = inventorySvc.findOne(itemID);
        item.setQuantity(item.getQuantity()+returnQuantity);
//        workOrderService.edit(workOrder);
        inventorySvc.edit(item);
        return "redirect:/admin/profile";
    }




}
