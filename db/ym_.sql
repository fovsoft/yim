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
  `avillage` int(10) unsigned NOT NULL COMMENT '村',
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ym_family_base` */

/*Table structure for table `ym_family_status` */

DROP TABLE IF EXISTS `ym_family_status`;

CREATE TABLE `ym_family_status` (
  `jtzkbh` int(11) NOT NULL COMMENT '家庭状况编号',
  `jtbh` varchar(20) DEFAULT NULL COMMENT '家庭编号，对应家庭表',
  `zpyy1` varchar(64) DEFAULT NULL COMMENT '致贫原因1（必填）',
  `zpyy2` varchar(64) DEFAULT NULL COMMENT '致贫原因2（选填）',
  `zpyy3` varchar(64) DEFAULT NULL COMMENT '致贫原因3（选填）',
  `ncjtrks` int(11) DEFAULT NULL COMMENT '年初家庭人口数',
  `ndjtrks` int(11) DEFAULT NULL COMMENT '年底家庭人口数',
  `gdmj` float DEFAULT NULL COMMENT '耕地面积（亩）',
  `yxggmj` float DEFAULT NULL COMMENT '有效灌溉面积（亩）',
  `ldmj` float DEFAULT NULL COMMENT '林地面积（亩）',
  `tghlmj` float DEFAULT NULL COMMENT '退耕还林面积（亩）',
  `lgmj` float DEFAULT NULL COMMENT '林果面积（亩）',
  `smmj` float DEFAULT NULL COMMENT '水面面积（亩）',
  `mcdmj` float DEFAULT NULL COMMENT '牧草地面积（亩）',
  `sfyltqydd` char(2) DEFAULT NULL COMMENT '是否有龙头企业带动',
  `sfycyzfdtrdd` char(2) DEFAULT NULL COMMENT '是否有创业致富带头人带动',
  `sftscyd` char(2) DEFAULT NULL COMMENT '是否通生产用电',
  `sftshyd` char(2) DEFAULT NULL COMMENT '是否通生活用电',
  `sftgbds` char(2) DEFAULT NULL COMMENT '是否通广播电视',
  `yssfkn` char(2) DEFAULT NULL COMMENT '饮水是否困难',
  `yssfaq` char(2) DEFAULT NULL COMMENT '饮水是否安全',
  `zfmj` float DEFAULT NULL COMMENT '住房面积（平方米）',
  `ywwscs` char(2) DEFAULT NULL COMMENT '有无卫生厕所',
  `sfwfh` char(2) DEFAULT NULL COMMENT '是否危房户',
  `wfdj` varchar(10) DEFAULT NULL COMMENT '危房等级',
  `wgnd` varchar(10) DEFAULT NULL COMMENT '危改年度',
  `zfjg` varchar(32) DEFAULT NULL COMMENT '住房结构',
  `sfjrnmzyhzs` char(2) DEFAULT NULL COMMENT '是否加入农民专业合作社',
  `yczgljl` float DEFAULT NULL COMMENT '与村主干路距离（公里）',
  `rhllx` varchar(20) DEFAULT NULL COMMENT '入户路类型',
  `zyrllx` varchar(20) DEFAULT NULL COMMENT '主要燃料类型',
  `bgqksm` varchar(256) DEFAULT NULL COMMENT '变更情况说明',
  PRIMARY KEY (`jtzkbh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='致贫原因及家庭基本条件表';

/*Data for the table `ym_family_status` */

/*Table structure for table `ym_region` */

DROP TABLE IF EXISTS `ym_region`;

CREATE TABLE `ym_region` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `pid` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '上级ID',
  `name` varchar(40) NOT NULL DEFAULT '' COMMENT '行政区划名称',
  `code` varchar(10) NOT NULL DEFAULT '' COMMENT '行政区划代码',
  `enable` smallint(2) unsigned NOT NULL DEFAULT 1 COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='行政区划表';

/*Data for the table `ym_region` */

insert  into `ym_region`(`id`,`pid`,`name`,`code`,`enable`) values (1,0,'南宁','',1),(2,0,'钦州','',1),(3,1,'青秀区','',1),(4,1,'兴宁区','',1),(5,1,'江南区','',1),(6,1,'横县','',1),(7,2,'钦南区','',1),(8,2,'钦北区','',1),(9,2,'灵山县','',1),(10,2,'浦北县','',1),(12,7,'街道A','',1),(13,8,'街道B','',1),(14,9,'灵城街道办','',1),(15,9,'平南镇','',1),(16,9,'那隆镇','',1),(17,10,'小江镇','',1),(18,10,'泉水镇','',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
