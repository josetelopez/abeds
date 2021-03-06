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
  `id_dirección` int(11) NOT NULL,
  `direccion` varchar(250) NOT NULL,
  `numero` varchar(50) DEFAULT NULL,
  `cod_postal` int(11) NOT NULL,
  `municipio` varchar(250) NOT NULL,
  `provincia` varchar(250) NOT NULL,
  `observaciones` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id_dirección`),
  UNIQUE KEY `idabedsd_direccion_UNIQUE` (`id_dirección`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abedsd_direccion`
--

LOCK TABLES `abedsd_direccion` WRITE;
/*!40000 ALTER TABLE `abedsd_direccion` DISABLE KEYS */;
INSERT INTO `abedsd_direccion` VALUES (1,'calle mensones','23',41510,'MAIRENA DEL ALCOR','SEVILLA',NULL),(2,'calle Leon XIII','7',41510,'MAIRENA DEL ALCOR','SEVILLA',NULL);
/*!40000 ALTER TABLE `abedsd_direccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `abedsd_usuario`
--

DROP TABLE IF EXISTS `abedsd_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `abedsd_usuario` (
  `id_usuario` int(11) NOT NULL,
  `id_tipo_usuario` int(11) NOT NULL,
  `nombreUsuario` varchar(50) NOT NULL,
  `constrasenna` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido1` varchar(50) NOT NULL,
  `apellido2` varchar(50) NOT NULL,
  `nif` varchar(9) DEFAULT NULL,
  `id_direccion` int(11) NOT NULL,
  `activo` varchar(1) NOT NULL,
  `telefono1` varchar(12) NOT NULL,
  `telefono2` varchar(12) DEFAULT NULL,
  `email` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `id_usuario_UNIQUE` (`id_usuario`),
  KEY `id_tipo_usuario_idx` (`id_tipo_usuario`),
  KEY `id_direccion_idx` (`id_direccion`),
  CONSTRAINT `id_direccion` FOREIGN KEY (`id_direccion`) REFERENCES `abedsd_direccion` (`id_dirección`),
  CONSTRAINT `id_tipo_usuario` FOREIGN KEY (`id_tipo_usuario`) REFERENCES `abedsp_tp_usuario` (`id_tp_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abedsd_usuario`
--

LOCK TABLES `abedsd_usuario` WRITE;
/*!40000 ALTER TABLE `abedsd_usuario` DISABLE KEYS */;
INSERT INTO `abedsd_usuario` VALUES (1,1,'josete','josete','Jose Manuel','Lopez ','Gonzalez','47003115Q',1,'S','627993624','654322123','gepettometal@hotmail.com');
/*!40000 ALTER TABLE `abedsd_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `abedsp_tp_usuario`
--

DROP TABLE IF EXISTS `abedsp_tp_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `abedsp_tp_usuario` (
  `id_tp_usuario` int(11) NOT NULL COMMENT 'Identificador del tipo de usuario\n',
  `tipo_usuario` varchar(100) NOT NULL COMMENT 'Nombre \ndel tipo de usuario',
  `cod_tipo_usuario` varchar(10) NOT NULL COMMENT 'Codigo del tipo de usuario\n',
  `descripcion` varchar(250) DEFAULT NULL COMMENT 'Descripcion del usuario\n',
  `lg_activo` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id_tp_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abedsp_tp_usuario`
--

LOCK TABLES `abedsp_tp_usuario` WRITE;
/*!40000 ALTER TABLE `abedsp_tp_usuario` DISABLE KEYS */;
INSERT INTO `abedsp_tp_usuario` VALUES (1,'ADMINISTRADOR','ADMIN','Tipo de administrador','S'),(2,'ARBITRO','ARB','Arbitro','S'),(3,'JUGADOR','JUG','Jugador de equipo','S'),(4,'ENTRENADOR','ENT','Entrenador de equipo','S'),(5,'RESPONSABLE SEDE','RES_SEDE','Responsable de la sede','S');
/*!40000 ALTER TABLE `abedsp_tp_usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-20 11:02:10
