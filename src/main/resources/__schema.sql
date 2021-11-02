CREATE TABLE IF NOT EXISTS movie (
	movieid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
	title text,
	imageurl text);

CREATE TABLE IF NOT EXISTS actor (
	actorid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
	name text,
	imageurl text);

CREATE TABLE IF NOT EXISTS genre (
	genreid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
	label text);


CREATE TABLE IF NOT EXISTS movieXactor (
	movieid uuid REFERENCES movie(movieid) ON DELETE CASCADE,
	actorid uuid REFERENCES actor(actorid) ON DELETE CASCADE);

CREATE TABLE IF NOT EXISTS movieXgenre (
	movieid uuid REFERENCES movie(movieid) ON DELETE CASCADE,
	genreid uuid REFERENCES genre(genreid) ON DELETE CASCADE);


INSERT INTO movie(title, imageurl) VALUES
	('Movie One','movie1.jpg'),
	('Movie Two','movie2.jpg'),
	('Movie Three','movie3.jpg'),
	('Movie Four','movie4.jpg');

INSERT INTO actor(name, imageurl) VALUES
	('Actor One','actor1.jpg'),
	('Actor Two','actor2.jpg'),
	('Actor Three','actor3.jpg'),
	('Actor Four','actor4.jpg'),
	('Actor Five','actor5.jpg');

INSERT INTO genre(label) VALUES
	('Genre One'),
	('Genre Two'),
	('Genre Three');


INSERT INTO movieXactor VALUES
	((SELECT movieid FROM movie WHERE title='Movie One'),(SELECT actorid FROM actor WHERE name='Actor One')),
	((SELECT movieid FROM movie WHERE title='Movie One'),(SELECT actorid FROM actor WHERE name='Actor Two')),
	((SELECT movieid FROM movie WHERE title='Movie Two'),(SELECT actorid FROM actor WHERE name='Actor Three')),
	((SELECT movieid FROM movie WHERE title='Movie Two'),(SELECT actorid FROM actor WHERE name='Actor Four')),
	((SELECT movieid FROM movie WHERE title='Movie Three'),(SELECT actorid FROM actor WHERE name='Actor Four')),
	((SELECT movieid FROM movie WHERE title='Movie Three'),(SELECT actorid FROM actor WHERE name='Actor Five')),
	((SELECT movieid FROM movie WHERE title='Movie Four'),(SELECT actorid FROM actor WHERE name='Actor One')),
	((SELECT movieid FROM movie WHERE title='Movie Four'),(SELECT actorid FROM actor WHERE name='Actor Four'));

INSERT INTO movieXgenre VALUES
    ((SELECT movieid FROM movie WHERE title='Movie One'),(SELECT genreid FROM genre WHERE name='Genre One')),
    ((SELECT movieid FROM movie WHERE title='Movie One'),(SELECT genreid FROM genre WHERE name='Genre Two')),
    ((SELECT movieid FROM movie WHERE title='Movie Two'),(SELECT genreid FROM genre WHERE name='Genre One')),
    ((SELECT movieid FROM movie WHERE title='Movie Three'),(SELECT genreid FROM genre WHERE name='Genre One')),
    ((SELECT movieid FROM movie WHERE title='Movie Three'),(SELECT genreid FROM genre WHERE name='Genre Two')),
    ((SELECT movieid FROM movie WHERE title='Movie Three'),(SELECT genreid FROM genre WHERE name='Genre Three'));

-- SELECT * FROM movie JOIN movieXactor USING (movieid) JOIN actor USING (actorid) JOIN movieXgenre USING (movieid) JOIN genre USING (genreid);