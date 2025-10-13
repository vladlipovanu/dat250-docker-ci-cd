package com.github.vladlipovanu.dat250.controllers;

import com.github.vladlipovanu.dat250.entities.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class UserController {

    private final List<User> users = new ArrayList<>();


    @GetMapping("/user")
    public List<User> getUsers() {
        return users;
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        users.add(user);
        return user;
    }
}
