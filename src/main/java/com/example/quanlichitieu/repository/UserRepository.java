package com.example.quanlichitieu.repository;

import com.example.quanlichitieu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
