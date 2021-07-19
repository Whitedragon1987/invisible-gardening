package com.invisiblegardening.controllers.dtos;

import com.invisiblegardening.Models.UserData;

public class UserDataInputDto {
    Long id;

    String userFirstname;
    String userLastname;
    String userAddress;
    String userZipcode;
    String userCity;
    String userPhoneNumber;

    public UserData toUserData() {
        var userData = new UserData();
        userData.setId(id);
        userData.setUserFirstname(userFirstname);
        userData.setUserLastname(userLastname);
        userData.setUserAddress(userAddress);
        userData.setUserZipcode(userZipcode);
        userData.setUserCity(userCity);
        userData.setUserPhoneNumber(userPhoneNumber);
        return userData;
    }
}
