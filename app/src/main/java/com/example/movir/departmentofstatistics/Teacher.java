package com.example.movir.departmentofstatistics;

import java.util.ArrayList;

public class Teacher {
    private Integer images;
    private String names;
    private String designations;
    private String emails;
    private String phones;


    public Teacher(Integer images, String names, String designations, String emails, String phones) {
        this.images = images;
        this.names = names;
        this.designations = designations;
        this.emails = emails;
        this.phones = phones;
    }

    public Integer getImages() {
        return images;
    }

    public String getNames() {
        return names;
    }

    public String getDesignations() {
        return designations;
    }

    public String getEmails() {
        return emails;
    }

    public String getPhones() {
        return phones;
    }

    public void setImages(Integer images) {
        this.images = images;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public void setDesignations(String designations) {
        this.designations = designations;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }
}

