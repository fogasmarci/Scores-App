package com.example.scoresapp.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;

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
  @OneToMany (mappedBy = "competition", cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
  private List<Game> games;
  @ManyToMany(mappedBy = "competitions")
  private Set<Team> teams;

  public Competition() {
    games = new ArrayList<>();
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

  public List<Game> getGames() {
    return games;
  }

  public void addGame(Game game) {
    games.add(game);
  }
}
