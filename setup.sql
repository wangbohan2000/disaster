-- MySQL dump 10.13  Distrib 5.7.29, for Linux (x86_64)
--
-- Host: localhost    Database: disaster
-- ------------------------------------------------------
-- Server version	5.7.29-0ubuntu0.18.04.1

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
-- Current Database: `disaster`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `disaster` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `disaster`;

--
-- Table structure for table `disaster`
--

DROP TABLE IF EXISTS `disaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disaster` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `details` text,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `provider_id` bigint(20) DEFAULT NULL,
  `expect_goods_name` varchar(255) NOT NULL,
  `expect_goods_cnt` double NOT NULL DEFAULT '0',
  `expect_goods_unit` varchar(10) NOT NULL DEFAULT '个',
  `pass` enum('审批通过','审批未通过','暂未审批') NOT NULL DEFAULT '暂未审批',
  PRIMARY KEY (`id`),
  KEY `fast_title` (`title`),
  KEY `disaster_user_id_fk` (`provider_id`),
  CONSTRAINT `disaster_user_id_fk` FOREIGN KEY (`provider_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disaster`
--

LOCK TABLES `disaster` WRITE;
/*!40000 ALTER TABLE `disaster` DISABLE KEYS */;
INSERT INTO `disaster` VALUES (2,'地震','日本省东京市发生9级地震，请支援我们一些物资吧！','2020-04-05 16:00:00',2,'帐篷',10,'万个','暂未审批'),(3,'瘟疫','台湾省台北市爆发瘟疫，请求支援！','2020-04-12 06:03:02',2,'口罩',10,'万个','审批未通过'),(9,'瘟疫','印度省爆发百年难得一见的瘟疫，请求支援!','2020-04-13 01:09:31',2,'口罩',10,'万个','审批通过');
/*!40000 ALTER TABLE `disaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `cnt` double NOT NULL,
  `unit` varchar(10) NOT NULL,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `provider_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fast_goods_name` (`name`),
  KEY `goods_user_id_fk` (`provider_id`),
  CONSTRAINT `goods_user_id_fk` FOREIGN KEY (`provider_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` VALUES (1,'帐篷',100,'万个','2020-04-11 07:45:24',4),(2,'口罩',940,'万个','2020-04-12 03:45:02',4),(3,'消毒液',100,'万瓶','2020-04-06 16:00:00',4),(4,'防护服',3000,'万套','2020-04-11 16:00:00',4),(5,'手电筒',30000,'万个','2020-04-11 16:00:00',4),(6,'压缩饼干',10,'万箱','2020-04-05 16:00:00',4),(7,'钢筋',10,'万吨','2020-04-06 16:00:00',4);
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logistic`
--

DROP TABLE IF EXISTS `logistic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `logistic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `manager_id` bigint(20) DEFAULT NULL,
  `dest_id` bigint(20) DEFAULT NULL,
  `status` enum('未发货','已发货','即将到达','已到达','已签收') DEFAULT '未发货',
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `end_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `goods_id` bigint(20) NOT NULL,
  `disaster_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `logistic_user_id_fk_2` (`manager_id`),
  KEY `logistic_user_id_fk_3` (`dest_id`),
  KEY `logistic_goods_id_fk` (`goods_id`),
  KEY `logistic_disaster_id_fk` (`disaster_id`),
  CONSTRAINT `logistic_disaster_id_fk` FOREIGN KEY (`disaster_id`) REFERENCES `disaster` (`id`),
  CONSTRAINT `logistic_goods_id_fk` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`),
  CONSTRAINT `logistic_user_id_fk_2` FOREIGN KEY (`manager_id`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `logistic_user_id_fk_3` FOREIGN KEY (`dest_id`) REFERENCES `user` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logistic`
--

LOCK TABLES `logistic` WRITE;
/*!40000 ALTER TABLE `logistic` DISABLE KEYS */;
INSERT INTO `logistic` VALUES (1,3,2,'未发货','2020-04-14 00:38:24','2020-04-17 00:38:24',2,9);
/*!40000 ALTER TABLE `logistic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `nameCN` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `nameCN` (`nameCN`),
  KEY `fast_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_FRONT','受灾一线'),(2,'ROLE_MANAGER','管理调度'),(3,'ROLE_PROVIDER','物资提供'),(4,'ROLE_ADMIN','超级管理员'),(5,'ROLE_LOGISTICS','物流监管');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `enable` tinyint(1) DEFAULT '0',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `fast_username` (`username`),
  KEY `user_role_id_fk` (`role_id`),
  CONSTRAINT `user_role_id_fk` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin',1,'2020-04-11 07:42:00',4),(2,'front','front',1,'2020-04-11 07:42:28',1),(3,'manager','manager',1,'2020-04-11 07:42:51',2),(4,'provider','provider',1,'2020-04-11 07:43:17',3),(5,'logistics','logistics',1,'2020-04-11 07:43:33',5),(9,'paul','paul',1,'2020-04-11 11:30:56',4),(10,'顺丰快递','sfkd',0,'2020-04-12 02:31:47',5),(11,'韵达快递','ydkd',0,'2020-04-12 02:32:31',5),(12,'玉树武警支队','yswjzd',0,'2020-04-12 02:33:41',1),(13,'汶川市人民政府','wcsrmzf',0,'2020-04-12 02:34:14',1),(14,'西北抗震救灾调度管理处','xbkzjzddglc',0,'2020-04-12 02:34:57',3),(15,'帐篷提供商','zptgs',0,'2020-04-12 02:36:16',4),(16,'口罩提供商','kztgs',0,'2020-04-12 02:36:36',4);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-14  9:45:25
