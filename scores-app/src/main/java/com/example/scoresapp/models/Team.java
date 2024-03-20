package com.example.scoresapp.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @ManyToMany
  @JoinTable (
      name = "team_competition",
      joinColumns = @JoinColumn(name = "team_id"),
      inverseJoinColumns = @JoinColumn(name = "competition_id"))
  private Set<Competition> competitions;
  @OneToMany (cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
  @Column(name = "games_to_play")
  private List<Game> gamesToPlay;
  @OneToMany (cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
  @Column(name = "played_games")
  private List<Game> playedGames;
  @OneToMany (mappedBy = "team", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
  private Set<Player> players;
  private String stadium;

  public Team() {
  }

  public Set<Competition> getCompetitions() {
    return competitions;
  }

  public void setCompetitions(Set<Competition> competitions) {
    this.competitions = competitions;
  }

  public String getStadium() {
    return stadium;
  }

  public void setStadium(String stadium) {
    this.stadium = stadium;
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

  public Set<Player> getPlayers() {
    return players;
  }

  public void setPlayers(Set<Player> players) {
    this.players = players;
  }

  public Long getId() {
    return id;
  }
}
