/*
Navicat MySQL Data Transfer

Source Server         : 555
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : cyporj

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2017-03-17 17:08:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cycarts`
-- ----------------------------
DROP TABLE IF EXISTS `cycarts`;
CREATE TABLE `cycarts` (
  `cycartid` int(11) NOT NULL AUTO_INCREMENT,
  `cyuid` int(11) NOT NULL,
  `cygid` int(11) NOT NULL,
  PRIMARY KEY (`cycartid`),
  KEY `cy1` (`cyuid`),
  KEY `cy2` (`cygid`),
  CONSTRAINT `cy1` FOREIGN KEY (`cyuid`) REFERENCES `cyusers` (`cyuid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cy2` FOREIGN KEY (`cygid`) REFERENCES `cygoods` (`cygid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cycarts
-- ----------------------------

-- ----------------------------
-- Table structure for `cyclassd`
-- ----------------------------
DROP TABLE IF EXISTS `cyclassd`;
CREATE TABLE `cyclassd` (
  `cdid` int(11) NOT NULL AUTO_INCREMENT,
  `cgid` int(11) NOT NULL,
  `cdname` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cdid`),
  KEY `1` (`cgid`),
  CONSTRAINT `1` FOREIGN KEY (`cgid`) REFERENCES `cyclassg` (`cgid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cyclassd
-- ----------------------------
INSERT INTO `cyclassd` VALUES ('1', '1', '手机');
INSERT INTO `cyclassd` VALUES ('2', '1', '笔记本');
INSERT INTO `cyclassd` VALUES ('3', '1', '台式机');
INSERT INTO `cyclassd` VALUES ('4', '1', '平板');
INSERT INTO `cyclassd` VALUES ('5', '1', '相机');
INSERT INTO `cyclassd` VALUES ('6', '1', '游戏机');
INSERT INTO `cyclassd` VALUES ('7', '1', '其他');
INSERT INTO `cyclassd` VALUES ('8', '2', '电扇');
INSERT INTO `cyclassd` VALUES ('9', '2', '台灯');
INSERT INTO `cyclassd` VALUES ('10', '2', '洗衣机');
INSERT INTO `cyclassd` VALUES ('11', '2', '电吹风');
INSERT INTO `cyclassd` VALUES ('12', '2', '电水壶');
INSERT INTO `cyclassd` VALUES ('13', '2', '其他');
INSERT INTO `cyclassd` VALUES ('14', '3', '日常用品');
INSERT INTO `cyclassd` VALUES ('15', '3', '乐器');
INSERT INTO `cyclassd` VALUES ('16', '3', '虚拟账号');
INSERT INTO `cyclassd` VALUES ('17', '3', '会员卡');
INSERT INTO `cyclassd` VALUES ('18', '3', '其他');
INSERT INTO `cyclassd` VALUES ('19', '4', '教材');
INSERT INTO `cyclassd` VALUES ('20', '4', '考研');
INSERT INTO `cyclassd` VALUES ('21', '4', '4/6级');
INSERT INTO `cyclassd` VALUES ('22', '4', '课外书');
INSERT INTO `cyclassd` VALUES ('23', '4', '其他');
INSERT INTO `cyclassd` VALUES ('24', '5', '自行车');
INSERT INTO `cyclassd` VALUES ('25', '5', '电动车');
INSERT INTO `cyclassd` VALUES ('26', '5', '助力车');
INSERT INTO `cyclassd` VALUES ('27', '6', '租房');
INSERT INTO `cyclassd` VALUES ('28', '6', '服装');
INSERT INTO `cyclassd` VALUES ('29', '6', '道具');
INSERT INTO `cyclassd` VALUES ('30', '6', '其他');

-- ----------------------------
-- Table structure for `cyclassg`
-- ----------------------------
DROP TABLE IF EXISTS `cyclassg`;
CREATE TABLE `cyclassg` (
  `cgid` int(11) NOT NULL AUTO_INCREMENT,
  `cgname` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cgid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cyclassg
-- ----------------------------
INSERT INTO `cyclassg` VALUES ('1', '电子设备');
INSERT INTO `cyclassg` VALUES ('2', '电器');
INSERT INTO `cyclassg` VALUES ('3', '生活娱乐');
INSERT INTO `cyclassg` VALUES ('4', '图书教材');
INSERT INTO `cyclassg` VALUES ('5', '校园代步');
INSERT INTO `cyclassg` VALUES ('6', '租赁');

-- ----------------------------
-- Table structure for `cygoods`
-- ----------------------------
DROP TABLE IF EXISTS `cygoods`;
CREATE TABLE `cygoods` (
  `cygid` int(11) NOT NULL AUTO_INCREMENT,
  `cygtitle` varchar(50) DEFAULT NULL,
  `cyuid` int(11) DEFAULT NULL,
  `cygdep` varchar(150) DEFAULT NULL,
  `cygphoto` varchar(150) DEFAULT NULL,
  `cygview` int(11) DEFAULT '0',
  `cyprice` int(11) DEFAULT NULL,
  `cycdid` int(11) DEFAULT NULL,
  `cygstats` int(11) DEFAULT '1',
  `cygdate` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cygid`),
  KEY `cy3` (`cyuid`),
  KEY `cy4` (`cycdid`),
  CONSTRAINT `cy3` FOREIGN KEY (`cyuid`) REFERENCES `cyusers` (`cyuid`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `cy4` FOREIGN KEY (`cycdid`) REFERENCES `cyclassd` (`cdid`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cygoods
-- ----------------------------
INSERT INTO `cygoods` VALUES ('1', '吉他他他dsad', '7', '吉他他他他他他他他说上上上上上上上上上', '1489739626452.jpg', '30', '12333', '15', '1', '2017-03-17 16:49:51');
INSERT INTO `cygoods` VALUES ('2', '123133', '7', '就急急急急急急急急急谁谁谁水水水水', '1486794954503.jpg', '11', '22222', '15', '1', '2017-02-11 14:35:54');
INSERT INTO `cygoods` VALUES ('3', '2133123', '7', '22222222222222222222222222222222222222222', '1486794992327.jpg', '18', '12122', '15', '1', '2017-02-11 14:36:32');
INSERT INTO `cygoods` VALUES ('4', '12313333', '7', '222222222222222222222222222222', '1486795027592.jpg', '8', '2222', '1', '1', '2017-02-11 14:37:07');
INSERT INTO `cygoods` VALUES ('6', 'ssad', '7', '的撒旦啊实打实大声道阿斯顿是打的', '1486795075545.jpg', '5', '12333', '19', '1', '2017-02-11 14:37:55');
INSERT INTO `cygoods` VALUES ('7', 'asdasd111123', '7', '的阿斯顿的顶顶顶顶顶的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶', '1486795095408.jpg', '10', '232', '1', '1', '2017-03-17 17:02:16');

-- ----------------------------
-- Table structure for `cymsg`
-- ----------------------------
DROP TABLE IF EXISTS `cymsg`;
CREATE TABLE `cymsg` (
  `msgid` int(11) NOT NULL AUTO_INCREMENT,
  `cyuid` int(11) DEFAULT NULL,
  `msgstr` varchar(150) DEFAULT NULL,
  `msgdata` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`msgid`),
  KEY `pk_1` (`cyuid`),
  CONSTRAINT `pk_1` FOREIGN KEY (`cyuid`) REFERENCES `cyusers` (`cyuid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cymsg
-- ----------------------------
INSERT INTO `cymsg` VALUES ('4', '7', '打', '2017-03-15 09:30:58');
INSERT INTO `cymsg` VALUES ('5', '7', '撒大声地', '2017-03-15 09:43:11');
INSERT INTO `cymsg` VALUES ('6', '7', '你爱谁打你', '2017-03-16 23:47:25');

-- ----------------------------
-- Table structure for `cyusers`
-- ----------------------------
DROP TABLE IF EXISTS `cyusers`;
CREATE TABLE `cyusers` (
  `cyuid` int(11) NOT NULL AUTO_INCREMENT,
  `cyuname` varchar(50) DEFAULT NULL,
  `cyuphone` varchar(11) DEFAULT NULL,
  `cyupwd` varchar(50) DEFAULT NULL,
  `cyrdate` varchar(50) DEFAULT NULL,
  `cyemail` varchar(50) DEFAULT NULL,
  `cyuqq` varchar(50) DEFAULT NULL,
  `cyuaddress` varchar(50) DEFAULT NULL,
  `cyuphoto` varchar(100) DEFAULT NULL,
  `cyustat` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cyuid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cyusers
-- ----------------------------
INSERT INTO `cyusers` VALUES ('7', 'admin', '15235835664', 'adminadmin', null, null, null, null, null, '1');

-- ----------------------------
-- Table structure for `cywant`
-- ----------------------------
DROP TABLE IF EXISTS `cywant`;
CREATE TABLE `cywant` (
  `cywid` int(11) NOT NULL AUTO_INCREMENT,
  `cyuid` int(11) DEFAULT NULL,
  `cywtitle` varchar(50) DEFAULT NULL,
  `cywstr` varchar(150) DEFAULT NULL,
  `cywprice` int(11) DEFAULT NULL,
  `cywdate` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cywid`),
  KEY `pk_2` (`cyuid`),
  CONSTRAINT `pk_2` FOREIGN KEY (`cyuid`) REFERENCES `cyusers` (`cyuid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cywant
-- ----------------------------
