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
	firstName varchar(25) NOT NULL,
	lastName varchar(25) NOT NULL,
	phone varchar(13) NOT NULL,
	email varchar(25) NOT NULL,
	street varchar(255) DEFAULT NULL,
    city varchar(255) DEFAULT NULL,
    state varchar (25) DEFAULT NULL,
    zip char(5) NOT NULL,
	userName varchar(11) NOT NULL,
	password varchar(255) NOT NULL,
	DOB date DEFAULT NULL,
	ssn char(9) NOT NULL,
	PRIMARY KEY (userName, phone)
);


INSERT INTO Car VALUES ('12345','Black','P150D',2017,'22.0','Leather','30000.00','P150D');
INSERT INTO User VALUES ('Kyle','Grondin','6305555555','test@example.com','123 Fake St', 'Fake City', 'IL', '60506', 'admin','password','1994-04-01','123456789');