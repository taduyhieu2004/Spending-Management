package com.example.quanlichitieu.service.impl;

import com.example.quanlichitieu.dto.request.TransactionRequest;
import com.example.quanlichitieu.dto.response.transaction.TransactionPageResponse;
import com.example.quanlichitieu.dto.response.transaction.TransactionResponse;
import com.example.quanlichitieu.entity.Transaction;
import com.example.quanlichitieu.exception.transaction.TransactionNotFoundException;
import com.example.quanlichitieu.repository.TransactionRepository;
import com.example.quanlichitieu.service.TransactionService;
import com.example.quanlichitieu.ultils.MapperUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
  private final TransactionRepository repository;

  @Override
  @Transactional
  public TransactionResponse create(TransactionRequest request) {
    log.info("(create) request: {}", request);

    Transaction transaction = MapperUtils.toEntity(request, Transaction.class);

    return MapperUtils.toDTO(repository.save(transaction), TransactionResponse.class);
  }

  @Override
  @Transactional
  public TransactionResponse update(TransactionRequest request, int id) {
    log.info("(update) id: {}, request: {}", id, request);

    Transaction transaction = find(id);
    updateTransactionFields(
          transaction,
          request.getName(),
          request.getTitle(),
          request.getDescription(),
          request.getAmount(),
          request.getTagId(),
          request.getCreatedBy()
    );

    return MapperUtils.toDTO(transaction, TransactionResponse.class);
  }

  @Override
  @Transactional
  public void delete(int id) {
    log.info("(delete) id:{}", id);

    repository.delete(find(id));
  }

  @Override
  public TransactionResponse details(int id) {
    log.info("(details) id:{}", id);

    checkTagFinanceExistsById(id);

    return repository.detail(id);
  }

  @Override
  public TransactionPageResponse list(String keyword, int size, int page, boolean isAll) {
    log.info("(list) keyword: {}, size : {}, page: {}, isAll: {}", keyword, size, page, isAll);

    Pageable pageable = PageRequest.of(page, size);
    List<TransactionResponse> transactionResponses = repository.search(keyword, pageable);
    int countSearch = repository.countSearch(keyword);

    return TransactionPageResponse.of(transactionResponses, countSearch);

  }


  private Transaction find(int id) {
    log.info("(find) id: {}", id);

    return repository.findById(id).orElseThrow(TransactionNotFoundException::new);
  }

  private static void updateTransactionFields(
        Transaction transaction,
        String name,
        String title,
        String description,
        double amount,
        int tagId,
        int createdBy
  ) {

    log.info("(updateTransactionFields)start");
    transaction.setName(name);
    transaction.setTitle(title);
    transaction.setDescription(description);
    transaction.setAmount(amount);
    transaction.setTagId(tagId);
    transaction.setCreatedBy(createdBy);
  }

  private void checkTagFinanceExistsById(int id) {
    log.info("(checkTransactionExists)id: {}", id);

    if (!repository.existsById(id)) {
      log.error("(checkTransactionExists) =============> TransactionNotFoundException");
      throw new TransactionNotFoundException();
    }

  }
}
