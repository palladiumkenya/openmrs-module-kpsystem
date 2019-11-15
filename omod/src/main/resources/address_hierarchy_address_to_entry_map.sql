-- MySQL dump 10.13  Distrib 5.6.44, for Win64 (x86_64)
--
-- Host: localhost    Database: openmrs
-- ------------------------------------------------------
-- Server version	5.6.44-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address_hierarchy_address_to_entry_map`
--

DROP TABLE IF EXISTS `address_hierarchy_address_to_entry_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address_hierarchy_address_to_entry_map` (
  `address_to_entry_map_id` int(11) NOT NULL AUTO_INCREMENT,
  `address_id` int(11) NOT NULL,
  `entry_id` int(11) NOT NULL,
  `uuid` char(38) NOT NULL,
  PRIMARY KEY (`address_to_entry_map_id`),
  KEY `address_id_to_person_address_table` (`address_id`),
  KEY `entry_id_to_address_hierarchy_table` (`entry_id`),
  CONSTRAINT `address_id_to_person_address_table` FOREIGN KEY (`address_id`) REFERENCES `person_address` (`person_address_id`),
  CONSTRAINT `entry_id_to_address_hierarchy_table` FOREIGN KEY (`entry_id`) REFERENCES `address_hierarchy_entry` (`address_hierarchy_entry_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_hierarchy_address_to_entry_map`
--

LOCK TABLES `address_hierarchy_address_to_entry_map` WRITE;
/*!40000 ALTER TABLE `address_hierarchy_address_to_entry_map` DISABLE KEYS */;
INSERT INTO `address_hierarchy_address_to_entry_map` VALUES (1,1,1673,'b3c2b7e9-8c62-44ec-b69e-5ee342f6beb2'),(2,7,1673,'e84a7a55-e808-4d6f-92c9-da78dd4212ef'),(3,78,1677,'3e4a58cf-e8c6-4dbf-b6a8-ef2932e31ef3'),(4,107,1676,'41c2076b-226c-4dd0-87a3-659326c5e117'),(5,109,1677,'85d76081-d982-4863-8bda-1b699f821a71'),(6,121,1673,'0d3105d8-a482-47e7-a232-88ce4986db54'),(7,135,1669,'c034ce98-6c35-4dc5-b90b-43a150a4f723');
/*!40000 ALTER TABLE `address_hierarchy_address_to_entry_map` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-12 15:34:30
