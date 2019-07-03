package com.example.user.projectwork;

public class Riders {

    private String firstname, lastname, mobile;

    public Riders(String firstname, String lastname, String mobile) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.mobile = mobile;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMobile() {
        return mobile;
    }
}
