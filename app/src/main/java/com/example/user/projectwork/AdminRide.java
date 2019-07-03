package com.example.user.projectwork;

public class AdminRide {
    private String pick, drop, email, pick_date, return_date;

    public AdminRide(String pick, String drop, String email, String pick_date, String return_date) {
        this.pick = pick;
        this.drop = drop;
        this.email = email;
        this.pick_date = pick_date;
        this.return_date = return_date;
    }

    public String getPick() {
        return pick;
    }

    public String getDrop() {
        return drop;
    }

    public String getEmail() {
        return email;
    }

    public String getPick_date() {
        return pick_date;
    }

    public String getReturn_date() {
        return return_date;
    }
}
