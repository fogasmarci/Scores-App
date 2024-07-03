package com.example.scoresapp.repositories;

import com.example.scoresapp.models.Game;
import com.example.scoresapp.models.GameStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

  @Override
  List<Game> findAll();

  @Override
  Optional<Game> findById(Long id);

  //nem is kell
  /*@Query(value = "SELECT * FROM games WHERE competition_id = :id AND away_team_id = :2", nativeQuery = true)
  Optional<Game> findByCompetitionIdAndGameStatus(Long id, GameStatus played);*/

  @Query(value = "SELECT * FROM games WHERE start_time = :startTime AND home_team = :homeTeam AND away_team = :awayTeam", nativeQuery = true)
  Optional<Game> findByStartTimeAndTeamNames(String startTime, String homeTeam, String awayTeam);
}
