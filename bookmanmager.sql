/*
SQLyog Ultimate v12.4.3 (64 bit)
MySQL - 5.7.25-log : Database - bookmanager
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookmanager` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bookmanager`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookName` varchar(20) NOT NULL,
  `author` varchar(20) NOT NULL,
  `price` float NOT NULL,
  `bookTypeId` int(11) NOT NULL,
  `bookDesc` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bookTypeId` (`bookTypeId`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`bookTypeId`) REFERENCES `booktype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`id`,`bookName`,`author`,`price`,`bookTypeId`,`bookDesc`) values 
(1,'C++','张三',100,1,''),
(2,'java','张三',500,1,'');

/*Table structure for table `booktype` */

DROP TABLE IF EXISTS `booktype`;

CREATE TABLE `booktype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookTypeName` varchar(20) NOT NULL,
  `bookTypeDesc` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `booktype` */

insert  into `booktype`(`id`,`bookTypeName`,`bookTypeDesc`) values 
(1,'计算机','信息'),
(2,'艺术',''),
(3,'历史','');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`) values 
(1,'12345','1234567'),
(2,'张三','123'),
(3,'2','1'),
(4,'3','2'),
(5,'5','5'),
(6,'7','7'),
(7,'6','5'),
(8,'8','2');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
