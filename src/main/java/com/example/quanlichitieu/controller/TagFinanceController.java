package com.example.quanlichitieu.controller;

import com.example.quanlichitieu.dto.ResponseGeneral;
import com.example.quanlichitieu.dto.response.tagfinance.TagFinancePageResponse;
import com.example.quanlichitieu.dto.response.tagfinance.TagFinanceResponse;
import com.example.quanlichitieu.dto.request.TagFinanceRequest;
import com.example.quanlichitieu.facade.TagFinanceFacadeService;
import com.example.quanlichitieu.service.MessageService;
import com.example.quanlichitieu.service.TagFinanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.example.quanlichitieu.constant.Constant.CommonConstants.*;
import static com.example.quanlichitieu.constant.Constant.MessageException.CREATE_TAG_FINANCE_SUCCESS;
import static com.example.quanlichitieu.constant.Constant.MessageException.UPDATE_TAG_FINANCE_SUCCESS;

@RestController
@RequestMapping("/api/v1/tag-finances")
@RequiredArgsConstructor
@Slf4j
public class TagFinanceController {
  private final TagFinanceService tagFinanceService;
  private final MessageService messageService;
  private final TagFinanceFacadeService tagFinanceFacadeService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseGeneral<TagFinanceResponse> create(
        @RequestBody @Validated TagFinanceRequest request,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) {

    log.info("(create) request: {}", request);

    return ResponseGeneral.ofCreated(
          messageService.getMessage(CREATE_TAG_FINANCE_SUCCESS, language),
          tagFinanceFacadeService.createTagFinance(request)
    );
  }

  @PutMapping("{id}")
  public ResponseGeneral<TagFinanceResponse> update(
        @PathVariable int id,
        @RequestBody @Validated TagFinanceRequest request,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) {

    log.info("(update) id: {}, request: {}", id, request);

    return ResponseGeneral.ofSuccess(
          messageService.getMessage(UPDATE_TAG_FINANCE_SUCCESS, language),
          tagFinanceFacadeService.updateTagFinance(request, id)
    );
  }

  @DeleteMapping("{id}")
  public ResponseGeneral<Void> delete(
        @PathVariable int id,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) {

    log.info("(delete) id :{}", id);
    tagFinanceService.delete(id);

    return ResponseGeneral.ofSuccess(
          messageService.getMessage(SUCCESS, language)
    );
  }

  @GetMapping("{id}")
  public ResponseGeneral<TagFinanceResponse> details(
        @PathVariable int id,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) {

    log.info("(details) id: " + id);

    return ResponseGeneral.ofSuccess(
          messageService.getMessage(SUCCESS, language),
          tagFinanceService.details(id)
    );
  }

  @GetMapping
  public ResponseGeneral<TagFinancePageResponse> list(
        @RequestParam(name = "keyword", required = false) String keyword,
        @RequestParam(name = "size", defaultValue = "10") int size,
        @RequestParam(name = "page", defaultValue = "0") int page,
        @RequestParam(name = "all", defaultValue = "false", required = false) boolean isAll,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) {

    log.info("(list) keyword: {}, size: {}, page: {}, isAll: {}", keyword, size, page, isAll);

    return ResponseGeneral.ofSuccess(
          messageService.getMessage(SUCCESS, language),
          tagFinanceFacadeService.listTagFiances(keyword, size, page, isAll)
    );

  }


}
