package com.invisiblegardening.controllers;

import com.invisiblegardening.Models.UserData;
import com.invisiblegardening.controllers.dtos.UserDataDto;
import com.invisiblegardening.controllers.dtos.UserDataInputDto;
import com.invisiblegardening.services.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("userdata")
public class UserDataController {
    private final UserDataService userDataService;

    @Autowired
    public UserDataController(UserDataService userDataService) {

        this.userDataService = userDataService;

    }

    @GetMapping("/users")
    public List<UserDataDto> getUserDataList(@RequestParam(value = "firstname", required = false, defaultValue = "") String userFirstname,
                                             @RequestParam( value = "lastname", required = false, defaultValue = "") String userLastname) {

        var dtos = new ArrayList<UserDataDto>();

        List<UserData> userDataList;

        if (userFirstname == null && userLastname == null){

            userDataList = userDataService.getUserDataList();

        }else if (userFirstname != null && userLastname == null){

            userDataList = userDataService.findUserDataListByUserFirstname(userFirstname);

        }else {

            userDataList = userDataService.findUserDataListByUserLastname(userLastname);

        }

        for (UserData userData : userDataList) {

            dtos.add(UserDataDto.fromUserData(userData));

        }

        return dtos;

    }


    @GetMapping("/{id}")
    public UserDataDto getUserData(@PathVariable("id") Long id) {

        var userData = userDataService.getUserData(id);

        return UserDataDto.fromUserData(userData);

    }

    @PostMapping
    public UserDataDto saveUserData(@RequestBody UserDataInputDto dto) {

        var userData = userDataService.saveUserData(dto.toUserData());

        return UserDataDto.fromUserData(userData);

    }

    @PutMapping("/{id}")
    public UserDataDto updateUserData(@PathVariable Long id,
                                     @RequestBody UserData userData) {

        userDataService.updateUserData(id, userData);

        return UserDataDto.fromUserData(userData);

    }

    @DeleteMapping("/{id}")
    public void deleteUserData(@PathVariable("id") Long id) {

        userDataService.deleteUserData(id);

    }

}