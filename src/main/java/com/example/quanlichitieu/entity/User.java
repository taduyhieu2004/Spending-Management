package com.example.quanlichitieu.entity;

import com.example.quanlichitieu.entity.base.BaseEntityWithUpdater;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntityWithUpdater {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String username;
  private String password;
  private String fullName;
  private String email;
  private boolean isActive;

  public User(String username, String password, String fullName, String email, boolean isActive) {
    this.username = username;
    this.password = password;
    this.fullName = fullName;
    this.email = email;
    this.isActive = isActive;
  }
}
