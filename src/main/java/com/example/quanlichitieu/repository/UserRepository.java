package com.example.quanlichitieu.repository;

import com.example.quanlichitieu.entity.TagFinance;
import com.example.quanlichitieu.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  boolean existsByUsername(String username);

  boolean existsByEmail(String email);

  @Query("SELECT u FROM User u WHERE (:keyword is null or lower(u.fullName)   LIKE lower(concat('%', :keyword, '%')))"

  )
  List<User> search(@Param("keyword") String keyword, Pageable pageable);

  @Query("select count(u) from User u where (: keyword is null or" +
        " lower(u.fullName) like %:keyword% )"

  )
  int countSearch(String keyword);

  @Modifying
  @Query(value = "UPDATE User SET isActive = true WHERE id = :id")
  void active(int id);

  @Query("SELECT u FROM User u WHERE u.username = :username")
  User getByUsername(String username);


}
