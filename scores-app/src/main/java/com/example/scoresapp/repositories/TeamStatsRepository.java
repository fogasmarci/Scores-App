package com.example.scoresapp.repositories;

import com.example.scoresapp.models.Team;
import com.example.scoresapp.models.TeamStats;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeamStatsRepository extends JpaRepository<TeamStats, Long> {
    @Override
    List<TeamStats> findAll();
}
