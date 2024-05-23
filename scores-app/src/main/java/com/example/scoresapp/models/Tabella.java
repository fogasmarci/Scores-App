package com.example.scoresapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table (name = "tables")
public class Tabella {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


}
