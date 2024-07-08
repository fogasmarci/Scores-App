package com.example.scoresapp.services;

import com.example.scoresapp.dtos.ScoreDTO;
import com.example.scoresapp.dtos.TableDataDTO;
import com.example.scoresapp.models.TeamStats;
import com.example.scoresapp.repositories.TeamStatsRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FootballTeamStatsService implements TeamStatsService {
    private TeamStatsRepository teamStatsRepository;

    public FootballTeamStatsService(TeamStatsRepository teamStatsRepository) {
        this.teamStatsRepository = teamStatsRepository;
    }

    @Override
    public void updateTable(ScoreDTO scoreDTO, List<TeamStats> table) {
        Optional<TeamStats> homeTeam = table.stream()
                .filter(team -> team.getTeam().equals(scoreDTO.homeTeamName()))
                .findFirst();

        Optional<TeamStats> awayTeam = table.stream()
                .filter(team -> team.getTeam().equals(scoreDTO.awayTeamName()))
                .findFirst();

        if (homeTeam.isEmpty() || awayTeam.isEmpty()) {
            throw new NoSuchElementException("Team not found");
        }

        if (scoreDTO.homeTeamScore().equals(scoreDTO.awayTeamScore())) {
            homeTeam.get().drewGame(scoreDTO);
            awayTeam.get().drewGame(scoreDTO);
        }

        if (scoreDTO.homeTeamScore() > scoreDTO.awayTeamScore()) {
            homeTeam.get().wonGame(scoreDTO);
            awayTeam.get().lostGame(scoreDTO);
        }

        if (scoreDTO.homeTeamScore() < scoreDTO.awayTeamScore()) {
            homeTeam.get().lostGame(scoreDTO);
            awayTeam.get().wonGame(scoreDTO);
        }

        setTableRank(table);
    }

    @Override
    public TableDataDTO showTableData(String competitionName) {

        return null;
    }

    private void setTableRank(List<TeamStats> table){
        table.sort(Comparator.comparing(TeamStats::getPoints)
                .thenComparing(TeamStats::getGoalDifference, Comparator.reverseOrder())
                .reversed());

        int rank = 1;
        for (TeamStats team : table) {
            team.setTeamRank(rank);
            teamStatsRepository.save(team);
            rank++;
        }
    }
}
