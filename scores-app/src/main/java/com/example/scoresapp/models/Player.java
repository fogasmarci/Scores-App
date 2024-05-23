package com.example.scoresapp.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.time.Duration;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "players")
public class Player {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  @Column(name = "player_id")
  private Long id;
  private String name;
  private boolean suspended;
  @Column(name = "yellow_cards")
  private int yellowCards;
  private String nationality;
  @ManyToOne
  private Team team;

}
