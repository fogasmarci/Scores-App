package com.example.scoresapp.models;

import com.example.scoresapp.dtos.ScoreDTO;
import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "games")
public class Game {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @Column(name = "home_team")
  private String homeTeamName;
  @Column(name = "home_team_score")
  private Integer homeTeamScore;
  @Column(name = "away_team")
  private String awayTeamName;
  @Column(name = "away_team_score")
  private Integer awayTeamScore;
  private int round;
  @Column(name = "game_status")
  private GameStatus gameStatus;
  @Column(name = "start_time")
  private LocalDateTime startTime;
  @ManyToOne
  @JoinColumn (name = "competition_id")
  private Competition competition;

  public Game() {
    gameStatus = GameStatus.Not_started;
  }

  public Game (String name, Competition competition, int round, LocalDateTime startTime, String homeTeamName, String awayTeamName) {
    this();
    this.homeTeamName = homeTeamName;
    this.awayTeamName = awayTeamName;
    this.name = name;
    this.competition = competition;
    this.round = round;
    this.startTime = startTime;
  }

  public void finishGame(ScoreDTO scoreDTO){
    this.gameStatus = GameStatus.Finished;
    this.homeTeamScore = scoreDTO.homeTeamScore();
    this.awayTeamScore = scoreDTO.awayTeamScore();
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

  public void setCompetition(Competition competition) {
    this.competition = competition;
    competition.addGame(this);
  }

  public Integer getHomeTeamScore() {
    return homeTeamScore;
  }

  public void setHomeTeamScore(int homeTeamScore) {
    this.homeTeamScore = homeTeamScore;
  }

  public Integer getAwayTeamScore() {
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getHomeTeamName() {
    return homeTeamName;
  }

  public void setHomeTeamName(String homeTeam) {
    this.homeTeamName = homeTeam;
  }

  public void setHomeTeamScore(Integer homeTeamScore) {
    this.homeTeamScore = homeTeamScore;
  }

  public String getAwayTeamName() {
    return awayTeamName;
  }

  public void setAwayTeamName(String awayTeam) {
    this.awayTeamName = awayTeam;
  }

  public void setAwayTeamScore(Integer awayTeamScore) {
    this.awayTeamScore = awayTeamScore;
  }
}
