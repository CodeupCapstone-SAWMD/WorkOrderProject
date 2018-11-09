package com.swm.datatracker.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Column(name = "user_id")
//    private long userId;

//    @Column(name = "user_id")
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
//    private List<User> users;
//
    // THIS WORKS SO FAR
    @Column(name = "role")
    private String role;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRole")
    private List<User> users;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy="userrole")
//    private List<User> users;

    public UserRole(long id, List<User> users, String role) {
        this.id = id;
        this.users = users;
        this.role = role;
    }

    public UserRole(List<User> users, String role) {
        this.users = users;
        this.role = role;
    }

    public UserRole(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return role;
    }

    public void setRoleName(String roleName) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

//    public void setUsers(List<User> users) {
//        this.users = users;
//    }
//
//    public List<User> getUsers() {
//        return this.users;
//    }

    public static UserRole admin(List<User> users) {
        return new UserRole(users, "ROLE_ADMIN");
    }
    public static UserRole editor(List<User> users) {
        return new UserRole(users, "ROLE_EDITOR");
    }
    public static UserRole user(List<User> users) {
        return new UserRole(users, "ROLE_USER");
    }
}
