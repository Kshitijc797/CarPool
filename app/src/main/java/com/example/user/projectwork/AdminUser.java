package com.example.user.projectwork;

public class AdminUser {
    private String firstname, lastname, email, username, mobile;

    public AdminUser(String firstname, String lastname, String email, String username, String mobile){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.mobile = mobile;
    }


    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getMobile() {
        return mobile;
    }
}
