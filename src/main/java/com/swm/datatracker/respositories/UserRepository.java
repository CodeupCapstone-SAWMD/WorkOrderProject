package com.swm.datatracker.respositories;

import org.springframework.data.repository.CrudRepository;
import com.swm.datatracker.models.User;

import java.util.List;


public interface UserRepository extends CrudRepository<User, Long> {


    User findByUsername(String username);


    List<User> findAllByEmailContainsOrUsernameContains(String string, String string2);

    List<User> findAllByUserRoleContains(long roleId);
}
