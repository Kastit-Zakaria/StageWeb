-- MariaDB dump 10.19  Distrib 10.4.32-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: stage_demo
-- ------------------------------------------------------
-- Server version	10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `enfant`
--

DROP TABLE IF EXISTS `enfant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enfant` (
  `date_naissance` date NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `sexe` enum('F','M') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enfant`
--

LOCK TABLES `enfant` WRITE;
/*!40000 ALTER TABLE `enfant` DISABLE KEYS */;
INSERT INTO `enfant` (`date_naissance`, `id`, `nom`, `prenom`, `sexe`) VALUES ('2020-10-10',1,'Durand','Lucas','M'),('2009-10-10',2,'Costa','Chloé','F'),('2022-03-14',3,'Lambert','Emma','F'),('2018-06-02',4,'Dubois','Noah','M'),('2016-09-21',5,'Peeters','Louise','F'),('2014-01-30',6,'Martin','Hugo','M'),('2012-05-17',7,'D\'Hondt','Léa','F'),('2011-08-08',8,'Lefèvre','Nathan','M'),('2019-04-25',9,'Janssens','Zoé','F'),('2023-02-11',10,'Benali','Yanis','M');
/*!40000 ALTER TABLE `enfant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscription`
--

DROP TABLE IF EXISTS `inscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inscription` (
  `enfant_id` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paye` bit(1) NOT NULL,
  `stage_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKnv3d5nhqugby4qfb7ovr8m61o` (`enfant_id`,`stage_id`),
  KEY `FK1dhcqs9gvxhe7myd7nx3ko8jp` (`stage_id`),
  CONSTRAINT `FK1dhcqs9gvxhe7myd7nx3ko8jp` FOREIGN KEY (`stage_id`) REFERENCES `stage` (`id`),
  CONSTRAINT `FKt1dtysbbuk15u2e7c79dyem57` FOREIGN KEY (`enfant_id`) REFERENCES `enfant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscription`
--

LOCK TABLES `inscription` WRITE;
/*!40000 ALTER TABLE `inscription` DISABLE KEYS */;
INSERT INTO `inscription` (`enfant_id`, `id`, `paye`, `stage_id`) VALUES (2,5,0x01,1),(3,6,0x01,4),(10,7,0x00,4),(1,8,0x01,4),(1,9,0x00,5),(4,10,0x01,5),(9,11,0x01,2),(5,12,0x00,6),(6,13,0x01,3),(7,14,0x00,1),(8,15,0x01,6),(4,16,0x00,2);
/*!40000 ALTER TABLE `inscription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stage`
--

DROP TABLE IF EXISTS `stage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stage` (
  `age_max` int(11) NOT NULL,
  `age_min` int(11) NOT NULL,
  `date_deb` date NOT NULL,
  `date_fin` date NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prix` int(11) NOT NULL,
  `denom` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKi1nni3gfm5kx7whqga9yp2ml6` (`denom`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stage`
--

LOCK TABLES `stage` WRITE;
/*!40000 ALTER TABLE `stage` DISABLE KEYS */;
INSERT INTO `stage` (`age_max`, `age_min`, `date_deb`, `date_fin`, `id`, `prix`, `denom`) VALUES (18,12,'2027-02-22','2027-02-26',1,20,'Sport'),(16,7,'2026-12-21','2026-12-24',2,15,'Lecture'),(18,12,'2027-04-26','2027-04-30',3,30,'Natation'),(6,3,'2026-12-28','2026-12-31',4,60,'Éveil musical'),(11,6,'2027-08-09','2027-08-13',5,75,'Atelier d\'arts plastiques'),(15,9,'2027-07-12','2027-07-16',6,150,'Équitation');
/*!40000 ALTER TABLE `stage` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed
