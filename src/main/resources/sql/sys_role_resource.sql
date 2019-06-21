/*
Navicat MySQL Data Transfer

Source Server         : ck
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : usthe

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-06-19 16:51:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `ROLE_ID` int(11) NOT NULL COMMENT '角色ID',
  `RESOURCE_ID` int(11) NOT NULL COMMENT '资源ID',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE KEY `ROLE_ID` (`ROLE_ID`,`RESOURCE_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=230 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='资源角色关联表';

-- ----------------------------
-- Records of sys_role_resource
-- ----------------------------
INSERT INTO `sys_role_resource` VALUES ('1', '100', '100', null, null);
INSERT INTO `sys_role_resource` VALUES ('3', '102', '100', null, null);
INSERT INTO `sys_role_resource` VALUES ('6', '101', '100', null, null);
INSERT INTO `sys_role_resource` VALUES ('9', '102', '103', null, null);
INSERT INTO `sys_role_resource` VALUES ('10', '103', '105', '2018-04-01 12:50:19', '2018-04-01 12:50:19');
INSERT INTO `sys_role_resource` VALUES ('21', '102', '102', '2018-04-09 21:09:09', '2018-04-09 21:09:09');
INSERT INTO `sys_role_resource` VALUES ('24', '103', '102', '2018-04-09 21:51:43', '2018-04-09 21:51:43');
INSERT INTO `sys_role_resource` VALUES ('25', '103', '103', '2018-04-09 21:51:46', '2018-04-09 21:51:46');
INSERT INTO `sys_role_resource` VALUES ('26', '103', '112', '2018-04-09 21:51:49', '2018-04-09 21:51:49');
INSERT INTO `sys_role_resource` VALUES ('27', '101', '112', '2018-04-09 22:21:02', '2018-04-09 22:21:02');
INSERT INTO `sys_role_resource` VALUES ('28', '101', '103', '2018-04-09 22:21:06', '2018-04-09 22:21:06');
INSERT INTO `sys_role_resource` VALUES ('29', '100', '102', '2018-04-09 22:25:09', '2018-04-09 22:25:09');
INSERT INTO `sys_role_resource` VALUES ('30', '101', '101', '2018-04-09 22:39:28', '2018-04-09 22:39:28');
INSERT INTO `sys_role_resource` VALUES ('31', '103', '100', '2018-04-09 22:45:00', '2018-04-09 22:45:00');
INSERT INTO `sys_role_resource` VALUES ('32', '103', '104', '2018-04-09 22:46:26', '2018-04-09 22:46:26');
INSERT INTO `sys_role_resource` VALUES ('33', '103', '106', '2018-04-09 22:46:28', '2018-04-09 22:46:28');
INSERT INTO `sys_role_resource` VALUES ('36', '103', '116', '2018-04-09 22:46:37', '2018-04-09 22:46:37');
INSERT INTO `sys_role_resource` VALUES ('39', '104', '102', '2018-04-09 22:49:52', '2018-04-09 22:49:52');
INSERT INTO `sys_role_resource` VALUES ('40', '104', '103', '2018-04-09 22:49:55', '2018-04-09 22:49:55');
INSERT INTO `sys_role_resource` VALUES ('41', '100', '103', '2018-04-09 22:51:56', '2018-04-09 22:51:56');
INSERT INTO `sys_role_resource` VALUES ('43', '102', '104', '2018-04-17 14:47:36', '2018-04-17 14:47:36');
INSERT INTO `sys_role_resource` VALUES ('44', '102', '106', '2018-04-17 14:47:40', '2018-04-17 14:47:40');
INSERT INTO `sys_role_resource` VALUES ('45', '102', '107', '2018-04-17 14:47:46', '2018-04-17 14:47:46');
INSERT INTO `sys_role_resource` VALUES ('46', '102', '117', '2018-04-17 14:47:50', '2018-04-17 14:47:50');
INSERT INTO `sys_role_resource` VALUES ('47', '102', '109', '2018-04-17 14:47:54', '2018-04-17 14:47:54');
INSERT INTO `sys_role_resource` VALUES ('48', '100', '112', '2018-04-25 09:58:27', '2018-04-25 09:58:27');
INSERT INTO `sys_role_resource` VALUES ('49', '100', '119', '2018-04-25 09:58:34', '2018-04-25 09:58:34');
INSERT INTO `sys_role_resource` VALUES ('50', '100', '120', '2018-04-25 09:58:38', '2018-04-25 09:58:38');
INSERT INTO `sys_role_resource` VALUES ('51', '100', '121', '2018-04-25 09:58:43', '2018-04-25 09:58:43');
INSERT INTO `sys_role_resource` VALUES ('52', '100', '122', '2018-04-25 09:58:48', '2018-04-25 09:58:48');
INSERT INTO `sys_role_resource` VALUES ('53', '100', '123', '2018-04-25 09:58:53', '2018-04-25 09:58:53');
INSERT INTO `sys_role_resource` VALUES ('54', '100', '124', '2018-04-25 09:58:57', '2018-04-25 09:58:57');
INSERT INTO `sys_role_resource` VALUES ('55', '100', '125', '2018-04-25 09:59:01', '2018-04-25 09:59:01');
INSERT INTO `sys_role_resource` VALUES ('56', '100', '126', '2018-04-25 09:59:06', '2018-04-25 09:59:06');
INSERT INTO `sys_role_resource` VALUES ('57', '100', '127', '2018-04-25 10:00:18', '2018-04-25 10:00:18');
INSERT INTO `sys_role_resource` VALUES ('58', '100', '128', '2018-04-25 10:00:22', '2018-04-25 10:00:22');
INSERT INTO `sys_role_resource` VALUES ('59', '100', '129', '2018-04-25 10:00:27', '2018-04-25 10:00:27');
INSERT INTO `sys_role_resource` VALUES ('60', '100', '130', '2018-04-25 10:00:31', '2018-04-25 10:00:31');
INSERT INTO `sys_role_resource` VALUES ('61', '100', '131', '2018-04-25 10:00:36', '2018-04-25 10:00:36');
INSERT INTO `sys_role_resource` VALUES ('62', '100', '133', '2018-04-25 10:00:43', '2018-04-25 10:00:43');
INSERT INTO `sys_role_resource` VALUES ('66', '102', '121', '2018-04-25 11:35:02', '2018-04-25 11:35:02');
INSERT INTO `sys_role_resource` VALUES ('67', '102', '122', '2018-04-25 11:35:07', '2018-04-25 11:35:07');
INSERT INTO `sys_role_resource` VALUES ('68', '102', '123', '2018-04-25 11:35:12', '2018-04-25 11:35:12');
INSERT INTO `sys_role_resource` VALUES ('69', '102', '124', '2018-04-25 11:35:17', '2018-04-25 11:35:17');
INSERT INTO `sys_role_resource` VALUES ('70', '102', '139', '2018-04-25 11:35:30', '2018-04-25 11:35:30');
INSERT INTO `sys_role_resource` VALUES ('71', '102', '140', '2018-04-25 11:35:35', '2018-04-25 11:35:35');
INSERT INTO `sys_role_resource` VALUES ('72', '102', '136', '2018-04-25 11:35:49', '2018-04-25 11:35:49');
INSERT INTO `sys_role_resource` VALUES ('73', '100', '134', '2018-04-25 11:36:16', '2018-04-25 11:36:16');
INSERT INTO `sys_role_resource` VALUES ('74', '100', '135', '2018-04-25 11:36:21', '2018-04-25 11:36:21');
INSERT INTO `sys_role_resource` VALUES ('75', '100', '136', '2018-04-25 11:36:25', '2018-04-25 11:36:25');
INSERT INTO `sys_role_resource` VALUES ('76', '100', '137', '2018-04-25 11:36:32', '2018-04-25 11:36:32');
INSERT INTO `sys_role_resource` VALUES ('77', '100', '138', '2018-04-25 11:36:36', '2018-04-25 11:36:36');
INSERT INTO `sys_role_resource` VALUES ('78', '100', '139', '2018-04-25 11:36:41', '2018-04-25 11:36:41');
INSERT INTO `sys_role_resource` VALUES ('79', '100', '140', '2018-04-25 11:36:45', '2018-04-25 11:36:45');
INSERT INTO `sys_role_resource` VALUES ('80', '100', '141', '2018-04-25 11:36:50', '2018-04-25 11:36:50');
INSERT INTO `sys_role_resource` VALUES ('81', '100', '142', '2018-04-25 11:36:54', '2018-04-25 11:36:54');
INSERT INTO `sys_role_resource` VALUES ('82', '100', '143', '2018-04-25 11:36:58', '2018-04-25 11:36:58');
INSERT INTO `sys_role_resource` VALUES ('83', '100', '144', '2018-04-25 11:37:02', '2018-04-25 11:37:02');
INSERT INTO `sys_role_resource` VALUES ('84', '100', '104', '2018-04-25 12:22:01', '2018-04-25 12:22:01');
INSERT INTO `sys_role_resource` VALUES ('85', '100', '106', '2018-04-25 12:22:06', '2018-04-25 12:22:06');
INSERT INTO `sys_role_resource` VALUES ('86', '100', '107', '2018-04-25 12:22:10', '2018-04-25 12:22:10');
INSERT INTO `sys_role_resource` VALUES ('87', '100', '109', '2018-04-25 12:22:15', '2018-04-25 12:22:15');
INSERT INTO `sys_role_resource` VALUES ('88', '100', '117', '2018-04-25 12:22:19', '2018-04-25 12:22:19');
INSERT INTO `sys_role_resource` VALUES ('89', '100', '146', '2018-04-25 12:22:22', '2018-04-25 12:22:22');
INSERT INTO `sys_role_resource` VALUES ('90', '102', '146', '2018-04-25 18:55:27', '2018-04-25 18:55:27');
INSERT INTO `sys_role_resource` VALUES ('92', '102', '125', '2018-04-25 18:55:50', '2018-04-25 18:55:50');
INSERT INTO `sys_role_resource` VALUES ('93', '102', '126', '2018-04-25 18:55:54', '2018-04-25 18:55:54');
INSERT INTO `sys_role_resource` VALUES ('94', '102', '127', '2018-04-25 18:55:59', '2018-04-25 18:55:59');
INSERT INTO `sys_role_resource` VALUES ('95', '102', '128', '2018-04-25 18:56:03', '2018-04-25 18:56:03');
INSERT INTO `sys_role_resource` VALUES ('97', '102', '130', '2018-04-25 18:56:12', '2018-04-25 18:56:12');
INSERT INTO `sys_role_resource` VALUES ('98', '102', '131', '2018-04-25 18:56:16', '2018-04-25 18:56:16');
INSERT INTO `sys_role_resource` VALUES ('99', '103', '119', '2018-04-25 18:56:47', '2018-04-25 18:56:47');
INSERT INTO `sys_role_resource` VALUES ('100', '103', '121', '2018-04-25 18:56:51', '2018-04-25 18:56:51');
INSERT INTO `sys_role_resource` VALUES ('101', '103', '122', '2018-04-25 18:56:55', '2018-04-25 18:56:55');
INSERT INTO `sys_role_resource` VALUES ('102', '103', '120', '2018-04-25 18:57:00', '2018-04-25 18:57:00');
INSERT INTO `sys_role_resource` VALUES ('104', '102', '129', '2018-04-25 18:57:35', '2018-04-25 18:57:35');
INSERT INTO `sys_role_resource` VALUES ('105', '102', '135', '2018-04-25 18:57:43', '2018-04-25 18:57:43');
INSERT INTO `sys_role_resource` VALUES ('106', '102', '133', '2018-04-25 18:57:47', '2018-04-25 18:57:47');
INSERT INTO `sys_role_resource` VALUES ('107', '102', '134', '2018-04-25 18:57:51', '2018-04-25 18:57:51');
INSERT INTO `sys_role_resource` VALUES ('108', '102', '137', '2018-04-25 18:57:55', '2018-04-25 18:57:55');
INSERT INTO `sys_role_resource` VALUES ('109', '102', '138', '2018-04-25 18:57:59', '2018-04-25 18:57:59');
INSERT INTO `sys_role_resource` VALUES ('110', '102', '141', '2018-04-25 18:58:03', '2018-04-25 18:58:03');
INSERT INTO `sys_role_resource` VALUES ('111', '102', '142', '2018-04-25 18:58:07', '2018-04-25 18:58:07');
INSERT INTO `sys_role_resource` VALUES ('112', '102', '143', '2018-04-25 18:58:11', '2018-04-25 18:58:11');
INSERT INTO `sys_role_resource` VALUES ('113', '102', '144', '2018-04-25 18:58:14', '2018-04-25 18:58:14');
INSERT INTO `sys_role_resource` VALUES ('114', '103', '123', '2018-04-25 18:58:20', '2018-04-25 18:58:20');
INSERT INTO `sys_role_resource` VALUES ('115', '103', '124', '2018-04-25 18:58:24', '2018-04-25 18:58:24');
INSERT INTO `sys_role_resource` VALUES ('116', '103', '125', '2018-04-25 18:58:29', '2018-04-25 18:58:29');
INSERT INTO `sys_role_resource` VALUES ('119', '103', '128', '2018-04-25 18:58:42', '2018-04-25 18:58:42');
INSERT INTO `sys_role_resource` VALUES ('120', '103', '129', '2018-04-25 18:58:46', '2018-04-25 18:58:46');
INSERT INTO `sys_role_resource` VALUES ('121', '103', '130', '2018-04-25 18:58:51', '2018-04-25 18:58:51');
INSERT INTO `sys_role_resource` VALUES ('123', '103', '133', '2018-04-25 18:59:00', '2018-04-25 18:59:00');
INSERT INTO `sys_role_resource` VALUES ('124', '103', '134', '2018-04-25 18:59:04', '2018-04-25 18:59:04');
INSERT INTO `sys_role_resource` VALUES ('125', '103', '135', '2018-04-25 18:59:08', '2018-04-25 18:59:08');
INSERT INTO `sys_role_resource` VALUES ('126', '103', '136', '2018-04-25 18:59:12', '2018-04-25 18:59:12');
INSERT INTO `sys_role_resource` VALUES ('127', '103', '137', '2018-04-25 18:59:16', '2018-04-25 18:59:16');
INSERT INTO `sys_role_resource` VALUES ('128', '103', '138', '2018-04-25 18:59:21', '2018-04-25 18:59:21');
INSERT INTO `sys_role_resource` VALUES ('129', '103', '139', '2018-04-25 18:59:24', '2018-04-25 18:59:24');
INSERT INTO `sys_role_resource` VALUES ('131', '103', '141', '2018-04-25 18:59:33', '2018-04-25 18:59:33');
INSERT INTO `sys_role_resource` VALUES ('132', '103', '142', '2018-04-25 18:59:37', '2018-04-25 18:59:37');
INSERT INTO `sys_role_resource` VALUES ('133', '103', '143', '2018-04-25 18:59:41', '2018-04-25 18:59:41');
INSERT INTO `sys_role_resource` VALUES ('135', '100', '148', '2018-04-26 16:05:43', '2018-04-26 16:05:43');
INSERT INTO `sys_role_resource` VALUES ('136', '100', '147', '2018-04-26 17:26:55', '2018-04-26 17:26:55');
INSERT INTO `sys_role_resource` VALUES ('139', '103', '150', '2018-04-26 23:12:29', '2018-04-26 23:12:29');
INSERT INTO `sys_role_resource` VALUES ('141', '102', '151', '2018-04-27 12:45:59', '2018-04-27 12:45:59');
INSERT INTO `sys_role_resource` VALUES ('142', '102', '149', '2018-04-27 12:46:04', '2018-04-27 12:46:04');
INSERT INTO `sys_role_resource` VALUES ('143', '103', '126', '2018-05-22 19:59:16', '2018-05-22 19:59:16');
INSERT INTO `sys_role_resource` VALUES ('144', '103', '127', '2018-05-22 19:59:21', '2018-05-22 19:59:21');
INSERT INTO `sys_role_resource` VALUES ('146', '102', '119', '2018-05-22 19:59:31', '2018-05-22 19:59:31');
INSERT INTO `sys_role_resource` VALUES ('147', '102', '120', '2018-05-22 19:59:35', '2018-05-22 19:59:35');
INSERT INTO `sys_role_resource` VALUES ('148', '102', '101', '2018-05-22 19:59:39', '2018-05-22 19:59:39');
INSERT INTO `sys_role_resource` VALUES ('149', '100', '101', '2018-05-23 17:08:33', '2018-05-23 17:08:33');
INSERT INTO `sys_role_resource` VALUES ('150', '106', '117', '2018-05-24 09:52:50', '2018-05-24 09:52:50');
INSERT INTO `sys_role_resource` VALUES ('153', '104', '154', '2018-05-24 11:29:36', '2018-05-24 11:29:36');
INSERT INTO `sys_role_resource` VALUES ('155', '100', '153', '2018-05-24 12:47:53', '2018-05-24 12:47:53');
INSERT INTO `sys_role_resource` VALUES ('156', '100', '155', '2018-05-24 16:26:33', '2018-05-24 16:26:33');
INSERT INTO `sys_role_resource` VALUES ('157', '103', '152', '2018-05-24 17:01:42', '2018-05-24 17:01:42');
INSERT INTO `sys_role_resource` VALUES ('158', '103', '101', '2018-05-24 17:02:15', '2018-05-24 17:02:15');
INSERT INTO `sys_role_resource` VALUES ('159', '102', '156', '2018-05-24 17:38:16', '2018-05-24 17:38:16');
INSERT INTO `sys_role_resource` VALUES ('160', '100', '150', '2018-05-24 22:20:00', '2018-05-24 22:20:00');
INSERT INTO `sys_role_resource` VALUES ('161', '102', '147', '2018-05-31 10:16:45', '2018-05-31 10:16:45');
INSERT INTO `sys_role_resource` VALUES ('162', '102', '150', '2018-05-31 10:16:49', '2018-05-31 10:16:49');
INSERT INTO `sys_role_resource` VALUES ('163', '102', '157', '2018-05-31 10:16:54', '2018-05-31 10:16:54');
INSERT INTO `sys_role_resource` VALUES ('164', '102', '158', '2018-05-31 10:16:58', '2018-05-31 10:16:58');
INSERT INTO `sys_role_resource` VALUES ('165', '103', '157', '2018-05-31 10:18:05', '2018-05-31 10:18:05');
INSERT INTO `sys_role_resource` VALUES ('166', '104', '156', '2018-05-31 10:19:00', '2018-05-31 10:19:00');
INSERT INTO `sys_role_resource` VALUES ('169', '104', '155', '2018-05-31 17:14:28', '2018-05-31 17:14:28');
INSERT INTO `sys_role_resource` VALUES ('170', '110', '101', '2018-06-01 10:52:20', '2018-06-01 10:52:20');
INSERT INTO `sys_role_resource` VALUES ('171', '110', '128', '2018-06-01 10:52:32', '2018-06-01 10:52:32');
INSERT INTO `sys_role_resource` VALUES ('172', '100', '163', '2018-06-01 10:55:56', '2018-06-01 10:55:56');
INSERT INTO `sys_role_resource` VALUES ('173', '102', '163', '2018-06-01 10:56:19', '2018-06-01 10:56:19');
INSERT INTO `sys_role_resource` VALUES ('175', '104', '163', '2018-06-01 10:56:41', '2018-06-01 10:56:41');
INSERT INTO `sys_role_resource` VALUES ('176', '109', '163', '2018-06-01 10:56:48', '2018-06-01 10:56:48');
INSERT INTO `sys_role_resource` VALUES ('177', '110', '163', '2018-06-01 10:56:54', '2018-06-01 10:56:54');
INSERT INTO `sys_role_resource` VALUES ('178', '102', '162', '2018-06-01 11:09:41', '2018-06-01 11:09:41');
INSERT INTO `sys_role_resource` VALUES ('179', '102', '161', '2018-06-01 11:09:46', '2018-06-01 11:09:46');
INSERT INTO `sys_role_resource` VALUES ('180', '110', '106', '2018-06-01 17:08:03', '2018-06-01 17:08:03');
INSERT INTO `sys_role_resource` VALUES ('181', '110', '160', '2018-06-01 17:08:15', '2018-06-01 17:08:15');
INSERT INTO `sys_role_resource` VALUES ('182', '102', '164', '2018-06-01 18:34:44', '2018-06-01 18:34:44');
INSERT INTO `sys_role_resource` VALUES ('184', '104', '101', '2018-06-01 18:35:25', '2018-06-01 18:35:25');
INSERT INTO `sys_role_resource` VALUES ('185', '103', '156', '2018-06-02 01:09:37', '2018-06-02 01:09:37');
INSERT INTO `sys_role_resource` VALUES ('186', '110', '146', '2018-06-02 01:09:48', '2018-06-02 01:09:48');
INSERT INTO `sys_role_resource` VALUES ('187', '100', '164', '2018-06-02 10:22:06', '2018-06-02 10:22:06');
INSERT INTO `sys_role_resource` VALUES ('188', '109', '141', '2018-06-03 06:45:46', '2018-06-03 06:45:46');
INSERT INTO `sys_role_resource` VALUES ('189', '102', '166', '2018-07-10 08:52:53', '2018-07-10 08:52:53');
INSERT INTO `sys_role_resource` VALUES ('190', '109', '125', '2018-07-10 13:50:03', '2018-07-10 13:50:03');
INSERT INTO `sys_role_resource` VALUES ('191', '100', '162', '2018-07-10 22:41:41', '2018-07-10 22:41:41');
INSERT INTO `sys_role_resource` VALUES ('192', '111', '109', '2018-07-10 22:42:42', '2018-07-10 22:42:42');
INSERT INTO `sys_role_resource` VALUES ('194', '103', '140', '2018-07-11 17:40:50', '2018-07-11 17:40:50');
INSERT INTO `sys_role_resource` VALUES ('196', '103', '131', '2018-10-15 21:55:22', '2018-10-15 21:55:22');
INSERT INTO `sys_role_resource` VALUES ('197', '100', '149', '2018-10-16 16:25:08', '2018-10-16 16:25:08');
INSERT INTO `sys_role_resource` VALUES ('199', '102', '155', '2018-10-17 10:44:46', '2018-10-17 10:44:46');
INSERT INTO `sys_role_resource` VALUES ('200', '100', '168', '2018-11-12 14:14:52', '2018-11-12 14:14:52');
INSERT INTO `sys_role_resource` VALUES ('201', '100', '167', '2018-11-12 14:19:35', '2018-11-12 14:19:35');
INSERT INTO `sys_role_resource` VALUES ('202', '100', '169', '2018-11-12 14:21:29', '2018-11-12 14:21:29');
INSERT INTO `sys_role_resource` VALUES ('203', '102', '167', '2018-11-19 14:45:31', '2018-11-19 14:45:31');
INSERT INTO `sys_role_resource` VALUES ('204', '102', '170', '2018-11-20 12:51:56', '2018-11-20 12:51:56');
INSERT INTO `sys_role_resource` VALUES ('210', '103', '149', '2018-11-20 23:18:54', '2018-11-20 23:18:54');
INSERT INTO `sys_role_resource` VALUES ('211', '103', '151', '2018-11-20 23:18:59', '2018-11-20 23:18:59');
INSERT INTO `sys_role_resource` VALUES ('212', '103', '171', '2018-11-20 23:19:06', '2018-11-20 23:19:06');
INSERT INTO `sys_role_resource` VALUES ('213', '103', '172', '2018-11-20 23:19:13', '2018-11-20 23:19:13');
INSERT INTO `sys_role_resource` VALUES ('214', '103', '173', '2018-11-20 23:19:25', '2018-11-20 23:19:25');
INSERT INTO `sys_role_resource` VALUES ('215', '103', '176', '2018-11-20 23:19:31', '2018-11-20 23:19:31');
INSERT INTO `sys_role_resource` VALUES ('216', '103', '175', '2018-11-20 23:19:37', '2018-11-20 23:19:37');
INSERT INTO `sys_role_resource` VALUES ('217', '103', '174', '2018-11-20 23:19:42', '2018-11-20 23:19:42');
INSERT INTO `sys_role_resource` VALUES ('218', '103', '107', '2018-12-04 09:23:35', '2018-12-04 09:23:35');
INSERT INTO `sys_role_resource` VALUES ('219', '103', '144', '2018-12-04 09:24:04', '2018-12-04 09:24:04');
INSERT INTO `sys_role_resource` VALUES ('220', '102', '171', '2018-12-04 11:14:56', '2018-12-04 11:14:56');
INSERT INTO `sys_role_resource` VALUES ('221', '104', '142', '2018-12-04 15:11:07', '2018-12-04 15:11:07');
INSERT INTO `sys_role_resource` VALUES ('222', '104', '143', '2018-12-04 15:11:13', '2018-12-04 15:11:13');
INSERT INTO `sys_role_resource` VALUES ('223', '102', '173', '2018-12-05 08:44:10', '2018-12-05 08:44:10');
INSERT INTO `sys_role_resource` VALUES ('224', '113', '120', '2018-12-05 10:38:16', '2018-12-05 10:38:16');
INSERT INTO `sys_role_resource` VALUES ('225', '113', '128', '2018-12-05 10:38:20', '2018-12-05 10:38:20');
INSERT INTO `sys_role_resource` VALUES ('226', '102', '154', '2019-02-18 03:14:01', '2019-02-18 03:14:01');
INSERT INTO `sys_role_resource` VALUES ('227', '102', '179', '2019-02-20 05:51:05', '2019-02-20 05:51:05');
INSERT INTO `sys_role_resource` VALUES ('228', '102', '178', '2019-02-20 07:52:28', '2019-02-20 07:52:28');
INSERT INTO `sys_role_resource` VALUES ('229', '102', '180', '2019-02-20 07:56:28', '2019-02-20 07:56:28');
