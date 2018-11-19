package com.swm.datatracker.controllers;

import com.swm.datatracker.models.Status;
import com.swm.datatracker.models.User;
import com.swm.datatracker.models.UserRole;
import com.swm.datatracker.models.WorkOrder;
import com.swm.datatracker.respositories.RolesRepository;
import com.swm.datatracker.respositories.StatusRepository;
import com.swm.datatracker.respositories.UserRepository;
import com.swm.datatracker.respositories.WorkOrderRepository;
import com.swm.datatracker.services.SmsSender;
import com.swm.datatracker.services.UserService;
import com.swm.datatracker.services.WorkOrderService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    private SmsSender smsSender;


    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder, WorkOrderRepository workOrderRepository, RolesRepository userRolesRepository, StatusRepository statusRepository, SmsSender smsSender) {
        this.userRepository = userRepository;
        this.statusRepository = statusRepository;
        this.passwordEncoder = passwordEncoder;
        this.workOrderRepository = workOrderRepository;
        this.userRolesRepository = userRolesRepository;

        this.smsSender = smsSender;
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

    @PostMapping("/contact")
    public String sendCommunication(Model vModel, @RequestParam(name = "mess") String mess) {
        smsSender.sendText(mess);
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

        Status submitted = statusRepository.findOne(1L);
        Status processing = statusRepository.findOne(2L);
        Status reviewed = statusRepository.findOne(3L);
        Status completed = statusRepository.findOne(4L);
        Status cancelled = statusRepository.findOne(5L);
        vModel.addAttribute("user", user);

        vModel.addAttribute("submitted", workOrderRepository.findAllByCustomerAndStatus(user, submitted));
        vModel.addAttribute("processing", workOrderRepository.findAllByCustomerAndStatus(user, processing));
        vModel.addAttribute("reviewed", workOrderRepository.findAllByCustomerAndStatus(user, reviewed));
        vModel.addAttribute("completed", workOrderRepository.findAllByCustomerAndStatus(user, completed));
        vModel.addAttribute("cancelled", workOrderRepository.findAllByCustomerAndStatus(user, cancelled));
        vModel.addAttribute("allOrders", workOrderRepository.findAllByCustomer(user));

        return "users/profile";
    }
//        // vModel.addAttribute("orders", workOrderRepository.findAllByUser(user.getId()));
//        vModel.addAttribute("orders", workOrderRepository.findAllByCustomer(user));
//        return "users/profile";
//    }

//    @RequestMapping(path = "/profile/edit", method = RequestMethod.GET)
    @GetMapping("/users/edit")
    public String getEditUser(Model vModel) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        vModel.addAttribute("updatedUser", user);
        return "users/edit";
    }

    @PostMapping("/users/edit/{id}")
    public String postEditUser(@ModelAttribute User newInfo, @PathVariable long id, Model vModel) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserRole ur = user.getRole();
        newInfo.setRole(ur);
        newInfo.setPassword(user.getPassword());
        userRepository.save(newInfo);

        return "users/profile";
    }


}

