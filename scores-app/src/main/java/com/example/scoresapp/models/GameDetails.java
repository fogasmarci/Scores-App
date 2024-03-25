package com.example.scoresapp.models;

import jakarta.persistence.*;


@Entity
@Table(name = "game_details")
public class GameDetails extends Game {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @OneToOne
  private Game game;

  public GameDetails() {
  }

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }
}
