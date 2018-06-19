/*
MySQL Backup
Database: fruits
Backup Time: 2018-06-17 22:42:49
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `fruits`.`fruit`;
DROP TABLE IF EXISTS `fruits`.`user`;
CREATE TABLE `fruit` (
  `fruitID` int(11) NOT NULL,
  `fruitName` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  PRIMARY KEY (`fruitID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `user` (
  `userName` varchar(40) NOT NULL,
  `password` int(11) NOT NULL,
  `state` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
BEGIN;
LOCK TABLES `fruits`.`fruit` WRITE;
DELETE FROM `fruits`.`fruit`;
INSERT INTO `fruits`.`fruit` (`fruitID`,`fruitName`,`price`,`description`,`quantity`) VALUES (1, '苹果', 3, 'tasty', 1),(2, '香蕉', 5, 'yellow', 2),(3, '梨子', 5, 'whilte', 4),(4, '猕猴桃', 7.5, 'green', 5),(5, '西瓜', 1, 'red', 7),(6, '荔枝', 8.5, 'pink', 4);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `fruits`.`user` WRITE;
DELETE FROM `fruits`.`user`;
INSERT INTO `fruits`.`user` (`userName`,`password`,`state`) VALUES ('lk', 123456, 'Normal'),('zxc', 123, 'Normal'),('zxy', 123, 'VIP');
UNLOCK TABLES;
COMMIT;
