/*
Navicat MySQL Data Transfer

Source Server         : localMysql
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : springboot

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2018-06-13 23:04:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(225) NOT NULL AUTO_INCREMENT,
  `name` varchar(225) DEFAULT NULL,
  `salary` double(225,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'mike', '3000');
INSERT INTO `account` VALUES ('2', '张国荣', '9');
INSERT INTO `account` VALUES ('3', '刘德华', '400');
INSERT INTO `account` VALUES ('4', '钟楚红', '1983');
INSERT INTO `account` VALUES ('5', '周润发', '1980');
INSERT INTO `account` VALUES ('6', '黎明', '999');
INSERT INTO `account` VALUES ('7', '王祖贤', '1988');
INSERT INTO `account` VALUES ('8', '王祖蓝', '2016');
INSERT INTO `account` VALUES ('9', '任贤齐', '2001');
INSERT INTO `account` VALUES ('10', '周星驰', '1988');
INSERT INTO `account` VALUES ('11', 'mike', '18');
INSERT INTO `account` VALUES ('16', 'mike', '18');
INSERT INTO `account` VALUES ('18', 'mike', '18');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(225) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `age` int(20) DEFAULT NULL,
  `school` varchar(225) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `count` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '张国荣', '男', '46', '香港中文大学', '2', '1');
INSERT INTO `student` VALUES ('2', '李荣基', '男', '78', '北京大学', '3', '1');
INSERT INTO `student` VALUES ('3', '周迅', '女', '33', '上戏', '1', '2');
INSERT INTO `student` VALUES ('4', '董美', '女', '38', '上戏', '1', '1');
INSERT INTO `student` VALUES ('5', '李静', '女', '28', '石油大学', '3', '1');
INSERT INTO `student` VALUES ('6', '王丽', '女', '25', '西昌学院', '3', '1');
INSERT INTO `student` VALUES ('7', '周润发', '男', '65', '香港', '1', '1');
INSERT INTO `student` VALUES ('8', '张国立', '男', '60', '四川', '3', '1');
INSERT INTO `student` VALUES ('9', '马未都', '男', '66', '北京', '2', '1');
INSERT INTO `student` VALUES ('10', '李丽君', '女', '35', '广州', '2', '1');
INSERT INTO `student` VALUES ('11', '迪丽热巴', '女', '25', '新疆', '3', '1');
INSERT INTO `student` VALUES ('12', '王祖蓝', '男', '38', '香港', '2', '1');
INSERT INTO `student` VALUES ('13', '曾志伟', '男', '65', '香港', '1', '1');
INSERT INTO `student` VALUES ('14', '艾琪', '女', '24', '广州', '2', '1');
INSERT INTO `student` VALUES ('15', '我就是欢', '男', '26', '上戏', '1', '1');
INSERT INTO `student` VALUES ('16', '2018', '女', '26', '四川大學', '1', '1');
INSERT INTO `student` VALUES ('17', '周星驰', '男', '58', '香港', '2', '1');
INSERT INTO `student` VALUES ('18', '周星驰', '男', '58', '香港', '2', '1');
INSERT INTO `student` VALUES ('19', '周星驰3', '男', '58', '香港', '2', '1');
INSERT INTO `student` VALUES ('20', '周星驰4', '男', '58', '香港', '2', '1');
INSERT INTO `student` VALUES ('21', '周星驰5', '男', '58', '香港', '2', '1');
INSERT INTO `student` VALUES ('22', '周星驰', '男', '58', '香港', '2', '1');
INSERT INTO `student` VALUES ('23', '周星驰7', '男', '58', '香港', '2', '1');
INSERT INTO `student` VALUES ('24', '周星驰8', '男', '58', '香港', '2', '1');
INSERT INTO `student` VALUES ('25', '周星驰9', '男', '58', '香港', '2', '1');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `money` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `operator` varchar(255) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', '11', '无成人陪伴儿童', '100', '1');
INSERT INTO `test` VALUES ('2', '11', '小动物托运', '200', '1');
INSERT INTO `test` VALUES ('1', '12', '担架旅客', '300', '1');
INSERT INTO `test` VALUES ('1', '12', '婴儿摇篮', '400', '1');
INSERT INTO `test` VALUES ('2', '11', '轮椅旅客', '100', '1');
INSERT INTO `test` VALUES ('1', '12', 'VIP旅客', '500', '1');
INSERT INTO `test` VALUES ('2', '12', 'VVIP旅客', '500', '2');
INSERT INTO `test` VALUES ('2', '12', '军残旅客', '111', '2');
INSERT INTO `test` VALUES ('1', '12', '警残旅客', '222', '2');

-- ----------------------------
-- Table structure for t_department
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '部门名称',
  `employee_amount` int(7) DEFAULT NULL COMMENT '部门员工人数',
  `code` varchar(11) CHARACTER SET utf8 DEFAULT NULL COMMENT '部门编号',
  `last_modify_time` datetime DEFAULT NULL COMMENT '最后编辑时间',
  `super_code` varchar(11) CHARACTER SET utf8 DEFAULT NULL COMMENT '上级部门id',
  `status` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '状态',
  `company` varchar(255) CHARACTER SET utf8 DEFAULT '' COMMENT '所属航空公司',
  PRIMARY KEY (`id`),
  KEY `code` (`code`),
  KEY `super_code` (`super_code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES ('1', '业务管理部', '156', '1', '2018-05-24 16:06:59', '', '启用', 'CA');
INSERT INTO `t_department` VALUES ('2', '开发部', '157', '2', '2018-05-24 16:11:24', 'cs1111', '停用', 'CA');
INSERT INTO `t_department` VALUES ('3', '市场部   ', '158', '12', '2018-05-24 16:14:40', 'cd1111', '启用', 'CA');

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 DEFAULT NULL,
  `parent_id` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '父菜单id',
  `order` tinyint(4) DEFAULT NULL COMMENT '菜单顺序',
  `url` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '访问地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '系统管理', '', '1', '');
INSERT INTO `t_menu` VALUES ('2', '角色管理', '1', null, '/role');
INSERT INTO `t_menu` VALUES ('3', '员工管理', '1', null, '/user');

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('1', 'user:*');
INSERT INTO `t_permission` VALUES ('2', 'student:*');
INSERT INTO `t_permission` VALUES ('3', 'user:select');
INSERT INTO `t_permission` VALUES ('4', 'user:add');
INSERT INTO `t_permission` VALUES ('5', 'user:update');
INSERT INTO `t_permission` VALUES ('6', 'user:delete');
INSERT INTO `t_permission` VALUES ('7', 'user:freeze');
INSERT INTO `t_permission` VALUES ('8', 'user:reset');
INSERT INTO `t_permission` VALUES ('9', 'role:select');
INSERT INTO `t_permission` VALUES ('10', 'role:add');
INSERT INTO `t_permission` VALUES ('11', 'role:update');
INSERT INTO `t_permission` VALUES ('12', 'role:delete');
INSERT INTO `t_permission` VALUES ('13', 'personal:select');
INSERT INTO `t_permission` VALUES ('14', 'personal:export');
INSERT INTO `t_permission` VALUES ('15', 'personal:import');
INSERT INTO `t_permission` VALUES ('16', 'personal:update');
INSERT INTO `t_permission` VALUES ('17', 'personal:print');
INSERT INTO `t_permission` VALUES ('18', 'team:select');
INSERT INTO `t_permission` VALUES ('19', 'team:export');
INSERT INTO `t_permission` VALUES ('20', 'team:import');
INSERT INTO `t_permission` VALUES ('21', 'team:update');
INSERT INTO `t_permission` VALUES ('22', 'team:print');
INSERT INTO `t_permission` VALUES ('23', 'home:select');
INSERT INTO `t_permission` VALUES ('24', 'home:issued');
INSERT INTO `t_permission` VALUES ('25', 'home:save');
INSERT INTO `t_permission` VALUES ('26', 'department:add');
INSERT INTO `t_permission` VALUES ('27', 'department:update');
INSERT INTO `t_permission` VALUES ('28', 'department:delete');
INSERT INTO `t_permission` VALUES ('29', 'personal:select-day');
INSERT INTO `t_permission` VALUES ('30', 'personal:export-day');
INSERT INTO `t_permission` VALUES ('31', 'personal:import-day');
INSERT INTO `t_permission` VALUES ('32', 'personal:update-day');
INSERT INTO `t_permission` VALUES ('33', 'personal:print-day');
INSERT INTO `t_permission` VALUES ('34', 'team:select-day');
INSERT INTO `t_permission` VALUES ('35', 'team:export-day');
INSERT INTO `t_permission` VALUES ('36', 'team:import-day');
INSERT INTO `t_permission` VALUES ('37', 'team:update-day');
INSERT INTO `t_permission` VALUES ('38', 'team:print-day');

-- ----------------------------
-- Table structure for t_permission_role
-- ----------------------------
DROP TABLE IF EXISTS `t_permission_role`;
CREATE TABLE `t_permission_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `permission_id` (`permission_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `t_permission_role_ibfk_1` FOREIGN KEY (`permission_id`) REFERENCES `t_permission` (`id`),
  CONSTRAINT `t_permission_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission_role
-- ----------------------------
INSERT INTO `t_permission_role` VALUES ('1', '2', '1');
INSERT INTO `t_permission_role` VALUES ('2', '2', '2');
INSERT INTO `t_permission_role` VALUES ('121', '3', '64');
INSERT INTO `t_permission_role` VALUES ('122', '4', '64');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  `role_num` int(11) DEFAULT NULL,
  `last_edit_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'admin', '1', '2018.05.23 14:52:05');
INSERT INTO `t_role` VALUES ('2', 'student', '1', '2018.05.23 14:52:05');
INSERT INTO `t_role` VALUES ('6', '林俊杰', '0', '2018.05.23 14:52:05');
INSERT INTO `t_role` VALUES ('46', '打发1', '0', '2018.05.23 14:52:05');
INSERT INTO `t_role` VALUES ('48', 'rrr', '0', '2018.05.23 14:52:05');
INSERT INTO `t_role` VALUES ('54', '编辑', '0', '2018.05.23 14:52:05');
INSERT INTO `t_role` VALUES ('55', 'ppp111', '0', '2018.05.23 14:52:05');
INSERT INTO `t_role` VALUES ('64', 'aaa1', '0', '2018.05.24 15:47:57');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工表id',
  `work_id` varchar(255) NOT NULL COMMENT '员工工号',
  `username` varchar(255) NOT NULL COMMENT '员工名字',
  `password` varchar(255) NOT NULL COMMENT '员工密码',
  `password_expiry_date` datetime NOT NULL COMMENT '密码有效截止时间',
  `department_id` int(11) DEFAULT NULL COMMENT '所属部门id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `final_editing_time` datetime DEFAULT NULL COMMENT '最后编辑时间',
  `final_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `state` tinyint(1) DEFAULT '0' COMMENT '员工状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '1', '张三', '123', '2018-05-22 10:06:23', null, null, null, null, '0');
INSERT INTO `t_user` VALUES ('2', '2', '李四', '111', '0000-00-00 00:00:00', null, null, null, null, '0');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `t_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1', '1');
INSERT INTO `t_user_role` VALUES ('2', '2', '2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(225) DEFAULT NULL,
  `dept` varchar(225) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `money` varchar(225) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
