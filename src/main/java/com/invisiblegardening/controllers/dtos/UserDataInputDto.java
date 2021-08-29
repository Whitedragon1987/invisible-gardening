package com.invisiblegardening.controllers.dtos;

import com.invisiblegardening.Models.UserData;

public class UserDataInputDto {
    public Long id;

    public String userFirstname;
    public String userLastname;
    public String userAddress;
    public String userZipcode;
    public String userCity;
    public String userPhoneNumber;
    public Boolean hasCompany;

    public UserData toUserData() {
        var userData = new UserData();

        userData.setId(id);

        userData.setUserFirstname(userFirstname);

        userData.setUserLastname(userLastname);

        userData.setUserAddress(userAddress);

        userData.setUserZipcode(userZipcode);

        userData.setUserCity(userCity);

        userData.setUserPhoneNumber(userPhoneNumber);

        userData.setHasCompany(hasCompany);

        return userData;

    }

}
