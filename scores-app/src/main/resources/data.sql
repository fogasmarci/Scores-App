INSERT INTO competitions (name)
VALUES ('La Liga'),
       ('Premier League'),
       ('Champions League');

-- La Liga (competition_id = 1)
INSERT INTO team_stats (team_rank, team_name, games_played, wins, draws, losses, goal_difference, points, competition_id)
VALUES
    (1, 'Barcelona', 4, 4, 0, 0, 11, 12, 1),  -- 12 points
    (2, 'Real Sociedad', 2, 1, 1, 0, 0, 4, 1),  -- 4 points
    (3, 'Sevilla', 3, 0, 2, 1, -2, 2, 1),  -- 2 points
    (4, 'Valencia', 4, 0, 2, 2, -2, 2, 1),  -- 2 points
    (5, 'Real Madrid', 4, 1, 0, 3, -4, 3, 1);  -- 3 points

-- Premier League (competition_id = 2)
INSERT INTO team_stats (team_rank, team_name, games_played, wins, draws, losses, goal_difference, points, competition_id)
VALUES
    (1, 'Manchester City', 1, 1, 0, 0, 2, 3, 2),  -- 3 points
    (2, 'Liverpool', 2, 1, 0, 1, 0, 3, 3),  -- 3 points
    (3, 'Manchester United', 2, 0, 0, 2, -6, 0, 2);  -- 0 points

-- Champions League (competition_id = 3)
INSERT INTO team_stats (team_rank, team_name, games_played, wins, draws, losses, goal_difference, points, competition_id)
VALUES
    (1, 'Barcelona', 1, 1, 0, 0, 2, 3, 3),  -- 3 points
    (2, 'Liverpool', 1, 0, 0, 1, -2, 0, 3);  -- 0 points



INSERT INTO teams (name, stadium)
VALUES ('Barcelona', 'Nou Camp'),
       ('Real Madrid', 'Bernabeu'),
       ('Valencia', 'Mestalla'),
       ('Real Sociedad', 'Reale Arena'),
       ('Sevilla', 'Ramón Sánchez Pizjuán'),
       ('Liverpool', 'Anfield'),
       ('Manchester United', 'Old Trafford'),
       ('Manchester City', 'Etihad');

INSERT INTO team_competition (team_id, competition_id)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (4, 1),
       (5, 1),
       (6, 2),
       (7, 2),
       (8, 2),
       (1, 3),
       (6, 3);

SET GLOBAL time_zone = '+03:00';
INSERT INTO games (name, home_team, home_team_score, away_team, away_team_score, round, game_status, start_time, competition_id)
VALUES ('Barcelona vs Real Madrid', 'Barcelona', 5, 'Real Madrid', 1, 1, 2, '2024-04-01 18:30', 1),
       ('Barcelona vs Valencia', 'Barcelona',  NULL, 'Valencia', NULL, 2, 0, '2024-05-11 18:00', 1),
       ('Real Madrid vs Valencia', 'Real Madrid', NULL, 'Valencia', NULL, 3, 0, '2024-05-17 20:00', 1),
       ('Barcelona vs Liverpool', 'Barcelona', 3, 'Liverpool', 1, 1, 2, '2024-05-05 21:00', 3),
       ('Real Sociedad vs Sevilla', 'Real Sociedad', 2, 'Sevilla', 2, 1, 2, '2024-04-10 18:30', 1),
       ('Sevilla vs Real Madrid', 'Sevilla', 1, 'Real Madrid', 3, 2, 2, '2024-04-15 20:30', 1),
       ('Liverpool vs Manchester United', 'Liverpool', 2, 'Manchester United', 0, 1, 2, '2024-04-20 17:00', 2),
       ('Manchester City vs Manchester United', 'Manchester City', 4, 'Manchester United', 2, 2, 2, '2024-04-25 16:00', 2),
       ('Real Sociedad vs Valencia', 'Real Sociedad', 1, 'Valencia', 1, 4, 2, '2024-05-01 19:00', 1),
       ('Barcelona vs Sevilla', 'Barcelona', 2, 'Sevilla', 0, 5, 2, '2024-05-10 21:00', 1),
       ('Liverpool vs Manchester City', 'Liverpool', NULL, 'Manchester City', NULL, 3, 0, '2024-05-15 18:00', 2),
       ('Manchester United vs Barcelona', 'Manchester United', NULL, 'Barcelona', NULL, 6, 0, '2024-05-20 20:00', 3),
       ('Valencia vs Real Madrid', 'Valencia', NULL, 'Real Madrid', NULL, 7, 0, '2024-05-25 18:30', 1),
       ('Sevilla vs Real Sociedad', 'Sevilla', NULL, 'Real Sociedad', NULL, 8, 0, '2024-06-01 20:00', 1);

DROP TABLE team_game;

CREATE TABLE team_game (home_team_id bigint, away_team_id bigint, game_id bigint, id bigint not null auto_increment, primary key (id));
INSERT INTO team_game (home_team_id, away_team_id, game_id)
VALUES (1, 2, 1),
       (1, 3, 2),
       (2, 3, 3),
       (1, 4, 4),
       (4, 5, 5),
       (5, 2, 6),
       (6, 7, 7),
       (8, 7, 8),
       (4, 3, 9),
       (1, 5, 10),
       (6, 8, 11),
       (7, 1, 12),
       (3, 2, 13),
       (5, 4, 14);

INSERT INTO players (name, suspended, yellow_cards, nationality, team_id)
VALUES ('Szoboszlai Dominik', FALSE, 3, 'Hungarian', 4),
       ('Lionel Messi', FALSE, 0, 'Argentinean', 1);







