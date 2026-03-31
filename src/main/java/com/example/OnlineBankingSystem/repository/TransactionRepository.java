package com.example.OnlineBankingSystem.repository;

import com.example.OnlineBankingSystem.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction , Long> {
}
