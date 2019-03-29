create database if not exists `txlcn-demo` default charset utf8 collate utf8_general_ci;

-- 创建Tm相关的表 beign

create database if not exists `txlcn-manager` default charset utf8 collate utf8_general_ci;

CREATE TABLE `t_tx_exception`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `group_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `unit_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `mod_id` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `transaction_state` tinyint(4) NULL DEFAULT NULL,
  `registrar` tinyint(4) NULL DEFAULT NULL,
  `remark` varchar(4096) NULL DEFAULT  NULL,
  `ex_state` tinyint(4) NULL DEFAULT NULL COMMENT '0 未解决 1已解决',
  -- `create_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- 创建Tm相关的表 end

-- 创建测试库 begin

create database if not exists `txlcn-demo` default charset utf8 collate utf8_general_ci;

-- 整个过程，这个里面并没有值，所以可以忽略
create table `t_demo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `kid` varchar(45) DEFAULT NULL,
  `group_id` varchar(64) DEFAULT NULL,
  `demo_field` varchar(255) DEFAULT NULL,
  `app_name` varchar(128) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;


CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

CREATE TABLE `userrole` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userID` bigint(20) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `roleName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;


-- 创建测试库 end