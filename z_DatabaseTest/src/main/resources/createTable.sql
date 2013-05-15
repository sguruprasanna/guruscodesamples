CREATE TABLE user
(
   ID int PRIMARY KEY NOT NULL,
   USERNAME varchar(32) NOT NULL,
   NAME varchar(64) NOT NULL
)
;
CREATE UNIQUE INDEX PRIMARY ON user(ID)
;
CREATE UNIQUE INDEX USERNAME ON user(USERNAME)
;



CREATE TABLE error
(
   errorid int PRIMARY KEY NOT NULL,
   code varchar(32) NOT NULL,
   description varchar(255) NOT NULL,
   createdon timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL
)
;
CREATE UNIQUE INDEX PRIMARY ON error(errorid)
;
