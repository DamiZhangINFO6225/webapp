/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : userman

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 10/02/2023 15:32:18
*/

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int(11),
  `name` varchar(255),
  `description` varchar(500),
  `sku` varchar(100),
  `owner_user_id` varchar(100),
  `quantity` varchar(255),
  `manufacturer` varchar(255),
  `date_added` varchar(255),
  `date_last_updated` varchar(255),
  PRIMARY KEY (`id`) USING BTREE
);

-- ----------------------------
-- Records of product
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL,
  `password` varchar(64),
  `email` varchar(50),
  `first_name` varchar(50),
  `last_name` varchar(20),
  `account_created` varchar(20),
  `account_update` varchar(50),
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE COMMENT '索引'
);

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (9, '$2a$10$elVRYOuuXXbdkYO8XIgTR.50JDq6NVNeQY9XRAXK9qX84sNPmgE.C', '175@qq.com', 'a', 'd', '2023-01-29 21:34:32', '2023-01-29 21:34:32');
INSERT INTO `user` VALUES (11, '$2a$10$y9D0.238WeGhFPvEuya9gelmSwkl0LA0VlGX0LJIFWHGCKZ9AH6Ee', '28333@qq.com', 'a', 'd', '2023-01-30 16:34:38', '2023-01-31 14:02:02');
INSERT INTO `user` VALUES (12, '$2a$10$U7nm8FwNYy13fNvqZ7LM3.ftZ6CbnkZtj7dB5pwsuKky1T.UFBKh6', '22@qq.com', 'a', 'd', '2023-01-30 16:37:28', '2023-01-30 16:37:28');
INSERT INTO `user` VALUES (14, '$2a$10$w6nNnZjyr4TL5tut94bAxe72OWEuG6XpAvSYT4eMc1Oof1WP5qMxq', '12@qq.com', 'a', 'd', '2023-02-01 13:18:18', '2023-02-01 13:18:18');
INSERT INTO `user` VALUES (15, '$2a$10$QhexzK0.12LC33kczr4dh.3emUUjcgtK1t.F3PIhAmZT91hqvx0Km', '11@qq.com', 'x', 'hou222', '2023-02-01 13:24:08', '2023-02-01 13:29:58');
INSERT INTO `user` VALUES (17, '$2a$10$.Izmmyqej/7A.h2Bfcit9.EHnhGee.saiDugyq6yTF/TxDTax2J66', '111@qq.com', '111', '222', '2023-02-01 13:55:04', '2023-02-01 14:09:12');
INSERT INTO `user` VALUES (18, '$2a$10$RpRgHwuDY9gd3cNgpYxyquryrWkoB1BJB46AubPTcvoN/r6kmL.qa', '123456@qq.com', '22', '22', '2023-02-01 14:37:36', '2023-02-01 14:40:36');
INSERT INTO `user` VALUES (19, '$2a$10$rM6tlX3LXhQ3FTpN82h.DOO8pmk78qcoQOoKJy2khfcSmuI.gMTVW', '1234566@qq.com', 'a', 'd', '2023-02-01 15:13:45', '2023-02-01 15:13:45');
