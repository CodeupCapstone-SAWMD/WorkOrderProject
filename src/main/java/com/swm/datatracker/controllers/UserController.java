package com.swm.datatracker.controllers;

import com.swm.datatracker.models.Status;
import com.swm.datatracker.models.User;
import com.swm.datatracker.models.UserRole;
import com.swm.datatracker.models.WorkOrder;
import com.swm.datatracker.respositories.RolesRepository;
import com.swm.datatracker.respositories.StatusRepository;
import com.swm.datatracker.respositories.UserRepository;
import com.swm.datatracker.respositories.WorkOrderRepository;
import com.swm.datatracker.services.UserService;
import com.swm.datatracker.services.WorkOrderService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import javax.management.relation.RoleResult;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private WorkOrderRepository workOrderRepository;
    private WorkOrderService workOrderService;
    private StatusRepository statusRepository;
//    private UserService userService;
    private RolesRepository userRolesRepository;


    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder, WorkOrderRepository workOrderRepository, RolesRepository userRolesRepository, StatusRepository statusRepository) {
        this.userRepository = userRepository;
        this.statusRepository = statusRepository;
        this.passwordEncoder = passwordEncoder;
        this.workOrderRepository = workOrderRepository;
        this.userRolesRepository = userRolesRepository;
        this.statusRepository = statusRepository;
    }

    @GetMapping("/")
    public String defaultRoute(Model vModel) {
        return "users/home";
    }

//    @GetMapping("/users/home")
//    public String routeUserHome(Model vModel) {
//        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Object creds = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//
//
////        UserRole usersRole = currentUser.getRole();
////        String role = usersRole.getRoleName();
////
////        vModel.addAttribute("user", currentUser);
////        System.out.println(role);
////
////        if (role.equals("ROLE_ADMIN")) {
////            return "redirect:/admin/home";
////        }
//
//        return "/users/home";
//    }

    @GetMapping("/contact")
    public String showContactForm(Model vModel) {
        return "contact";
    }

    @GetMapping("/about")
    public String showAboutPage(Model vModel) {
        return "about";
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        UserRole ur = userRolesRepository.findOneById(2L);
        user.setRole(ur);
        userRepository.save(user);

        // FIND THE ID OF THE LAST USER
        List<User> users = userRepository.findAll();
        User last = users.get(users.size() - 1);

        // CREATE AND SAVE ROLE FOR NEWEST USER
        UserRole newUser = new UserRole();
        newUser.setRole("ROLE_USER");
        newUser.setUserId(last.getId());

        userRolesRepository.save(newUser);
        return "redirect:/login";
    }

//    @RequestMapping(path = "/users/profile", method = RequestMethod.GET)
    @GetMapping("/users/profile")
    public String userProfile(Model vModel) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User u = userRepository.findOne(2L);

        Status submitted = statusRepository.findOne(1L);
        Status pendingAssignment = statusRepository.findOne(2L);
        Status processing = statusRepository.findOne(3L);
        Status reviewed = statusRepository.findOne(4L);
        Status completed = statusRepository.findOne(5L);
        Status cancelled = statusRepository.findOne(6L);
        vModel.addAttribute("user", u);

        vModel.addAttribute("submitted", workOrderRepository.findAllByCustomerAndStatus(u, submitted));
        vModel.addAttribute("pending", workOrderRepository.findAllByCustomerAndStatus(u, pendingAssignment));
        vModel.addAttribute("processing", workOrderRepository.findAllByCustomerAndStatus(u, processing));
        vModel.addAttribute("reviewed", workOrderRepository.findAllByCustomerAndStatus(u, reviewed));
        vModel.addAttribute("completed", workOrderRepository.findAllByCustomerAndStatus(u, completed));
        vModel.addAttribute("cancelled", workOrderRepository.findAllByCustomerAndStatus(u, cancelled));
        vModel.addAttribute("allOrders", workOrderRepository.findAllByCustomer(u));

        return "users/profile";
    }
//        // vModel.addAttribute("orders", workOrderRepository.findAllByUser(user.getId()));
//        vModel.addAttribute("orders", workOrderRepository.findAllByCustomer(user));
//        return "users/profile";
//    }

//    @RequestMapping(path = "/profile/edit", method = RequestMethod.GET)
    @GetMapping("/users/profile/edit")
    public String editUser(Model vModel) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        vModel.addAttribute("user", user);
        return "users/edit";
    }


}

