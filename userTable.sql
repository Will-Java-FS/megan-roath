SET search_path TO public;
DROP TABLE if exists users;

CREATE TABLE if not exists users(
	id serial primary key,
	user_name varchar(50) unique not null,
	user_password varchar(50) not null
);

INSERT INTO users VALUES
(default, 'sarah', 'pwd'),
(default, 'megan', 'securepwd');

SELECT * FROM users;