package com.swm.datatracker.controllers;

import com.swm.datatracker.models.User;
import com.swm.datatracker.models.UserRole;
import com.swm.datatracker.respositories.UserRepository;
import com.swm.datatracker.respositories.WorkOrderRepository;
import com.swm.datatracker.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;

@Controller
public class UserController {
    private UserRepository users;
    private PasswordEncoder passwordEncoder;
    private WorkOrderRepository workOrderRepository;
    private UserService userService;


    public UserController(UserRepository users, PasswordEncoder passwordEncoder, WorkOrderRepository workOrderRepository) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
        this.workOrderRepository = workOrderRepository;
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
        users.save(user);
        return "redirect:/login";
    }

//    @RequestMapping(path = "/users/profile", method = RequestMethod.GET)
    @GetMapping("/users/profile")
    public String userProfile(Model vModel) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        vModel.addAttribute("user", user);
//        vModel.addAttribute("orders", workOrderRepository.findAllByUser(user.getId()));
        vModel.addAttribute("orders", workOrderRepository.findAllByCustomer(user));
        return "users/profile";
    }

//    @RequestMapping(path = "/profile/edit", method = RequestMethod.GET)
    @GetMapping("/users/profile/edit")
    public String editUser(Model vModel) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        vModel.addAttribute("user", user);
        return "users/edit";
    }


}

