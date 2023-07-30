package com.example.quanlichitieu.facade;

import com.example.quanlichitieu.dto.request.TransactionRequest;
import com.example.quanlichitieu.dto.response.transaction.TransactionResponse;

public interface TransactionFacadeService {
  TransactionResponse createTransaction(TransactionRequest request);

  TransactionResponse updateTransaction(TransactionRequest request, int id);
}
