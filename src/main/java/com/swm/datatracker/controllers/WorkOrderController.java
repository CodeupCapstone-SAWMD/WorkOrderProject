package com.swm.datatracker.controllers;


import com.swm.datatracker.models.User;
import com.swm.datatracker.models.WorkOrder;
import com.swm.datatracker.models.*;
import com.swm.datatracker.respositories.*;
import com.swm.datatracker.services.UserService;
import com.swm.datatracker.services.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class WorkOrderController {
    @Autowired
    private UserRepository userRepo;
    private UserService userService;

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private StatusRepository statusRepo;

    @Autowired
    private InventoryRepository inventoryRepo;

    private RolesRepository rolesRepo;
    private CategoryRepository categoryRepository;
    private StatusRepository statusRepository;

    private WorkOrderRepository workOrderRepository;
    private WorkOrderService workOrderService;

    public WorkOrderController(WorkOrderService service, WorkOrderRepository workOrderRepository, CategoryRepository categoryRepository,
                               StatusRepository statusRepository) {
        this.workOrderRepository = workOrderRepository;
        this.workOrderService = service;
        this.categoryRepository = categoryRepository;
        this.statusRepository = statusRepository;
    }

    // Controller for static test page //
    @GetMapping("/index")
    public String staticPage() {
        return "static";
    }

    //Copied the Springblog Post controller

    @GetMapping("/workorders")
    public String workorders(Model vModel) {

        List<User> userList = userRepo.findAll();
        List<User> emps = new ArrayList<>();
        for (User u : userList) {
            if (u.getRole().getRoleName().equals("ROLE_EDITOR")) {
                emps.add(u);
            }
        }

        vModel.addAttribute("emps", emps);
        vModel.addAttribute("submitted", workOrderService.statusList(1));
        vModel.addAttribute("processing", workOrderService.statusList(2));
        vModel.addAttribute("review", workOrderService.statusList(3));
        vModel.addAttribute("complete", workOrderService.statusList(4));
        vModel.addAttribute("cancelled", workOrderService.statusList(5));
        vModel.addAttribute("all", workOrderRepository.findAll());

        return "workorders/index";
    }

    @PostMapping("/work-order/{id}/update")
    public String updateStatus(@PathVariable long id, Model vModel) {
        WorkOrder wo = workOrderRepository.findOne(id);
        Status woStatus = wo.getStatus();
        long statusId = woStatus.getId();
        long newId = statusId + 1;

//        vModel.addAttribute("");
        return "workorders/index";
    }

    @GetMapping("/work-order/{id}")
    public String worOrderId(@PathVariable long id, Model vModel) {
        vModel.addAttribute("workorder", workOrderService.findOne(id));
        return "workorders/show";
    }

    @GetMapping("/work-order/create")
    public String showPostForm(WorkOrder workOrder, Model vModel) {
//        vModel.addAttribute("employees", userRepo.findAllByUserRoleContains(2));
//        System.out.println((rolesRepo.findAllByRoleContains("user")));

        vModel.addAttribute("workorder", new WorkOrder());
//        UserRole ur = rolesRepo.findOne(2L);
//        List<User> custos = userRepo.findAllByUserRole(ur);
//        Object user = SecurityContextHolder.getContext().getAuthentication().getCredentials();
//        System.out.println(user);


        // WAY TO FIND ALL 'CUSTOMERS'
        List<User> userList = userRepo.findAll();
        List<User> custs = new ArrayList<>();
            for (User u : userList) {
                if (u.getRole().getRoleName().equals("ROLE_USER")) {
                    custs.add(u);
                }
            }

        vModel.addAttribute("customers", custs);

        vModel.addAttribute("categories", categoryRepository.findAll());
        vModel.addAttribute("status", statusRepository.findAll());
        vModel.addAttribute("employees", userRepo.findAll());
        vModel.addAttribute("workorder", workOrder);
        vModel.addAttribute("category", categoryRepo.findAll());
        vModel.addAttribute("inventories", inventoryRepo.findAll());
//        System.out.println(userService.findAllEmployees());
        return "workorders/create";
    }

    @PostMapping("/work-order/create")
    public String createPost(@ModelAttribute WorkOrder workOrder) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User test = new User;
        System.out.println(user.getLastName());
        Date currentDate = new Date();
//        System.out.println(currentDate);
        workOrder.setCustomer(userRepo.findOne(user.getId()));
        workOrder.setSubmittedDate(currentDate);
//        workOrder.setStatus(statusRepo.findOne((long) 1));
        WorkOrder newWorkOrder = workOrderService.save(workOrder);
        return "redirect:/work-order/"+ newWorkOrder.getId();
    }

    @PostMapping("/work-order/assign/{id}")
    public String assignEmployees(@RequestParam(name = "employee") long employee, @PathVariable long id, Model vModel) {
        User emp = userRepo.findOne(employee);
        WorkOrder wo = workOrderRepository.findOne(id);
        wo.setEmployee(emp);

        Long invAmount = wo.getRequestedQuantity();

        Inventory inv = wo.getInventory();
        Long fullCount = inv.getQuantity();


        inv.setQuantity(fullCount - invAmount);
        inventoryRepo.save(inv);

        long currentStatusId = wo.getStatus().getId();
        currentStatusId += 1;
        wo.setStatus(statusRepository.findOne(currentStatusId));
        workOrderRepository.save(wo);

        return "redirect:/workorders";
    }

    @GetMapping("/work-order/{id}/edit")
    public String editWorkOrder(@PathVariable long id, Model vModel) {
        vModel.addAttribute("workorder", workOrderService.findOne(id));
        WorkOrder wo = workOrderRepository.findOne(id);
//        System.out.println(wo.getSubmittedDate());
        List<User> emps = userRepo.findAll();
        List<User> woEmps = new ArrayList<>();
        for (User u : emps) {
//                System.out.println(u.getRole());
            if (u.getRole().getRoleName().equals("ROLE_EDITOR")) {
                woEmps.add(u);
            }
        }
        vModel.addAttribute("employees", woEmps);
        vModel.addAttribute("submittedDate", wo.getSubmittedDate());
        vModel.addAttribute("status", statusRepo.findAll());
        vModel.addAttribute("category", categoryRepo.findAll());
        vModel.addAttribute("inventories", inventoryRepo.findAll());
        return "workorders/edit";
    }

    @PostMapping("/work-order/{id}/edit")
    public String updatePost(@ModelAttribute WorkOrder workOrder) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        workOrder.setUser(userRepository.findOne(user.getId()));
        Inventory item = inventoryRepo.findOne(workOrder.getInventory().getId());
        System.out.println(item.getQuantity());
        item.setQuantity(item.getQuantity() - workOrder.getRequestedQuantity());
        System.out.println(item.getQuantity());
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
        vModel.addAttribute("workorders", workOrderService.userWorkOrders());
        return "workorders/index";
//
    }

    @GetMapping("/workorders/search")
    public String searchWorkOrders(Model vModel, @RequestParam(name = "searchTerm") String search) {
        List<WorkOrder> searchDescNotesResults = workOrderRepository.findAllByDescriptionContainsOrNotesContains(search, search);
        List<WorkOrder> searchByIdResults = new ArrayList<>();
        List<WorkOrder> searchByZipResults = new ArrayList<>();

        try {
            searchByIdResults = workOrderRepository.findAllById(Long.parseLong(search));
            searchByZipResults = workOrderRepository.findAllById(Long.parseLong(search));
        } catch (Exception e){
            System.out.println(e + "no data");
        }

        vModel.addAttribute("searchDescNotesResults", searchDescNotesResults);
        vModel.addAttribute("searchByIdResults", searchByIdResults);
        vModel.addAttribute("searchByZipResults", searchByZipResults);


        return "workorders/search";
    }
}
