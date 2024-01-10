package com.example.quanlichitieu.entity;

import com.example.quanlichitieu.entity.base.BaseEntityWithUpdater;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tag_finances")
@AllArgsConstructor
@NoArgsConstructor
public class TagFinance extends BaseEntityWithUpdater {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;
  private String name;
  private String description;

  public TagFinance(String name, String description) {
    this.name = name;
    this.description = description;

  }

}
