package com.example.quanlichitieu.service;

import com.example.quanlichitieu.dto.request.TransactionRequest;
import com.example.quanlichitieu.dto.request.user.ChangePasswordRequest;
import com.example.quanlichitieu.dto.response.tagfinance.TagFinancePageResponse;
import com.example.quanlichitieu.dto.response.transaction.TransactionPageResponse;
import com.example.quanlichitieu.dto.response.transaction.TransactionResponse;
import com.example.quanlichitieu.entity.Transaction;

public interface TransactionService {
  TransactionResponse create(TransactionRequest request);

  TransactionResponse update(TransactionRequest request, int id);

  void delete(int id);

  TransactionResponse details(int id);

  TransactionPageResponse list(String keyword, int size, int page, boolean isAll);


}
