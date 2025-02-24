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

    public User getUser(String id) {

        if (users.containsKey(id)){
            return users.get(id);
        }
        throw new IllegalArgumentException("User with id: " + id + " - not found");
    }

    public User deleteUser(String id) {

        if (users.containsKey(id)){
            return users.remove(id);
        }
        throw new IllegalArgumentException("User with id " + id + "not found");
    }

    public User updateUserBalance(String id, double amount) {

        if (users.containsKey(id)) {
            users.get(id).setBalance(amount);
            return users.get(id);
        }

        throw new IllegalArgumentException("User with id " + id + "not found");
    }
}