drop table geek if exists cascade;
drop table log if exists cascade;
drop sequence geek_seq if exists;
drop sequence log_seq if exists;

create table geek (
	id numeric not null,
	name varchar(25) not null,
	sex varchar(20) not null,
	interests varchar(255) not null,
	avatar varchar(255),
	cptview numeric not null,
	primary key (id)
);

create table log (
	id numeric not null,
	id_geek numeric not null,
	hour date not null,
	ipadress varchar(16) not null,
	primary key (id)
);

create sequence geek_seq start with 1000;
create sequence log_seq start with 1000;
