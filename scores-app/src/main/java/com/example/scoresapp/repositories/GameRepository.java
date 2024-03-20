package com.example.scoresapp.repositories;

import com.example.scoresapp.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

  @Override
  List<Game> findAll();

  @Override
  Optional<Game> findById(Long id);
}
