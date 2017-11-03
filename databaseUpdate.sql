use java3final;

drop table user;

create table user (
	firstName VARCHAR(50),
	lastName VARCHAR(50),
	phone VARCHAR(11),
	email VARCHAR(50),
	city VARCHAR(50),
	street VARCHAR(50),
	state VARCHAR(50),
	zip INT(6),
	userName VARCHAR(50),
	password VARCHAR(255),
	DOB date,
	ssn VARCHAR(9)
);