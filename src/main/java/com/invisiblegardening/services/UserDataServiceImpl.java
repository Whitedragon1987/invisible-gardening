package com.invisiblegardening.services;

import antlr.RecognitionException;
import com.invisiblegardening.Exceptions.RecordNotFoundException;
import com.invisiblegardening.Models.UserData;
import com.invisiblegardening.repositories.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDataServiceImpl implements UserDataService{
    private UserDataRepository userDataRepository;

    @Autowired
    public UserDataServiceImpl(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }

    // find alle userdata and return them in a list
    @Override
    public List<UserData> getUserDataList() {
        return userDataRepository.findAll();
    }

    // find all userdata by firstname and return them in a list
    @Override
    public List<UserData> findUserDataListByUserFirstname(String userFirstname) {
        return this.userDataRepository.findByUserFirstnameContainingIgnoreCase(userFirstname);
    }

    // find all userdata where firstname equals input and return them in a list
    @Override
    public List<UserData> findUserDataListByUsersLastname(String userLastname) {
        return this.userDataRepository.findByUserLastnameContainingIgnoreCase(userLastname);
    }

    // find all userdata where lastname equals input and return them in a list

}
