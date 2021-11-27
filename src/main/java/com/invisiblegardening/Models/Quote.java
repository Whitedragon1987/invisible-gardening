package com.invisiblegardening.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Quote {

    @Id
    @GeneratedValue
    Long id;

    String description;
    Date date;
    Status status;

    @OneToOne
    Picture picture;

    @OneToOne
    UserData userData;


    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Picture getPicture() {
        return picture;
    }

    public UserData getUserData() {
        return userData;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
