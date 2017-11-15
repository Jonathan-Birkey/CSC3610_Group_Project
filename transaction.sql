use java3final;

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
