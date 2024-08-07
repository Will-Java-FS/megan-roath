SET search_path TO students;
drop table if exists students;

create table if not exists students (
	a_id serial primary key,
	email varchar(50),
	major varchar(50),
	age int,
	password varchar(50)
	
);

insert into students values
(default, 'email@email.com', 'math', 50,'password');

select * from students;
