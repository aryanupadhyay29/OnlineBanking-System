package com.example.OnlineBankingSystem.service;

import com.example.OnlineBankingSystem.exception.InvalidCredentialsException;
import com.example.OnlineBankingSystem.exception.UserNotFoundException;
import com.example.OnlineBankingSystem.model.User;
import com.example.OnlineBankingSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }
    public User login(String email, String password) {
        if (email == null || email.isBlank() || password == null || password.isBlank()) {
            throw new IllegalArgumentException("Email and password are required");
        }

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        if (!Objects.equals(user.getPassword(), password)) {
            throw new InvalidCredentialsException("Invalid password");
        }

        return user;
    }
}
