CREATE DATABASE  IF NOT EXISTS `basetransporte` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `basetransporte`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: basetransporte
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bus`
--

DROP TABLE IF EXISTS `bus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bus` (
  `id_bus` int(15) NOT NULL,
  `capacidad` int(11) DEFAULT NULL,
  `matricula` varchar(45) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `choferid` int(15) NOT NULL,
  `categoriaid` int(15) NOT NULL,
  `terminaldestinoid` int(15) NOT NULL,
  `terminalorigenid` int(15) NOT NULL,
  PRIMARY KEY (`id_bus`,`choferid`,`categoriaid`,`terminaldestinoid`,`terminalorigenid`),
  UNIQUE KEY `matricula_UNIQUE` (`matricula`),
  KEY `fk_Bus_Chofer_idx` (`choferid`),
  KEY `fk_Bus_Terminal1_idx` (`terminaldestinoid`),
  KEY `fk_Bus_TerminalOrigen1_idx` (`terminalorigenid`),
  KEY `fk_Bus_table11_idx` (`categoriaid`),
  CONSTRAINT `fk_Bus_Chofer` FOREIGN KEY (`choferid`) REFERENCES `chofer` (`id_chofer`),
  CONSTRAINT `fk_Bus_Terminal1` FOREIGN KEY (`terminaldestinoid`) REFERENCES `terminaldestino` (`id_terminaldestino`),
  CONSTRAINT `fk_Bus_TerminalOrigen1` FOREIGN KEY (`terminalorigenid`) REFERENCES `terminalorigen` (`id_terminalorigen`),
  CONSTRAINT `fk_Bus_table11` FOREIGN KEY (`categoriaid`) REFERENCES `categoria` (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bus`
--

