/*
Navicat MySQL Data Transfer

Source Server         : localhostDB
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : currency

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2018-11-11 15:17:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for features
-- ----------------------------
DROP TABLE IF EXISTS `features`;
CREATE TABLE `features` (
  `id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '编号',
  `height` float(255,0) DEFAULT '0' COMMENT '身高',
  `fat_or_thin` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT '瘦' COMMENT '胖或瘦',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of features
-- ----------------------------
INSERT INTO `features` VALUES ('001', '175', '瘦');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `name` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', 'sadg15', '13', 'asdga5');
INSERT INTO `user` VALUES ('5', 'asdg', '22', 'sdagadg');
INSERT INTO `user` VALUES ('6', 'asdgg', '22', '123@154');
INSERT INTO `user` VALUES ('7', 'fgd', '22', '123@154');
