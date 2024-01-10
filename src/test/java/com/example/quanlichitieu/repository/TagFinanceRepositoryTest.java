package com.example.quanlichitieu.repository;

import com.example.quanlichitieu.entity.TagFinance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class TagFinanceRepositoryTest {

  @Autowired
  TagFinanceRepository repository;

  @Autowired
  TestEntityManager entityManager;

  private TagFinance mockTagFinance(){
    return new TagFinance(
          "test",
          "string"
    );
  }

  @Test
  void testSaveMethod_WhenSaveTagFinance_ReturnTagFinance(){
    TagFinance tagFinanceEntity = mockTagFinance();

    entityManager.persistAndFlush(tagFinanceEntity);

    TagFinance tagFinance = repository.save(tagFinanceEntity);

    Assertions.assertEquals(tagFinanceEntity.getName(), tagFinance.getName());
    Assertions.assertEquals(tagFinanceEntity.getDescription(), tagFinance.getDescription());
  }


}
