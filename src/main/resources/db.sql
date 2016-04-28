
DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user (
  user_id int NOT NULL AUTO_INCREMENT,
  username varchar(30) DEFAULT NULL,
  password varchar(30) DEFAULT NULL,
  PRIMARY KEY (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;