SET search_path TO public;
DROP TABLE if exists users;

CREATE TABLE if not exists users(
	userid serial primary key,
	name varchar(50) unique not null,
	password varchar(50) not null
);

INSERT INTO users VALUES
(default, 'sarah', 'pwd'),
(default, 'megan', 'securepwd');

SELECT * FROM users;