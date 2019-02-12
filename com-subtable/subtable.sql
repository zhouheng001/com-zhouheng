/*
Navicat MySQL Data Transfer
Source Server         : local
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : book_00
Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001
Date: 2017-03-10 09:48:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_user_0000`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_0000`;
CREATE TABLE `t_user_0000` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_num` varchar(64) NOT NULL,
  `user_name` varchar(16) NOT NULL,
  `password` varchar(64) NOT NULL,
  `age` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_num` (`user_num`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_0000
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user_0001`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_0001`;
CREATE TABLE `t_user_0001` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_num` varchar(64) NOT NULL,
  `user_name` varchar(16) NOT NULL,
  `password` varchar(64) NOT NULL,
  `age` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_num` (`user_num`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_0001
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user_0002`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_0002`;
CREATE TABLE `t_user_0002` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_num` varchar(64) NOT NULL,
  `user_name` varchar(16) NOT NULL,
  `password` varchar(64) NOT NULL,
  `age` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_num` (`user_num`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_0002
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user_0003`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_0003`;
CREATE TABLE `t_user_0003` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_num` varchar(64) NOT NULL,
  `user_name` varchar(16) NOT NULL,
  `password` varchar(64) NOT NULL,
  `age` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_num` (`user_num`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_0003
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user_0004`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_0004`;
CREATE TABLE `t_user_0004` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_num` varchar(64) NOT NULL,
  `user_name` varchar(16) NOT NULL,
  `password` varchar(64) NOT NULL,
  `age` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_num` (`user_num`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_0004