package com.example.OnlineBankingSystem.repository;

import com.example.OnlineBankingSystem.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
