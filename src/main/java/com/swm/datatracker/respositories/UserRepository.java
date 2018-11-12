package com.swm.datatracker.respositories;

import com.swm.datatracker.models.UserRole;
import org.springframework.data.repository.CrudRepository;
import com.swm.datatracker.models.User;

import java.util.List;


public interface UserRepository extends CrudRepository<User, Long> {


    List<User> findAll();

    User findByUsername(String username);

    List<User> findAllByUserRole(UserRole userRole);

    List<User> findAllByEmailContainsOrUsernameContains(String string, String string2);

    List<User> findAllByUserRoleContains(long roleId);
}
