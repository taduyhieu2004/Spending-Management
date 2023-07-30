package com.example.quanlichitieu.service;

import com.example.quanlichitieu.dto.request.TransactionRequest;
import com.example.quanlichitieu.dto.response.transaction.TransactionResponse;
import com.example.quanlichitieu.entity.Transaction;

public interface TransactionService {
  TransactionResponse create(TransactionRequest request);
}
