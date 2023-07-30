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
@Table(name = "transactions")
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class Transaction extends BaseEntityWithUpdater {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private String title;
  private String description;
  private double amount;
  private int tagId;

  public static Transaction from(
        String name,
        String title,
        String description,
        double amount,
        int tagId
  ) {
    return Transaction.of(0, name, title, description, amount, tagId);
  }
}


