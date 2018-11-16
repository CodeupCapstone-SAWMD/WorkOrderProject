package com.swm.datatracker.services;

import com.swm.datatracker.models.PasswordResetToken;
import com.swm.datatracker.models.User;
import com.swm.datatracker.respositories.PasswordTokenRepository;
import com.swm.datatracker.respositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.List;

public class UserService {

    private final UserRepository usersRepo;
    private final PasswordTokenRepository passwordTokenRepository;
    private final PasswordResetToken passwordResetToken;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository usersRepo, PasswordTokenRepository passwordTokenRepository, PasswordResetToken passwordResetToken, PasswordEncoder passwordEncoder) {
        this.usersRepo = usersRepo;
        this.passwordTokenRepository = passwordTokenRepository;
        this.passwordResetToken = passwordResetToken;
        this.passwordEncoder = passwordEncoder;
    }
    public Iterable<User> findAll() {
        return usersRepo.findAll();
    }

    public User save(User user) {
        return usersRepo.save(user);
    }

    public User findOne(long id) {
        return usersRepo.findOne(id);
    }

    public List<User> search(String string){
        return usersRepo.findAllByEmailContainsOrUsernameContains(string, string);
    }
    public List<User> findAllAdmin() {
        return usersRepo.findAllByUserRoleContains(1);
    }

    public  List<User> findAllEmployees (){
        return usersRepo.findAllByUserRoleContains(2);
    }

    public User findUserByEmail(String email) {
        return usersRepo.findByEmail(email);
    }

//    public void createPasswordResetTokenForUser(User user, String token) {
//        PasswordResetToken myToken = new PasswordResetToken(token, user);
//        passwordTokenRepository.save(myToken);
//    }
//
//    public void changeUserPassword(User user, String password) {
//        user.setPassword(passwordEncoder.encode(password));
//        usersRepo.save(user);
//    }
}
