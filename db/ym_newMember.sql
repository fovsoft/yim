/*
SQLyog v10.2 
MySQL - 5.5.5-10.2.14-MariaDB-log : Database - ym
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ym` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ym`;

/*Table structure for table `ym_family_base` */

DROP TABLE IF EXISTS `ym_family_base`;

CREATE TABLE `ym_family_base` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `city` int(10) unsigned NOT NULL COMMENT '市',
  `county` int(10) unsigned NOT NULL COMMENT '县（市、区）',
  `town` int(10) unsigned NOT NULL COMMENT '镇（乡、街道）',
  `avillage` varchar(20) NOT NULL DEFAULT '' COMMENT '行政村',
  `nvillage` varchar(20) NOT NULL DEFAULT '' COMMENT '自然村（屯）',
  `tel` varchar(20) NOT NULL DEFAULT '' COMMENT '联系电话',
  `dpst_bk` int(10) unsigned NOT NULL COMMENT '开户银行',
  `bk_num` varchar(20) NOT NULL DEFAULT '' COMMENT '银行卡号',
  `family_attr` smallint(3) unsigned NOT NULL DEFAULT 0 COMMENT '贫困户属性',
  `poverty_relief_tm` smallint(4) unsigned NOT NULL DEFAULT 0 COMMENT '计划脱贫年度',
  `poverty_rtn_tm` smallint(4) unsigned NOT NULL DEFAULT 0 COMMENT '返贫年度',
  `poverty_rtn_rsn` varchar(20) NOT NULL DEFAULT '' COMMENT '返贫原因',
  `is_martyrsfamily` smallint(1) unsigned NOT NULL DEFAULT 0 COMMENT '是否军烈属（1是0否）',
  `is_relocated` smallint(1) unsigned NOT NULL DEFAULT 1 COMMENT '是否搬迁户（1是0否）',
  `relocated_way` varchar(20) NOT NULL DEFAULT '' COMMENT '搬迁方式',
  `relocated_addr` varchar(80) NOT NULL DEFAULT '' COMMENT '搬迁地址',
  `add_time` datetime DEFAULT NULL COMMENT '录入日期',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  `uid` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '录入人ID',
  `poverty_causes1` tinyint(2) unsigned NOT NULL DEFAULT 0 COMMENT '致贫主因1',
  `poverty_causes2` tinyint(2) unsigned NOT NULL DEFAULT 0 COMMENT '致贫主因1',
  `poverty_causes3` tinyint(2) unsigned NOT NULL DEFAULT 0 COMMENT '致贫主因1',
  `household_num_Jan` tinyint(2) unsigned NOT NULL DEFAULT 0 COMMENT '年初家庭人口数',
  `household_num_Dec` tinyint(2) unsigned NOT NULL DEFAULT 0 COMMENT '年末家庭人口数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

/*Table structure for table `ym_family_base_addition` */

DROP TABLE IF EXISTS `ym_family_base_addition`;

