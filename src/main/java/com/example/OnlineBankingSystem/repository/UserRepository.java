package com.example.OnlineBankingSystem.repository;

import com.example.OnlineBankingSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
     User findByUsername(String username);
}
