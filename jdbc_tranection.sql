/*
SQLyog Community v12.5.1 (64 bit)
MySQL - 10.1.29-MariaDB : Database - jdbc_tranection
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jdbc_tranection` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `jdbc_tranection`;

/*Table structure for table `food` */

DROP TABLE IF EXISTS `food`;

CREATE TABLE `food` (
  `foodId` int(10) NOT NULL,
  `foodName` varchar(100) NOT NULL,
  `foodCost` varchar(100) NOT NULL,
  `resturentId` int(10) NOT NULL,
  PRIMARY KEY (`foodId`),
  KEY `resturentId` (`resturentId`),
  CONSTRAINT `food_ibfk_1` FOREIGN KEY (`resturentId`) REFERENCES `restaurant` (`restaurantId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `food` */

insert  into `food`(`foodId`,`foodName`,`foodCost`,`resturentId`) values 
(1,'food1','heavy',1),
(12,'food4','cost',2),
(101,'food2','exp',2);

/*Table structure for table `restaurant` */

DROP TABLE IF EXISTS `restaurant`;

CREATE TABLE `restaurant` (
  `restaurantId` int(10) NOT NULL,
  `restaurantName` varchar(100) NOT NULL,
  `restaurantRank` varchar(100) NOT NULL,
  `restaurantAddress` varchar(100) NOT NULL,
  PRIMARY KEY (`restaurantId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `restaurant` */

insert  into `restaurant`(`restaurantId`,`restaurantName`,`restaurantRank`,`restaurantAddress`) values 
(1,'res2','expensive','asd'),
(2,'res3','excellent','naogaon'),
(3,'res4','rank','nao');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
