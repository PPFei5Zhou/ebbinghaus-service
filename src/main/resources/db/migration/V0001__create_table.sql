CREATE TABLE `library`
(
    `id`                char(16) COLLATE utf8mb4_bin                            NOT NULL,
    `library_name`      varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `library_parent_id` char(16) COLLATE utf8mb4_bin DEFAULT NULL,
    `library_owner_id`  char(16) COLLATE utf8mb4_bin                            NOT NULL,
    `data_status`       int                          DEFAULT NULL,
    `create_date`       datetime(6) DEFAULT NULL,
    `update_date`       datetime(6) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

CREATE TABLE `library_card`
(
    `id`            char(16) COLLATE utf8mb4_bin                            NOT NULL,
    `card_title`    varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `card_subtitle` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci  DEFAULT NULL,
    `card_content`  varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `library_id`    char(16) COLLATE utf8mb4_bin                            NOT NULL,
    `data_status`   int                                                      DEFAULT NULL,
    `create_date`   datetime(6) DEFAULT NULL,
    `update_date`   datetime(6) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;