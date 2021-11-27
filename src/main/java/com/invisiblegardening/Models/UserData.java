package com.invisiblegardening.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserData {

    @Id
//    @GeneratedValue
    Long id;

    String userFirstname;
    String userLastname;
    String userAddress;
    String userZipcode;
    String userCity;
    String userPhoneNumber;


    @OneToOne(mappedBy = "userData")
    User user;

    @OneToOne(mappedBy = "userData")
    Quote quote;

    @OneToMany(mappedBy = "userData")
    List<Request> requests;

    public Long getId() {

        return id;

    }

    public String getUserFirstname() {

        return userFirstname;

    }

    public String getUserLastname() {

        return userLastname;

    }

    public String getUserAddress() {

        return userAddress;

    }

    public String getUserZipcode() {

        return userZipcode;

    }

    public String getUserCity() {

        return userCity;

    }

    public String getUserPhoneNumber() {

        return userPhoneNumber;

    }

    public void setId(Long id) {

        this.id = id;

    }

    public void setUserFirstname(String userFirstname) {

        this.userFirstname = userFirstname;

    }

    public void setUserLastname(String userLastname) {

        this.userLastname = userLastname;

    }

    public void setUserAddress(String userAddress) {

        this.userAddress = userAddress;

    }

    public void setUserZipcode(String userZipcode) {

        this.userZipcode = userZipcode;

    }

    public void setUserCity(String userCity) {

        this.userCity = userCity;

    }

    public void setUserPhoneNumber(String userPhoneNumber) {

        this.userPhoneNumber = userPhoneNumber;

    }

}
