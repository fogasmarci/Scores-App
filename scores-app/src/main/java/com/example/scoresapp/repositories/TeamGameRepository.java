package com.example.scoresapp.repositories;

import com.example.scoresapp.models.TeamGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamGameRepository extends JpaRepository<TeamGame, Long> {

  @Query(value = "SELECT * FROM team_game WHERE game_id = :gameId", nativeQuery = true) //not in use
  Optional<TeamGame> findByGameId(@Param("gameId") Long GameId);

  @Query(value = "SELECT * FROM team_game WHERE home_team_id = :teamId OR away_team_id = :teamId", nativeQuery = true)
  List<TeamGame> findByTeamId(@Param("teamId") Long teamId);
}
