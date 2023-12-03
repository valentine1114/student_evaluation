-- MySQL dump 10.13  Distrib 8.0.32, for macos13 (arm64)
--
-- Host: 8.130.99.18    Database: stu_evaluation
-- ------------------------------------------------------
-- Server version	8.0.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `node`
--

DROP TABLE IF EXISTS `node`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `node` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `node_path` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `node`
--

LOCK TABLES `node` WRITE;
/*!40000 ALTER TABLE `node` DISABLE KEYS */;
INSERT INTO `node` VALUES (1,NULL,'/StudentEvaluation/personalSummary'),(2,NULL,'/StudentEvaluation/gpa'),(3,NULL,'/StudentEvaluation/research'),(4,NULL,'/StudentEvaluation/backbone'),(5,NULL,'/StudentEvaluation/socialPractice'),(6,NULL,'/StudentEvaluation/volunteer'),(7,NULL,'/Scoring/personalSummary'),(8,NULL,'/Scoring/gpa'),(9,NULL,'/Scoring/research'),(10,NULL,'/Scoring/backbone'),(11,NULL,'/Scoring/socialPractice'),(12,NULL,'/Scoring/volunteer'),(13,NULL,'/Scoring/personalSummaryList'),(14,NULL,'/Scoring/gpaList'),(15,NULL,'/Scoring/researchList'),(16,NULL,'/Scoring/backboneList'),(17,NULL,'/Scoring/socialPracticeList'),(18,NULL,'/Scoring/volunteerList'),(19,NULL,'/sums/summary'),(20,NULL,'/sums/lists');
/*!40000 ALTER TABLE `node` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `research`
--

DROP TABLE IF EXISTS `research`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `research` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `StudentID` int DEFAULT NULL,
  `Time` date DEFAULT NULL,
  `Type` enum('论文','比赛','专利','其他') COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Content` varchar(300) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Opinion` varchar(300) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `uploadUrl` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `StudentID` (`StudentID`),
  CONSTRAINT `research_ibfk_1` FOREIGN KEY (`StudentID`) REFERENCES `student_info` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `research`
--

LOCK TABLES `research` WRITE;
/*!40000 ALTER TABLE `research` DISABLE KEYS */;
INSERT INTO `research` VALUES (1,1,'2023-05-05','论文','2333',NULL,NULL),(2,2,'2023-05-05','比赛','牛',NULL,NULL),(3,3,'2023-05-09','专利','牛牛牛',NULL,NULL),(4,4,'2023-05-28','其他','555',NULL,NULL),(5,4,'2023-05-10','比赛','777',NULL,NULL),(6,2,'2023-05-02','论文','',NULL,NULL),(7,2,'2023-05-02','论文','123',NULL,NULL),(8,2,'2023-05-09','其他','123',NULL,NULL),(9,11,'2023-07-04','论文','q',NULL,NULL),(10,1,'2023-07-02','论文','123',NULL,'http://localhost:8818/uploads/cfab97d6-19e7-4c0f-9f63-61ee5af92210.jpeg'),(11,1,'2023-07-03','论文','123',NULL,'http://localhost:8818/uploads/1fa563e7-1bef-4f0d-be86-c8dd42f8c268.jpeg'),(12,1,'2023-07-03','论文','123',NULL,'http://localhost:8818/uploads/8077fb35-9480-41fa-92c0-62a1412172be.jpeg'),(13,1,'2023-07-02','论文','123',NULL,'http://localhost:8818/uploads/a00055fa-3447-432e-824e-893672448455.jpeg'),(14,1,'2023-07-03','论文','123',NULL,'http://localhost:8818/uploads/59276076-1164-4de4-95f5-fe14c04dab0b.jpeg'),(15,1,'2023-07-02','论文','123',NULL,'http://localhost:8818/uploads/5c45a38d-203f-4146-b417-9ed6f47cbe8f.jpeg'),(16,1,'2023-07-02','比赛','123',NULL,'http://localhost:8818/uploads/d843d066-5e72-438f-93e0-233cf62e8811.jpeg'),(17,1,'2023-07-02','论文','123',NULL,'http://localhost:8818/uploads/a8cf1258-21fa-4869-9970-98acbbda136e.jpeg'),(18,1,'2023-06-29','论文','123',NULL,'http://localhost:8818/uploads/309d8f3f-022a-485a-b417-41f4565508f6.jpeg'),(19,1,'2023-06-29','论文','123',NULL,'http://localhost:8818/uploads/309d8f3f-022a-485a-b417-41f4565508f6.jpeg'),(20,1,'2023-07-03','论文','123',NULL,'http://localhost:8818/uploads/d981ca48-0c9d-4e44-a223-c480c6e7e4d9.jpeg'),(21,1,'2023-07-03','论文','',NULL,'http://localhost:8818/uploads/43e48b35-ed6e-413a-be4c-935a04f22468.jpeg'),(22,1,'2023-07-03','论文','',NULL,'http://localhost:8818/uploads/43e48b35-ed6e-413a-be4c-935a04f22468.jpeg'),(23,1,'2023-07-02','论文','123',NULL,'http://localhost:8818/uploads/45ad7bf4-5db5-4756-bea6-feb533c5627e.jpeg'),(24,1,'2023-07-02','论文','123',NULL,'http://localhost:8818/uploads/8e44e29e-d8a6-4efd-bf8b-5a72057f37cf.jpeg'),(25,1,'2023-07-02','比赛','222',NULL,'http://localhost:8818/uploads/e5dbbd7b-fa6e-4093-8453-9b8bef686abd.JPEG'),(26,1,'2023-07-03','论文','123',NULL,'http://localhost:8818/uploads/9a5d261c-f7e3-42c6-accf-b884915691c0.JPEG'),(27,2,'2023-07-04','专利','12345',NULL,''),(28,1,'2023-07-05','比赛','213',NULL,''),(29,1,'2023-07-05','比赛','12345',NULL,''),(30,1,'2023-07-05','专利','12345',NULL,'');
/*!40000 ALTER TABLE `research` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'student'),(2,'teacher'),(3,'admin'),(4,'sup_admin'),(5,'social_pracice_teacher'),(6,'gpa_teacher'),(7,'volunteer_teacher'),(8,'research_teacher'),(9,'yearly_summary_teacher'),(10,'leadership_teacher');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_node`
--

DROP TABLE IF EXISTS `role_node`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_node` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` int NOT NULL,
  `node_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `node_id` (`node_id`),
  CONSTRAINT `role_node_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `role_node_ibfk_2` FOREIGN KEY (`node_id`) REFERENCES `node` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_node`
--

LOCK TABLES `role_node` WRITE;
/*!40000 ALTER TABLE `role_node` DISABLE KEYS */;
INSERT INTO `role_node` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,1,6),(8,2,7),(9,2,8),(10,2,9),(11,2,10),(12,2,11),(13,2,12),(14,2,13),(15,2,14),(16,2,15),(17,2,16),(18,2,17),(19,2,18),(23,3,19),(24,3,20),(26,4,1),(27,4,2),(28,4,3),(29,4,4),(30,4,5),(31,4,6),(32,4,7),(33,4,8),(34,4,9),(35,4,10),(36,4,11),(37,4,12),(38,4,13),(39,4,14),(40,4,15),(41,4,16),(42,4,17),(43,4,18),(44,4,19),(45,4,20),(46,6,8),(47,6,14),(48,10,10),(49,10,16),(50,8,9),(51,8,15),(52,5,11),(53,5,17),(54,7,12),(55,7,18),(56,9,7),(57,9,13);
/*!40000 ALTER TABLE `role_node` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_uri`
--

DROP TABLE IF EXISTS `role_uri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_uri` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` int NOT NULL,
  `URI_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `URI_id` (`URI_id`),
  CONSTRAINT `role_uri_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `role_uri_ibfk_2` FOREIGN KEY (`URI_id`) REFERENCES `uris` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_uri`
--

LOCK TABLES `role_uri` WRITE;
/*!40000 ALTER TABLE `role_uri` DISABLE KEYS */;
INSERT INTO `role_uri` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,1,6),(7,5,12),(8,6,8),(9,7,11),(10,8,10),(11,9,9),(12,10,13),(13,4,1),(14,4,2),(15,4,3),(16,4,4),(17,4,5),(18,4,6),(19,4,7),(20,4,8),(21,4,9),(22,4,10),(23,4,11),(24,4,12),(25,4,13),(26,5,3),(27,6,6),(28,7,6),(29,8,1),(30,9,2),(31,10,4);
/*!40000 ALTER TABLE `role_uri` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `social_practice`
--

DROP TABLE IF EXISTS `social_practice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `social_practice` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `StudentID` int DEFAULT NULL,
  `Time` date DEFAULT NULL,
  `ActivityTheme` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Organizer` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Position` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Duration` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `StudentID` (`StudentID`),
  CONSTRAINT `social_practice_ibfk_1` FOREIGN KEY (`StudentID`) REFERENCES `student_info` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `social_practice`
--

LOCK TABLES `social_practice` WRITE;
/*!40000 ALTER TABLE `social_practice` DISABLE KEYS */;
INSERT INTO `social_practice` VALUES (1,2,'2023-05-21','<活动主题>','<组织者>','<位置>',7),(2,2,'2023-05-01','1','1','1',2592000),(3,2,'2023-03-27','2','2','2',2),(4,2,'2023-05-01','2','1','1',0),(5,NULL,NULL,NULL,NULL,NULL,NULL),(6,NULL,'2023-05-10','112','111','11111',0);
/*!40000 ALTER TABLE `social_practice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_info`
--

DROP TABLE IF EXISTS `student_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_info` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `student_number` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name_pinyin` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `gender` char(1) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `id_number` varchar(18) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `nation` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ethnicity` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `political_status` enum('共产党员（含预备党员）','共青团员','群众','其他') COLLATE utf8mb4_general_ci DEFAULT NULL,
  `student_type` enum('二学位','专业硕士','工程博士','工学博士','工程管理硕士') COLLATE utf8mb4_general_ci DEFAULT NULL,
  `major` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `role_id` int DEFAULT '1',
  `school` enum('求知一苑','求知二苑','求知三苑','燕南一苑','燕南二苑','燕南三苑','未名一苑','未名二苑','未名三苑','英杰一苑','英杰二苑','英杰三苑','博雅一苑','博雅二苑','博雅三苑','博实苑') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `constraint_unique_number` (`student_number`),
  KEY `fk_role_id` (`role_id`),
  CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_info`
--

LOCK TABLES `student_info` WRITE;
/*!40000 ALTER TABLE `student_info` DISABLE KEYS */;
INSERT INTO `student_info` VALUES (1,'张三','123','Wang Wu','F','11010119920307003X','南京','汉族','1992-03-07','群众','工程博士','机械工程',1,'燕南一苑'),(2,'李四','2','Li Si','F','111111','北京','汉族','1996-06-06','共青团员','二学位','软件工程',1,'求知一苑'),(3,'王五','123458','Wang Wu','F','11010119920307003X','南京','汉族','1992-03-07','群众','工程博士','机械工程',1,'燕南三苑'),(4,'赵六','123459','Zhao Liu','M','11010119930307004X','广州','汉族','1993-03-07','其他','工学博士','电子信息工程',1,'博实苑'),(5,'孙七','123460','Sun Qi','F','11010119940307005X','深圳','汉族','1994-03-07','共产党员（含预备党员）','工程管理硕士','管理科学与工程',1,'未名二苑'),(6,'周八','123461','Zhou Ba','M','11010119950307006X','成都','汉族','1995-03-07','共青团员','二学位','生物医学工程',1,'英杰一苑'),(7,'吴九','123462','Wu Jiu','F','11010119960307007X','武汉','汉族','1996-03-07','群众','专业硕士','环境工程',1,'博雅二苑'),(8,'郑十','123463','Zheng Shi','M','11010119970307008X','杭州','汉族','1997-03-07','其他','工程博士','材料科学与工程',1,'博实苑'),(9,'王明','123464','Wang Ming','F','11010119980307009X','西安','汉族','1998-03-07','共产党员（含预备党员）','工学博士','艺术设计',1,'博实苑'),(10,'张三','1233333','Wang Wu','F','11010119920307003X','南京','汉族','1992-03-07','群众','工程博士','机械工程',1,'博实苑'),(11,'李四','2222','Li Si','F','111111','北京','汉族','1996-06-06','共青团员','二学位','软件工程',1,'求知二苑'),(12,'张三丰A','111111112','Wang Wu','F','11010119920307003X','南京','汉族','1992-03-07','群众','工程博士','机械工程',1,'燕南一苑'),(13,'abc','11222','Wang Wu','F','11010119920307003X','南京','汉族','1992-03-07','群众','工程博士','机械工程',1,'燕南一苑'),(15,'abcd','112222','Wang Wu','F','11010119920307003X','南京','汉族','1992-03-07','群众','工程博士','机械工程',1,'燕南一苑'),(16,'abcd1','11222222','Wang Wu','F','11010119920307003X','南京','汉族','1992-03-07','群众','工程博士','机械工程',1,'燕南一苑'),(17,'abcd12','112222222','Wang Wu','F','11010119920307003X','南京','汉族','1992-03-07','群众','工程博士','机械工程',1,'燕南一苑');
/*!40000 ALTER TABLE `student_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`se`@`localhost`*/ /*!50003 TRIGGER `add_summary_score_trigger` AFTER INSERT ON `student_info` FOR EACH ROW BEGIN
    INSERT INTO summary_scores (studentID) VALUES (NEW.id);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `student_leadership`
--

DROP TABLE IF EXISTS `student_leadership`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_leadership` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `StudentID` int DEFAULT NULL,
  `StartTime` date DEFAULT NULL,
  `Department` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Position` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `StudentID` (`StudentID`),
  CONSTRAINT `student_leadership_ibfk_1` FOREIGN KEY (`StudentID`) REFERENCES `student_info` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_leadership`
--

LOCK TABLES `student_leadership` WRITE;
/*!40000 ALTER TABLE `student_leadership` DISABLE KEYS */;
INSERT INTO `student_leadership` VALUES (1,2,'2023-05-01','我说的','为人'),(2,3,'2023-05-02','多释放','多释放'),(3,4,'2023-05-15','qwe','qwesda'),(11,2,'2023-05-01','2','1'),(12,1,'2023-07-02','123','123');
/*!40000 ALTER TABLE `student_leadership` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_scores`
--

DROP TABLE IF EXISTS `student_scores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_scores` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `StudentID` int DEFAULT NULL,
  `GPA` float DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `StudentID` (`StudentID`),
  CONSTRAINT `student_scores_ibfk_1` FOREIGN KEY (`StudentID`) REFERENCES `student_info` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_scores`
--

LOCK TABLES `student_scores` WRITE;
/*!40000 ALTER TABLE `student_scores` DISABLE KEYS */;
INSERT INTO `student_scores` VALUES (1,1,4.5),(2,2,2.5),(3,3,3.9),(4,4,3.4),(5,5,3.5),(6,6,3.6),(7,7,3.7),(8,8,3.8),(9,9,3.9);
/*!40000 ALTER TABLE `student_scores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summary_scores`
--

DROP TABLE IF EXISTS `summary_scores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `summary_scores` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `StudentID` int DEFAULT NULL,
  `social_practice_score` float DEFAULT NULL,
  `research_score` float DEFAULT NULL,
  `volunteer_score` float DEFAULT NULL,
  `leadership_score` float DEFAULT NULL,
  `gpa_score` float DEFAULT NULL,
  `summary_score` float DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `StudentID` (`StudentID`),
  CONSTRAINT `summary_scores_ibfk_1` FOREIGN KEY (`StudentID`) REFERENCES `student_info` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summary_scores`
--

LOCK TABLES `summary_scores` WRITE;
/*!40000 ALTER TABLE `summary_scores` DISABLE KEYS */;
INSERT INTO `summary_scores` VALUES (1,1,8,100,1,1,3,56),(2,2,5,1,1,1,8,3),(3,3,4,4,NULL,5,NULL,NULL),(4,4,1,5,NULL,NULL,6,NULL),(5,5,10,NULL,NULL,NULL,7,NULL),(6,6,NULL,NULL,NULL,NULL,10,NULL),(7,7,NULL,NULL,NULL,NULL,9,9),(8,8,NULL,NULL,NULL,NULL,NULL,8),(9,9,6,NULL,NULL,NULL,9,NULL),(10,10,NULL,NULL,NULL,NULL,NULL,NULL),(11,11,NULL,NULL,NULL,NULL,NULL,NULL),(12,12,NULL,NULL,NULL,NULL,NULL,NULL),(13,13,NULL,NULL,NULL,NULL,NULL,NULL),(14,15,NULL,NULL,NULL,NULL,NULL,NULL),(15,16,NULL,NULL,NULL,NULL,NULL,NULL),(16,17,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `summary_scores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `id` int NOT NULL AUTO_INCREMENT,
  `job_number` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'10000','超级管理员',4),(2,'10001','王老师',8);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uris`
--

DROP TABLE IF EXISTS `uris`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `uris` (
  `id` int NOT NULL,
  `node_URI` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uris`
--

LOCK TABLES `uris` WRITE;
/*!40000 ALTER TABLE `uris` DISABLE KEYS */;
INSERT INTO `uris` VALUES (1,'/api/research'),(2,'/api/yearlySummary'),(3,'/api/socialPractice'),(4,'/api/studentLeadership'),(5,'/api/studentScores'),(6,'/api/studentVolunteer'),(7,'/api/scores'),(8,'/api/yearlyGpaSummaryScores/GPA'),(9,'/api/yearlyGpaSummaryScores/yearly'),(10,'/api/yearlyGpaSummaryScores/research'),(11,'/api/yearlyGpaSummaryScores/volunteer'),(12,'/api/yearlyGpaSummaryScores/social'),(13,'/api/yearlyGpaSummaryScores/leadership');
/*!40000 ALTER TABLE `uris` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `volunteer_service`
--

DROP TABLE IF EXISTS `volunteer_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `volunteer_service` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `StudentID` int DEFAULT NULL,
  `Hours` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `StudentID` (`StudentID`),
  CONSTRAINT `volunteer_service_ibfk_1` FOREIGN KEY (`StudentID`) REFERENCES `student_info` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `volunteer_service`
--

LOCK TABLES `volunteer_service` WRITE;
/*!40000 ALTER TABLE `volunteer_service` DISABLE KEYS */;
INSERT INTO `volunteer_service` VALUES (1,3,40),(2,4,70),(3,2,30),(4,1,40);
/*!40000 ALTER TABLE `volunteer_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yearly_summary`
--

DROP TABLE IF EXISTS `yearly_summary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `yearly_summary` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `StudentID` int DEFAULT NULL,
  `Summary` text COLLATE utf8mb4_general_ci,
  `Year` year DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `StudentID` (`StudentID`),
  CONSTRAINT `yearly_summary_ibfk_1` FOREIGN KEY (`StudentID`) REFERENCES `student_info` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yearly_summary`
--

LOCK TABLES `yearly_summary` WRITE;
/*!40000 ALTER TABLE `yearly_summary` DISABLE KEYS */;
INSERT INTO `yearly_summary` VALUES (1,1,'123',2013),(2,2,'123',2014),(3,3,'12345',NULL),(4,4,NULL,NULL),(5,5,NULL,NULL),(6,6,NULL,NULL),(7,7,NULL,NULL),(8,8,NULL,NULL),(9,9,NULL,NULL);
/*!40000 ALTER TABLE `yearly_summary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'stu_evaluation'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-04 11:15:41
