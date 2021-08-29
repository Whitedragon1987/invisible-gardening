package com.invisiblegardening.services;

import com.invisiblegardening.Exceptions.RecordNotFoundException;
import com.invisiblegardening.Exceptions.UsernameAlreadyExistException;
import com.invisiblegardening.Exceptions.UsernameNotFoundException;
import com.invisiblegardening.Models.Authority;
import com.invisiblegardening.Models.User;
import com.invisiblegardening.repositories.UserDataRepository;
import com.invisiblegardening.repositories.UserRepository;
import com.invisiblegardening.utils.RandomStringGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements com.invisiblegardening.services.UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDataRepository userDataRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Collection<User> getUsers() {

        return userRepository.findAll();

    }

    @Override
    public Optional<User> getUser(String username) {

        return userRepository.findById(username);

    }

    @Override
    public boolean userExists(String username) {

        return userRepository.existsById(username);

    }

    @Override
    public String createUser(User user) {

        if(userExists(user.getUsername())){
            throw new UsernameAlreadyExistException("Username is al in gebuik");
        }

        String randomString = RandomStringGenerator.generateAlphaNumeric(20);

        user.setEmail(user.getEmail());

        user.setApikey(randomString);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.getAuthorities().clear();

        user.addAuthority(new Authority(user.getUsername(),"ROLE_USER"));

        user.setId((getUsers().size())+1);

        User newUser = userRepository.save(user);

        return newUser.getUsername();

    }

    @Override
    public void deleteUser(String username) {

        userRepository.deleteById(username);

    }

    @Override
    public void updateUser(String username, User newUser) {

        if (!userRepository.existsById(username)) throw new RecordNotFoundException();

        User user = userRepository.findById(username).get();

        user.setPassword(newUser.getPassword());

        userRepository.save(user);

    }

    @Override
    public Set<Authority> getAuthorities(String username) {

        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);

        User user = userRepository.findById(username).get();

        return user.getAuthorities();

    }

    @Override
    public void addAuthority(String username, String authority) {

        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);

        User user = userRepository.findById(username).get();

        user.addAuthority(new Authority(username, authority));

        userRepository.save(user);
    }

    @Override
    public void removeAuthority(String username, String authority) {

        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);

        User user = userRepository.findById(username).get();

        Authority authorityToRemove = user.getAuthorities().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().get();

        user.removeAuthority(authorityToRemove);

        userRepository.save(user);

    }

    @Override
    public void assignUserDataToUser(Long userDataId, String username) {

        var optionalUser = userRepository.findById(username);

        var optionalUserData = userDataRepository.findById(userDataId);

        if (optionalUserData.isPresent() && optionalUser.isPresent()) {

            var user = optionalUser.get();

            var userData = optionalUserData.get();

            user.setUserData(userData);

            userRepository.save(user);

        }

    }

}