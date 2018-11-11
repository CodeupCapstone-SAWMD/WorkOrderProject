package com.swm.datatracker.controllers;

import com.swm.datatracker.models.User;
import com.swm.datatracker.models.WorkOrder;
import com.swm.datatracker.respositories.*;
import com.swm.datatracker.services.UserService;
import com.swm.datatracker.services.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class WorkOrderController {
    @Autowired
    private UserRepository userRepo;
    private UserService userService;

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private StatusRepository statusRepo;

    private WorkOrderRepository workOrderRepository;
    private WorkOrderService workOrderService;

    public WorkOrderController(WorkOrderService service, WorkOrderRepository workOrderRepository) {
        this.workOrderRepository = workOrderRepository;
        this.workOrderService = service;
    }

    // Controller for static test page //
    @GetMapping("/index")
    public String staticPage() {
        return "static";
    }

    //Copied the Springblog Post controller

    @GetMapping("/workorders")
    public String workorders(Model vModel) {
        vModel.addAttribute("workorders", workOrderService.findAll());
        return "workorders/index";
    }

    @GetMapping("/work-order/{id}")
    public String worOrderId(@PathVariable long id, Model vModel) {
//        System.out.println(workOrderService.findOne(id));
        vModel.addAttribute("workorder", workOrderService.findOne(id));
        return "/workorders/show";
    }

    @GetMapping("/work-order/create")
    public String showPostForm(WorkOrder workOrder, Model vModel) {
//        vModel.addAttribute("employees", userRepo.findAllByUserRoleContains(2));
//        System.out.println((rolesRepo.findAllByRoleContains("user")));
        vModel.addAttribute("workorder", workOrder);
//        System.out.println(statusRepo.findAll());
        vModel.addAttribute("status", statusRepo.findAll());
        vModel.addAttribute("category", categoryRepo.findAll());
//        System.out.println(userService.findAllEmployees());
        return "workorders/create";
    }

    @PostMapping("/work-order/create")
    public String createPost(@ModelAttribute WorkOrder workOrder) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Date currentDate = new Date();
        System.out.println(currentDate);
//        workOrder.setCustomer(userRepo.findOne(user.getId()));
        workOrder.setSubmittedDate(currentDate);
        WorkOrder newWorkOrder = workOrderService.save(workOrder);
        return "redirect:/workorders";
    }

    @GetMapping("/work-order/{id}/edit")
    public String editWorkOrder(@PathVariable long id, Model vModel) {
        vModel.addAttribute("workorder", workOrderService.findOne(id));
        return "workorders/edit";
    }

    @PostMapping("/work-order/{id}/edit")
    public String updatePost(@ModelAttribute WorkOrder workOrder) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        post.setUser(userRepository.findOne(user.getId()));
        WorkOrder updatedWorkOrder = workOrderService.edit(workOrder);
        return "redirect:/work-order/" + updatedWorkOrder.getId();
    }

    //
    @GetMapping("/work-order/{id}/delete")
    public String deletePost(@PathVariable long id) {
        workOrderService.delete(id);
        return "redirect:/workorders";
    }

    //
//    @RequestMapping(path = "/posts/search/{string}", method = RequestMethod.GET)
//    public String search(@PathVariable String string, Model vModel) {
//        vModel.addAttribute("postings", postService.search(string));
//        return "posts/index";
//    }
//
    @GetMapping("/workorders/user-posts")
    public String userPosts(Model vModel) {
        vModel.addAttribute("postings", workOrderService.userWorkOrders());
        return "workorders/index";
//
    }
}
