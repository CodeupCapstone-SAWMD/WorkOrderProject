package com.swm.datatracker.services;

import com.swm.datatracker.models.User;
import com.swm.datatracker.models.UserWithRoles;
import com.swm.datatracker.respositories.RolesRepository;
import com.swm.datatracker.respositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("customeUserDetailsService")
public class UserDetailsLoader implements UserDetailsService {
    private final UserRepository usersRepository;
    private final RolesRepository rolesRepository;

    public UserDetailsLoader(UserRepository usersRepository, RolesRepository rolesRepository) {
        this.usersRepository = usersRepository;
        this.rolesRepository = rolesRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = usersRepo.findByUsername(username);
        User user = usersRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }

//        return new UserWithRoles(user);
        return new UserWithRoles(user, rolesRepository.ofUserWith(username)); // This is the only change
    }
}
