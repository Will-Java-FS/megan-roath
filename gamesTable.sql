SET search_path TO public;
DROP TABLE if exists games;

CREATE TABLE if not exists games(
	gameId serial primary key,
	gameName varchar(50) unique not null
);