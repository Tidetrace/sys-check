/*
Navicat MySQL Data Transfer

Source Server         : ck
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : usthe

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-06-19 16:51:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `CODE` varchar(30) NOT NULL COMMENT '角色编码',
  `NAME` varchar(30) DEFAULT NULL COMMENT '角色名称',
  `STATUS` smallint(4) DEFAULT '1' COMMENT '状态   1:正常、9：禁用',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色信息表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('100', 'role_admin', '管理员角色', '1', null, null);
INSERT INTO `sys_role` VALUES ('102', 'role_user', '用户角色', '1', null, null);
INSERT INTO `sys_role` VALUES ('103', 'role_guest', '访客角色', '1', null, null);
INSERT INTO `sys_role` VALUES ('104', 'role_anon', '非角色', '1', null, null);
