package com.example.UserAuthentication.Services;

import com.example.UserAuthentication.Entity.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {

    //<String = usedId
    private Map<String, User> users = new HashMap<>();

    public User createUser(User user) {

        user.setId(UUID.randomUUID().toString());
        users.put(user.getId(), user);

        return user;
    }

    public Map<String, User> getAllUsers() {
        return users;
    }

    public User getUser(String id, String password) {

        if (users.containsKey(id)){
            if (users.get(id).getPassword().equals(password)){
                return users.get(id);
            }
            throw new IllegalArgumentException("User with id: " + id + " - password is not correct.");
        }
        throw new IllegalArgumentException("User with id: " + id + " - not found");
    }

    public User deleteUser(String id) {

        if (users.containsKey(id)){
            return users.remove(id);
        }
        throw new IllegalArgumentException("User with id " + id + " - not found");
    }

    public User updateUser(String id, User user) {

        if (!users.containsKey(id)) {
            throw new IllegalArgumentException("User with id " + id + " - not found");
        }

        User updateUser = users.get(id);

            if (users.containsKey(id)) {

                updateUser.setUserName(user.getUserName());
                updateUser.setPassword(user.getPassword());
                updateUser.setBalance(user.getBalance());

            }

        return updateUser;
    }
}