LOCK TABLES `bus` WRITE;
/*!40000 ALTER TABLE `bus` DISABLE KEYS */;
/*!40000 ALTER TABLE `bus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `categoria` (
  `id_categoria` int(15) NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chofer`
--

DROP TABLE IF EXISTS `chofer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `chofer` (
  `id_chofer` int(15) NOT NULL,
  `cedula_chofer` int(10) DEFAULT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `apellidoMaterno` varchar(30) DEFAULT NULL,
  `apellidoPaterno` varchar(30) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `estadoCivil` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_chofer`),
  UNIQUE KEY `dni_UNIQUE` (`cedula_chofer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chofer`
--

LOCK TABLES `chofer` WRITE;
/*!40000 ALTER TABLE `chofer` DISABLE KEYS */;
/*!40000 ALTER TABLE `chofer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudaddestino`
--

DROP TABLE IF EXISTS `ciudaddestino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ciudaddestino` (
  `id_ciudaddestino` int(15) NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `codigoPostal` varchar(20) DEFAULT NULL,
  `provincia` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_ciudaddestino`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudaddestino`
--

LOCK TABLES `ciudaddestino` WRITE;
/*!40000 ALTER TABLE `ciudaddestino` DISABLE KEYS */;
/*!40000 ALTER TABLE `ciudaddestino` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudadorigen`
--

DROP TABLE IF EXISTS `ciudadorigen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ciudadorigen` (
  `id_ciudadorigen` int(15) NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `codigoPostal` varchar(20) DEFAULT NULL,
  `provincia` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_ciudadorigen`),
  UNIQUE KEY `codigoPostal_UNIQUE` (`codigoPostal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudadorigen`
--

LOCK TABLES `ciudadorigen` WRITE;
/*!40000 ALTER TABLE `ciudadorigen` DISABLE KEYS */;
/*!40000 ALTER TABLE `ciudadorigen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pasaje`
--

DROP TABLE IF EXISTS `pasaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pasaje` (
  `id_pasaje` int(15) NOT NULL,
  `horasalida` varchar(10) DEFAULT NULL,
  `fechasalida` date DEFAULT NULL,
  `estado` varchar(15) DEFAULT NULL,
  `busid` int(15) NOT NULL,
  PRIMARY KEY (`id_pasaje`,`busid`),
  KEY `fk_Pasaje_Bus1_idx` (`busid`),
  CONSTRAINT `fk_Pasaje_Bus1` FOREIGN KEY (`busid`) REFERENCES `bus` (`id_bus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pasaje`
--

LOCK TABLES `pasaje` WRITE;
/*!40000 ALTER TABLE `pasaje` DISABLE KEYS */;
/*!40000 ALTER TABLE `pasaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pasajero`
--

DROP TABLE IF EXISTS `pasajero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pasajero` (
  `cedula` int(10) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `apellidoMaterno` varchar(30) DEFAULT NULL,
  `apellidoPaterno` varchar(30) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  PRIMARY KEY (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pasajero`
--

LOCK TABLES `pasajero` WRITE;
/*!40000 ALTER TABLE `pasajero` DISABLE KEYS */;
/*!40000 ALTER TABLE `pasajero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rol` (
  `idrol` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idrol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `terminaldestino`
--

DROP TABLE IF EXISTS `terminaldestino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `terminaldestino` (
  `id_terminaldestino` int(15) NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `ciudaddestinoid` int(15) NOT NULL,
  PRIMARY KEY (`id_terminaldestino`,`ciudaddestinoid`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `fk_TerminalDestino_CiudadDestino1_idx` (`ciudaddestinoid`),
  CONSTRAINT `fk_TerminalDestino_CiudadDestino1` FOREIGN KEY (`ciudaddestinoid`) REFERENCES `ciudaddestino` (`id_ciudaddestino`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `terminaldestino`
--

LOCK TABLES `terminaldestino` WRITE;
/*!40000 ALTER TABLE `terminaldestino` DISABLE KEYS */;
/*!40000 ALTER TABLE `terminaldestino` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `terminalorigen`
--

DROP TABLE IF EXISTS `terminalorigen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `terminalorigen` (
  `id_terminalorigen` int(15) NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `ciudadorigenid` int(15) NOT NULL,
  PRIMARY KEY (`id_terminalorigen`,`ciudadorigenid`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `fk_TerminalOrigen_Ciudad1_idx` (`ciudadorigenid`),
  CONSTRAINT `fk_TerminalOrigen_Ciudad1` FOREIGN KEY (`ciudadorigenid`) REFERENCES `ciudadorigen` (`id_ciudadorigen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `terminalorigen`
--

LOCK TABLES `terminalorigen` WRITE;
/*!40000 ALTER TABLE `terminalorigen` DISABLE KEYS */;
/*!40000 ALTER TABLE `terminalorigen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `nusuario` varchar(45) DEFAULT NULL,
  `contraseña` varchar(64) DEFAULT NULL,
  `rol` varchar(45) DEFAULT NULL,
  `rol_idrol` int(11) NOT NULL,
  PRIMARY KEY (`idusuario`,`rol_idrol`),
  KEY `fk_usuario_rol1_idx` (`rol_idrol`),
  CONSTRAINT `fk_usuario_rol1` FOREIGN KEY (`rol_idrol`) REFERENCES `rol` (`idrol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventapasaje`
--

DROP TABLE IF EXISTS `ventapasaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ventapasaje` (
  `id_ventapasaje` int(15) NOT NULL,
  `fecha` date DEFAULT NULL,
  `precio` decimal(9,2) DEFAULT NULL,
  `asiento` int(11) NOT NULL,
  `pasajeid` int(15) NOT NULL,
  `dni` int(15) NOT NULL,
  PRIMARY KEY (`id_ventapasaje`,`pasajeid`,`dni`),
  UNIQUE KEY `asiento_UNIQUE` (`asiento`),
  KEY `fk_VentaPasaje_Pasaje1_idx` (`pasajeid`),
  KEY `fk_VentaPasaje_Pasajero1_idx` (`dni`),
  CONSTRAINT `fk_VentaPasaje_Pasaje1` FOREIGN KEY (`pasajeid`) REFERENCES `pasaje` (`id_pasaje`),
  CONSTRAINT `fk_VentaPasaje_Pasajero1` FOREIGN KEY (`dni`) REFERENCES `pasajero` (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventapasaje`
--

LOCK TABLES `ventapasaje` WRITE;
/*!40000 ALTER TABLE `ventapasaje` DISABLE KEYS */;
/*!40000 ALTER TABLE `ventapasaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'basetransporte'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-25 23:52:40
