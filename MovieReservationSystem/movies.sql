
DROP SCHEMA IF EXISTS movie;
CREATE SCHEMA movie;

CREATE TABLE `movie`.`movie` (
`_id` INT NOT NULL AUTO_INCREMENT, 
`title` VARCHAR(255) NOT NULL , 
`info` VARCHAR(255) NOT NULL ,
`duration` INT NOT NULL, 
`image` VARCHAR(255) NOT NULL,
PRIMARY KEY (`_id`)) 
ENGINE = InnoDB;

CREATE TABLE `movie`.`showtime`(
`_id` INT NOT NULL AUTO_INCREMENT,
`movie_id` INT NOT NULL,
`showtime` VARCHAR(255) NOT NULL,
`capacity` INT NOT NULL,
PRIMARY KEY (`_id`),
INDEX `showtime_movie_idx` (`movie_id` ASC),
 CONSTRAINT `showtime_movie_id`
FOREIGN KEY (`movie_id`)
REFERENCES `movie`.`movie` (`_id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION);


INSERT INTO `movie`.`movie` (title, info, duration, image)  VALUES ('Jurassic World: Dominion', 'Dominion takes place four years after Isla Nublar has been destroyed. Dinosaurs now live—and hunt—alongside humans all over the world. This fragile balance will reshape the future and determine, once and for all.', 147, 'https://pbs.twimg.com/media/FQUDopwVsAEjmB2?format=jpg&name=large');
INSERT INTO `movie`.`movie` (title, info, duration, image)  VALUES ('Minions: The Rise of Gru', 'Minions: The Rise of Gru is a 2022 American computer-animated action comedy film produced by Illumination and distributed by Universal Pictures. It is the sequel to the spin-off prequel Minions and the fifth entry overall in the Despicable Me franchise.', 88, 'https://m.media-amazon.com/images/M/MV5BZDQyODUwM2MtNzA0YS00ZjdmLTgzMjItZWRjN2YyYWE5ZTNjXkEyXkFqcGdeQXVyMTI2MzY1MjM1._V1_.jpg');
INSERT INTO `movie`.`movie` (title, info, duration, image)  VALUES ('Top Gun: Maverick', 'Captain Pete "Maverick" Mitchell, after more than three decades of service as one of the top aviators in the Navy, is now a flight instructor who finds himself training a group of Top Gun graduates for a specialised mission.', 130, 'https://upload.wikimedia.org/wikipedia/en/1/13/Top_Gun_Maverick_Poster.jpg');
INSERT INTO `movie`.`movie` (title, info, duration, image)  VALUES ('Ah Girls Go Army', 'Ah Girls Go Army is a 2022 Singaporean military comedy film. Directed by Jack Neo, the film follows the first batch of female recruits as they undergo and serve National Service in the fictional near future of Singapore.', 120, 'https://xinemas.com/data/upload/movies/2022/ah-girls-go-army.jpg');
INSERT INTO `movie`.`movie` (title, info, duration, image)  VALUES ('Doraemon: Nobita\'s Little Star Wars 2021', '‘Doraemon: Nobita\'s Little Star Wars 2021 is a 2022 Japanese animated epic space opera film. It is the 41st Doraemon film and serves as a remake of the 1985 film Doraemon: Nobita\'s Little Star Wars.', 108, 'https://www.gematsu.com/wp-content/uploads/2020/12/Doraemon-2021-Game_12-01-20.jpg');
INSERT INTO `movie`.`movie` (title, info, duration, image)  VALUES ('Jujutsu Kaisen 0', 'Yuta Okkotsu is a nervous high school student who is suffering from a serious problem—his childhood friend Rika has turned into a Curse and won\'t leave him alone. Since Rika is no ordinary Curse, his plight is noticed by Satoru Gojo.', 105, 'https://img.game-news24.com/2022/01/Jujutsu-Kaisen-0-Anime-Films-are-the-beginning-of-March-aren-t-they.png');


INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (1, '9.00', 50 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (1, '9.45', 50 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (1, '10.00', 35 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (1, '10.20', 35 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (1, '17.30', 40 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (1, '20.00', 30 );

INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (2, '9.00', 40 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (2, '11.00', 40 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (2, '11.45', 40 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (2, '14.00', 50 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (2, '15.00', 30 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (2, '16.00', 40 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (2, '19.00', 40 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (2, '20.00', 20 );

INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (3, '9.00', 50 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (3, '11.00', 50 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (3, '16.00', 20 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (3, '18.00', 30 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (3, '19.00', 40 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (3, '20.00', 45 );

INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (4, '9.00', 50 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (4, '10.00', 20 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (4, '11.00', 30 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (4, '18.00', 50 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (4, '19.00', 40 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (4, '20.00', 40 );

INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (5, '10.00', 50 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (5, '16.00', 50 );

