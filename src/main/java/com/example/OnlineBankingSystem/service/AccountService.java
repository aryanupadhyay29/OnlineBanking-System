package com.example.OnlineBankingSystem.service;

import com.example.OnlineBankingSystem.exception.UserNotFoundException;
import com.example.OnlineBankingSystem.model.Account;
import com.example.OnlineBankingSystem.model.User;
import com.example.OnlineBankingSystem.repository.AccountRepository;
import com.example.OnlineBankingSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    public Account createAccount(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        Account account = new Account();

        account.setAccountNumber(UUID.randomUUID().toString());
        account.setBalance(0.0);
        account.setUser(user);

        return accountRepository.save(account);
    }
}
