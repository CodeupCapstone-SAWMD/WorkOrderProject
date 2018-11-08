package com.swm.datatracker.models;

import javax.persistence.*;

//test

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true, length = 45)
    private String username;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 45)
    private String firstName;

    @Column(nullable = false, length = 45)
    private String lastName;

    @Column(nullable = false, length = 11)
    private long streetNumber;

    @Column(nullable = false, length = 45)
    private String streetName;

    @Column(nullable = false, length = 45)
    private String city;

    @Column(nullable = false, length = 20)
    private long zipcode;

    @Column(nullable = false)
    private String phoneNumber;

    public User() {
    }

    public User(String username, String email, String password, String firstName, String lastName, long streetNumber, String streetName, String city, long zipcode, String phoneNumber) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
    }

    public User(long id, String username, String email, String password, String firstName, String lastName, long streetNumber, String streetName, String city, long zipcode, String phoneNumber) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
    }

    public User(User copy) {
        id = copy.id;
        username = copy.username;
        email = copy.email;
        password = copy.password;
        firstName = copy.firstName;
        lastName = copy.lastName;
        streetNumber = copy.streetNumber;
        streetName = copy.streetName;
        city = copy.city;
        zipcode = copy.zipcode;
        phoneNumber = copy.phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(long streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getZipcode() {
        return zipcode;
    }

    public void setZipcode(long zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
