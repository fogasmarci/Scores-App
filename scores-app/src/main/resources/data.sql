INSERT INTO competitions (name)
VALUES ('La Liga'),
       ('Premier League'),
       ('Champions League');

INSERT INTO teams (name, stadium, games_to_play_id, played_games_id)
VALUES ('Barcelona', 'Nou Camp', null, 1),
       ('Barcelona', 'Nou Camp', 2, null),
       ('Barcelona', 'Nou Camp', 4, null),
       ('Real Madrid', 'Bernabeu', null, 1),
       ('Real Madrid', 'Bernabeu', 3, null),
       ('Valencia', 'Mestalla', 2, null),
       ('Valencia', 'Mestalla', 3, null,
       ('Liverpool', 'Anfield', 4, null);

INSERT INTO team_competition (team_id, competition_id)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (4, 2),
       (4, 3),
       (1, 3);

INSERT INTO games (score, game_status, start_time, competition_id, home_team_id, away_team_id)
VALUES ('5-1', 2, '2024-01-01', 1, 1, 4),
       (NULL, 0, '2024-05-05', 1),
       (NULL, 0, '2024-05-05', 1),
       (NULL, 0, '2024-05-05', 3);


/*INSERT INTO game_team (game_id, team_id)
VALUES (1, 1),
       (1, 2),
       (2, 1),
       (2, 3),
       (3, 2),
       (3, 3),
       (4, 1),
       (4, 4);*/

INSERT INTO players (name, suspended, yellow_cards, nationality, team_id)
VALUES ('Szoboszlai Dominik', FALSE, 3, 'Hungarian', 4),
       ('Lionel Messi', FALSE, 0, 'Argentinean', 1);







