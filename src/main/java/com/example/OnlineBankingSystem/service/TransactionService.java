package com.example.OnlineBankingSystem.service;

import com.example.OnlineBankingSystem.model.Account;
import com.example.OnlineBankingSystem.model.Transaction;
import com.example.OnlineBankingSystem.repository.AccountRepository;
import com.example.OnlineBankingSystem.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public String deposit(Long accountId, Double amount){
        Account account = accountRepository.findById(accountId).orElseThrow();
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);

        Transaction tx = new Transaction();
        tx.setAmount(amount);
        tx.setType("Deposit");
        tx.setAccount(account);
        tx.setTimestamps(java.time.LocalDateTime.now());
        transactionRepository.save(tx);

        return "Deposit Successful";
    }

    public String withdraw(Long accountId, Double amount){
        Account account = accountRepository.findById(accountId).orElseThrow();
        if(account.getBalance() < amount){
            return "Insufficient Balance";
        }
        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);
        Transaction tx = new Transaction();
        tx.setAmount(amount);
        tx.setType("Withdraw");
        tx.setAccount(account);
        tx.setTimestamps(java.time.LocalDateTime.now());
        transactionRepository.save(tx);

        return "Withdraw Successful";
    }
}
