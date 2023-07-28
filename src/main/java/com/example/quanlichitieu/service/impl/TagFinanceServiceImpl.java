package com.example.quanlichitieu.service.impl;

import com.example.quanlichitieu.dto.reponse.TagFinanceResponse;
import com.example.quanlichitieu.dto.request.TagFinanceRequest;
import com.example.quanlichitieu.repository.TagFinanceRepository;
import com.example.quanlichitieu.service.TagFinanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class TagFinanceServiceImpl implements TagFinanceService {
  private final TagFinanceRepository repository;

  @Override
  public TagFinanceResponse create(TagFinanceRequest request) {
    return null;
  }

  @Override
  public TagFinanceResponse update(TagFinanceRequest request, int id) {
    return null;
  }
}
