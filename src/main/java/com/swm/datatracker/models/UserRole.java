package com.swm.datatracker.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_roles")
public class UserRole {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(name = "user_id")
        private long userId;

        @Column(name = "role")
        private String role;

//        @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRole")
//        private List<User> users;

//        @OneToOne
//        private User user;

        public UserRole() {}

        public UserRole(long id, long userId, String role) {
            this.id = id;
            this.userId = userId;
            this.role = role;
//            this.user = user;
        }

        public UserRole(long userId, String role) {
            this.userId = userId;
            this.role = role;
//            this.user = user;
        }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public String getRoleName() {
            return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setRoleName(String role) {
            this.role = role;
    }

//    public User getUser() {
//            return user;
//    }
//
//    public void setUser(User user) {
//            this.user = user;
//    }

//    public List<User> getUsers() {
//            return users;
//    }
//
//    public void setUsers(List<User> users) {
//            this.users = users;
//    }

}
