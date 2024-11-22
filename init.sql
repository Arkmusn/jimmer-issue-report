CREATE TABLE `app_collection` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL COMMENT '唯一 code.',
  `channel` varchar(20) NOT NULL COMMENT '渠道. ldx, store, etc.',
  `area_language_code` varchar(10) NOT NULL COMMENT '地区代码. tw, hk, mo, us, uk, jp',
  `name` varchar(100) NOT NULL COMMENT '集合名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni` (`code`,`channel`,`area_language_code`),
  KEY `idx_area_code` (`area_language_code`),
  KEY `idx_code` (`code`),
  KEY `idx_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `app_collection_item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `app_collection_id` bigint DEFAULT NULL,
  `source` varchar(20) NOT NULL COMMENT '应用来源. ads, app, easyfun, etc.',
  `name` varchar(100) NOT NULL COMMENT '应用名',
  `package_name` varchar(200) NOT NULL COMMENT '包名',
  `delete_millis` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni` (`app_collection_id`,`source`,`package_name`,`delete_millis`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO cz_app_center.app_collection (id, code, channel, area_language_code, name) VALUES (19629, 'test', 'test', 'test', 'test');

INSERT INTO cz_app_center.app_collection_item (id, app_collection_id, source, name, package_name, delete_millis) VALUES (3225, 19629, 'insert', 'insert-name2', 'insert', 0);
INSERT INTO cz_app_center.app_collection_item (id, app_collection_id, source, name, package_name, delete_millis) VALUES (3224, 19629, 'update', 'update-name2', 'update', 0);

# select id, app_collection_id, source, name, package_name, delete_millis from app_collection_item where app_collection_id = 19629;