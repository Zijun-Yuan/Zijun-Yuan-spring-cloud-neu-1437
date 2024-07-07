/*
 Navicat Premium Data Transfer

 Source Server         : 2024
 Source Server Type    : MySQL
 Source Server Version : 80022 (8.0.22-cynos)
 Source Host           : sh-cynosdbmysql-grp-p5gfqnbw.sql.tencentcdb.com:26557
 Source Schema         : eps

 Target Server Type    : MySQL
 Target Server Version : 80022 (8.0.22-cynos)
 File Encoding         : 65001

 Date: 05/07/2024 18:25:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int NOT NULL AUTO_INCREMENT COMMENT '系统管理员编号',
  `admin_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统管理员登录编码',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统管理员登录密码',
  `remarks` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city`  (
  `city_code` varchar(9) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '城市编号',
  `city_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '城市名',
  `province_id` int NOT NULL COMMENT '城市所属省份id',
  PRIMARY KEY (`city_code`) USING BTREE,
  INDEX `province_id`(`province_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for info
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info`  (
  `info_id` int NOT NULL AUTO_INCREMENT COMMENT '信息id',
  `status` int NOT NULL DEFAULT 1 COMMENT '0已删除\r\n1公众监督员supervisor已提交\r\n2已指派网格员inspector\r\n3网格员inspector已填写',
  `aqi_level` int NOT NULL COMMENT 'aqi等级1-6',
  `city_code` int NOT NULL COMMENT '城市代码',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '详细地址',
  `feedback` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '反馈信息',
  `time_supervisor` datetime NOT NULL COMMENT '反馈时间（公众监督员）',
  `time_inspector` datetime NULL DEFAULT NULL COMMENT '反馈时间（网格员）',
  `so2` double NULL DEFAULT NULL COMMENT 'so2浓度',
  `co` double NULL DEFAULT NULL COMMENT 'co浓度',
  `o3` double NULL DEFAULT NULL COMMENT '臭氧',
  `pm25` double NULL DEFAULT NULL COMMENT 'pm2.5浓度',
  `supervisor_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公众监督员姓名',
  `inspector_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网格员姓名',
  `aqi_real` int NULL DEFAULT NULL COMMENT 'aqi的值',
  PRIMARY KEY (`info_id`) USING BTREE,
  INDEX `city_code`(`city_code` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 399 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for info_with_inspector
-- ----------------------------
DROP TABLE IF EXISTS `info_with_inspector`;
CREATE TABLE `info_with_inspector`  (
  `i_id` int NOT NULL COMMENT '网格员负责事件id',
  `info_id` int NOT NULL COMMENT '网格员负责信息id',
  `inspector_id` int NOT NULL COMMENT '网格员id',
  `isdel` int NOT NULL DEFAULT 0 COMMENT '软删除\r\n0是未删除\r\n1是已删除',
  PRIMARY KEY (`i_id`) USING BTREE,
  INDEX `info_id`(`info_id` ASC) USING BTREE,
  INDEX `inspector_id`(`inspector_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for info_with_supervisor
-- ----------------------------
DROP TABLE IF EXISTS `info_with_supervisor`;
CREATE TABLE `info_with_supervisor`  (
  `s_id` int NOT NULL COMMENT '公众监督员负责事件id',
  `info_id` int NOT NULL COMMENT '公众监督员负责信息id',
  `supervisor_id` int NOT NULL COMMENT '公众监督员id',
  `isdel` int NOT NULL DEFAULT 0 COMMENT '软删除\r\n0是未删除\r\n1是已删除',
  PRIMARY KEY (`s_id`) USING BTREE,
  INDEX `infos_id`(`info_id` ASC) USING BTREE,
  INDEX `supervisor_id`(`supervisor_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for inspector
-- ----------------------------
DROP TABLE IF EXISTS `inspector`;
CREATE TABLE `inspector`  (
  `inspector_id` int NOT NULL AUTO_INCREMENT COMMENT '网格员编号',
  `inspector_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '网格员登录编码',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '网格员登录密码',
  `tel_num` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '网格员电话',
  `real_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '网格员姓名',
  `city_code` varchar(9) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '网格员所负责的城市代码',
  `isdel` int NULL DEFAULT NULL COMMENT '软删除\r\n0 能使用\r\n1 已删除',
  `remarks` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`inspector_id`) USING BTREE,
  INDEX `city_code_inspector`(`city_code` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province`  (
  `province_id` int NOT NULL COMMENT '省id',
  `province_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '省名',
  `simple_name` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省简称',
  `index` int NULL DEFAULT NULL COMMENT 'index排名',
  PRIMARY KEY (`province_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for supervisor
-- ----------------------------
DROP TABLE IF EXISTS `supervisor`;
CREATE TABLE `supervisor`  (
  `supervisor_id` int NOT NULL AUTO_INCREMENT COMMENT '公众监督员id',
  `tel_id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '公众监督员编号（手机号码）',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公众监督员登录密码',
  `real_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公众监督员真实姓名',
  `birthday` date NOT NULL COMMENT '公众监督员生日日期',
  `sex` int NOT NULL DEFAULT 1 COMMENT '公众监督员性别（1：男；0：女）',
  `age` int NOT NULL COMMENT '公众监督员年龄',
  `isdel` int NULL DEFAULT 0 COMMENT '软删除\r\n0 能使用\r\n1 已删除',
  `remarks` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`supervisor_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
