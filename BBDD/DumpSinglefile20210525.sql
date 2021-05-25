CREATE DATABASE  IF NOT EXISTS `abeds` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `abeds`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: abeds
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `abedsd_direccion`
--

DROP TABLE IF EXISTS `abedsd_direccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `abedsd_direccion` (
  `id_direccion` int(11) NOT NULL,
  `cod_postal` int(11) DEFAULT NULL,
  `direccion` varchar(250) NOT NULL,
  `municipio` varchar(250) NOT NULL,
  `numero` varchar(50) DEFAULT NULL,
  `observaciones` varchar(250) DEFAULT NULL,
  `provincia` varchar(100) NOT NULL,
  PRIMARY KEY (`id_direccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abedsd_direccion`
--

LOCK TABLES `abedsd_direccion` WRITE;
/*!40000 ALTER TABLE `abedsd_direccion` DISABLE KEYS */;
INSERT INTO `abedsd_direccion` VALUES (1,41510,'Calle Mensones','MAIRENA DEL ALCOR','3',NULL,'SEVILLA');
/*!40000 ALTER TABLE `abedsd_direccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `abedsd_equipo`
--

DROP TABLE IF EXISTS `abedsd_equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `abedsd_equipo` (
  `id_equipo` int(11) NOT NULL,
  `activo` varchar(1) NOT NULL,
  `anno` int(11) NOT NULL,
  `municipio` varchar(250) NOT NULL,
  `nombre_equipo` varchar(250) NOT NULL,
  `num_jugadores` int(11) NOT NULL,
  `id_categoria` int(11) DEFAULT NULL,
  `id_entrenador` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_equipo`),
  KEY `FKcoyaivabepn57wrvm1xf2ppvn` (`id_categoria`),
  KEY `FK62mf2cu2k7oquksbs1mbrpc8y` (`id_entrenador`),
  CONSTRAINT `FK62mf2cu2k7oquksbs1mbrpc8y` FOREIGN KEY (`id_entrenador`) REFERENCES `abedsd_usuario` (`id_usuario`),
  CONSTRAINT `FKcoyaivabepn57wrvm1xf2ppvn` FOREIGN KEY (`id_categoria`) REFERENCES `abedsp_tp_categoria` (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abedsd_equipo`
--

LOCK TABLES `abedsd_equipo` WRITE;
/*!40000 ALTER TABLE `abedsd_equipo` DISABLE KEYS */;
INSERT INTO `abedsd_equipo` VALUES (1,'S',2020,'MAIRENA DEL ALCOR','Mairena Cadete',12,4,2);
/*!40000 ALTER TABLE `abedsd_equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `abedsd_jugador`
--

DROP TABLE IF EXISTS `abedsd_jugador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `abedsd_jugador` (
  `id_jugador` int(11) NOT NULL,
  `dorsal` int(11) DEFAULT NULL,
  `id_categoria` int(11) DEFAULT NULL,
  `id_equipo` int(11) DEFAULT NULL,
  `id_estado` int(11) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_jugador`),
  KEY `FKlmkox7i4er5buiehgkqluinn` (`id_categoria`),
  KEY `FKiohva2w0dj6qxympeavuyoa0l` (`id_equipo`),
  KEY `FK4kj8ajjvthdxnpqmtuc1sxg7i` (`id_estado`),
  KEY `FKo08974ggrrws5px4jg4q0nch6` (`id_usuario`),
  CONSTRAINT `FK4kj8ajjvthdxnpqmtuc1sxg7i` FOREIGN KEY (`id_estado`) REFERENCES `abedsp_estado` (`id_estado`),
  CONSTRAINT `FKiohva2w0dj6qxympeavuyoa0l` FOREIGN KEY (`id_equipo`) REFERENCES `abedsd_equipo` (`id_equipo`),
  CONSTRAINT `FKlmkox7i4er5buiehgkqluinn` FOREIGN KEY (`id_categoria`) REFERENCES `abedsp_tp_categoria` (`id_categoria`),
  CONSTRAINT `FKo08974ggrrws5px4jg4q0nch6` FOREIGN KEY (`id_usuario`) REFERENCES `abedsd_usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abedsd_jugador`
--

