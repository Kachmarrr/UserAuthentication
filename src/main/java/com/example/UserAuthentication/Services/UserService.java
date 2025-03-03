package com.example.UserAuthentication.Services;

import com.example.UserAuthentication.Entity.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class UserService {

    private List<User> users = FileReaderWriter.readCSVFile();

    public User createUser(User user) {

        user.setId(UUID.randomUUID().toString());
        users.add(user);
        FileReaderWriter.writeToCSVFile(users);

        return user;
    }

    public User getUser(String userId) {

        User getUser =  users.stream()
               .filter(user -> user.getId().equals(userId))
               .findFirst()
               .orElse(null);

        if (getUser != null){
            return getUser;
        }

       throw new IllegalArgumentException("User with id: " + userId + " not found");
    }

    public User deleteUser(String userId) {

        User userDell = getUser(userId);

        if (userDell != null) {
            users.remove(userDell);
            FileReaderWriter.writeToCSVFile(users);
            return userDell;
        }
        throw new IllegalArgumentException("User with id " + userId + " - not found");

    }

    public User updateUser(String userId, User user) {

        User userUpdate = getUser(userId);

        if (userUpdate != null) {

            userUpdate.setUserName(user.getUserName());
            userUpdate.setPassword(user.getPassword());
            userUpdate.setBalance(user.getBalance());

            FileReaderWriter.writeToCSVFile(users);

            return userUpdate;
        }
        throw new IllegalArgumentException("User with id " + userId + " - not found");
    }

}