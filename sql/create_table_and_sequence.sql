drop table geek if exists cascade;
drop sequence geek_seq if exists;

create table geek (
	id numeric not null,
	name varchar(25) not null,
	sex varchar(20) not null,
	interests varchar(255) not null,
	avatar varchar(255),
	cptview numeric not null,
	primary key (id)
);

create sequence geek_seq start with 1000;
