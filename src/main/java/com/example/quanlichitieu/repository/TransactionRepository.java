package com.example.quanlichitieu.repository;


import com.example.quanlichitieu.dto.response.transaction.TransactionResponse;

import com.example.quanlichitieu.entity.Transaction;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
  @Query("SELECT new com.example.quanlichitieu.dto.response.transaction.TransactionResponse" +
        "(tr.name, tr.title, tr.description, tr.amount," +
        " t.name, t.description," +
        " ut.id, ut.fullName, ut.email, " +
        " u.id, u.fullName, u.email) " +
        "FROM Transaction tr " +
        "JOIN TagFinance t ON tr.tagId = t.id " +
        "JOIN User ut ON t.createdBy = ut.id " +
        "JOIN User u ON tr.createdBy = u.id " +
        "WHERE tr.id = :id")
  TransactionResponse detail(int id);

  @Query("SELECT new com.example.quanlichitieu.dto.response.transaction.TransactionResponse" +
        "(tr.name, tr.title, tr.description, tr.amount," +
        " t.name, t.description," +
        " ut.id, ut.fullName, ut.email, " +
        " u.id, u.fullName, u.email) " +
        "FROM Transaction tr " +
        "JOIN TagFinance t ON tr.tagId = t.id " +
        "JOIN User ut ON t.createdBy = ut.id " +
        "JOIN User u ON tr.createdBy = u.id " +
        "WHERE (:keyword is null or lower(tr.name) LIKE lower(concat('%', :keyword, '%')))")
  List<TransactionResponse> search(@Param("keyword") String keyword, Pageable pageable);


  @Query("select count(tr) from Transaction tr where (: keyword is null or" +
        " lower(tr.name) like %:keyword% )"
  )
  int countSearch(String keyword);
}



