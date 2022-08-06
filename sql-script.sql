
CREATE DATABASE IF NOT EXISTS `secure_spring_mvc_db_auth`
USE `secure_spring_mvc_db_auth`;

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(60) NOT NULL,
  `enabled` tinyint(4) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO secure_spring_mvc_db_auth.users (username,password,enabled) 
VALUES ('admin','{noop}admin123',1);


CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  KEY `authorities_relation_1` (`username`),
  CONSTRAINT `authorities_relation_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO secure_spring_mvc_db_auth.authorities (username,authority) 
VALUES ('admin','ADMIN');
