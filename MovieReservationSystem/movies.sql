
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

CREATE TABLE `movie`.`user` (
`_id` INT NOT NULL AUTO_INCREMENT, 
`name` VARCHAR(255) NOT NULL , 
`username` VARCHAR(255) NOT NULL , 
`password` VARCHAR(255) NOT NULL , 
PRIMARY KEY (`_id`)) 
ENGINE = InnoDB;

INSERT INTO `movie`.`movie` (title, info, duration, image)  VALUES ('Movie A', 'MOvie A Info', 123, 'https://static.wikia.nocookie.net/marvelcinematicuniverse/images/9/97/Scarlet_Witch.jpg/revision/latest?cb=20220501012641');
INSERT INTO `movie`.`movie` (title, info, duration, image)  VALUES ('Movie B', 'MOvie B Info', 133, 'https://static.wikia.nocookie.net/marvelcinematicuniverse/images/9/97/Scarlet_Witch.jpg/revision/latest?cb=20220501012641');
INSERT INTO `movie`.`movie` (title, info, duration, image)  VALUES ('Movie C', 'MOvie C Info', 144, 'https://static.wikia.nocookie.net/marvelcinematicuniverse/images/9/97/Scarlet_Witch.jpg/revision/latest?cb=20220501012641');
INSERT INTO `movie`.`movie` (title, info, duration, image)  VALUES ('Movie D', 'MOvie D Info', 110, 'https://static.wikia.nocookie.net/marvelcinematicuniverse/images/9/97/Scarlet_Witch.jpg/revision/latest?cb=20220501012641');
INSERT INTO `movie`.`movie` (title, info, duration, image)  VALUES ('Movie E', 'MOvie E Info', 102, 'https://static.wikia.nocookie.net/marvelcinematicuniverse/images/9/97/Scarlet_Witch.jpg/revision/latest?cb=20220501012641');
INSERT INTO `movie`.`movie` (title, info, duration, image)  VALUES ('Movie F', 'MOvie F Info', 90, 'https://static.wikia.nocookie.net/marvelcinematicuniverse/images/9/97/Scarlet_Witch.jpg/revision/latest?cb=20220501012641');


INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (1, '9.00', 50 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (1, '10.00', 50 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (1, '17.00', 50 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (1, '20.00', 50 );

INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (2, '9.00', 50 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (2, '11.00', 50 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (2, '14.00', 50 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (2, '15.00', 50 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (2, '16.00', 50 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (2, '19.00', 50 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (2, '20.00', 50 );

INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (3, '9.00', 50 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (3, '11.00', 50 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (3, '16.00', 50 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (3, '18.00', 50 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (3, '19.00', 50 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (3, '20.00', 50 );

INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (4, '9.00', 50 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (4, '10.00', 50 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (4, '11.00', 50 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (4, '18.00', 50 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (4, '19.00', 50 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (4, '20.00', 50 );

INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (5, '10.00', 50 );
INSERT INTO `movie`.`showtime` (movie_id, showtime, capacity)  VALUES (5, '16.00', 50 );