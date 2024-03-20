package com.example.scoresapp.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "games")
public class Game {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String score;
  @Column(name = "game_status")
  private GameStatus gameStatus;
  @Column(name = "start_time")
  private LocalDateTime startTime;
  @ManyToOne
  @JoinColumn (name = "competition_id")
  private Competition competition;
  @ManyToOne
  @Column(name = "home_team")
  private Team homeTeam;
  private int homeTeamScore;
  @ManyToOne
  @Column(name = "away_team")
  private Team awayTeam;
  private int awayTeamScore;
  private int round;

  public Game() {
    gameStatus = GameStatus.Not_started;
  }

  public Game (Competition competition, Team homeTeam, Team awayTeam, LocalDateTime startTime) {
    this();
    this.competition = competition;
    this.homeTeam = homeTeam;
    this.awayTeam = awayTeam;
    this.startTime = startTime;
  }

  public void setGameStatusToFinished(){
    this.gameStatus = GameStatus.Finished;
  }

  public GameStatus getGameStatus() {
    return gameStatus;
  }

  public void setGameStatus(GameStatus gameStatus) {
    this.gameStatus = gameStatus;
  }

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }

  public Competition getCompetition() {
    return competition;
  }

  public String getScore() {
    return score;
  }

  public void setScore(String score) {
    this.score = score;
  }

  public void setCompetition(Competition competition) {
    this.competition = competition;
  }

  public Team getHomeTeam() {
    return homeTeam;
  }

  public void setHomeTeam(Team homeTeam) {
    this.homeTeam = homeTeam;
  }

  public int getHomeTeamScore() {
    return homeTeamScore;
  }

  public void setHomeTeamScore(int homeTeamScore) {
    this.homeTeamScore = homeTeamScore;
  }

  public Team getAwayTeam() {
    return awayTeam;
  }

  public void setAwayTeam(Team awayTeam) {
    this.awayTeam = awayTeam;
  }

  public int getAwayTeamScore() {
    return awayTeamScore;
  }

  public void setAwayTeamScore(int awayTeamScore) {
    this.awayTeamScore = awayTeamScore;
  }

  public int getRound() {
    return round;
  }

  public void setRound(int round) {
    this.round = round;
  }

  public Long getId() {
    return id;
  }
}
