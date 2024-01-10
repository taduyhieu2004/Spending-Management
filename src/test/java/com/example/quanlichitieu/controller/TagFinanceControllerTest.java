package com.example.quanlichitieu.controller;

import com.example.quanlichitieu.configuration.Configuration;
import com.example.quanlichitieu.dto.request.TagFinanceRequest;
import com.example.quanlichitieu.dto.response.tagfinance.TagFinanceResponse;
import com.example.quanlichitieu.dto.response.user.UserResponse;
import com.example.quanlichitieu.exception.tagfinance.TagFinanceAlreadyExistException;
import com.example.quanlichitieu.facade.TagFinanceFacadeService;
import com.example.quanlichitieu.service.MessageService;
import com.example.quanlichitieu.service.TagFinanceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TagFinanceController.class)
@ContextConfiguration(classes = Configuration.class)
public class TagFinanceControllerTest {

  @Autowired
  TagFinanceController tagFinanceController;

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @MockBean
  TagFinanceService tagFinanceService;
  @MockBean
  TagFinanceFacadeService tagFinanceFacadeService;

  @MockBean
  MessageService messageService;

  private static final String END_POINT_PATH ="/api/v1/tag-finances";

  private TagFinanceRequest mockTagFinanceRequest(){
    return new TagFinanceRequest(
          "test",
          "string",
          1
    );
  }


  private UserResponse mockUserResponse(){
    return new UserResponse(
          1,
          "Nguyen Van A",
          "haha@gmail.com"
    );
  }
  private TagFinanceResponse mockTagFinanceResponse(){
    return new TagFinanceResponse(
          "test",
          "string",
          mockUserResponse()
    );
  }

  @Test
  void testValid_WhenNameTagFinanceInvalid_Return400AndException() throws Exception{
    TagFinanceRequest mockRequest = mockTagFinanceRequest();
    mockRequest.setName("");

    mockMvc.perform(
          post(END_POINT_PATH)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(mockRequest)))
          .andExpect(status().isBadRequest())
          .andExpect(jsonPath("$.data.code").value("name not blank"))
          .andDo(print());

  }

  @Test
  void testCreate_WhenNameTagFinanceAlreadyExists_ReturnException() throws Exception {
    TagFinanceRequest mockRequest = mockTagFinanceRequest();

    Mockito.when(tagFinanceFacadeService.createTagFinance(mockRequest)).thenThrow(new TagFinanceAlreadyExistException());

    mockMvc.perform(
          post(END_POINT_PATH)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(mockRequest)))
          .andExpect(status().isConflict())
          .andExpect(jsonPath("$.data.code")
                .value("com.example.quanlichitieu.exception.TagFinanceAlreadyExistException"))
          .andDo(print());


  }

  @Test
  void testCreate_WhenSuccess_Return201AndResponseBody()throws Exception {
    TagFinanceRequest mockRequest = mockTagFinanceRequest();

    Mockito.when(tagFinanceFacadeService.createTagFinance(mockRequest)).thenReturn(mockTagFinanceResponse());

    MvcResult result = mockMvc.perform(
          post(END_POINT_PATH)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(mockRequest)))
          .andExpect(status().isCreated())
          .andReturn();

    String response = result.getResponse().getContentAsString();

    Assertions.assertEquals(
          response,
          objectMapper.writeValueAsString(tagFinanceController.create(mockRequest,"en")));
  }


}
