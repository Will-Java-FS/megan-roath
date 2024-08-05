SET search_path TO public;
DROP TABLE if exists games;

CREATE TABLE if not exists games(
	gameid serial primary key,
	gamename varchar(50) unique not null,
	owner varchar(50) not null
);

INSERT INTO games VALUES
(default, 'Minecraft', 'Microsoft'),
(default, 'Fortnite', 'Epic'),
(default, 'Stray', 'BlueTwelve'),
(default, 'GTA5', 'RockstarGames');

select * from games;
