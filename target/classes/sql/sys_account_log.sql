/*
Navicat MySQL Data Transfer

Source Server         : ck
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : usthe

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-06-19 16:51:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_account_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_account_log`;
CREATE TABLE `sys_account_log` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户账户操作日志主键',
  `LOG_NAME` varchar(255) DEFAULT NULL COMMENT '日志名称(login,register,logout)',
  `USER_ID` varchar(30) DEFAULT NULL COMMENT '用户id',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `SUCCEED` tinyint(4) DEFAULT NULL COMMENT '是否执行成功(0失败1成功)',
  `MESSAGE` varchar(255) DEFAULT NULL COMMENT '具体消息',
  `IP` varchar(255) DEFAULT NULL COMMENT '登录ip',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='登录注册登出记录';

-- ----------------------------
-- Records of sys_account_log
-- ----------------------------
INSERT INTO `sys_account_log` VALUES ('17', '用户登录日志', 'tom', '2018-04-22 13:22:39', '1', null, '10.0.75.2');
