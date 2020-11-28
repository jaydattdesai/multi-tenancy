
create database testdb2;
use testdb2;

DROP TABLE IF EXISTS `sample_entity`;

SET character_set_client = utf8mb4 ;
 
CREATE TABLE `sample_entity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


