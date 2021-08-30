package com.invisiblegardening.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Review {

    @Id
    @GeneratedValue
    Long id;

    String value;
    String description;

    @OneToOne
    UserData userData;

    @OneToOne
    Picture picture;

    public Long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public UserData getUserData() {
        return userData;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
