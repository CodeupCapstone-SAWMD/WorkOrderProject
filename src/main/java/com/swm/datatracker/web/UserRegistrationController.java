package com.swm.datatracker.web;

import com.swm.datatracker.models.User;
import com.swm.datatracker.models.UserRole;
import com.swm.datatracker.respositories.RolesRepository;
import com.swm.datatracker.respositories.StatusRepository;
import com.swm.datatracker.respositories.UserRepository;
import com.swm.datatracker.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private RolesRepository userRolesRepository;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model, @RequestParam(name = "error") String error) {
        model.addAttribute("error", error);
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(
            @ModelAttribute("user") @Valid UserRegistrationDto userDto,
            BindingResult result) {

        if (result.hasErrors()){
            return "registration";
        }
        try{
            User newUser = new User();
            newUser.setFirstName(userDto.getFirstName());
            newUser.setLastName(userDto.getLastName());
            newUser.setEmail(userDto.getEmail());
            newUser.setStreetNumber(userDto.getStreetNumber());
            newUser.setStreetName(userDto.getStreetName());
            newUser.setCity(userDto.getCity());
            newUser.setZipcode(userDto.getZipcode());
            newUser.setPhoneNumber(userDto.getPhoneNumber());
            newUser.setUsername(userDto.getUserName());

            String hash = passwordEncoder.encode(userDto.getPassword());
            newUser.setPassword(hash);

            UserRole ur = userRolesRepository.findOneById(2L);
            newUser.setRole(ur);
            userRepository.save(newUser);

            // FIND THE ID OF THE LAST USER
            List<User> users = userRepository.findAll();
            User last = users.get(users.size() - 1);

            // CREATE AND SAVE ROLE FOR NEWEST USER
            UserRole newUserRole = new UserRole();
            newUserRole.setRole("ROLE_USER");
            newUserRole.setUserId(last.getId());

            userRolesRepository.save(newUserRole);
        }
        catch (Exception e){
            System.out.println(e);
            return "redirect:/registration?error=true";
        }
        return "redirect:/login";
    }



}
