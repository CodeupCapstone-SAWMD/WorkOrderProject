package com.swm.datatracker.respositories;

import com.swm.datatracker.models.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolesRepository extends CrudRepository<UserRole, Long> {

    @Query("select ur.role from UserRole ur, User u where u.username=?1")
    List<String> ofUserWith(String username);
}