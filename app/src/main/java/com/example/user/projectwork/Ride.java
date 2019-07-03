package com.example.user.projectwork;

public class Ride {
    private String pick, drop, email, pick_date, return_date;

    public Ride(String pick, String drop, String email, String pick_date, String return_date) {
        this.pick = pick;
        this.drop = drop;
        this.email = email;
        this.pick_date = pick_date;
        this.return_date = return_date;
    }

    public String getPick() {
        return pick;
    }

    public void setPick(String pick) {
        this.pick = pick;
    }

    public String getDrop() {
        return drop;
    }

    public void setDrop(String drop) {
        this.drop = drop;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPick_date() {
        return pick_date;
    }

    public void setPick_date(String pick_date) {
        this.pick_date = pick_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }
}
