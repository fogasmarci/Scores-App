INSERT INTO competitions (name)
VALUES ('La Liga'),
       ('Premier League'),
       ('Champions League');

INSERT INTO team_stats (team_rank, team_name, games_played, wins, draws, losses, goal_difference, points, competition_id)
VALUES (1, 'Barcelona', 1, 1, 0, 0, 5, 3, 1),
       (2, 'Real Madrid', 1, 0, 0, 1, -5, 0, 1),
       (3, 'Valencia', 0, 0, 0, 0, 0, 0, 1);

INSERT INTO teams (name, stadium)
VALUES ('Barcelona', 'Nou Camp'),
       ('Real Madrid', 'Bernabeu'),
       ('Valencia', 'Mestalla'),
       ('Liverpool', 'Anfield');

INSERT INTO team_competition (team_id, competition_id)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (4, 2),
       (4, 3),
       (1, 3);

INSERT INTO games (name, home_team, home_team_score, away_team, away_team_score, round, game_status, start_time, competition_id)
VALUES ('Barcelona vs Real Madrid', 'Barcelona', 5, 'Real Madrid', 1, 1, 2, '2024-01-01', 1),
       ('Barcelona vs Valencia', 'Barcelona',  NULL, 'Valencia', NULL, 2, 0, '2024-05-05', 1),
       ('Real Madrid vs Valencia', 'Real Madrid', NULL, 'Valencia', NULL, 3, 0, '2024-05-05', 1),
       ('Barcelona vs Liverpool', 'Barcelona', NULL, 'Liverpool', NULL, 1, 0, '2024-05-05', 3);

DROP TABLE team_game;

CREATE TABLE team_game (home_team_id bigint, away_team_id bigint, game_id bigint, id bigint not null auto_increment, primary key (id));

INSERT INTO team_game (home_team_id, away_team_id, game_id)
VALUES (1, 2, 1),
       (1, 3, 2),
       (2, 3, 3),
       (1, 4, 4);

INSERT INTO players (name, suspended, yellow_cards, nationality, team_id)
VALUES ('Szoboszlai Dominik', FALSE, 3, 'Hungarian', 4),
       ('Lionel Messi', FALSE, 0, 'Argentinean', 1);







