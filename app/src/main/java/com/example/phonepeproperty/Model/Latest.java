package com.example.phonepeproperty.Model;

public class Latest {
   private String day;
    private String activity;

    public Latest(String day, String activity) {
        this.day = day;
        this.activity = activity;
    }

    public Latest() {
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getDay() {
        return day;
    }

    public String getActivity() {
        return activity;
    }
}
