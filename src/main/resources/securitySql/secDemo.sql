/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.22-log : Database - secdemo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `log` */

DROP TABLE IF EXISTS `log`;

CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `module` varchar(30) DEFAULT NULL,
  `action` varchar(30) DEFAULT NULL,
  `actionTime` varchar(30) DEFAULT NULL,
  `userIP` varchar(30) DEFAULT NULL,
  `operTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `log` */

/*Table structure for table `resources` */

DROP TABLE IF EXISTS `resources`;

CREATE TABLE `resources` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `resKey` varchar(50) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `resUrl` varchar(200) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;

/*Data for the table `resources` */

insert  into `resources`(`id`,`name`,`parentId`,`resKey`,`type`,`resUrl`,`level`,`description`) values (1,'权限资源管理',1000,'resManage','1','/resManage',1,'权限资源管理菜单'),(2,'权限资源查询',1,'resQuery','2','/resManage/resQuery.do',2,'权限资源查看'),(3,'权限资源添加',1,'resAdd','2','/resManage/resAdd.do',2,'权限资源添加'),(1000,'系统主页',0,'resMain','0','/sys/main.html',0,'系统主页访问');

/*Table structure for table `resources_role` */

DROP TABLE IF EXISTS `resources_role`;

CREATE TABLE `resources_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resc_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `resources_role` */

insert  into `resources_role`(`id`,`resc_id`,`role_id`) values (1,1,1),(2,2,1),(3,3,1),(4,1000,1);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `roleKey` varchar(50) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `enable` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`id`,`name`,`roleKey`,`description`,`enable`) values (1,'超级管理员','ROLE_USER','admin',1);

/*Table structure for table `serverinfo` */

DROP TABLE IF EXISTS `serverinfo`;

CREATE TABLE `serverinfo` (
  `id` int(10) NOT NULL DEFAULT '0',
  `cpuUsage` varchar(255) DEFAULT NULL,
  `setCpuUsage` varchar(255) DEFAULT NULL,
  `jvmUsage` varchar(255) DEFAULT NULL,
  `setJvmUsage` varchar(255) DEFAULT NULL,
  `ramUsage` varchar(255) DEFAULT NULL,
  `setRamUsage` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `operTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `mark` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `serverinfo` */

insert  into `serverinfo`(`id`,`cpuUsage`,`setCpuUsage`,`jvmUsage`,`setJvmUsage`,`ramUsage`,`setRamUsage`,`email`,`operTime`,`mark`) values (1,'9.3','20','64.0','80','75.0','80','1212614949@qq.com','2013-11-19 11:31:04','<font color=\'red\'>内存当前：75.0%,超出预设值  60%</font>'),(2,'0.8','20','60.0','80','75.0','80','1212614949@qq.com','2013-11-19 11:32:02','<font color=\'red\'>内存当前：75.0%,超出预设值  60%</font>'),(3,'1.5','20','59.0','80','75.0','80','1212614949@qq.com','2013-11-19 11:33:03','<font color=\'red\'>内存当前：75.0%,超出预设值  60%</font>'),(4,'0.7','20','57.0','80','75.0','80','1212614949@qq.com','2013-11-19 11:34:02','<font color=\'red\'>内存当前：75.0%,超出预设值  60%</font>'),(5,'2.3','20','57.0','80','75.0','80','1212614949@qq.com','2013-11-19 11:35:02','<font color=\'red\'>内存当前：75.0%,超出预设值  60%</font>'),(6,'17.9','20','57.0','80','77.0','80','1212614949@qq.com','2013-11-19 11:36:02','<font color=\'red\'>内存当前：77.0%,超出预设值  60%</font>');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `userPassword` varchar(40) DEFAULT NULL,
  `userRealName` varchar(20) DEFAULT NULL,
  `userPhone` varchar(30) DEFAULT NULL,
  `userQQ` varchar(30) DEFAULT NULL,
  `regTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`userId`,`userName`,`userPassword`,`userRealName`,`userPhone`,`userQQ`,`regTime`,`status`) values (1,'admin','admin','admin','0253526','32432','2016-10-11 13:48:45',NULL);

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `role_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`id`,`user_id`,`role_id`) values (1,1,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
