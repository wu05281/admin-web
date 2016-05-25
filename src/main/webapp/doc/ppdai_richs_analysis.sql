/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.6.26-log : Database - ppdai_richs_analysis
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ppdai_richs_analysis` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ppdai_richs_analysis`;


/*Data for the table `mb_member` */

/*Table structure for table `sys_dictionary` */

DROP TABLE IF EXISTS `sys_dictionary`;

CREATE TABLE `sys_dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(64) NOT NULL,
  `text` varchar(64) NOT NULL,
  `dictionarytype_id` int(11) NOT NULL,
  `seq` tinyint(1) NOT NULL DEFAULT '0',
  `state` tinyint(1) NOT NULL DEFAULT '0',
  `isdefault` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='数据字典';

/*Data for the table `sys_dictionary` */

insert  into `sys_dictionary`(`id`,`code`,`text`,`dictionarytype_id`,`seq`,`state`,`isdefault`) values (1,'0','管理员',2,0,0,0),(2,'1','用户',2,0,0,1),(3,'1000','支持银行',1,0,1,1);

/*Table structure for table `sys_dictionarytype` */

DROP TABLE IF EXISTS `sys_dictionarytype`;

CREATE TABLE `sys_dictionarytype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(64) NOT NULL,
  `name` varchar(64) NOT NULL,
  `seq` tinyint(1) NOT NULL DEFAULT '0',
  `description` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='字典分类';

/*Data for the table `sys_dictionarytype` */

insert  into `sys_dictionarytype`(`id`,`code`,`name`,`seq`,`description`,`pid`) values (1,'base','基础设置',0,'基础设置',NULL),(2,'usertype','用户类型',0,'用户类型',1);

/*Table structure for table `sys_organization` */

DROP TABLE IF EXISTS `sys_organization`;

CREATE TABLE `sys_organization` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `code` varchar(64) NOT NULL,
  `icon` varchar(32) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `seq` tinyint(1) NOT NULL DEFAULT '0',
  `createdatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='组织机构';

/*Data for the table `sys_organization` */

insert  into `sys_organization`(`id`,`name`,`address`,`code`,`icon`,`pid`,`seq`,`createdatetime`) values (1,'技术部','地址','01','icon_company',NULL,0,'2014-02-19 01:00:00'),(2,'研发部','','02','icon_folder',1,0,'2016-04-14 21:09:29');

/*Table structure for table `sys_resource` */

DROP TABLE IF EXISTS `sys_resource`;

CREATE TABLE `sys_resource` (
  `id` smallint(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `url` varchar(100) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `icon` varchar(32) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `seq` tinyint(1) NOT NULL DEFAULT '0',
  `state` tinyint(1) NOT NULL DEFAULT '0',
  `resourcetype` tinyint(1) NOT NULL DEFAULT '0',
  `createdatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=54 DEFAULT CHARSET=utf8 COMMENT='资源';

/*Data for the table `sys_resource` */

