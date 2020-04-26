/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50711
Source Host           : 127.0.0.1:3306
Source Database       : easy

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2020-04-26 23:44:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_i18n
-- ----------------------------
DROP TABLE IF EXISTS `sys_i18n`;
CREATE TABLE `sys_i18n` (
  `i18n_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `i18n_key` varchar(100) DEFAULT NULL COMMENT '国际化键值',
  `i18n_content` varchar(200) DEFAULT NULL COMMENT '国际化内容',
  `i18n_lang` varchar(5) DEFAULT NULL COMMENT '国际化语言',
  `i18n_rmk` varchar(100) DEFAULT NULL COMMENT '国际化备注',
  `create_time` datetime DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`i18n_id`),
  UNIQUE KEY `sys_i18n_inx` (`i18n_key`,`i18n_lang`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_i18n
-- ----------------------------
INSERT INTO `sys_i18n` VALUES ('1', 'test', '测试', 'zh-CN', '测试', null, null, null, null);
INSERT INTO `sys_i18n` VALUES ('2', 'test', 'test', 'en-US', 'test', null, null, null, null);
INSERT INTO `sys_i18n` VALUES ('3', 'easy.sys.menu', '菜单', 'zh-CN', '', null, null, null, null);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `menu_name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `menu_url` varchar(200) DEFAULT NULL COMMENT '菜单显示URL',
  `menu_path` varchar(200) DEFAULT NULL COMMENT '菜单对应的前台页面地址',
  `menu_auth` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `menu_type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：隐藏菜单 3：按钮',
  `menu_icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `menu_order` int(11) DEFAULT NULL COMMENT '排序',
  `create_time` datetime DEFAULT NULL,
  `create_by` bigint(64) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` bigint(64) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '权限菜单', '/cust', null, 'sys:user:shiro', '0', 'lan', '1', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('2', '1', '菜单', '/cust/tree', 'tree/index', null, '1', 'lan', '2', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('3', '0', '登陆', '/login', 'login/index', null, '2', null, '10', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('7', '1', 'test', '/cust/table', 'table/index', null, '0', 'user', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('8', '0', '系统管理', '/user/User', 'user/User', null, '0', 'user', '10', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('9', '8', '用户管理', '/user/User', 'user/User', null, '1', 'user', '10', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('10', '8', '菜单管理', '/menu/Menu', 'menu/Menu', null, '1', 'user', '20', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('11', '8', '角色管理', '/role/Role', 'role/Role', null, '1', 'user', '30', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('12', '8', '国际化管理', '/i18n/I18n', 'i18n/I18n', null, '1', 'user', '40', null, null, null, null);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'ADMIN', '管理员', '1', null, null, null);
INSERT INTO `sys_role` VALUES ('2', 'TEST', '测试', null, null, null, null);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('3', '1', '2');
INSERT INTO `sys_role_menu` VALUES ('4', '1', '1');
INSERT INTO `sys_role_menu` VALUES ('5', '2', '9');
INSERT INTO `sys_role_menu` VALUES ('6', '2', '10');
INSERT INTO `sys_role_menu` VALUES ('7', '2', '8');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `user_pwd` varchar(100) DEFAULT NULL COMMENT '密码',
  `user_salt` varchar(64) DEFAULT NULL COMMENT '盐',
  `user_email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `user_mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `user_status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', 'cicada@163.com', '18967835678', '1', '1', '2019-01-18 11:11:11', null, null);
INSERT INTO `sys_user` VALUES ('2', 'fantasy', '123456789', '50', 'vi2014@qq.com', '18344369426', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('3', 'das', 'das', 'dsd', 'dd', 'adasd', '0', null, null, null, null);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '1', '1');
