package com.example.quanlichitieu.service.impl;

import com.example.quanlichitieu.dto.request.TagFinanceRequest;
import com.example.quanlichitieu.dto.response.tagfinance.TagFinancePageResponse;
import com.example.quanlichitieu.dto.response.tagfinance.TagFinanceResponse;
import com.example.quanlichitieu.entity.TagFinance;
import com.example.quanlichitieu.exception.tagfinance.TagFinanceAlreadyExistException;
import com.example.quanlichitieu.exception.tagfinance.TagFinanceNotFoundException;
import com.example.quanlichitieu.repository.TagFinanceRepository;
import com.example.quanlichitieu.service.TagFinanceService;
import com.example.quanlichitieu.ultils.MapperUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static com.example.quanlichitieu.ultils.MapperUtils.MODEL_MAPPER;

@Slf4j
@RequiredArgsConstructor
public class TagFinanceServiceImpl implements TagFinanceService {
  private final TagFinanceRepository repository;



  @Override
  @Transactional
  public TagFinanceResponse create(TagFinanceRequest request) {
    log.info("(create) request: {}", request);

    checkTagFinanceExists(request.getName());
    TagFinance tagFinance = MapperUtils.toEntity(request, TagFinance.class);

    return MapperUtils.toDTO(repository.save(tagFinance), TagFinanceResponse.class);
  }

  @Override
  @Transactional
  public TagFinanceResponse update(TagFinanceRequest request, int id) {
    log.info("(update) id: {}, request: {}", id, request);

    TagFinance tagFinance = find(id);
    checkTagFinanceExistsForUpdate(tagFinance, request);
    MODEL_MAPPER.map(request, tagFinance);

    return MapperUtils.toDTO(repository.save(tagFinance), TagFinanceResponse.class);
  }

  @Override
  @Transactional
  public void delete(int id) {
    log.info("(delete) id:{}", id);

    repository.delete(find(id));
  }

  @Override
  public TagFinanceResponse details(int id) {
    log.info("(details) id:{}", id);

    checkTagFinanceExistsById(id);

    return repository.detail(id);
  }

  @Override
  public TagFinancePageResponse list(String keyword, int size, int page, boolean isAll) {
    log.info("(list) keyword: {}, size : {}, page: {}, isAll: {}", keyword, size, page, isAll);

    Pageable pageable = PageRequest.of(page, size);
    List<TagFinance> tagFinances = isAll ?
          repository.findAll() : repository.search(keyword, pageable);
    List<TagFinanceResponse> tagFinanceResponses = new ArrayList<>();
    TagFinanceResponse response;
    for (TagFinance tagFinance : tagFinances) {
      response = new TagFinanceResponse(
            tagFinance.getName(),
            tagFinance.getDescription(),
            tagFinance.getCreatedBy()
      );
      tagFinanceResponses.add(response);

    }

    return TagFinancePageResponse.of(tagFinanceResponses, isAll ? tagFinances.size() : repository.countSearch(keyword));
  }

  private void checkTagFinanceExists(String name) {
    log.info("(checkTagFinanceExist) name : {}", name);

    if (repository.existsByName(name)) {

      log.error("(checkTagFinanceExists) =============> TagFinanceAlreadyExistException");
      throw new TagFinanceAlreadyExistException();

    }
  }

  private void checkTagFinanceExistsForUpdate(TagFinance tagFinance, TagFinanceRequest request) {
    if (!tagFinance.getName().equals(request.getName())) {
      checkTagFinanceExists(request.getName());
    }
  }

  private TagFinance find(int id) {
    log.info("(find)id: {}", id);

    return repository.findById(id).orElseThrow(TagFinanceNotFoundException::new);

  }

  private void checkTagFinanceExistsById(int id) {
    log.info("(checkTagFinanceExists)id: {}", id);

    if (!repository.existsById(id)) {
      log.error("(checkTagFinanceExists) =============> TagFinanceNotFoundException");
      throw new TagFinanceNotFoundException();
    }

  }
}
