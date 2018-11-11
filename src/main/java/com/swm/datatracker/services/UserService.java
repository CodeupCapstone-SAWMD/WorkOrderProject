package com.swm.datatracker.services;

import com.swm.datatracker.models.User;
import com.swm.datatracker.respositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;
import java.util.List;

public class UserService {

    private final UserRepository usersRepo;

    public UserService(UserRepository usersRepo) {
        this.usersRepo = usersRepo;
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

}
