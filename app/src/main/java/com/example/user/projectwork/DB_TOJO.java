package com.example.user.projectwork;

public class DB_TOJO
{
    public int getId() {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }


    public String getPICKLOC()
    {
        return pickloc;
    }

    public void setPICKLOC(String pickloc)
    {
        this.pickloc = pickloc;
    }

    public String getDROPLOC()
    {
        return droploc;
    }

    public void setDROPLOC(String droploc)
    {
        this.droploc = droploc;
    }

    public String getDATE()
    {
        return date;
    }

    public void setDATE(String date)
    {
        this.date = date;
    }


    int id;
    String pickloc ,droploc ,date;  //first highlight them and click on generate then on constructor click on all 4 optns when const created again come here highlight them right click on generate and on getter and setter


    public DB_TOJO(int id, String pickloc, String droploc, String date) {

        this.id = id;
        this.pickloc = pickloc;
        this.droploc = droploc;
        this.date = date;
    }

    public DB_TOJO()
    {

    }




}
