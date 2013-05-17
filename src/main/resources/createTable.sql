CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `name` varchar(64) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `available` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;


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


alter table error modify errorid int AUTO_INCREMENT