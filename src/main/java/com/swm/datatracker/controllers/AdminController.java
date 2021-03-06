package com.swm.datatracker.controllers;

import com.swm.datatracker.models.Status;
import com.swm.datatracker.models.User;
import com.swm.datatracker.models.UserRole;
import com.swm.datatracker.models.WorkOrder;
import com.swm.datatracker.respositories.RolesRepository;
import com.swm.datatracker.respositories.StatusRepository;
import com.swm.datatracker.respositories.UserRepository;
import com.swm.datatracker.respositories.WorkOrderRepository;
import com.swm.datatracker.services.WorkOrderService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
public class AdminController {
    private WorkOrderRepository workOrderRepository;
    private WorkOrderService workOrderService;

    private StatusRepository statusRepository;
    private UserRepository userRepository;
    private RolesRepository rolesRepository;


    public AdminController(WorkOrderRepository workOrderRepository, StatusRepository statusRepository, UserRepository userRepository, RolesRepository rolesRepository) {
        this.workOrderRepository = workOrderRepository;
        this.statusRepository = statusRepository;
        this.userRepository = userRepository;
        this.rolesRepository = rolesRepository;
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
        Status processing = statusRepository.findOne(2L);
        Status reviewed = statusRepository.findOne(3L);
        Status complete = statusRepository.findOne(4L);
        Status canceled = statusRepository.findOne(5L);

        vModel.addAttribute("canceledOrders", workOrderRepository.findAllByStatus(canceled));
        vModel.addAttribute("inReview", workOrderRepository.findAllByStatus(reviewed));
        vModel.addAttribute("processingOrders", workOrderRepository.findAllByStatus(processing));
        vModel.addAttribute("submittedOrders", workOrderRepository.findAllByStatus(submitted));
        vModel.addAttribute("completeOrders", workOrderRepository.findAllByStatus(complete));
        vModel.addAttribute("allOrders", workOrderRepository.findAll());

        vModel.addAttribute("user", user);
        return "admin/profile";
    }

    @GetMapping("/admin/view-users")
    public String editPermissions(Model vModel) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        vModel.addAttribute("user", user);
//        vModel.addAttribute("role", user.getRole());

        // all user roles in array list and pushed to front end
        ArrayList<UserRole> allRoles = new ArrayList<>();
        UserRole admin = rolesRepository.findOne(1L);
        UserRole cust = rolesRepository.findOne(2L);
        UserRole emp = rolesRepository.findOne(3L);
        allRoles.add(admin);
        allRoles.add(emp);
        allRoles.add(cust);
        vModel.addAttribute("allRoles", allRoles);

        // sort by user role into lists
        ArrayList<User> admins = new ArrayList<>();
        ArrayList<User> employees = new ArrayList<>();
        ArrayList<User>  customers = new ArrayList<>();
        Iterable<User> all = userRepository.findAll();

        for (User eachuser: all) {
            if(eachuser.getRole().getId() == 1){
                admins.add(eachuser);
            }
            if(eachuser.getRole().getId() == 3){
                employees.add(eachuser);
            }
            if(eachuser.getRole().getId() == 2) {
                customers.add(eachuser);
            }
        }
        // lists generated and pushed to front end
        vModel.addAttribute("admins", admins);
        vModel.addAttribute("employees", employees);
        vModel.addAttribute("customers", customers);
        vModel.addAttribute("allUsers", all);
        vModel.addAttribute("selecteduser", user);

        return "admin/view-users";
    }

    @PostMapping("/admin/update-perms/{id}")
    public String updatePermissions(@RequestParam(name = "roleselected") String roleselected, @PathVariable long id) {

        User cust = userRepository.findOne(id);
        UserRole newRole = new UserRole();

        if (roleselected.equals("ROLE_ADMIN")){ newRole = rolesRepository.findOne(1L); }
        if (roleselected.equals("ROLE_EDITOR")){ newRole = rolesRepository.findOne(3L); }
        if (roleselected.equals("ROLE_USER")){ newRole = rolesRepository.findOne(2L);
        }
        cust.setRole(newRole);

        UserRole usersNewRole = rolesRepository.findOneByUserId(cust.getId());

        if (newRole.getRoleName().equals("ROLE_ADMIN")) { usersNewRole.setRoleName("ROLE_ADMIN"); }
        if (newRole.getRoleName().equals("ROLE_EDITOR")) { usersNewRole.setRoleName("ROLE_EDITOR"); }
        if (newRole.getRoleName().equals("ROLE_USER")) { usersNewRole.setRoleName("ROLE_USER"); }

        rolesRepository.save(usersNewRole);
        userRepository.save(cust);

//        System.out.println(roleselected);
//        rolesRepository.findAllByRoleIsLike(roleselected);

        return "redirect:/admin/view-users";
    }

    @GetMapping("/admin/view-profile/{id}")
    public String viewProfile(@PathVariable String id, Model vModel) {
        User viewedUser = userRepository.findOne(Long.parseLong(id));
        vModel.addAttribute("user", viewedUser);
        return "admin/view-profile";
    }

    @GetMapping("/admin/edit")
    public String getEditAdmin(Model vModel) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        vModel.addAttribute("updatedUser", user);
        return "emp/edit";
    }

    @PostMapping("/admin/edit/{id}")
    public String postEditAdmin(@ModelAttribute User newInfo, @PathVariable long id, Model vModel) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserRole ur = user.getRole();
        newInfo.setRole(ur);
        newInfo.setPassword(user.getPassword());
        userRepository.save(newInfo);

        return "admin/profile";
    }
}
