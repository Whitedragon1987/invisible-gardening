package com.invisiblegardening.Models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Quote {

    @Id
    @GeneratedValue
    Long id;

    String description;
    Date date;

    @OneToOne
    Picture picture;

    @OneToOne
    UserData userData;


    public Long getId() {
        return id;
    }

    public String getQuoteDescription() {
        return description;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuoteDescription(String quoteDescription) {
        this.description = quoteDescription;
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
}
