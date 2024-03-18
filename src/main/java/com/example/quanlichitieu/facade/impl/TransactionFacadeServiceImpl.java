package com.example.quanlichitieu.facade.impl;

import com.example.quanlichitieu.dto.request.TransactionRequest;
import com.example.quanlichitieu.dto.response.tagfinance.TagFinanceResponse;
import com.example.quanlichitieu.dto.response.transaction.TransactionResponse;
import com.example.quanlichitieu.dto.response.user.UserResponse;
import com.example.quanlichitieu.facade.TagFinanceFacadeService;
import com.example.quanlichitieu.facade.TransactionFacadeService;
import com.example.quanlichitieu.service.TagFinanceService;
import com.example.quanlichitieu.service.TransactionService;
import com.example.quanlichitieu.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequiredArgsConstructor
@Slf4j

public class TransactionFacadeServiceImpl implements TransactionFacadeService {
  private final TransactionService transactionService;
  private final TagFinanceService tagFinanceService;
  private final UserService userService;

  @Override
  public TransactionResponse createTransaction(TransactionRequest request) {
    log.info("(createTransaction) request: {}", request);

    TransactionResponse response = transactionService.create(request);
    TagFinanceResponse tagFinanceResponse = tagFinanceService.details(request.getTagId());
    UserResponse userResponse = userService.details(request.getCreatedBy());
    response.setTagFinance(tagFinanceResponse);
    response.setCreatedBy(userResponse);

    return response;
  }

  @Override
  public TransactionResponse updateTransaction(TransactionRequest request, int id) {
    log.info("(updateTransaction) id: {}, request: {}", id, request);

    TransactionResponse response = transactionService.update(request, id);
    TagFinanceResponse tagFinanceResponse = tagFinanceService.details(request.getTagId());
    UserResponse userResponse = userService.details(request.getCreatedBy());
    response.setTagFinance(tagFinanceResponse);
    response.setCreatedBy(userResponse);

    return response;
  }
}
