package com.example.UserAuthentication.Controllers;

import com.example.UserAuthentication.Entity.User;
import com.example.UserAuthentication.Services.UserService;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users/")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable String userId) {
            return userService.getUser(userId);
    }

    @DeleteMapping("/users/{userId}")
    public User deleteUser(@PathVariable String userId) {
        return userService.deleteUser(userId);
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable String userId, @RequestBody User user){
        return userService.updateUser(userId, user);
    }

}
