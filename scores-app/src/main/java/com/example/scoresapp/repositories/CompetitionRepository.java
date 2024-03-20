package com.example.scoresapp.repositories;

import com.example.scoresapp.models.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long> {

  @Override
  List<Competition> findAll();

  Optional<Competition> findByName(String name);
}
