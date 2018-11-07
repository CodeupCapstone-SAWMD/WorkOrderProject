-- ****************** SqlDBM: MySQL ******************;
-- ***************************************************;

-- ************************************** `user_roles`
drop database mgmt_db;

CREATE database if not exists mgmt_db;

use mgmt_db;

CREATE TABLE `user_roles`
(
 `id`   INT unsigned NOT NULL AUTO_INCREMENT,
 `role` VARCHAR(45) NOT NULL,
PRIMARY KEY (`id`)
);

-- ************************************** `status`

CREATE TABLE `status`
(
 `id`   INT unsigned NOT NULL AUTO_INCREMENT,
 `name` VARCHAR(45) NOT NULL,
PRIMARY KEY (`id`)
);

-- ************************************** `inventory`

CREATE TABLE `inventory`
(
 `id`       INT unsigned NOT NULL AUTO_INCREMENT,
 `name`     TEXT NOT NULL ,
 `size`     VARCHAR(45) NOT NULL ,
 `price`    INT unsigned NOT NULL ,
 `quantity` INT unsigned NOT NULL ,
PRIMARY KEY (`id`)
);

-- ************************************** `categories`

CREATE TABLE `categories`
(
 `id`   INT unsigned NOT NULL AUTO_INCREMENT,
 `name` TEXT NOT NULL ,
PRIMARY KEY (`id`)
);

-- ************************************** `users`

CREATE TABLE `users`
(
 `id`             INT unsigned NOT NULL AUTO_INCREMENT,
 `username`       varchar(45) NOT NULL,
 `email`          varchar(45) NOT NULL,
 `password`       text NOT NULL,
 `first_name`     varchar(45) NOT NULL,
 `last_name`      varchar(45) NOT NULL,
 `street_number` INT NOT NULL,
 `street_name` varchar(45) NOT NULL,
 `city`           varchar(45) NOT NULL,
 `zip`            INT unsigned NOT NULL,
 `phone_number`   INT unsigned NOT NULL,
 `role_id`        INT unsigned NOT NULL,
PRIMARY KEY (`id`),
KEY `fkIdx_80` (`role_id`),
CONSTRAINT `FK_80` FOREIGN KEY `fkIdx_80` (`role_id`) REFERENCES `user_roles` (`id`)
);

-- ************************************** `work_order`

CREATE TABLE `work_order`
(
 `id`             INT unsigned NOT NULL AUTO_INCREMENT,
 `description`    text NOT NULL,
 `notes`          text NOT NULL,
 `category_id`    INT unsigned NOT NULL,
 `status_id`      INT unsigned NOT NULL,
 `customer_id`    INT unsigned NOT NULL,
 `street_number` INT unsigned NOT NULL,
 `street_name` INT unsigned NOT NULL,
 `zip_code` INT unsigned NOT NULL,
 `submitted_date` DATE NOT NULL,
 `employee_id`    INT unsigned NOT NULL,
PRIMARY KEY (`id`),
KEY `fkIdx_100` (`employee_id`),
CONSTRAINT `FK_100` FOREIGN KEY `fkIdx_100` (`employee_id`) REFERENCES `users` (`id`),
KEY `fkIdx_77` (`category_id`),
CONSTRAINT `FK_77` FOREIGN KEY `fkIdx_77` (`category_id`) REFERENCES `categories` (`id`),
KEY `fkIdx_91` (`status_id`),
CONSTRAINT `FK_91` FOREIGN KEY `fkIdx_91` (`status_id`) REFERENCES `status` (`id`),
KEY `fkIdx_94` (`customer_id`),
CONSTRAINT `FK_94` FOREIGN KEY `fkIdx_94` (`customer_id`) REFERENCES `users` (`id`)
);

