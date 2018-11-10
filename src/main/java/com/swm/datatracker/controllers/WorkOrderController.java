package com.swm.datatracker.controllers;

import com.swm.datatracker.models.User;
import com.swm.datatracker.models.WorkOrder;
import com.swm.datatracker.respositories.UserRepository;
import com.swm.datatracker.respositories.WorkOrderRepository;
import com.swm.datatracker.services.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class WorkOrderController {
    @Autowired
    private UserRepository userRepo;

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

    //Copied the Springblog Post controller

    @GetMapping("/workorders")
    public String workorders(Model vModel) {
        vModel.addAttribute("workorders", workOrderService.findAll());
        return "workorders/index";
    }

    @GetMapping("/word-order/{id}")
    public String worOrderId(@PathVariable long id, Model vModel) {
        vModel.addAttribute("workorder", workOrderService.findOne(id));
        return "workorders/show";
    }
    @GetMapping("/work-order/create")
    public String showPostForm(WorkOrder workOrder, Model vModel) {
        vModel.addAttribute("workorder", workOrder);
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
//
//    @RequestMapping(path = "/posts/{id}/edit", method = RequestMethod.GET)
//    public String editPost(@PathVariable long id, Model vModel) {
//        vModel.addAttribute("post", postService.findOne(id));
//        return "posts/edit";
//    }
//
//    @RequestMapping(path = "/posts/{id}/edit", method = RequestMethod.POST)
//    public String updatePost(@ModelAttribute Post post) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        post.setUser(userRepository.findOne(user.getId()));
//        Post updatedPost = postService.edit(post);
//        return "redirect:/posts/" + updatedPost.getId();
//    }
//
//    @RequestMapping(path = "/posts/{id}/delete", method = RequestMethod.DELETE)
//    public String deletePost(@PathVariable long id) {
//        postService.delete(id);
//        return "redirect:/posts";
//    }
//
//    @RequestMapping(path = "/posts/search/{string}", method = RequestMethod.GET)
//    public String search(@PathVariable String string, Model vModel) {
//        vModel.addAttribute("postings", postService.search(string));
//        return "posts/index";
//    }
//
//    @RequestMapping(path = "/posts/user-posts", method = RequestMethod.GET)
//    public String userPosts(Model vModel) {
//        vModel.addAttribute("postings", postService.userPosts());
//        return "posts/index";
//
}
