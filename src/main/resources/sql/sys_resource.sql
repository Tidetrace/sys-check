/*
Navicat MySQL Data Transfer

Source Server         : ck
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : usthe

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-06-19 16:51:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '资源ID',
  `CODE` varchar(30) DEFAULT NULL COMMENT '资源名称',
  `NAME` varchar(30) DEFAULT NULL COMMENT '资源描述',
  `PARENT_ID` int(11) DEFAULT NULL COMMENT '父资源编码->菜单',
  `URI` varchar(100) DEFAULT NULL COMMENT '访问地址URL',
  `TYPE` smallint(4) DEFAULT NULL COMMENT '类型 1:菜单menu 2:资源element(rest-api) 3:资源分类',
  `METHOD` varchar(10) DEFAULT NULL COMMENT '访问方式 GET POST PUT DELETE PATCH',
  `ICON` varchar(100) DEFAULT NULL COMMENT '图标',
  `STATUS` smallint(4) DEFAULT '1' COMMENT '状态   1:正常、9：禁用',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=146 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='资源信息表(菜单,资源)';

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('101', 'ACCOUNT_LOGIN', '用户登录', '103', '/account/login', '2', 'POST', null, '1', null, null);
INSERT INTO `sys_resource` VALUES ('103', 'GROUP_ACCOUNT', '账户系列', '110', '', '3', 'POST', null, '1', null, null);
INSERT INTO `sys_resource` VALUES ('104', 'USER_MAGE', '用户管理', '-1', '', '1', 'POST', 'fa fa-user', '1', null, null);
INSERT INTO `sys_resource` VALUES ('106', 'RESOURCE_MAGE', '资源配置', '-1', '', '1', 'POST', 'fa fa-pie-chart', '1', null, null);
INSERT INTO `sys_resource` VALUES ('107', 'MENU_MANAGE', '菜单管理', '106', '/index/menu', '1', 'POST', 'fa fa-th', '1', null, null);
INSERT INTO `sys_resource` VALUES ('109', 'API_MANAGE', 'API管理', '106', '/index/api', '1', null, 'fa fa-share', '1', '2018-04-07 09:40:24', '2018-04-07 09:40:24');
INSERT INTO `sys_resource` VALUES ('110', 'CATEGORY_GROUP', '分类集合(API类别请放入此集合)', '-1', null, '3', null, null, '1', '2018-04-07 14:27:58', '2018-04-07 14:27:58');
INSERT INTO `sys_resource` VALUES ('112', 'ACCOUNT_REGISTER', '用户注册', '103', '/account/register', '2', 'POST', null, '1', '2018-04-07 16:21:45', '2018-04-07 16:21:45');
INSERT INTO `sys_resource` VALUES ('115', 'GROUP_USER', '用户系列', '110', '', '3', 'GET', null, '1', '2018-04-07 16:31:01', '2018-04-07 16:31:01');
INSERT INTO `sys_resource` VALUES ('117', 'ROLE_MANAGE', '角色管理', '106', '/index/role', '1', null, 'fa fa-adjust', '1', '2018-04-08 05:36:31', '2018-04-08 05:36:31');
INSERT INTO `sys_resource` VALUES ('118', 'GROUP_RESOURCE', '资源系列', '110', null, '3', null, null, '1', '2018-04-09 02:29:14', '2018-04-09 02:29:14');
INSERT INTO `sys_resource` VALUES ('119', 'USER_ROLE_APPID', '获取对应用户角色', '115', '/user/role/*', '2', 'GET', null, '1', '2018-04-12 03:07:22', '2018-04-12 03:07:22');
INSERT INTO `sys_resource` VALUES ('120', 'USER_LIST', '获取用户列表', '115', '/user/list', '2', 'GET', null, '1', '2018-04-12 03:08:30', '2018-04-12 03:08:30');
INSERT INTO `sys_resource` VALUES ('121', 'USER_AUTHORITY_ROLE', '给用户授权添加角色', '115', '/user/authority/role', '2', 'POST', null, '1', '2018-04-12 03:15:56', '2018-04-12 03:15:56');
INSERT INTO `sys_resource` VALUES ('122', 'USER_AUTHORITY_ROLE', '删除已经授权的用户角色', '115', '/user/authority/role', '2', 'DELETE', null, '1', '2018-04-12 03:29:03', '2018-04-12 03:29:03');
INSERT INTO `sys_resource` VALUES ('123', 'RESOURCE_AUTORITYMENU', '获取用户被授权菜单', '118', '/resource/authorityMenu', '2', 'GET', null, '1', '2018-04-12 05:30:03', '2018-04-12 05:30:03');
INSERT INTO `sys_resource` VALUES ('124', 'RESOURCE_MENUS', '获取全部菜单列', '118', '/resource/menus', '2', 'GET', null, '1', '2018-04-12 05:42:46', '2018-04-12 05:42:46');
INSERT INTO `sys_resource` VALUES ('125', 'RESOURCE_MENU', '增加菜单', '118', '/resource/menu', '2', 'POST', null, '1', '2018-04-12 06:15:39', '2018-04-12 06:15:39');
INSERT INTO `sys_resource` VALUES ('126', 'RESOURCE_MENU', '修改菜单', '118', '/resource/menu', '2', 'PUT', null, '1', '2018-04-12 06:16:35', '2018-04-12 06:16:35');
INSERT INTO `sys_resource` VALUES ('127', 'RESOURCE_MENU', '删除菜单', '118', '/resource/menu', '2', 'DELETE', null, '1', '2018-04-12 06:17:18', '2018-04-12 06:17:18');
INSERT INTO `sys_resource` VALUES ('128', 'RESOURCE_API', '获取API list', '118', '/resource/api/*/*/*', '2', 'GET', null, '1', '2018-04-12 06:18:02', '2018-04-12 06:18:02');
INSERT INTO `sys_resource` VALUES ('129', 'RESOURCE_API', '增加API', '118', '/resource/api', '2', 'POST', null, '1', '2018-04-12 06:18:42', '2018-04-12 06:18:42');
INSERT INTO `sys_resource` VALUES ('130', 'RESOURCE_API', '修改API', '118', '/resource/api', '2', 'PUT', null, '1', '2018-04-12 06:19:32', '2018-04-12 06:19:32');
INSERT INTO `sys_resource` VALUES ('131', 'RESOURCE_API', '删除API', '118', '/resource/api', '2', 'DELETE', null, '1', '2018-04-12 06:20:03', '2018-04-12 06:20:03');
INSERT INTO `sys_resource` VALUES ('132', 'GROUP_ROLE', '角色系列', '110', null, '3', null, null, '1', '2018-04-12 06:22:02', '2018-04-12 06:22:02');
INSERT INTO `sys_resource` VALUES ('133', 'ROLE_USER', '获取角色关联用户列表', '132', '/role/user/*/*/*', '2', 'GET', null, '1', '2018-04-12 06:22:59', '2018-04-12 06:22:59');
INSERT INTO `sys_resource` VALUES ('134', 'ROLE_USER', '获取角色未关联用户列表', '132', '/role/user/-/*/*/*', '2', 'GET', null, '1', '2018-04-12 06:24:09', '2018-04-12 06:24:09');
INSERT INTO `sys_resource` VALUES ('135', 'ROLE_API', '获取角色关联API资源', '132', '/role/api/*/*/*', '2', 'GET', null, '1', '2018-04-12 06:25:32', '2018-04-12 06:25:32');
INSERT INTO `sys_resource` VALUES ('136', 'ROLE_API', '获取角色未关联API资源', '132', '/role/api/-/*/*/*', '2', 'GET', null, '1', '2018-04-12 06:26:12', '2018-04-12 06:26:12');
INSERT INTO `sys_resource` VALUES ('137', 'ROLE_MENU', '获取角色关联菜单资源', '132', '/role/menu/*/*/*', '2', 'GET', null, '1', '2018-04-12 06:27:20', '2018-04-12 06:27:20');
INSERT INTO `sys_resource` VALUES ('138', 'ROLE_MENU', '获取角色未关联菜单资源', '132', '/role/menu/-/*/*/*', '2', 'GET', null, '1', '2018-04-12 06:27:56', '2018-04-12 06:27:56');
INSERT INTO `sys_resource` VALUES ('139', 'ROLE_AUTHORITY_RESOURCE', '授权资源给角色', '132', '/role/authority/resource', '2', 'POST', null, '1', '2018-04-12 06:29:45', '2018-04-12 06:29:45');
INSERT INTO `sys_resource` VALUES ('140', 'ROLE_AUTHORITY_RESOURCE', '删除角色的授权资源', '132', '/role/authority/resource', '2', 'DELETE', null, '1', '2018-04-12 06:31:12', '2018-04-12 06:31:12');
INSERT INTO `sys_resource` VALUES ('141', 'ROLE', '获取角色LIST', '132', '/role/*/*', '2', 'GET', null, '1', '2018-04-12 06:32:34', '2018-04-12 06:32:34');
INSERT INTO `sys_resource` VALUES ('142', 'ROLE', '添加角色', '132', '/role', '2', 'POST', null, '1', '2018-04-12 06:33:25', '2018-04-12 06:33:25');
INSERT INTO `sys_resource` VALUES ('143', 'USER', '更新角色', '132', '/role', '2', 'PUT', null, '1', '2018-04-12 06:34:27', '2018-04-12 06:34:27');
INSERT INTO `sys_resource` VALUES ('144', 'ROLE', '删除角色', '132', '/role', '2', 'DELETE', null, '1', '2018-04-12 06:35:15', '2018-04-12 06:35:15');
INSERT INTO `sys_resource` VALUES ('145', 'LOG_WATCH', '日志记录', '104', '/index/log', '1', null, 'fa fa-rss-square', '1', '2018-04-22 08:12:24', '2018-04-22 08:12:24');
