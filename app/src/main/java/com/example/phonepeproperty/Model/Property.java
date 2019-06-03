package com.example.phonepeproperty.Model;

public class Property {

    private String propertyCV_mProjectTitle,propertyCV_mRate,propertyCV_mPropertyType,propertyCV_mPropertyFor,propertyCV_mPartyName;
    private int propertyCV_mId;

    public Property(int propertyCV_mId, String propertyCV_mProjectTitle, String propertyCV_mRate, String propertyCV_mPropertyType, String propertyCV_mPropertyFor, String propertyCV_mPartyName) {
        this.propertyCV_mProjectTitle = propertyCV_mProjectTitle;
        this.propertyCV_mRate = propertyCV_mRate;
        this.propertyCV_mPropertyType = propertyCV_mPropertyType;
        this.propertyCV_mPropertyFor = propertyCV_mPropertyFor;
        this.propertyCV_mPartyName = propertyCV_mPartyName;
        this.propertyCV_mId = propertyCV_mId;
    }


    public Property() {
    }

    public void setPropertyCV_mProjectTitle(String propertyCV_mProjectTitle) {
        this.propertyCV_mProjectTitle = propertyCV_mProjectTitle;
    }

    public void setPropertyCV_mRate(String propertyCV_mRate) {
        this.propertyCV_mRate = propertyCV_mRate;
    }

    public void setPropertyCV_mPropertyType(String propertyCV_mPropertyType) {
        this.propertyCV_mPropertyType = propertyCV_mPropertyType;
    }

    public void setPropertyCV_mPropertyFor(String propertyCV_mPropertyFor) {
        this.propertyCV_mPropertyFor = propertyCV_mPropertyFor;
    }

    public void setPropertyCV_mPartyName(String propertyCV_mPartyName) {
        this.propertyCV_mPartyName = propertyCV_mPartyName;
    }

    public void setPropertyCV_mId(int propertyCV_mId) {
        this.propertyCV_mId = propertyCV_mId;
    }

    public String getPropertyCV_mProjectTitle() {
        return propertyCV_mProjectTitle;
    }

    public String getPropertyCV_mRate() {
        return propertyCV_mRate;
    }

    public String getPropertyCV_mPropertyType() {
        return propertyCV_mPropertyType;
    }

    public String getPropertyCV_mPropertyFor() {
        return propertyCV_mPropertyFor;
    }

    public String getPropertyCV_mPartyName() {
        return propertyCV_mPartyName;
    }

    public int getPropertyCV_mId() {
        return propertyCV_mId;
    }
}
