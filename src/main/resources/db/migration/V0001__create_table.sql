CREATE TABLE `library`
(
    `id`                  char(36)     NOT NULL,
    `library_name`        varchar(100) NOT NULL,
    `library_description` varchar(200) DEFAULT NULL,
    `library_parent_id`   char(36)     DEFAULT NULL,
    `library_owner_id`    char(36)     NOT NULL,
    `create_date`         datetime(6)  DEFAULT NULL,
    `update_date`         datetime(6)  DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin;

CREATE TABLE `library_card`
(
    `id`            char(36)     NOT NULL,
    `card_title`    varchar(100) NOT NULL,
    `card_subtitle` varchar(200)  DEFAULT NULL,
    `card_content`  varchar(2000) DEFAULT NULL,
    `library_id`    char(36)     NOT NULL,
    `create_date`   datetime(6)   DEFAULT NULL,
    `update_date`   datetime(6)   DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin;