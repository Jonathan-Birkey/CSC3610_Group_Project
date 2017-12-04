DROP DATABASE IF EXISTS java3Final;

create database java3Final;

use java3Final;

drop table if exists Car;

Create table Car(
	carID varchar(5) NOT NULL,
	color varchar(20) NOT NULL,
	model varchar(10) NOT NULL,
	year int(4) NOT NULL,
	sizeOfWheels double(3,1) NOT NULL,
	interiorType varchar(20) NOT NULL,
	price double(7,2) NOT NULL,
	subModel varchar(10) NOT NULL,
	PRIMARY KEY (carID)
);

drop table if exists User;

CREATE TABLE User(
	firstName varchar(50) NOT NULL,
	lastName varchar(50) NOT NULL,
	phone varchar(15) NOT NULL,
	email varchar(50) NOT NULL,
	street varchar(100) DEFAULT NULL,
    city varchar(100) DEFAULT NULL,
    state varchar (25) DEFAULT NULL,
    zip char(6) NOT NULL,
	userName varchar(50) NOT NULL,
	password varchar(255) NOT NULL,
	DOB date DEFAULT NULL,
	ssn char(15) NOT NULL,
	PRIMARY KEY (userName, phone)
);

drop table transaction;

create table transaction(
	id int not null auto_increment,
	name varchar(25),
	model varchar(25),
	submodel varchar(25),
	color varchar(25),
	date_bought date,
	price decimal(8,2),
	primary key (id)
);