package com.example.phonepeproperty.Model;

public class Myreminder {
    private String relatedTo;
    private String description;

    private String date;
    public Myreminder(String relatedTo, String description, String date) {
        this.relatedTo = relatedTo;
        this.description = description;
        this.date = date;
    }

    public Myreminder() {
    }

    public void setRelatedTo(String relatedTo) {
        this.relatedTo = relatedTo;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRelatedTo() {
        return relatedTo;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }
}
