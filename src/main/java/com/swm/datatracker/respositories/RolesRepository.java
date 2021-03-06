package com.swm.datatracker.respositories;

import com.swm.datatracker.models.User;
import com.swm.datatracker.models.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolesRepository extends CrudRepository<UserRole, Long> {

//    @Query("select ur.role from UserRole ur, User u where u.username=?1")
////    List<String> ofUserWith(String username);

        @Query("select ur.role from UserRole ur, User u where u.username=?1 and ur.userId = u.id")
        List<String> ofUserWith(String username);

        @Query("FROM UserRole ur WHERE ur.id = ?1")
        UserRole findOneById(Long id);

        List<User> findAllByRoleIsLike(String name);

        @Query("FROM UserRole ur WHERE userId = ?1")
        UserRole findOneByUserId(Long id);
}
