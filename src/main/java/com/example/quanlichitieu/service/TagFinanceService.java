package com.example.quanlichitieu.service;

import com.example.quanlichitieu.dto.response.tagfinance.TagFinancePageResponse;
import com.example.quanlichitieu.dto.response.tagfinance.TagFinanceResponse;
import com.example.quanlichitieu.dto.request.TagFinanceRequest;


public interface TagFinanceService {
  TagFinanceResponse create(TagFinanceRequest request);

  TagFinanceResponse update(TagFinanceRequest request, int id);

  void delete(int id);

  TagFinanceResponse details(int id);
  TagFinancePageResponse list(String keyword, int size, int page, boolean isAll);
}
