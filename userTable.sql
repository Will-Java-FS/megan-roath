SET search_path TO public;
DROP TABLE if exists users;

CREATE TABLE if not exists users(
	userId serial primary key,
	name varchar(255) unique not null,
	password varchar(255) not null
);

INSERT INTO users VALUES
(default, 'sarah', 'pwd'),
(default, 'megan', 'securepwd');

SELECT * FROM users;