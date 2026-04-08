package com.example.OnlineBankingSystem.controller;

import com.example.OnlineBankingSystem.config.JwtUtil;
import com.example.OnlineBankingSystem.model.User;
import com.example.OnlineBankingSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/")
    public String Health(){

        return "Server is running";
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);

    }
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User loggedInUser = userService.login(user.getEmail(), user.getPassword());
        return jwtUtil.generateToken(loggedInUser.getEmail());
    }


}
