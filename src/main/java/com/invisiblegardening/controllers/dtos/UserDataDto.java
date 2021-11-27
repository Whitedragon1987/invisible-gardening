package com.invisiblegardening.controllers.dtos;

import com.invisiblegardening.Models.UserData;

public class UserDataDto {
    public Long id;

    public String userFirstname;
    public String userLastname;
    public String userAddress;
    public String userZipcode;
    public String userCity;
    public String userPhoneNumber;




    public static UserDataDto fromUserData(UserData userData) {
        if (userData == null ) return null;

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
