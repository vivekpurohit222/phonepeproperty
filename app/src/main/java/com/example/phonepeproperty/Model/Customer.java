package com.example.phonepeproperty.Model;

public class Customer {

    private String customerCV_mCompany,customerCV_mPhone,customerCV_mDateCtreated,customerCV_mInterested,customerCV_mProjectName;
    private int customerCV_id;

    public Customer(int customerCV_id, String customerCV_mCompany, String customerCV_mPhone, String customerCV_mDateCtreated, String customerCV_mInterested, String customerCV_mProjectName) {
        this.customerCV_id = customerCV_id;
        this.customerCV_mCompany = customerCV_mCompany;
        this.customerCV_mPhone = customerCV_mPhone;
        this.customerCV_mDateCtreated = customerCV_mDateCtreated;
        this.customerCV_mInterested = customerCV_mInterested;
        this.customerCV_mProjectName = customerCV_mProjectName;

    }

    public Customer() {
    }

    public void setCustomerCV_mCompany(String customerCV_mCompany) {
        this.customerCV_mCompany = customerCV_mCompany;
    }

    public void setCustomerCV_mPhone(String customerCV_mPhone) {
        this.customerCV_mPhone = customerCV_mPhone;
    }

    public void setCustomerCV_mDateCtreated(String customerCV_mDateCtreated) {
        this.customerCV_mDateCtreated = customerCV_mDateCtreated;
    }

    public void setCustomerCV_mInterested(String customerCV_mInterested) {
        this.customerCV_mInterested = customerCV_mInterested;
    }

    public void setCustomerCV_mProjectName(String customerCV_mProjectName) {
        this.customerCV_mProjectName = customerCV_mProjectName;
    }

    public void setCustomerCV_id(int customerCV_id) {
        this.customerCV_id = customerCV_id;
    }

    public String getCustomerCV_mCompany() {
        return customerCV_mCompany;
    }

    public String getCustomerCV_mPhone() {
        return customerCV_mPhone;
    }

    public String getCustomerCV_mDateCtreated() {
        return customerCV_mDateCtreated;
    }

    public String getCustomerCV_mInterested() {
        return customerCV_mInterested;
    }

    public String getCustomerCV_mProjectName() {
        return customerCV_mProjectName;
    }

    public int getCustomerCV_id() {
        return customerCV_id;
    }
}
