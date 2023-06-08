-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `compras_ventas`
--

DROP TABLE IF EXISTS `compras_ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compras_ventas` (
  `idCompras_ventas` int NOT NULL AUTO_INCREMENT,
  `precio_total` decimal(10,0) NOT NULL,
  `fecha_cv` date NOT NULL,
  `descripcionEstado` varchar(45) NOT NULL,
  `cantidad` int NOT NULL,
  `Estados_idEstados` int NOT NULL,
  `Juegos_idJuegos` int NOT NULL,
  `compra_o_venta` tinyint NOT NULL,
  `descripcionJuego` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCompras_ventas`),
  KEY `fk_Compras_ventas_Estados1_idx` (`Estados_idEstados`),
  KEY `fk_Compras_ventas_Juegos1_idx` (`Juegos_idJuegos`),
  CONSTRAINT `fk_Compras_ventas_Estados1` FOREIGN KEY (`Estados_idEstados`) REFERENCES `estados` (`idEstados`),
  CONSTRAINT `fk_Compras_ventas_Juegos1` FOREIGN KEY (`Juegos_idJuegos`) REFERENCES `juegos` (`idJuegos`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras_ventas`
--

LOCK TABLES `compras_ventas` WRITE;
/*!40000 ALTER TABLE `compras_ventas` DISABLE KEYS */;
INSERT INTO `compras_ventas` VALUES (1,100,'2023-06-04','Juego de Mundo Abierto',1,2,112,0,'Entregado'),(2,50,'2023-06-04','Juego de Cubos',1,2,106,1,NULL),(3,107,'2023-06-04','Juego de hacer lo que quieras',1,2,107,0,'Entregado'),(4,107,'2023-06-04','Juego de hacer lo que quieras',1,1,107,1,NULL),(5,50,'2023-06-04','Juego facil',2,3,109,1,'Demasiado Caro Cambiar precio por $30'),(6,40,'2023-06-07','Juego demasiado ezz',1,4,115,1,'Ya nadie lo juega'),(7,30,'2023-06-04','Juego muy complicado',2,2,119,1,NULL),(8,30,'2023-06-04','Juego ez',1,1,119,0,'Recojer en tienda');
/*!40000 ALTER TABLE `compras_ventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras_ventas_has_cuentas`
--

DROP TABLE IF EXISTS `compras_ventas_has_cuentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compras_ventas_has_cuentas` (
  `Compras_ventas_idCompras_ventas` int NOT NULL,
  `Cuentas_idCuentas` int NOT NULL,
  KEY `fk_Compras_ventas_has_Cuentas_Cuentas1_idx` (`Cuentas_idCuentas`),
  KEY `fk_Compras_ventas_has_Cuentas_Compras_ventas1_idx` (`Compras_ventas_idCompras_ventas`),
  CONSTRAINT `fk_Compras_ventas_has_Cuentas_Compras_ventas1` FOREIGN KEY (`Compras_ventas_idCompras_ventas`) REFERENCES `compras_ventas` (`idCompras_ventas`) ON DELETE CASCADE,
  CONSTRAINT `fk_Compras_ventas_has_Cuentas_Cuentas1` FOREIGN KEY (`Cuentas_idCuentas`) REFERENCES `cuentas` (`idCuentas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras_ventas_has_cuentas`
--

LOCK TABLES `compras_ventas_has_cuentas` WRITE;
/*!40000 ALTER TABLE `compras_ventas_has_cuentas` DISABLE KEYS */;
INSERT INTO `compras_ventas_has_cuentas` VALUES (1,100),(2,101),(3,100),(4,100),(5,100),(7,100),(8,100),(6,100);
/*!40000 ALTER TABLE `compras_ventas_has_cuentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consolas`
--

DROP TABLE IF EXISTS `consolas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consolas` (
  `idEtiquetas` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idEtiquetas`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consolas`
--

LOCK TABLES `consolas` WRITE;
/*!40000 ALTER TABLE `consolas` DISABLE KEYS */;
INSERT INTO `consolas` VALUES (1,'PC'),(2,'PlayStation 4'),(3,'PlayStation 5'),(4,'Xbox X'),(5,'Nintendo Switch');
/*!40000 ALTER TABLE `consolas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuentas`
--

DROP TABLE IF EXISTS `cuentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuentas` (
  `idCuentas` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `nickname` varchar(45) NOT NULL,
  `direcion` varchar(50) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `contrasenia` varchar(100) NOT NULL,
  `foto` varchar(100) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `desabilitado` tinyint NOT NULL,
  `Roles_idRoles` int NOT NULL,
  PRIMARY KEY (`idCuentas`),
  UNIQUE KEY `nickname_UNIQUE` (`nickname`),
  UNIQUE KEY `correo_UNIQUE` (`correo`),
  KEY `fk_Cuentas_Roles_idx` (`Roles_idRoles`),
  CONSTRAINT `fk_Cuentas_Roles` FOREIGN KEY (`Roles_idRoles`) REFERENCES `roles` (`idRoles`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentas`
--

LOCK TABLES `cuentas` WRITE;
/*!40000 ALTER TABLE `cuentas` DISABLE KEYS */;
INSERT INTO `cuentas` VALUES (1,'juan','loyola','chaufa','calle Ascent 123','angelo00051@outlook.com','123123',NULL,'jhksdfgds sdfhdsfh hjsdfh',0,1),(2,'renato','delgado','rena','calle icebox','prueba@gmail.com','123123',NULL,'jhksdfgds sdfhdsfh hjsdfh',0,1),(10,'romel','garay','romeo','calle bind','prueba2@gmail.com','123123',NULL,'jhksdfgds sdfh hjsdfh',0,2),(11,'oscar','agreda','osc','calle breeze','prueba3@gmail.com','123123',NULL,'j sdfhdsfh hjsdfh',0,2),(100,'dylan','bustamante','dyl','Jr Zepita','a20180159@pucp.edu.pe','123123',NULL,'Alumno que vive en chosica',0,3),(101,'rodrigo','tinoco','rodri','Huancayork','a2019019@pucp.edu.pe','123123',NULL,'Espero NO jalar IWEB ',0,3),(102,'luciana','iza','eggpotato','calle 7','patata@gmail.com','123123',NULL,'jhksdf hjsdfh',0,3),(103,'María','Gómez','mariag','Avenida 456','mariagomez@example.com','pass456',NULL,'Descripción 2',0,3),(104,'Pedro','López','pedrol','Calle Principal','pedrolopez@example.com','password789',NULL,'Descripción 3',0,3),(105,'Laura','Martínez','lauram','Avenida Central','lauramartinez@example.com','secretword',NULL,'Descripción 4',0,3),(106,'Carlos','Rodríguez','carlosr','Calle Secundaria','carlosrodriguez@example.com','pass1234',NULL,'Descripción 5',0,3),(107,'Ana','Sánchez','anas','Avenida 789','anasanchez@example.com','mypassword',NULL,'Descripción 6',0,3),(108,'Luis','Hernández','luish','Calle Principal','luishernandez@example.com','qwerty123',NULL,'Descripción 7',0,3),(109,'Sofía','García','sofiag','Avenida 555','sofiagarcia@example.com','test123',NULL,'Descripción 8',0,3),(110,'Daniel','Torres','danielt','Calle 999','danieltorres@example.com','password123',NULL,'Descripción 9',0,3),(111,'Marta','Ortega','martaort','Avenida Principal','martaortega@example.com','mypass123',NULL,'Descripción 10',0,3);
/*!40000 ALTER TABLE `cuentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estados`
--

DROP TABLE IF EXISTS `estados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estados` (
  `idEstados` int NOT NULL AUTO_INCREMENT,
  `nombre_estado` varchar(45) NOT NULL,
  PRIMARY KEY (`idEstados`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estados`
--

LOCK TABLES `estados` WRITE;
/*!40000 ALTER TABLE `estados` DISABLE KEYS */;
INSERT INTO `estados` VALUES (1,'pendiente'),(2,'aceptado'),(3,'no aceptado'),(4,'rechazado'),(5,'retirado');
/*!40000 ALTER TABLE `estados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `generos`
--

DROP TABLE IF EXISTS `generos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `generos` (
  `idEtiquetas` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idEtiquetas`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `generos`
--

LOCK TABLES `generos` WRITE;
/*!40000 ALTER TABLE `generos` DISABLE KEYS */;
INSERT INTO `generos` VALUES (1,'1 jugador'),(2,'Multijugador'),(3,'Acción'),(4,'Aventura'),(5,'Estrategia'),(6,'Shooter'),(7,'Deportes'),(8,'Carreras'),(9,'Puzzle'),(10,'Terror'),(11,'Mundo abierto'),(12,'battle royal');
/*!40000 ALTER TABLE `generos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `juegos`
--

DROP TABLE IF EXISTS `juegos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `juegos` (
  `idJuegos` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `precio` decimal(10,0) NOT NULL,
  `descuento` decimal(10,0) NOT NULL,
  `stock` int NOT NULL,
  `foto` varchar(100) NOT NULL,
  `retirar_juego` tinyint NOT NULL,
  `juego_sugerido` tinyint NOT NULL,
  `Cuentas_idCuentas` int DEFAULT NULL,
  PRIMARY KEY (`idJuegos`),
  UNIQUE KEY `foto_UNIQUE` (`foto`),
  KEY `fk_Juegos_Cuentas1_idx` (`Cuentas_idCuentas`,`idJuegos`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `juegos`
--

LOCK TABLES `juegos` WRITE;
/*!40000 ALTER TABLE `juegos` DISABLE KEYS */;
INSERT INTO `juegos` VALUES (100,'Valorant','Juego de disparos casi tan bueno como CSGO',0,0,100,'img/juegos/1valorant.png',0,0,NULL),(101,'dota2','juegazo',0,0,100,'img/juegos/2dota2.jpg',0,0,NULL),(102,'Toontown','juego de farmeo',0,0,100,'img/juegos/3toon.jpg',0,0,NULL),(103,'Call of Duty','shooter',150,0,5,'img/juegos/4callDuty.jpg',0,0,NULL),(104,'Beyond two souls ','Beyond: Two Souls es un videojuego de drama interactivo, desarrollado por Quantic Dream y distribuido por Sony',120,20,100,'img/juegos/5beyond.jpg',0,0,NULL),(105,'The Legend of Zelda: Breath of the Wild','Videojuego de aventuras',180,10,50,'img/juegos/6zelda.jpg',0,0,NULL),(106,'Minecraft','Juego de construcción y aventura',50,0,200,'img/juegos/7mine.jpg',0,0,NULL),(107,'Grand Theft Auto V','Videojuego de acción y mundo abierto',200,25,20,'img/juegos/8gta5.jpg',0,0,NULL),(108,'FIFA 22','Videojuego de fútbol',60,0,30,'img/juegos/9fifa.jpeg',0,0,NULL),(109,'Assassins Creed Valhalla','Videojuego de acción y aventura',140,15,15,'img/juegos/10assa.jpg',0,0,100),(110,'Animal Crossing: New Horizons','Videojuego de simulación de vida',60,0,10,'img/juegos/11animal.jpg',0,0,NULL),(111,'Super Mario Odyssey','Videojuego de plataformas',50,0,50,'img/juegos/12mario.jpg',0,0,NULL),(112,'The Witcher 3: Wild Hunt','Videojuego de rol y acción',40,10,25,'img/juegos/13witcher.jpg',0,0,100),(113,'Fortnite','Videojuego de Battle Royale',100,0,100,'img/juegos/14fortnite.jpg',0,0,NULL),(114,'Red Dead Redemption 2','Videojuego de acción y mundo abierto',60,0,40,'img/juegos/15reddead.jpg',0,0,NULL),(115,'Pokemon','Videojuego de Pokemon',60,0,1,'img/juegos/16pokemon.png',0,0,NULL),(116,'The Last of Us Part II','Videojuego de acción y aventura',70,0,20,'img/juegos/17lastofus.jpg',0,0,NULL),(117,'Overwatch','Videojuego de disparos en equipo',40,0,50,'img/juegos/18over.jpg',0,0,NULL),(118,'Resident Evil Village','Videojuego de terror y supervivencia',50,0,15,'img/juegos/19resident.jpg',0,0,NULL),(119,'Splatoon 2','Videojuego de disparos y acción',40,0,40,'img/juegos/20spla.jpg',0,0,100),(120,'Final Fantasy VII Remake','Videojuego de rol y aventuras',60,0,25,'img/juegos/21final.jpg',0,0,NULL);
/*!40000 ALTER TABLE `juegos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `juegos_has_consolas`
--

DROP TABLE IF EXISTS `juegos_has_consolas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `juegos_has_consolas` (
  `Juegos_idJuegos` int NOT NULL,
  `Consolas_idEtiquetas` int NOT NULL,
  PRIMARY KEY (`Juegos_idJuegos`,`Consolas_idEtiquetas`),
  KEY `fk_Juegos_has_Consolas_Consolas1_idx` (`Consolas_idEtiquetas`),
  KEY `fk_Juegos_has_Consolas_Juegos1_idx` (`Juegos_idJuegos`),
  CONSTRAINT `fk_Juegos_has_Consolas_Consolas1` FOREIGN KEY (`Consolas_idEtiquetas`) REFERENCES `consolas` (`idEtiquetas`),
  CONSTRAINT `fk_Juegos_has_Consolas_Juegos1` FOREIGN KEY (`Juegos_idJuegos`) REFERENCES `juegos` (`idJuegos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `juegos_has_consolas`
--

LOCK TABLES `juegos_has_consolas` WRITE;
/*!40000 ALTER TABLE `juegos_has_consolas` DISABLE KEYS */;
/*!40000 ALTER TABLE `juegos_has_consolas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `juegos_has_generos`
--

DROP TABLE IF EXISTS `juegos_has_generos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `juegos_has_generos` (
  `Juegos_idJuegos` int NOT NULL,
  `Generos_idEtiquetas` int NOT NULL,
  PRIMARY KEY (`Juegos_idJuegos`,`Generos_idEtiquetas`),
  KEY `fk_Juegos_has_Generos_Generos1_idx` (`Generos_idEtiquetas`),
  KEY `fk_Juegos_has_Generos_Juegos1_idx` (`Juegos_idJuegos`),
  CONSTRAINT `fk_Juegos_has_Generos_Generos1` FOREIGN KEY (`Generos_idEtiquetas`) REFERENCES `generos` (`idEtiquetas`),
  CONSTRAINT `fk_Juegos_has_Generos_Juegos1` FOREIGN KEY (`Juegos_idJuegos`) REFERENCES `juegos` (`idJuegos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `juegos_has_generos`
--

LOCK TABLES `juegos_has_generos` WRITE;
/*!40000 ALTER TABLE `juegos_has_generos` DISABLE KEYS */;
/*!40000 ALTER TABLE `juegos_has_generos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `idRoles` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idRoles`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Manager'),(2,'Administrador'),(3,'Usuario');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-07 19:08:42
