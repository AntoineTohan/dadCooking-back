-- MySQL dump 10.13  Distrib 5.7.29, for Linux (x86_64)
--
-- Host: localhost    Database: dadcooking
-- ------------------------------------------------------
-- Server version	5.7.29

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
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `food` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` VALUES (1,'Farine'),(2,'Sucre'),(3,'Fromage blanc'),(4,'Sucre vanillé'),(5,'Oeufs'),(12,'Beurre'),(13,'Levure chimique'),(14,'Sel'),(23,'Lait'),(24,'Pépites de chocolat');
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (29),(29),(29);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredients`
--

DROP TABLE IF EXISTS `ingredients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingredients` (
  `id` bigint(20) NOT NULL,
  `quantite` int(11) NOT NULL,
  `unite` varchar(255) DEFAULT NULL,
  `food_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqls1de0m5x1knx4epeeefh9pa` (`food_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredients`
--

LOCK TABLES `ingredients` WRITE;
/*!40000 ALTER TABLE `ingredients` DISABLE KEYS */;
INSERT INTO `ingredients` VALUES (6,100,'GRAMME',1),(7,200,'GRAMME',2),(8,1,'KILO',3),(9,20,'GRAMME',4),(10,4,'NONE',5),(15,150,'GRAMME',1),(16,150,'GRAMME',2),(17,125,'GRAMME',12),(18,30,'GRAMME',13),(19,2,'NONE',5),(20,5,'GRAMME',14),(22,70,'GRAMME',2),(25,150,'MILLILITRE',23),(26,50,'GRAMME',12),(27,50,'GRAMME',24);
/*!40000 ALTER TABLE `ingredients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipes`
--

DROP TABLE IF EXISTS `recipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recipes` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `preparation` text,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipes`
--

LOCK TABLES `recipes` WRITE;
/*!40000 ALTER TABLE `recipes` DISABLE KEYS */;
INSERT INTO `recipes` VALUES (11,'Gâteau au fromage blanc','Séparez les jaunes des blancs d’œufs. Tamisez la farine. Beurrez un moule à manqué de 25 cm de diamètre. Préchauffez le four th.5 (150°C).\nEnsuite, battez les jaunes d’œufs, le sucre en poudre et le sucre vanillé (ou le zeste de citron) dans un saladier jusqu’à blanchiment. Ajoutez la farine puis le fromage blanc et mélangez bien. Battez les blancs en neige avec une pincée de sel puis incorporez-les à la spatule, dans la préparation.\nVidez la préparation dans le moule à manqué beurré et enfournez pendant 1 heure. Vérifiez la cuisson du four en plantant un couteau propre au coeur du gâteau. Si le couteau ressort propre, votre gâteau est cuit. Sinon remettez-le au four quelques minutes tout en surveillant la cuisson. Sortez le gâteau du four et laissez-le refroidir dans le moule.'),(21,'Madeleines à la vanille','Préchauffez votre four à 170°C (th.5-6).\nFaites fondre le beurre au micro-ondes.\nCassez les œufs dans un saladier puis battez-les.\nAjoutez-y le sucre avec 1 pincée de sel puis fouettez de manière à ce que le mélange blanchisse.\nAjoutez également la farine et le ½ sachet de levure ainsi que le beurre fondu.\nMélangez minutieusement.\nGarnissez les alvéoles d’un moule à madeleines avec cette pâte.\nEnfournez pendant 15 min.\nRetirez du four puis démoulez les madeleines.\nLaissez-les refroidir puis servez-les.'),(28,'Muffins aux pépites de chocolat','Préchauffez le four à th. 6 (180°).\nMélangez la farine, la levure, le sucre, puis ajoutez les oeufs battus, le beurre fondu, le lait et en dernier les pépites.\nRemplissez des moules à muffins en silicone et enfournez durant 15 minutes. La cuisson est terminée lorsqu\'ils sont légèrement blonds.\nLaissez refroidir à température ambiante.');
/*!40000 ALTER TABLE `recipes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipes_ingredients`
--

DROP TABLE IF EXISTS `recipes_ingredients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recipes_ingredients` (
  `recipes_id` bigint(20) NOT NULL,
  `ingredients_id` bigint(20) NOT NULL,
  KEY `FKlvjx0n917c1o5h1f4uyswgpx7` (`ingredients_id`),
  KEY `FK7nlvtcyl7qjws7gh3h6xbruwi` (`recipes_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipes_ingredients`
--

LOCK TABLES `recipes_ingredients` WRITE;
/*!40000 ALTER TABLE `recipes_ingredients` DISABLE KEYS */;
INSERT INTO `recipes_ingredients` VALUES (11,6),(11,7),(11,8),(11,9),(11,10),(21,9),(21,15),(21,16),(21,17),(21,18),(21,19),(21,20),(28,15),(28,18),(28,22),(28,9),(28,19),(28,25),(28,26),(28,27);
/*!40000 ALTER TABLE `recipes_ingredients` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-17 18:51:31
