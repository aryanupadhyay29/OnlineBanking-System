package com.example.OnlineBankingSystem.controller;

import com.example.OnlineBankingSystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/deposit/{accountId}/{amount}")
    public String deposit(@PathVariable Long accountId, @PathVariable Double amount) {
        return transactionService.deposit(accountId, amount);
    }

    @PostMapping("/withdraw/{accountId}/{amount}")
    public String withdraw(@PathVariable Long accountId, @PathVariable Double amount) {
        return transactionService.withdraw(accountId, amount);
    }


}
