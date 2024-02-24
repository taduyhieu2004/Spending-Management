package com.example.quanlichitieu.service;

import com.example.quanlichitieu.configuration.Configuration;
import com.example.quanlichitieu.dto.request.TagFinanceRequest;
import com.example.quanlichitieu.dto.response.tagfinance.TagFinanceResponse;
import com.example.quanlichitieu.entity.TagFinance;
import com.example.quanlichitieu.exception.tagfinance.TagFinanceAlreadyExistException;

import com.example.quanlichitieu.exception.tagfinance.TagFinanceNotFoundException;
import com.example.quanlichitieu.repository.TagFinanceRepository;
import com.example.quanlichitieu.repository.TagFinanceRepositoryTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

@WebMvcTest(TagFinanceService.class)
@ContextConfiguration(classes = Configuration.class)
public class TagFinanceServiceTest {
  @MockBean
  private TagFinanceRepository repository;

  @Autowired
  private TagFinanceService tagFinanceService;

  private TagFinanceRequest mockTagFinanceRequest(){
    return new TagFinanceRequest(
          "test",
          "string",
          1
    );
  }

  private TagFinance mockTagFinance(){
    return new TagFinance(
          1,
          "test",
          "string"
    );
  }
  private static int MOCK_ID = 100;

  @Test
  public void testCreate_WhenNameTagFinanceAlreadyExists_ThrowException(){
    TagFinanceRequest mockRequest = mockTagFinanceRequest();

    Mockito.when(repository.existsByName(mockRequest.getName())).thenReturn(true);

    Assertions.assertThrows(TagFinanceAlreadyExistException.class,()-> tagFinanceService.create(mockRequest));
  }

  @Test
  public void testCreate_WhenSuccess_ReturnsTagFinanceResponse(){
    TagFinanceRequest mockRequest = mockTagFinanceRequest();
    TagFinance mockEntity = mockTagFinance();

    Mockito.when(repository.existsByName(mockRequest.getName())).thenReturn(false);
    Mockito.when(repository.save(mockEntity)).thenReturn(mockEntity);

    TagFinanceResponse response = tagFinanceService.create(mockRequest);

    Assertions.assertEquals(mockEntity.getName(),response.getName());
    Assertions.assertEquals(mockEntity.getDescription(),response.getDescription());
  }

  @Test
  public void testUpdate_WhenIdNotFound_ThrowException(){
    TagFinanceRequest mockRequest = mockTagFinanceRequest();


    Mockito.when(repository.findById(MOCK_ID)).thenThrow(new TagFinanceNotFoundException());

    Assertions.assertThrows(TagFinanceNotFoundException.class,()-> tagFinanceService.update(mockRequest, MOCK_ID));

  }
}
