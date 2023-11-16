INSERT INTO user_data (name, password, username, age, email) VALUES ('John Doe', 'password123', 'john_doe', 30, 'john.doe@example.com');
INSERT INTO user_data (name, password, username, age, email) VALUES ('Jane Smith', 'pass456', 'jane_smith', 25, 'jane.smith@example.com');
INSERT INTO user_data (name, password, username, age, email) VALUES ('Alice Johnson', 'alice_pass', 'alice_j', 28, 'alice.j@example.com');
INSERT INTO user_data (name, password, username, age, email) VALUES ('Bob Anderson', 'bob_pass', 'bob_a', 35, 'bob.anderson@example.com');

INSERT INTO genre (name, creation_date) VALUES ('Action', '2023-11-11');
INSERT INTO genre (name, creation_date) VALUES ('Drama', '2023-11-10');
INSERT INTO genre (name, creation_date) VALUES ('Comedy', '2023-11-09');
INSERT INTO genre (name, creation_date) VALUES ('Thriller', '2023-11-08');
INSERT INTO genre (name, creation_date) VALUES ('Sci-Fi', '2023-11-07');
INSERT INTO genre (name, creation_date) VALUES ('Romance', '2023-11-06');

INSERT INTO movie (name, filmed_at, description) VALUES ('Inception', '2010-07-16', 'A mind-bending thriller about dreams within dreams.');
INSERT INTO movie (name, filmed_at, description) VALUES ('The Shawshank Redemption', '1994-09-23', 'A tale of friendship and redemption in Shawshank State Penitentiary.');
INSERT INTO movie (name, filmed_at, description) VALUES ('Pulp Fiction', '1994-10-14', 'Quentin Tarantino iconic nonlinear narrative.');
INSERT INTO movie (name, filmed_at, description) VALUES ('The Dark Knight', '2008-07-18', 'Christopher Nolan epic Batman sequel.');
INSERT INTO movie (name, filmed_at, description) VALUES ('Forrest Gump', '1994-07-06', 'The life story of a simple man with extraordinary experiences.');
INSERT INTO movie (name, filmed_at, description) VALUES ('The Matrix', '1999-03-31', 'A sci-fi classic exploring the concept of reality.');
INSERT INTO movie (name, filmed_at, description) VALUES ('Titanic', '1997-11-18', 'A romance-drama set against the backdrop of the ill-fated RMS Titanic.');
INSERT INTO movie (name, filmed_at, description) VALUES ('The Silence of the Lambs', '1991-02-14', 'A psychological thriller featuring Hannibal Lecter.');
INSERT INTO movie (name, filmed_at, description) VALUES ('The Godfather', '1972-03-14', 'A crime epic directed by Francis Ford Coppola.');
INSERT INTO movie (name, filmed_at, description) VALUES ('Eternal Sunshine of the Spotless Mind', '2004-03-19', 'A unique romantic science fiction film.');

SET @action_id = (SELECT id FROM genre WHERE name = 'Action');
SET @drama_id = (SELECT id FROM genre WHERE name = 'Drama');
SET @comedy_id = (SELECT id FROM genre WHERE name = 'Comedy');
SET @thriller_id = (SELECT id FROM genre WHERE name = 'Thriller');
SET @scifi_id = (SELECT id FROM genre WHERE name = 'Sci-Fi');
SET @romance_id = (SELECT id FROM genre WHERE name = 'Romance');

INSERT INTO movie_genre (movie_id, genre_id) VALUES ((SELECT id FROM movie WHERE name = 'Inception'), @action_id);
INSERT INTO movie_genre (movie_id, genre_id) VALUES ((SELECT id FROM movie WHERE name = 'Inception'), @drama_id);
INSERT INTO movie_genre (movie_id, genre_id) VALUES ((SELECT id FROM movie WHERE name = 'The Shawshank Redemption'), @drama_id);
INSERT INTO movie_genre (movie_id, genre_id) VALUES ((SELECT id FROM movie WHERE name = 'Pulp Fiction'), @drama_id);
INSERT INTO movie_genre (movie_id, genre_id) VALUES ((SELECT id FROM movie WHERE name = 'The Dark Knight'), @action_id);
INSERT INTO movie_genre (movie_id, genre_id) VALUES ((SELECT id FROM movie WHERE name = 'Forrest Gump'), @comedy_id);
INSERT INTO movie_genre (movie_id, genre_id) VALUES ((SELECT id FROM movie WHERE name = 'The Matrix'), @scifi_id);
INSERT INTO movie_genre (movie_id, genre_id) VALUES ((SELECT id FROM movie WHERE name = 'Titanic'), @romance_id);
INSERT INTO movie_genre (movie_id, genre_id) VALUES ((SELECT id FROM movie WHERE name = 'The Silence of the Lambs'), @thriller_id);
INSERT INTO movie_genre (movie_id, genre_id) VALUES ((SELECT id FROM movie WHERE name = 'The Godfather'), @drama_id);
INSERT INTO movie_genre (movie_id, genre_id) VALUES ((SELECT id FROM movie WHERE name = 'Eternal Sunshine of the Spotless Mind'), @romance_id);

INSERT INTO movie_rate (movie_id, rate, user_id) VALUES ((SELECT id FROM movie WHERE name = 'Inception'), 4.5, (SELECT id FROM user_data WHERE username = 'john_doe'));
INSERT INTO movie_rate (movie_id, rate, user_id) VALUES ((SELECT id FROM movie WHERE name = 'The Shawshank Redemption'), 5.0, (SELECT id FROM user_data WHERE username = 'jane_smith'));
INSERT INTO movie_rate (movie_id, rate, user_id) VALUES ((SELECT id FROM movie WHERE name = 'The Matrix'), 4.8, (SELECT id FROM user_data WHERE username = 'alice_j'));
INSERT INTO movie_rate (movie_id, rate, user_id) VALUES ((SELECT id FROM movie WHERE name = 'Titanic'), 4.2, (SELECT id FROM user_data WHERE username = 'bob_a'));
INSERT INTO movie_rate (movie_id, rate, user_id) VALUES ((SELECT id FROM movie WHERE name = 'The Silence of the Lambs'), 4.5, (SELECT id FROM user_data WHERE username = 'alice_j'));
INSERT INTO movie_rate (movie_id, rate, user_id) VALUES ((SELECT id FROM movie WHERE name = 'The Godfather'), 4.9, (SELECT id FROM user_data WHERE username = 'bob_a'));
INSERT INTO movie_rate (movie_id, rate, user_id) VALUES ((SELECT id FROM movie WHERE name = 'Eternal Sunshine of the Spotless Mind'), 4.7, (SELECT id FROM user_data WHERE username = 'alice_j'));
