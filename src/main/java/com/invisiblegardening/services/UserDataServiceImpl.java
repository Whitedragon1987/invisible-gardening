package com.invisiblegardening.services;

import com.invisiblegardening.Exceptions.RecordNotFoundException;
import com.invisiblegardening.Models.UserData;
import com.invisiblegardening.repositories.UserDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDataServiceImpl implements UserDataService {
    private final UserDataRepository userDataRepository;

    @Autowired
    public UserDataServiceImpl(UserDataRepository userDataRepository) {

        this.userDataRepository = userDataRepository;

    }

    @Override
    public List<UserData> getUserDataList() {

        return userDataRepository.findAll();

    }

    @Override
    public List<UserData> findUserDataListByUserFirstname(String userFirstname) {

        var optionalUserDataList = userDataRepository.findByUserFirstnameContainingIgnoreCase(userFirstname);

        if(optionalUserDataList.isEmpty()) {

            throw new RecordNotFoundException("no user with firstname " + userFirstname);

        }

        return optionalUserDataList;

    }

    @Override
    public List<UserData> findUserDataListByUserLastname(String userLastname) {

        var optionalUserDataList = userDataRepository.findByUserLastnameContainingIgnoreCase(userLastname);

        if(optionalUserDataList.isEmpty()) {

            throw new RecordNotFoundException("no user with lastname " + userLastname);

        }

        return optionalUserDataList;

    }

    @Override
    public UserData getUserData(Long id) {

        var optionalUserData = userDataRepository.findById(id);

        if (optionalUserData.isEmpty()) {

            throw new RecordNotFoundException("userdata does not exist");

        } else {

            return optionalUserData.get();

        }

    }

    @Override
    public UserData saveUserData(UserData userData) {

        return userDataRepository.save(userData);

    }

    @Override
    public void updateUserData(Long id, UserData userdata) {

        Optional<UserData> optionalUserData = userDataRepository.findById(id);

        if(optionalUserData.isEmpty()) {

            throw new RecordNotFoundException("userdata does not exist");

        } else {

            userDataRepository.save(userdata);

        }

    }

    @Override
    public void deleteUserData(Long id) {

        userDataRepository.deleteById(id);

    }

}