CREATE TABLE `ym_family_base_addition` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fid` int(10) unsigned NOT NULL,
  `poverty_causes1` tinyint(2) unsigned NOT NULL DEFAULT 0,
  `poverty_causes2` tinyint(2) unsigned NOT NULL DEFAULT 0,
  `poverty_causes3` tinyint(2) unsigned NOT NULL DEFAULT 0,
  `household_num_Jan` tinyint(2) unsigned NOT NULL DEFAULT 0,
  `household_num_Dec` tinyint(2) unsigned NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Table structure for table `ym_family_base_condition` */

DROP TABLE IF EXISTS `ym_family_base_condition`;

CREATE TABLE `ym_family_base_condition` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fid` int(10) unsigned NOT NULL DEFAULT 0,
  `area_cultivated` decimal(6,2) unsigned NOT NULL DEFAULT 0.00 COMMENT '耕地面积（亩）',
  `area_woodland` decimal(6,2) unsigned NOT NULL DEFAULT 0.00 COMMENT '林地面积（亩）',
  `area_turninto` decimal(6,2) unsigned NOT NULL DEFAULT 0.00 COMMENT '退耕还林面积（亩）',
  `area_fruit` decimal(6,2) unsigned NOT NULL DEFAULT 0.00 COMMENT '林果面积（亩）',
  `area_foragegrass` decimal(6,2) unsigned NOT NULL DEFAULT 0.00 COMMENT '牧草地面积（亩)',
  `area_waters` decimal(6,2) unsigned NOT NULL DEFAULT 0.00 COMMENT '水面面积（亩）',
  `is_cooperative` tinyint(1) unsigned NOT NULL DEFAULT 0 COMMENT '是否加入农民专业合作社',
  `get_leaded` tinyint(1) unsigned NOT NULL DEFAULT 0 COMMENT '是否有龙头企业带动',
  `get_pioneer` tinyint(1) unsigned NOT NULL DEFAULT 0 COMMENT '是否有创业致富带头人带动',
  `get_electric` tinyint(1) unsigned NOT NULL DEFAULT 0 COMMENT '是否通生活用电',
  `get_television` tinyint(1) unsigned NOT NULL DEFAULT 0 COMMENT '是否通广播电视',
  `get_potablewater` tinyint(1) unsigned NOT NULL DEFAULT 0 COMMENT '是否解决安全饮用水',
  `get_toilet` tinyint(1) unsigned NOT NULL DEFAULT 0 COMMENT '是否有卫生厕所',
  `distance_mainroad` decimal(5,2) unsigned NOT NULL DEFAULT 0.00 COMMENT '与村主干路距离（公里）',
  `type_road` tinyint(2) unsigned NOT NULL DEFAULT 0 COMMENT '入户路类型',
  `area_housing` decimal(5,2) unsigned NOT NULL DEFAULT 0.00 COMMENT '住房面积（平方米）',
  `is_dilapidated` tinyint(1) unsigned NOT NULL DEFAULT 0 COMMENT '是否危房',
  `level_dilapidated` tinyint(2) unsigned DEFAULT 0 COMMENT '危房等级',
  `year_reform` smallint(6) unsigned DEFAULT 0 COMMENT '危改年度',
  `type_fuel` tinyint(2) unsigned NOT NULL DEFAULT 0 COMMENT '主要燃料类型',
  `type_fuel_other` varchar(20) NOT NULL DEFAULT '' COMMENT '具体燃料名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='生产生活条件';

/*Table structure for table `ym_family_base_member` */

DROP TABLE IF EXISTS `ym_family_base_member`;

CREATE TABLE `ym_family_base_member` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `fid` int(10) unsigned NOT NULL COMMENT '家庭id',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '姓名',
  `sex` tinyint(1) NOT NULL DEFAULT 1 COMMENT '性别1男0女',
  `relation` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '与户主关系',
  `nation` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '民族',
  `political_exp` tinyint(2) unsigned NOT NULL DEFAULT 0 COMMENT '政治面貌',
  `level_edu` tinyint(2) unsigned NOT NULL DEFAULT 0 COMMENT '文化程度',
  `school_status` tinyint(2) unsigned NOT NULL DEFAULT 0 COMMENT '在校生状况',
  `stopedu_rsn` tinyint(2) unsigned NOT NULL DEFAULT 0 COMMENT '失学原因',
  `healthy_status` tinyint(2) unsigned NOT NULL DEFAULT 0 COMMENT '健康状况',
  `labor_skill` tinyint(2) unsigned NOT NULL DEFAULT 0 COMMENT '劳动技能',
  `can_mandarin` tinyint(1) unsigned NOT NULL DEFAULT 0 COMMENT '是否会讲普通话',
  `medical_insurance` tinyint(1) unsigned NOT NULL DEFAULT 0 COMMENT '是否参加城镇居民基本医疗保险',
  `business_insurance` tinyint(1) unsigned NOT NULL DEFAULT 0 COMMENT '是否参加商业补充医疗保险',
  `basic_allowances` tinyint(1) unsigned NOT NULL DEFAULT 0 COMMENT '是否享受农村居民最低生活保障',
  `endowment_insurance` tinyint(1) unsigned NOT NULL DEFAULT 0 COMMENT '是否参加城乡居民基本养老保险',
  `accident_insurance` tinyint(1) unsigned NOT NULL DEFAULT 0 COMMENT '是否享受人身意外保险补贴',
  `tel` varchar(15) NOT NULL DEFAULT '' COMMENT '联系电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
