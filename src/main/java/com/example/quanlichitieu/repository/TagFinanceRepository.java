package com.example.quanlichitieu.repository;

import com.example.quanlichitieu.dto.response.tagfinance.TagFinanceResponse;
import com.example.quanlichitieu.entity.TagFinance;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TagFinanceRepository extends JpaRepository<TagFinance, Integer> {
  boolean existsByName(String name);
  boolean existsById(String id);

  @Query("SELECT new com.example.quanlichitieu.dto.response.tagfinance.TagFinanceResponse" +
        "( t.name, t.description, u.id, u.fullName, u.email) " +
        "FROM TagFinance t " +
        "JOIN User u ON t.createdBy = u.id " +
        "WHERE t.id = :id")
  TagFinanceResponse detail(int id);

  @Query("SELECT t FROM TagFinance t WHERE (:keyword is null or lower(t.name)   LIKE lower(concat('%', :keyword, '%')))"

  )
  List<TagFinance> search(@Param("keyword") String keyword, Pageable pageable);

  @Query("select count(t) from TagFinance t where (: keyword is null or" +
        " lower(t.name) like %:keyword% )"

  )
  int countSearch(String keyword);
}
