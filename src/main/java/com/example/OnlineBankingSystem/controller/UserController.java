package com.example.OnlineBankingSystem.controller;

import com.example.OnlineBankingSystem.model.User;
import com.example.OnlineBankingSystem.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    @GetMapping("/")
    public String Health(){

        return "Server is running";
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);

    }
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userService.login(user.getEmail(), user.getPassword());
    }


}