insert  into `sys_resource`(`id`,`name`,`url`,`description`,`icon`,`pid`,`seq`,`state`,`resourcetype`,`createdatetime`) values (1,'系统管理','','系统管理','icon_folder',NULL,7,0,0,'2014-02-19 01:00:00'),(2,'资源管理','/resource/manager','资源管理','icon_resource',1,1,0,0,'2014-02-19 01:00:00'),(5,'资源列表','/resource/treeGrid','资源列表','icon_resource',2,0,0,1,'2014-02-19 01:00:00'),(6,'添加','/resource/add','资源添加','icon_resource',2,0,0,1,'2014-02-19 01:00:00'),(7,'编辑','/resource/edit','资源编辑','icon_resource',2,0,0,1,'2014-02-19 01:00:00'),(8,'删除','/resource/delete','资源删除','icon_resource',2,0,0,1,'2014-02-19 01:00:00'),(3,'角色管理','/role/manager','角色管理','icon_role',1,2,0,0,'2014-02-19 01:00:00'),(10,'角色列表','/role/dataGrid','角色列表','icon_role',3,0,0,1,'2014-02-19 01:00:00'),(11,'添加','/role/add','角色添加','icon_role',3,0,0,1,'2014-02-19 01:00:00'),(12,'编辑','/role/edit','角色编辑','icon_role',3,0,0,1,'2014-02-19 01:00:00'),(13,'删除','/role/delete','角色删除','icon_role',3,0,0,1,'2014-02-19 01:00:00'),(14,'授权','/role/grant','角色授权','icon_role',3,0,0,1,'2014-02-19 01:00:00'),(4,'用户管理','/user/manager','用户管理','icon_user',1,3,0,0,'2014-02-19 01:00:00'),(15,'用户列表','/user/dataGrid','用户列表','icon_user',4,0,0,1,'2014-02-19 01:00:00'),(16,'添加','/user/add','用户添加','icon_user',4,0,0,1,'2014-02-19 01:00:00'),(17,'编辑','/user/edit','用户编辑','icon_user',4,0,0,1,'2014-02-19 01:00:00'),(18,'删除','/user/delete','用户删除','icon_user',4,0,0,1,'2014-02-19 01:00:00'),(19,'查看','/user/view','用户查看','icon_user',4,0,0,1,'2014-02-19 01:00:00'),(20,'部门管理','/organization/manager','部门管理','icon_org',1,4,0,0,'2014-02-19 01:00:00'),(21,'部门列表','/organization/treeGrid','用户列表','icon_org',20,0,0,1,'2014-02-19 01:00:00'),(22,'添加','/organization/add','部门添加','icon_org',20,0,0,1,'2014-02-19 01:00:00'),(23,'编辑','/organization/edit','部门编辑','icon_org',20,0,0,1,'2014-02-19 01:00:00'),(24,'删除','/organization/delete','部门删除','icon_org',20,0,0,1,'2014-02-19 01:00:00'),(25,'查看','/organization/view','部门查看','icon_org',20,0,0,1,'2014-02-19 01:00:00'),(26,'数据字典','/dictionary/manager','数据字典','icon_dic',1,5,0,0,'2014-02-19 01:00:00'),(27,'字典列表','/dictionary/dataGrid','字典列表','icon_dic',26,0,0,1,'2014-02-19 01:00:00'),(28,'字典类别列表','/dictionarytype/dataGrid','字典类别列表','icon_dic',26,0,0,1,'2014-02-19 01:00:00'),(29,'添加','/dictionary/add','字典添加','icon_dic',26,0,0,1,'2014-02-19 01:00:00'),(30,'编辑','/dictionary/edit','字典编辑','icon_dic',26,0,0,1,'2014-02-19 01:00:00'),(31,'删除','/dictionary/delete','字典删除','icon_dic',26,0,0,1,'2014-02-19 01:00:00');

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` smallint(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `seq` tinyint(1) NOT NULL DEFAULT '0',
  `description` varchar(255) DEFAULT NULL,
  `isdefault` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色';

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`name`,`seq`,`description`,`isdefault`) values (1,'超级管理员',0,'超级管理员，拥有全部权限',0),(2,'测试',0,'测试',1);

/*Table structure for table `sys_role_resource` */

DROP TABLE IF EXISTS `sys_role_resource`;

CREATE TABLE `sys_role_resource` (
  `role_id` smallint(5) NOT NULL,
  `resource_id` smallint(5) NOT NULL,
  PRIMARY KEY (`role_id`,`resource_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='角色资源';

/*Data for the table `sys_role_resource` */

insert  into `sys_role_resource`(`role_id`,`resource_id`) values (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20),(1,21),(1,22),(1,23),(1,24),(1,25),(1,26),(1,27),(1,28),(1,29),(1,30),(1,31);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` smallint(5) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(64) NOT NULL,
  `name` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `sex` tinyint(1) NOT NULL DEFAULT '0',
  `age` tinyint(1) NOT NULL DEFAULT '0',
  `usertype` tinyint(1) NOT NULL DEFAULT '0',
  `isdefault` tinyint(1) NOT NULL DEFAULT '0',
  `state` tinyint(1) NOT NULL DEFAULT '0',
  `organization_id` int(11) NOT NULL DEFAULT '0',
  `createdatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `loginname` (`loginname`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户';

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`loginname`,`name`,`password`,`sex`,`age`,`usertype`,`isdefault`,`state`,`organization_id`,`createdatetime`) values (1,'admin','超级管理员','21232f297a57a5a743894a0e4a801fc3',0,18,1,0,0,1,'2012-06-04 01:00:00'),(2,'lichao','李超','e10adc3949ba59abbe56e057f20f883e',0,25,2,1,0,2,'2016-04-14 21:06:49');

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `user_id` smallint(5) NOT NULL,
  `role_id` smallint(5) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='用户角色';

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`user_id`,`role_id`) values (1,1),(2,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
