package com.invisiblegardening.services;

import com.invisiblegardening.Models.UserData;

import java.util.List;

public interface UserDataService {

    List<UserData> getUserDataList();
    List<UserData> findUserDataListByUserFirstname(String userFirstname);
    List<UserData> findUserDataListByUserLastname(String userLastname);

    UserData getUserData(Long id);
    UserData saveUserData(UserData userData);

    void updateUserData(Long id, UserData userData);
    void deleteUserData(Long id);
    void assignCompanyToUserData(Long companyId, Long id);
}