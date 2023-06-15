package com.amyauth.devilfood;

import java.util.HashMap;

public class Database_People {

    String useerName,User_Id,user_Phone,area;

    public Database_People(String useerName, String user_Id, String user_Phone, String area) {
        this.useerName = useerName;
        User_Id = user_Id;
        this.user_Phone = user_Phone;
        this.area = area;
    }

    public Database_People() {

    }

    public String getUseerName() {
        return useerName;
    }

    public void setUseerName(String useerName) {
        this.useerName = useerName;
    }

    public String getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(String user_Id) {
        User_Id = user_Id;
    }

    public String getUser_Phone() {
        return user_Phone;
    }

    public void setUser_Phone(String user_Phone) {
        this.user_Phone = user_Phone;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
