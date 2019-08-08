/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50644
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50644
File Encoding         : 65001

Date: 2019-08-08 14:48:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hero
-- ----------------------------
DROP TABLE IF EXISTS `hero`;
CREATE TABLE `hero` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `hp` float(255,0) DEFAULT NULL,
  `damage` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hero
-- ----------------------------
INSERT INTO `hero` VALUES ('3', '寒冰射手', '2000', '1');
INSERT INTO `hero` VALUES ('5', '狼王', '5000', '0');
INSERT INTO `hero` VALUES ('6', '魔女', '1500', '2');
INSERT INTO `hero` VALUES ('7', '盖伦', '7000', '0');
INSERT INTO `hero` VALUES ('8', '盲僧', '3000', '0');
INSERT INTO `hero` VALUES ('9', '波塞冬', '4000', '0');
INSERT INTO `hero` VALUES ('10', '大龙', '1000', '0');
