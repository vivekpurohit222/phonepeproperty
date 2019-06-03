package com.example.phonepeproperty.Model;

public class Task_Main {
    private String dash_mName, dash_mPriority, dash_mStatus;
    private String dash_mStartDate, dash_mDueDate;

    public Task_Main(String dash_mName, String dash_mPriority, String dash_mStatus, String dash_mStartDate, String dash_mDueDate) {
        this.dash_mName = dash_mName;
        this.dash_mPriority = dash_mPriority;
        this.dash_mStatus = dash_mStatus;
        this.dash_mStartDate = dash_mStartDate;
        this.dash_mDueDate = dash_mDueDate;
    }

    public Task_Main() {
    }

    public void setDash_mName(String dash_mName) {
        this.dash_mName = dash_mName;
    }

    public void setDash_mPriority(String dash_mPriority) {
        this.dash_mPriority = dash_mPriority;
    }

    public void setDash_mStatus(String dash_mStatus) {
        this.dash_mStatus = dash_mStatus;
    }

    public void setDash_mStartDate(String dash_mStartDate) {
        this.dash_mStartDate = dash_mStartDate;
    }

    public void setDash_mDueDate(String dash_mDueDate) {
        this.dash_mDueDate = dash_mDueDate;
    }

    public String getDash_mName() {
        return dash_mName;
    }

    public String getDash_mPriority() {
        return dash_mPriority;
    }

    public String getDash_mStatus() {
        return dash_mStatus;
    }

    public String getDash_mStartDate() {
        return dash_mStartDate;
    }

    public String getDash_mDueDate() {
        return dash_mDueDate;
    }
}
