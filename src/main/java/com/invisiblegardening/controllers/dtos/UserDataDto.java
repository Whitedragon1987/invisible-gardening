package com.invisiblegardening.controllers.dtos;

import com.invisiblegardening.Models.UserData;

public class UserDataDto {
    Long id;

    String userFirstname;
    String userLastname;
    String userAddress;
    String userZipcode;
    String userCity;
    String userPhoneNumber;

    public static UserDataDto fromUserData(UserData userData) {
        var dto = new UserDataDto();
        dto.id = userData.getId();
        dto.userFirstname = userData.getUserFirstname();
        dto.userLastname = userData.getUserLastname();
        dto.userAddress = userData.getUserAddress();
        dto.userZipcode = userData.getUserZipcode();
        dto.userCity = userData.getUserCity();
        dto.userPhoneNumber = userData.getUserPhoneNumber();
        return dto;
    }
}
