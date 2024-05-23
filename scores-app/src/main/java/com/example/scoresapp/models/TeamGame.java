package com.example.scoresapp.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "team_game")
public class TeamGame {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @OneToOne
  private Team homeTeam;
  @OneToOne
  private Team awayTeam;

  @OneToOne
  private Game game;

  public TeamGame() {
  }

  public TeamGame(Game game, Team homeTeam, Team awayTeam) {
    this.game = game;
    this.homeTeam = homeTeam;
    this.awayTeam = awayTeam;
  }

  public Long getId() {
    return id;
  }

  public Team getHomeTeam() {
    return homeTeam;
  }

  public void setHomeTeam(Team homeTeam) {
    this.homeTeam = homeTeam;
  }

  public Team getAwayTeam() {
    return awayTeam;
  }

  public void setAwayTeam(Team awayTeam) {
    this.awayTeam = awayTeam;
  }

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }
}
