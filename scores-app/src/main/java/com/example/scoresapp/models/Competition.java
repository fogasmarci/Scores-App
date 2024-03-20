package com.example.scoresapp.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "competitions")
public class Competition {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "competition_id")
  private Long id;
  private String name;
  @OneToMany (mappedBy = "competition", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
  private List<Game> gamesToPlay;
  @OneToMany (mappedBy = "competition", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
  private List<Game> playedGames;
  @ManyToMany(mappedBy = "competitions")
  private Set<Team> teams;

  public Competition() {
    gamesToPlay = new ArrayList<>();
    playedGames = new ArrayList<>();
  }

  public Competition(Set<Team> teams, String name) {
    this.teams = teams;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Set<Team> getTeams() {
    return teams;
  }

  public void setTeams(Set<Team> teams) {
    this.teams = teams;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Game> getGamesToPlay() {
    return gamesToPlay;
  }

  public void addGameToPlay(Game game) {
    gamesToPlay.add(game);
  }

  public List<Game> getPlayedGames() {
    return playedGames;
  }

  public void addToPlayedGames(Game game) {
    gamesToPlay.remove(game);
    playedGames.add(game);
  }
}
