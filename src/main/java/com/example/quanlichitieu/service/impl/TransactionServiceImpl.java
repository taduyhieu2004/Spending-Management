package com.example.quanlichitieu.service.impl;

import com.example.quanlichitieu.dto.request.TransactionRequest;
import com.example.quanlichitieu.dto.response.transaction.TransactionResponse;
import com.example.quanlichitieu.entity.Transaction;
import com.example.quanlichitieu.repository.TransactionRepository;
import com.example.quanlichitieu.service.TransactionService;
import com.example.quanlichitieu.ultils.MapperUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
  private final TransactionRepository repository;

  @Override
  public TransactionResponse create(TransactionRequest request) {
    log.info("(create) request: {}", request);

    Transaction transaction = MapperUtils.toEntity(request, Transaction.class);

    return MapperUtils.toDTO(repository.save(transaction), TransactionResponse.class);
  }
}
