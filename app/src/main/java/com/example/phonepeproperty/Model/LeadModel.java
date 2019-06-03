package com.example.phonepeproperty.Model;

public class LeadModel {
    private String  leadCV_mName,leadCV_mPhone,leadCV_mAssigned,leadCV_mStatus,leadCV_mSource,leadCV_mLastContact,leadCV_mCreated;
private int leadCV_mId;
    public LeadModel(int leadCV_mId, String leadCV_mName, String leadCV_mPhone, String leadCV_mAssigned, String leadCV_mStatus, String leadCV_mSource, String leadCV_mLastContact, String leadCV_mCreated) {
        this.leadCV_mId = leadCV_mId;
        this.leadCV_mName = leadCV_mName;
        this.leadCV_mPhone = leadCV_mPhone;
        this.leadCV_mAssigned = leadCV_mAssigned;
        this.leadCV_mStatus = leadCV_mStatus;
        this.leadCV_mSource = leadCV_mSource;
        this.leadCV_mLastContact = leadCV_mLastContact;
        this.leadCV_mCreated = leadCV_mCreated;
    }

    public LeadModel() {
    }

    public void setLeadCV_mName(String leadCV_mName) {
        this.leadCV_mName = leadCV_mName;
    }

    public void setLeadCV_mPhone(String leadCV_mPhone) {
        this.leadCV_mPhone = leadCV_mPhone;
    }

    public void setLeadCV_mAssigned(String leadCV_mAssigned) {
        this.leadCV_mAssigned = leadCV_mAssigned;
    }

    public void setLeadCV_mStatus(String leadCV_mStatus) {
        this.leadCV_mStatus = leadCV_mStatus;
    }

    public void setLeadCV_mSource(String leadCV_mSource) {
        this.leadCV_mSource = leadCV_mSource;
    }

    public void setLeadCV_mLastContact(String leadCV_mLastContact) {
        this.leadCV_mLastContact = leadCV_mLastContact;
    }

    public void setLeadCV_mCreated(String leadCV_mCreated) {
        this.leadCV_mCreated = leadCV_mCreated;
    }

    public void setLeadCV_mId(int leadCV_mId) {
        this.leadCV_mId = leadCV_mId;
    }

    public int getLeadCV_mId() {
        return leadCV_mId;
    }

    public String getLeadCV_mName() {
        return leadCV_mName;
    }

    public String getLeadCV_mPhone() {
        return leadCV_mPhone;
    }

    public String getLeadCV_mAssigned() {
        return leadCV_mAssigned;
    }

    public String getLeadCV_mStatus() {
        return leadCV_mStatus;
    }

    public String getLeadCV_mSource() {
        return leadCV_mSource;
    }

    public String getLeadCV_mLastContact() {
        return leadCV_mLastContact;
    }

    public String getLeadCV_mCreated() {
        return leadCV_mCreated;
    }
}
