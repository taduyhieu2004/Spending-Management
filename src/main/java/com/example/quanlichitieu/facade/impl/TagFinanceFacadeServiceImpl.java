package com.example.quanlichitieu.facade.impl;

import com.example.quanlichitieu.dto.request.TagFinanceRequest;
import com.example.quanlichitieu.dto.response.tagfinance.TagFinancePageResponse;
import com.example.quanlichitieu.dto.response.tagfinance.TagFinanceResponse;
import com.example.quanlichitieu.dto.response.user.UserResponse;
import com.example.quanlichitieu.facade.TagFinanceFacadeService;
import com.example.quanlichitieu.service.TagFinanceService;
import com.example.quanlichitieu.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class TagFinanceFacadeServiceImpl implements TagFinanceFacadeService {
  private final TagFinanceService tagFinanceService;
  private final UserService userService;

  @Override
  public TagFinanceResponse createTagFinance(TagFinanceRequest request) {
    log.info("(createTagFinance) request: {}", request);

    TagFinanceResponse tagFinanceResponse = tagFinanceService.create(request);
    UserResponse userResponse = userService.details(request.getCreatedBy());
    tagFinanceResponse.setCreatedBy(userResponse);

    return tagFinanceResponse;
  }

  @Override
  public TagFinanceResponse updateTagFinance(TagFinanceRequest request, int id) {
    log.info("(updateTagFinance) id: {}, request: {}", id, request);

    TagFinanceResponse tagFinanceResponse = tagFinanceService.update(request, id);
    UserResponse userResponse = userService.details(request.getCreatedBy());
    tagFinanceResponse.setCreatedBy(userResponse);

    return tagFinanceResponse;
  }

  @Override
  public TagFinancePageResponse listTagFiances(String keyword, int size, int page, boolean isAll) {
    log.info("(list) keyword: {}, size: {}, page: {}, isAll: {}", keyword, size, page, isAll);

    TagFinancePageResponse response = tagFinanceService.list(keyword, size, page, isAll);
    UserResponse userResponse;
    for (TagFinanceResponse tagFinanceResponse : response.getTagFinanceResponses()) {
      userResponse = userService.details(tagFinanceResponse.getCreatedBy().getId());
      tagFinanceResponse.setCreatedBy(userResponse);
    }
    return response;
  }
}
