package com.swm.datatracker.controllers;

import com.swm.datatracker.models.MailSender;
import com.swm.datatracker.models.PasswordResetToken;
import com.swm.datatracker.models.User;
import com.swm.datatracker.respositories.PasswordTokenRepository;
import com.swm.datatracker.respositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.UUID;

@Controller
public class PasswordResetController {
    private MailSender mailSender;
    private UserRepository userRepository;
    private PasswordTokenRepository passwordTokenRepository;
    private PasswordEncoder passwordEncoder;

    public PasswordResetController(MailSender mailSender,
                                   UserRepository userRepository,
                                   PasswordTokenRepository passwordTokenRepository,
                                   PasswordEncoder passwordEncoder) {
        this.mailSender = mailSender;
        this.userRepository = userRepository;
        this.passwordTokenRepository = passwordTokenRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping(value = "/users/forgot", method = RequestMethod.GET)
    public String displayForgotPasswordPage(Model vModel) {
        return "users/forgot";
    }

    @RequestMapping(value = "/users/forgot", method = RequestMethod.POST)
    public String processForgotPasswordForm(@RequestParam("email") String userEmail, HttpServletRequest request, Model vModel) {

        boolean emailIsEmpty = userEmail.isEmpty();

        if (emailIsEmpty)  {
            vModel.addAttribute("isEmpty", emailIsEmpty);
            vModel.addAttribute("errorMessage", "Please enter an email address");
        } else if (userRepository.findByEmail(userEmail) == null) {
            vModel.addAttribute("userDoesNotExist", true);
            vModel.addAttribute("userNotFound", "User with that email does not exist or cannot be found. Try again.");
        } else {

            User user = userRepository.findByEmail(userEmail);
                System.out.println(user.getUsername());
                System.out.println(user.getPasswordToken());

            PasswordResetToken pt = new PasswordResetToken();
                pt.setUser(user);

                LocalDateTime ldt = LocalDateTime.now();
                LocalDateTime expired = ldt.plusMinutes(5);
                pt.setCreated_on(ldt);
                pt.setExpires_on(expired);
                pt.setToken(UUID.randomUUID().toString());

                passwordTokenRepository.save(pt);

            String appUrl = request.getScheme() + "://" + request.getServerName() + ":8080";

            mailSender.sendMail("support@demo.com", user.getEmail(),
                    "Password Reset Request",
                    "To reset your password, click the link below:\n" + appUrl
                            + "/reset?token=" + pt.getToken() + ". If you did not request a password change, you may ignore " +
                            "this email as it is entirely safe to do so. Thank you.");

                vModel.addAttribute("hasSent", true);
                vModel.addAttribute("successMessage", "If a user exists with that email, a password reset link will be sent to the email address provided");
        }
        return "users/forgot";
    }

    @RequestMapping(value = "/reset", method = RequestMethod.GET)
    public String displayResetPasswordPage(Model vModel,
                                           @RequestParam("token") String token, RedirectAttributes redirect) {

        PasswordResetToken pt = passwordTokenRepository.findByToken(token);
        Long id = pt.getUser().getId();
        User user = userRepository.findOne(id);
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime expires = pt.getExpires_on();

        if (user != null && ldt.isBefore(expires)) { // TOKEN IS NOT EXPIRED.
            vModel.addAttribute("resetToken", token); // ATTACH TOKEN TO RESET FORM

        } else if (user != null && ldt.isAfter(expires)) { // TOKEN IS EXPIRED
            redirect.addFlashAttribute("isExpired", true);
            redirect.addFlashAttribute("errorMessage", "This is an invalid password reset link.");
            return "redirect:/login";
        }

        vModel.addAttribute("user", user);
//        viewModel.addAttribute("formatter", formatter);
        return "users/reset";
    }

    @RequestMapping(value = "/reset/{token}", method = RequestMethod.POST)
    public String setNewPassword(Model vModel,
                                 @PathVariable String token,
                                 @RequestParam(name = "password") String password,
                                 RedirectAttributes redirect /* , @RequestParam Map<String, String> requestParams */) {

        // FIND USER WITH THE TOKEN
        PasswordResetToken pt = passwordTokenRepository.findByToken(token);
            Long id = pt.getUser().getId();
            User tokenUser = userRepository.findOne(id);

        if (password.isEmpty()) {
            vModel.addAttribute("hasError", true);
            vModel.addAttribute("resetToken", token);
            vModel.addAttribute("errorMessage", "Passwords cannot be empty. Passwords must be between 8-20 characters");
            return "users/reset";
        } else {

            // WILL ALWAYS BE NOT-NULL BUT CHECK
            if (tokenUser != null) {
                tokenUser.setPassword(passwordEncoder.encode(password));
                userRepository.save(tokenUser);

                // MODEL ATTRIBUTE ON REDIRECT
                redirect.addFlashAttribute("hasReset", true);
                redirect.addFlashAttribute("successMessage", "You have successfully reset your password. You may now login.");

                return "redirect:/login";

            } else {
                vModel.addAttribute("errorMessage", "Oops!  This is an invalid password reset link.");
            }
        }
        return "users/reset";
    }

    // ROUTE TO LOGIN PAGE WITH BAD TOKEN
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ModelAndView handleMissingParams(MissingServletRequestParameterException ex) {
        return new ModelAndView("redirect:/login");
    }
}
