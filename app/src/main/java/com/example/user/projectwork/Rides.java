package com.example.user.projectwork;

public class Rides {
    private String pick, drop;

    public Rides(String pick,String drop){
        this.pick = pick;
        this.drop = drop;
    }

    public String getPick(){
        return pick;
    }

    public void setPick(String pick){
        this.pick = pick;
    }

    public String getDrop(){
        return drop;
    }

    public void setDrop(String drop){
        this.drop = drop;
    }
}
