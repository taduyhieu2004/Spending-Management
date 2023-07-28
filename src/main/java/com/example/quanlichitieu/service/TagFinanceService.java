package com.example.quanlichitieu.service;

import com.example.quanlichitieu.dto.reponse.TagFinanceResponse;
import com.example.quanlichitieu.dto.request.TagFinanceRequest;
import com.example.quanlichitieu.entity.TagFinance;

public interface TagFinanceService {
  TagFinanceResponse create(TagFinanceRequest request);
  TagFinanceResponse update(TagFinanceRequest request, int id);
}