LOCK TABLES `abedsd_jugador` WRITE;
/*!40000 ALTER TABLE `abedsd_jugador` DISABLE KEYS */;
INSERT INTO `abedsd_jugador` VALUES (1,12,1,1,1,1);
/*!40000 ALTER TABLE `abedsd_jugador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `abedsd_usuario`
--

DROP TABLE IF EXISTS `abedsd_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `abedsd_usuario` (
  `id_usuario` int(11) NOT NULL,
  `activo` varchar(1) NOT NULL,
  `apellido1` varchar(50) NOT NULL,
  `apellido2` varchar(50) NOT NULL,
  `contrasenna` varchar(255) NOT NULL,
  `email` varchar(250) DEFAULT NULL,
  `nif` varchar(9) DEFAULT NULL,
  `nombre` varchar(50) NOT NULL,
  `nombre_usuario` varchar(150) NOT NULL,
  `telefono1` varchar(12) NOT NULL,
  `telefono2` varchar(12) DEFAULT NULL,
  `id_direccion` int(11) DEFAULT NULL,
  `id_tp_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `FKd2p23uhna2jca99g8m7onv3f0` (`id_direccion`),
  KEY `FK1841iuea3janmknpollfw6lg8` (`id_tp_usuario`),
  CONSTRAINT `FK1841iuea3janmknpollfw6lg8` FOREIGN KEY (`id_tp_usuario`) REFERENCES `abedsp_tp_usuario` (`id_tp_usuario`),
  CONSTRAINT `FKd2p23uhna2jca99g8m7onv3f0` FOREIGN KEY (`id_direccion`) REFERENCES `abedsd_direccion` (`id_direccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abedsd_usuario`
--

LOCK TABLES `abedsd_usuario` WRITE;
/*!40000 ALTER TABLE `abedsd_usuario` DISABLE KEYS */;
INSERT INTO `abedsd_usuario` VALUES (1,'S','LOPEZ','GONZALEZ','josete','gepettometal@hotmail.com','47003115Q','JOSE MANUEL','Josete','627993624','955943429',1,1),(2,'S','GOMEZ','AZORIN','encarna','lopezgonzalezjose7@gmail.com','56332145L','ENCARNA','Encarna','984352317',NULL,1,2);
/*!40000 ALTER TABLE `abedsd_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `abedsp_estado`
--

DROP TABLE IF EXISTS `abedsp_estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `abedsp_estado` (
  `id_estado` int(11) NOT NULL,
  `cod_estado` int(11) NOT NULL,
  `nombre_estado` varchar(50) NOT NULL,
  `observacion` varchar(250) NOT NULL,
  PRIMARY KEY (`id_estado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abedsp_estado`
--

LOCK TABLES `abedsp_estado` WRITE;
/*!40000 ALTER TABLE `abedsp_estado` DISABLE KEYS */;
INSERT INTO `abedsp_estado` VALUES (1,1,'ALTA','Esta en Alta'),(2,2,'BAJA','Esta en Baja'),(3,3,'SANCIONADO','Esta sancionado'),(4,4,'EXPULSADO','Ha sido expulsado del campeonato');
/*!40000 ALTER TABLE `abedsp_estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `abedsp_tp_categoria`
--

DROP TABLE IF EXISTS `abedsp_tp_categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `abedsp_tp_categoria` (
  `id_categoria` int(11) NOT NULL,
  `cod_categoria` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `obervacion` varchar(250) NOT NULL,
  `orden_categoria` int(11) NOT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abedsp_tp_categoria`
--

LOCK TABLES `abedsp_tp_categoria` WRITE;
/*!40000 ALTER TABLE `abedsp_tp_categoria` DISABLE KEYS */;
INSERT INTO `abedsp_tp_categoria` VALUES (1,'ALE','ALEVIN','Alevin (10 y 11  años)',3),(2,'BEN','BENJAMIN','Benjamin( 8 y 9 años)',2),(3,'INF','INFANTIL','Infantil (12 y 13 años)',4),(4,'PBEN','PREBENJAMIN','PreBenjamin (5,6 y 7 años)',1),(5,'CAD','CADETA','Cadete (14 y 15 años)',5),(6,'JUV','JUVENIL','Juvenil (16,17 y 18 años)',6);
/*!40000 ALTER TABLE `abedsp_tp_categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `abedsp_tp_usuario`
--

DROP TABLE IF EXISTS `abedsp_tp_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `abedsp_tp_usuario` (
  `id_tp_usuario` int(11) NOT NULL,
  `cod_tipo_usuario` varchar(10) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `lg_activo` varchar(100) DEFAULT NULL,
  `tipo_usuario` varchar(100) NOT NULL,
  PRIMARY KEY (`id_tp_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abedsp_tp_usuario`
--

LOCK TABLES `abedsp_tp_usuario` WRITE;
/*!40000 ALTER TABLE `abedsp_tp_usuario` DISABLE KEYS */;
INSERT INTO `abedsp_tp_usuario` VALUES (1,'ADMIN','Tipo de administrador	','S','ADMINISTRADOR'),(2,'ARB','Arbitro','S','ADMIN'),(3,'JUG','Jugador de equipo	','S','JUG'),(4,'ENT','Entrenador de equipo	','S','ENT'),(5,'RES_SEDE','Responsable de la sede	','S','RES_SEDE');
/*!40000 ALTER TABLE `abedsp_tp_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-25  8:35:32
