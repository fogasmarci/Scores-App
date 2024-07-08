package com.example.scoresapp.services;

import com.example.scoresapp.dtos.GameDTO;
import com.example.scoresapp.dtos.ScoreDTO;
import com.example.scoresapp.models.Game;
import com.example.scoresapp.models.Team;
import com.example.scoresapp.repositories.GameRepository;
import com.example.scoresapp.repositories.TeamRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ApiService {
    private static final String API_URL = "https://api-football-v1.p.rapidapi.com/v3";
    private static final String API_KEY = "01ced68fabmsh3ce6ddc08f07f04p1ab1f4jsna1ace7390998";
    private final HttpClient httpClient;
    private final GameService gameService;
    private final GameRepository gameRepository;
    private final TeamRepository teamRepository;

    public ApiService(GameService gameService, GameRepository gameRepository, TeamRepository teamRepository) {
        this.httpClient = HttpClient.newHttpClient();
        this.gameService = gameService;
        this.gameRepository = gameRepository;
        this.teamRepository = teamRepository;
    }

    public void getTeamIdFromTeamName() throws IOException, InterruptedException {
        List<Team> teams = teamRepository.findAll();
        for (Team team : teams) {
            String teamName = URLEncoder.encode(team.getName(), StandardCharsets.UTF_8);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL + "/teams" + "?name=" + teamName))
                    .header("X-RapidAPI-Key", API_KEY)
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Failed to get competitions: " + response.body());
            }

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(response.body());
            JsonNode teamFromApi = root.path("response").get(0).path("team");
            Long id = teamFromApi.path("id").asLong();
            team.setApiId(id);
            teamRepository.save(team);
        }
    }

    public GameDTO getGameResult(String teamIDs, String date) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + "/fixtures/headtohead" + "?h2h=" + teamIDs + "&date=" + date))
                .header("X-RapidAPI-Key", API_KEY)
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Failed to get competitions: " + response.body());
        }

        return mapJsonToDTO(response.body());
    }

    private GameDTO mapJsonToDTO (String jsonResponse) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(jsonResponse);
        JsonNode fixture = root.path("response").get(0).path("fixture");
        JsonNode teams = root.path("response").get(0).path("teams");
        JsonNode goals = root.path("response").get(0).path("goals");

        String startTime = fixture.path("date").asText();
        String homeTeam = teams.path("home").path("name").asText();
        String awayTeam = teams.path("away").path("name").asText();
        int homeScore = goals.path("home").asInt();
        int awayScore = goals.path("away").asInt();

        //Itt azért vannak bajok
        Game gameCheck = gameRepository.findById(2L).orElseThrow();
        LocalDateTime localDateTime = gameCheck.getStartTime().minusHours(2);
        Game game = gameRepository.findByStartTimeAndTeamNames(localDateTime.toString(), gameCheck.getHomeTeamName(), gameCheck.getAwayTeamName())
                .orElseThrow(() -> new NoSuchElementException("Game with start time " + startTime + ", home team " + homeTeam + ", away team " + awayTeam + " not found."));

        gameService.playGame(game, new ScoreDTO(homeTeam, homeScore, awayTeam, awayScore));

        return new GameDTO(game);
    }
}

