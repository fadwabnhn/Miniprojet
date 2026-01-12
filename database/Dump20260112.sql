-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: miniprojet_db
-- ------------------------------------------------------
-- Server version	8.0.44

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user_goals`
--

DROP TABLE IF EXISTS `user_goals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_goals` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `skill` varchar(255) DEFAULT NULL,
  `suggested_goal` varchar(255) DEFAULT NULL,
  `time` int NOT NULL,
  `user_id` bigint NOT NULL,
  `strategies` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_goal` (`user_id`),
  CONSTRAINT `fk_user_goal` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_goals`
--

LOCK TABLES `user_goals` WRITE;
/*!40000 ALTER TABLE `user_goals` DISABLE KEYS */;
INSERT INTO `user_goals` VALUES (1,'WRITING','REVIEW_FLASHCARDS',16,3,NULL),(2,'WRITING','REVIEW_FLASHCARDS',15,3,NULL),(3,'WRITING','REVIEW_FLASHCARDS',15,3,NULL),(4,'WRITING','WRITE_SENTENCES',15,3,NULL),(5,'WRITING','WRITE_SENTENCES',15,3,NULL),(6,'WRITING','WRITE_SENTENCES',15,3,NULL),(7,'WRITING','WRITE_SENTENCES',15,3,NULL),(8,'WRITING','REVIEW_FLASHCARDS',16,3,NULL),(9,'WRITING','REVIEW_FLASHCARDS',16,3,NULL),(10,'WRITING','WRITE_SENTENCES',17,3,NULL),(11,'WRITING','WRITE_SENTENCES',18,3,NULL),(12,'WRITING','WRITE_SENTENCES',10,3,NULL),(13,'LISTENING','WRITE_SENTENCES',16,3,NULL),(14,'SPEAKING','REVIEW_FLASHCARDS',7,3,NULL),(15,'READING','REVIEW_FLASHCARDS',11,3,NULL),(16,'READING','REVIEW_FLASHCARDS',15,3,NULL),(17,'READING','WRITE_SENTENCES',17,3,NULL),(18,'READING','WRITE_SENTENCES',17,3,NULL),(19,'READING','WRITE_SENTENCES',17,3,NULL),(20,'WRITING','WRITE_SENTENCES',6,3,NULL),(21,'WRITING','WRITE_SENTENCES',6,3,NULL),(22,'LISTENING','REVIEW_FLASHCARDS',9,3,NULL),(23,'READING','WRITE_SENTENCES',14,3,NULL),(24,'READING','WRITE_SENTENCES',14,3,NULL),(25,'READING','WRITE_SENTENCES',14,3,NULL),(26,'LISTENING','WRITE_SENTENCES',10,3,NULL),(27,'LISTENING','WRITE_SENTENCES',14,3,NULL),(28,'LISTENING','WRITE_SENTENCES',14,3,NULL),(29,'READING','REVIEW_FLASHCARDS',5,3,NULL),(30,'WRITING','REVIEW_FLASHCARDS',5,5,NULL),(31,'SPEAKING','WRITE_SENTENCES',5,5,NULL),(32,'WRITING','WRITE_SENTENCES',20,5,NULL),(33,'WRITING','WRITE_SENTENCES',20,5,NULL),(34,'WRITING','WRITE_SENTENCES',20,5,NULL),(35,'SPEAKING','REVIEW_FLASHCARDS',6,5,NULL),(36,'SPEAKING','REVIEW_FLASHCARDS',16,5,NULL),(37,'WRITING','REVIEW_FLASHCARDS',15,5,'LISTENING,SPEAKING,READING'),(38,'READING','REVIEW_FLASHCARDS',13,5,'LISTENING,VOCABULARY,SPEAKING');
/*!40000 ALTER TABLE `user_goals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_profile`
--

DROP TABLE IF EXISTS `user_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_profile` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `preference` varchar(255) DEFAULT NULL,
  `time_selected` int DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_profile_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_profile`
--

LOCK TABLES `user_profile` WRITE;
/*!40000 ALTER TABLE `user_profile` DISABLE KEYS */;
INSERT INTO `user_profile` VALUES (1,'Leïla','A2','Reading',20,3),(2,'Leïla','A2','Reading',20,3),(3,'Leïla','A2','Reading',20,3),(4,'Iman','B2','Auditory',10,5),(5,'Leïla','None','None',15,3),(6,'leila sahnoun','None','None',15,3),(7,'Leïla','None','None',15,3),(8,'Leïla','None','None',15,3),(9,'Leïla','None','None',15,3),(10,'Leïla','None','None',15,3),(11,'Leïla','None','None',15,3),(12,'Leïla','None','None',15,3),(13,'Leïla','None','None',15,3),(14,'Leïla','None','None',15,3),(15,'Leïla','None','None',15,3),(16,'Leïla','None','None',15,3),(17,'Leïla','None','None',15,3),(18,'Leïla','None','None',15,3),(19,'Leïla','None','None',15,3),(20,'Leïla','None','None',15,3),(21,'Leïla','None','None',15,3),(22,'Leïla','None','None',15,3),(23,'Leïla','None','None',15,3),(24,'Leïla','None','None',15,3),(25,'Leïla','None','None',15,3),(26,'Leïla','None','None',15,3),(27,'Leïla','None','None',15,3),(28,'Leïla','None','None',15,3),(29,'Leïla','None','None',15,3),(30,'Leïla','None','None',15,3),(31,'Leïla','None','None',15,3),(32,'Leïla','None','None',15,3),(33,'leila','B2+','Visual',30,3),(34,'leila','None','None',15,3),(35,'lei','None','None',15,3),(36,'leilâ','None','None',20,3),(37,'Laila','None','None',15,3),(38,'Leïla','None','None',15,3),(39,'lllll','None','None',15,3),(40,'hhhh','None','None',15,3),(41,'nn','None','None',30,3),(42,'jj','None','None',15,3),(43,'ggg','None','None',15,3),(44,'gg','None','None',15,3),(45,'uhhh','None','None',15,3),(46,'kgkgkg','None','None',15,3),(47,'hgghhg','None','None',15,3),(48,'Leïlà','None','None',15,3),(49,'leil','None','None',15,3),(50,'iman','A2','Auditory',20,5),(51,'imane','None','None',15,5),(52,'iman21','None','None',10,5),(53,'Imane','B1','Reading',25,5),(54,'iman','None','None',15,5),(55,'Imane','None','None',15,5),(56,'Leïla','None','None',15,5),(57,'iman','None','None',15,5),(58,'imanl','None','None',15,5),(59,'imañn','None','None',15,5),(60,'jkjhh','None','None',15,5),(61,'imannn','A1','Visual',10,5),(62,'imane','A2','Reading',20,5);
/*!40000 ALTER TABLE `user_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,NULL,'leila@test.com','1234'),(3,NULL,'shnnleila147@gmail.com','loulou2004'),(5,NULL,'imansahnoun80@gmail.com','iman21');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-01-12 22:21:30
