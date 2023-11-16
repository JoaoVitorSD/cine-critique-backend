INSERT INTO genre (name, creation_date) VALUES ('Action', '2023-11-11');
INSERT INTO genre (name, creation_date) VALUES ('Drama', '2023-11-10');
INSERT INTO genre (name, creation_date) VALUES ('Comedy', '2023-11-09');

INSERT INTO movie (name, filmed_at, description) VALUES ('Inception', '2010-07-16', 'A mind-bending thriller about dreams within dreams.');
INSERT INTO movie (name, filmed_at, description) VALUES ('The Shawshank Redemption', '1994-09-23', 'A tale of friendship and redemption in Shawshank State Penitentiary.');
INSERT INTO movie (name, filmed_at, description) VALUES ('Pulp Fiction', '1994-10-14', 'Quentin Tarantino siconic nonlinear narrative.');
INSERT INTO movie (name, filmed_at, description) VALUES ('The Dark Knight', '2008-07-18', 'Christopher Nolan epic Batman sequel.');
INSERT INTO movie (name, filmed_at, description) VALUES ('Forrest Gump', '1994-07-06', 'The life story of a simple man with extraordinary experiences.');

-- Retrieving genre IDs
SET @action_id = (SELECT id FROM genre WHERE name = 'Action');
SET @drama_id = (SELECT id FROM genre WHERE name = 'Drama');
SET @comedy_id = (SELECT id FROM genre WHERE name = 'Comedy');

-- Associating movies with genres in the movie_genre table
INSERT INTO movie_genre (movie_id, genre_id) VALUES ((SELECT id FROM movie WHERE name = 'Inception'), @action_id);
INSERT INTO movie_genre (movie_id, genre_id) VALUES ((SELECT id FROM movie WHERE name = 'Inception'), @drama_id);
INSERT INTO movie_genre (movie_id, genre_id) VALUES ((SELECT id FROM movie WHERE name = 'Inception'), @drama_id);
INSERT INTO movie_genre (movie_id, genre_id) VALUES ((SELECT id FROM movie WHERE name = 'The Shawshank Redemption'), @drama_id);
INSERT INTO movie_genre (movie_id, genre_id) VALUES ((SELECT id FROM movie WHERE name = 'Pulp Fiction'), @drama_id);
INSERT INTO movie_genre (movie_id, genre_id) VALUES ((SELECT id FROM movie WHERE name = 'The Dark Knight'), @action_id);
INSERT INTO movie_genre (movie_id, genre_id) VALUES ((SELECT id FROM movie WHERE name = 'Forrest Gump'), @comedy_id);
