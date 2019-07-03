package com.example.user.projectwork;

public class Users {

    private String firstname, lastname, mobile;

    public Users(String firstname, String lastname, String mobile){
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

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
