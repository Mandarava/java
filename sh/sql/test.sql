/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2016-06-20 13:23:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `SID` varchar(8) NOT NULL,
  `sname` varchar(10) NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`SID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES ('S000001', '张三丰', '男', '2016-06-19', '上海');
INSERT INTO `students` VALUES ('S000003', '貂蝉', '女', '2016-06-19', '南京');
INSERT INTO `students` VALUES ('S000004', '李四', '女', '2016-06-21', '天桥桥洞');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'zhangsan', '123456');

-- ----------------------------
-- Procedure structure for myproc
-- ----------------------------
DROP PROCEDURE IF EXISTS `myproc`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `myproc`(OUT s int)
BEGIN
select COUNT(*) into s from users;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for myproc2
-- ----------------------------
DROP PROCEDURE IF EXISTS `myproc2`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `myproc2`(IN num int)
BEGIN
SELECT num;
SET num=num+1;
SELECT num;
END
;;
DELIMITER ;
