create table Person (
	personid int not null AUTO_INCREMENT primary key,
	name varchar(32) not null,
	sex varchar(1) not null
);


create table Event (
	eventid int not null AUTO_INCREMENT primary key,
	name varchar(32) not null
	
);

create table Speaker(
	speakerid int primary key AUTO_INCREMENT not null,
	personid int ,
	FOREIGN KEY(personid) references Person(personid),
	eventid int,
	FOREIGN KEY(eventid) references Event(eventid)
	
);

alter table event add speakerid int not null;

alter table event add	constraint event_speakerid_FK
	FOREIGN KEY (speakerid)
	references Speaker(speakerid);
	
	
create table Topic (
	topicid int primary key not null AUTO_INCREMENT,
	name varchar(100),
	eventid int,
	speakerid int,
	constraint topic_event_fk FOREIGN KEY(eventid) references event(eventid),
	constraint topic_speaker_fk FOREIGN KEY(speakerid) REFERENCES Speaker(speakerid)
);