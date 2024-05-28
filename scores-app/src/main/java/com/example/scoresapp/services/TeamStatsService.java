package com.example.scoresapp.services;

import com.example.scoresapp.dtos.ScoreDTO;
import com.example.scoresapp.models.TeamStats;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeamStatsService {
    public void updateTable(ScoreDTO scoreDTO, List<TeamStats> table);
}
