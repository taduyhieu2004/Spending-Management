package com.example.quanlichitieu.controller;

import com.example.quanlichitieu.dto.ResponseGeneral;
import com.example.quanlichitieu.dto.request.TransactionRequest;
import com.example.quanlichitieu.dto.response.transaction.TransactionPageResponse;
import com.example.quanlichitieu.dto.response.transaction.TransactionResponse;
import com.example.quanlichitieu.entity.Transaction;
import com.example.quanlichitieu.facade.TransactionFacadeService;
import com.example.quanlichitieu.service.MessageService;
import com.example.quanlichitieu.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.example.quanlichitieu.constant.Constant.CommonConstants.*;
import static com.example.quanlichitieu.constant.Constant.MessageException.CREATE_TRANSACTION_SUCCESS;
import static com.example.quanlichitieu.constant.Constant.MessageException.UPDATE_TRANSACTION_SUCCESS;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/transactions")
public class TransactionController {
  private final TransactionService transactionService;
  private final MessageService messageService;
  private final TransactionFacadeService transactionFacadeService;

  @PostMapping
  public ResponseGeneral<TransactionResponse> create(
        @RequestBody @Valid TransactionRequest request,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) {

    log.info("(create) request:{} ", request);

    return ResponseGeneral.ofCreated(
          messageService.getMessage(CREATE_TRANSACTION_SUCCESS, language),
          transactionFacadeService.createTransaction(request)
    );
  }

  @PutMapping("{id}")
  public ResponseGeneral<TransactionResponse> update(
        @PathVariable int id,
        @RequestBody @Valid TransactionRequest request,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) {

    log.info("(update) id: {}, request: {}", id, request);

    return ResponseGeneral.ofCreated(
          messageService.getMessage(UPDATE_TRANSACTION_SUCCESS, language),
          transactionFacadeService.updateTransaction(request, id)
    );
  }

  @DeleteMapping("{id}")
  public ResponseGeneral<Void> delete(
        @PathVariable int id,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) {

    log.info("(delete) id: {}", id);
    transactionService.delete(id);

    return ResponseGeneral.ofSuccess(
          messageService.getMessage(SUCCESS, language)

    );
  }

  @GetMapping("{id}")
  public ResponseGeneral<TransactionResponse> details(
        @PathVariable int id,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) {

    log.info("(details) id: {}", id);

    return ResponseGeneral.ofSuccess(
          messageService.getMessage(SUCCESS, language),
          transactionService.details(id)
    );
  }

  @GetMapping
  public ResponseGeneral<TransactionPageResponse> list(
        @RequestParam(name = "keyword", required = false) String keyword,
        @RequestParam(name = "size", defaultValue = "10") int size,
        @RequestParam(name = "page", defaultValue = "0") int page,
        @RequestParam(name = "all", defaultValue = "false", required = false) boolean isAll,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) {

    log.info("(list) keyword: {}, size: {}, page: {}, isAll: {}", keyword, size, page, isAll);
    return ResponseGeneral.ofSuccess(
          messageService.getMessage(SUCCESS, language),
          transactionService.list(keyword, size, page, isAll)
    );
  }

}
