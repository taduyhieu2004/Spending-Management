package com.example.quanlichitieu.service.impl;

import com.example.quanlichitieu.dto.request.user.UserRequest;
import com.example.quanlichitieu.dto.request.user.UserUpdateRequest;
import com.example.quanlichitieu.dto.response.tagfinance.TagFinanceResponse;
import com.example.quanlichitieu.dto.response.user.UserPageResponse;
import com.example.quanlichitieu.dto.response.user.UserResponse;
import com.example.quanlichitieu.entity.TagFinance;
import com.example.quanlichitieu.entity.User;
import com.example.quanlichitieu.exception.user.EmailAlreadyExistException;
import com.example.quanlichitieu.exception.user.UserAlreadyExistException;
import com.example.quanlichitieu.exception.user.UserNotFoundException;
import com.example.quanlichitieu.repository.UserRepository;
import com.example.quanlichitieu.service.UserService;
import com.example.quanlichitieu.ultils.MapperUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static com.example.quanlichitieu.ultils.MapperUtils.MODEL_MAPPER;

@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
  private final UserRepository repository;

  @Override
  public UserResponse create(UserRequest request) {
    log.info("(create) request: {}", request);

    checkExistedPreCreate(
          request.getUsername(),
          request.getEmail()
    );
    User user = MapperUtils.toEntity(request, User.class);

    return MapperUtils.toDTO(repository.save(user), UserResponse.class);
  }

  @Override
  public UserResponse update(UserUpdateRequest request, int id) {
    log.info("(update) request: {}", request);

    User user = find(id);
    checkExistedPreUpdate(user, request.getEmail());
    MODEL_MAPPER.map(request, user);

    return MapperUtils.toDTO(repository.save(user), UserResponse.class);
  }

  @Override
  public void delete(int id) {
    log.info("(delete) id: {}", id);

    repository.delete(find(id));
  }


  @Override
  public UserResponse details(int id) {
    log.info("(details) id:{}", id);

    User user = find(id);

    return MapperUtils.toDTO(user, UserResponse.class);
  }

  @Override
  public UserPageResponse list(String keyword, int size, int page, boolean isAll) {
    log.info("(list) keyword: {}, size : {}, page: {}, isAll: {}", keyword, size, page, isAll);

    Pageable pageable = PageRequest.of(page, size);
    List<User> users = isAll ?
          repository.findAll() : repository.search(keyword, pageable);
    List<UserResponse> userResponses = MapperUtils.toDTOs(users, UserResponse.class);

    return UserPageResponse.of(userResponses, isAll ? users.size() : repository.countSearch(keyword));


  }

  private User find(int id) {
    log.info("(find) id:{}", id);

    return repository.findById(id).orElseThrow(UserNotFoundException::new);
  }

  private void checkExistedPreCreate(String username, String email) {
    log.info("(checkExistedPreCreate)  username: {}, email: {}", email, username);
    checkExistedUsername(username);
    checkExistedEmail(email);

  }

  private void checkExistedPreUpdate(User user, String email) {
    log.info("(checkExistedPreUpdate)  email: {}", email);
    if (!user.getEmail().equals(email)) {
      checkExistedEmail(email);
    }
  }


  private void checkExistedEmail(String email) {
    log.info("(checkExistedEmail) email: {}", email);
    if (repository.existsByEmail(email)) {
      log.error("(checkExistedEmail) =============> EmailAlreadyExistException");
      throw new EmailAlreadyExistException();
    }
  }

  private void checkExistedUsername(String username) {
    log.info("(checkExistedUsername) username: {}", username);
    if (repository.existsByUsername(username)) {
      log.error("(checkExistedUsername) =============> UsernameAlreadyExistException");
      throw new UserAlreadyExistException();
    }
  }

}
