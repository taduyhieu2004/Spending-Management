package com.example.quanlichitieu.facade;

import com.example.quanlichitieu.dto.request.TagFinanceRequest;
import com.example.quanlichitieu.dto.response.tagfinance.TagFinancePageResponse;
import com.example.quanlichitieu.dto.response.tagfinance.TagFinanceResponse;
import com.example.quanlichitieu.entity.TagFinance;

public interface TagFinanceFacadeService {
  TagFinanceResponse createTagFinance(TagFinanceRequest request);

  TagFinanceResponse updateTagFinance(TagFinanceRequest request, int id);

  TagFinancePageResponse listTagFiances(String keyword, int size, int page, boolean isAll);
}
