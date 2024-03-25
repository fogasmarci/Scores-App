INSERT INTO competitions (name)
VALUES ('La Liga'),
       ('Premier League'),
       ('Champions League');

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

INSERT INTO games (name, home_team_score, away_team_score, game_status, start_time, round, competition_id, game_details_id)
VALUES ('Barcelona vs Real Madrid', 5, 1, 2, '2024-01-01', 1, 1, null),
       ('Barcelona vs Valencia', NULL, NULL, 0, '2024-05-05', 2, 1, null),
       ('Real Madrid vs Valencia', NULL, NULL, 0, '2024-05-05', 3, 1, null),
       ('Barcelona vs Liverpool', NULL, NULL, 0, '2024-05-05', 5, 3, null);


INSERT INTO game_team (game_id, team_id)
VALUES (1, 1),
       (1, 2),
       (2, 1),
       (2, 3),
       (3, 2),
       (3, 3),
       (4, 1),
       (4, 4);

INSERT INTO players (name, suspended, yellow_cards, nationality, team_id)
VALUES ('Szoboszlai Dominik', FALSE, 3, 'Hungarian', 4),
       ('Lionel Messi', FALSE, 0, 'Argentinean', 1);







