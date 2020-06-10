/*
 Navicat MySQL Data Transfer

 Source Server         : tasker
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : tasker

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 10/06/2020 15:54:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `cid` mediumint(0) NOT NULL AUTO_INCREMENT,
  `major` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `class` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (1, '电子信息类', '198');

-- ----------------------------
-- Table structure for t_users_tasks
-- ----------------------------
DROP TABLE IF EXISTS `t_users_tasks`;
CREATE TABLE `t_users_tasks`  (
  `uid` int(0) NOT NULL,
  `tid` int(0) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 0,
  INDEX `t_users_tasks_users_uid_fk`(`uid`) USING BTREE,
  INDEX `t_users_tasks_tasks_tid_fk`(`tid`) USING BTREE,
  CONSTRAINT `t_users_tasks_tasks_tid_fk` FOREIGN KEY (`tid`) REFERENCES `tasks` (`tid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_users_tasks_users_uid_fk` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_users_tasks
-- ----------------------------
INSERT INTO `t_users_tasks` VALUES (1, 23, 1);
INSERT INTO `t_users_tasks` VALUES (2, 23, 1);
INSERT INTO `t_users_tasks` VALUES (3, 23, 0);
INSERT INTO `t_users_tasks` VALUES (4, 23, 0);
INSERT INTO `t_users_tasks` VALUES (5, 23, 0);
INSERT INTO `t_users_tasks` VALUES (6, 23, 0);
INSERT INTO `t_users_tasks` VALUES (7, 23, 0);
INSERT INTO `t_users_tasks` VALUES (8, 23, 0);
INSERT INTO `t_users_tasks` VALUES (9, 23, 0);
INSERT INTO `t_users_tasks` VALUES (10, 23, 0);
INSERT INTO `t_users_tasks` VALUES (11, 23, 0);
INSERT INTO `t_users_tasks` VALUES (12, 23, 0);
INSERT INTO `t_users_tasks` VALUES (13, 23, 0);
INSERT INTO `t_users_tasks` VALUES (14, 23, 1);
INSERT INTO `t_users_tasks` VALUES (15, 23, 0);
INSERT INTO `t_users_tasks` VALUES (16, 23, 0);
INSERT INTO `t_users_tasks` VALUES (17, 23, 0);
INSERT INTO `t_users_tasks` VALUES (18, 23, 0);
INSERT INTO `t_users_tasks` VALUES (19, 23, 0);
INSERT INTO `t_users_tasks` VALUES (20, 23, 0);
INSERT INTO `t_users_tasks` VALUES (21, 23, 0);
INSERT INTO `t_users_tasks` VALUES (23, 23, 0);
INSERT INTO `t_users_tasks` VALUES (24, 23, 0);
INSERT INTO `t_users_tasks` VALUES (25, 23, 0);
INSERT INTO `t_users_tasks` VALUES (26, 23, 0);
INSERT INTO `t_users_tasks` VALUES (27, 23, 0);
INSERT INTO `t_users_tasks` VALUES (29, 23, 0);

-- ----------------------------
-- Table structure for tasks
-- ----------------------------
DROP TABLE IF EXISTS `tasks`;
CREATE TABLE `tasks`  (
  `tid` int(0) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `content` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `createTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `deadline` timestamp(0) NULL DEFAULT NULL,
  `createFor` mediumint(0) NOT NULL,
  `createrId` int(0) NOT NULL,
  `type` tinyint(0) NOT NULL,
  PRIMARY KEY (`tid`) USING BTREE,
  INDEX `tasks_class_cid_fk`(`createFor`) USING BTREE,
  CONSTRAINT `tasks_class_cid_fk` FOREIGN KEY (`createFor`) REFERENCES `class` (`cid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tasks
-- ----------------------------
INSERT INTO `tasks` VALUES (23, '易班每日健康打卡', '需要每天完成', '2020-06-09 23:03:58', NULL, 1, 14, 1);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `uid` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gender` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `qq` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `class` mediumint(0) NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE,
  INDEX `users_class_cid_fk`(`class`) USING BTREE,
  CONSTRAINT `users_class_cid_fk` FOREIGN KEY (`class`) REFERENCES `class` (`cid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, '陈璐', NULL, '女', '', NULL, 1);
INSERT INTO `users` VALUES (2, '郭月琳', NULL, '女', '', NULL, 1);
INSERT INTO `users` VALUES (3, '解锦欢', NULL, '女', '', NULL, 1);
INSERT INTO `users` VALUES (4, '马玲玉', NULL, '女', '', NULL, 1);
INSERT INTO `users` VALUES (5, '王迪迪', NULL, '女', '', NULL, 1);
INSERT INTO `users` VALUES (6, '王蕊欣', NULL, '女', '', NULL, 1);
INSERT INTO `users` VALUES (7, '王依晴', NULL, '女', '', NULL, 1);
INSERT INTO `users` VALUES (8, '吴倩倩', NULL, '女', '', NULL, 1);
INSERT INTO `users` VALUES (9, '张可', NULL, '女', '', NULL, 1);
INSERT INTO `users` VALUES (10, '曹子亨', NULL, '男', '', NULL, 1);
INSERT INTO `users` VALUES (11, '勾开元', NULL, '男', '', NULL, 1);
INSERT INTO `users` VALUES (12, '韩佳玮', NULL, '男', '', NULL, 1);
INSERT INTO `users` VALUES (13, '韩堂坤', NULL, '男', '', NULL, 1);
INSERT INTO `users` VALUES (14, '金旭阳', 'JINXUyang123', '男', '', NULL, 1);
INSERT INTO `users` VALUES (15, '李文哲', NULL, '男', '', NULL, 1);
INSERT INTO `users` VALUES (16, '刘晨星', NULL, '男', '', NULL, 1);
INSERT INTO `users` VALUES (17, '刘沁源', NULL, '男', '', NULL, 1);
INSERT INTO `users` VALUES (18, '穆龙天', NULL, '男', '', NULL, 1);
INSERT INTO `users` VALUES (19, '王聪', NULL, '男', '', NULL, 1);
INSERT INTO `users` VALUES (20, '王浩', NULL, '男', '', NULL, 1);
INSERT INTO `users` VALUES (21, '王杰', NULL, '男', '', NULL, 1);
INSERT INTO `users` VALUES (23, '徐炤瑞', NULL, '男', '', NULL, 1);
INSERT INTO `users` VALUES (24, '薛泽鹏', NULL, '男', '', NULL, 1);
INSERT INTO `users` VALUES (25, '于晨浩', NULL, '男', '', NULL, 1);
INSERT INTO `users` VALUES (26, '贠芃江', NULL, '男', '', NULL, 1);
INSERT INTO `users` VALUES (27, '张庆权', NULL, '男', '', NULL, 1);
INSERT INTO `users` VALUES (29, '赵冠熙', NULL, '男', '', NULL, 1);

SET FOREIGN_KEY_CHECKS = 1;

-- ----------------------------
-- events
-- ----------------------------

CREATE EVENT IF NOT EXISTS updateStatus
    ON SCHEDULE EVERY 1 DAY STARTS DATE_ADD(DATE_ADD(CURDATE(), INTERVAL 1 DAY), INTERVAL 0 HOUR)
    ON COMPLETION PRESERVE ENABLE
    DO UPDATE tasker.t_users_tasks SET t_users_tasks.status = false where t_users_tasks.type = 1;