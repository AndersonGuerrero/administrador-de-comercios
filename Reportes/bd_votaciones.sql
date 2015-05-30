-- MySQL dump 10.13  Distrib 5.5.41, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: bd_votaciones
-- ------------------------------------------------------
-- Server version	5.5.41-0ubuntu0.14.04.1-log

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
-- Table structure for table `candidatos`
--

DROP TABLE IF EXISTS `candidatos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `candidatos` (
  `nombres` varchar(30) NOT NULL,
  `Apellido` varchar(30) NOT NULL,
  `Descripcion` varchar(30) NOT NULL,
  `edad` int(11) NOT NULL,
  `mandato` varchar(50) NOT NULL,
  `votos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidatos`
--

LOCK TABLES `candidatos` WRITE;
/*!40000 ALTER TABLE `candidatos` DISABLE KEYS */;
INSERT INTO `candidatos` VALUES ('Anderson Andres','Guerrero Garcia','Candidato PSUV',51,'Nacionales',9),('Pedro Jose','Alvares Sumosa','Patria Segura',55,'Nacionales',6),('Ricardo Jose','Garcia perez','Mas Atencion medica para el pu',44,'Nacionales',3),('Samuel Josue','Agraz Gonzalez','Mejorar las calles',39,'Nacionales',2),('Genesis Alejandra','Guerrero Garcia','Para una patria MEJORR',35,'Nacionales',1),('Maria Carolina','Hernandez Alvarado','Patria Para Todos',49,'Estadales',0),('Alexander Rafael','Andrade Caseres','PUeblo Seguro y Firme',52,'Estadales',0),('Maira Elizabeth','Aguirre Castro','Union Social',60,'Estadales',2),('Luisana Maria','Soto Garcia','PSUV',25,'Estadales',0),('Yosley Secilia','Monoga Leon','PSUV',57,'Estadales',0),('Yeferson Jose','Facundes Rosales','Por Una patria Limpia',59,'Municipales',0),('Maria Rosmary','Mejias Garcia','Todo Juntos PODEMOS',62,'Municipales',0),('Damarys Luisangelis','Lugo Sarmiento','Patri Unida Socialista',48,'Municipales',0),('Paola Lesly','Perez Gonzalez','PSUV',31,'Municipales',0),('Juan David','Garcia Guerrero','Candidato del PSUV',72,'Municipales',0);
/*!40000 ALTER TABLE `candidatos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-02-18 16:36:44
