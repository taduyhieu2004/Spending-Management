package com.example.quanlichitieu.repository;

import com.example.quanlichitieu.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
