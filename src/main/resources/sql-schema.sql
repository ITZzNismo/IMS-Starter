drop schema ims;
CREATE SCHEMA IF NOT EXISTS `ims`;
USE `ims` ;
CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
    `product_id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(40)  DEFAULT NULL,
    `price` DECIMAL(40, 2) NOT NULL
    PRIMARY KEY (`product_id`)
);

CREATE TABLE IF NOT EXISTS	`ims`.`orders` (
	`order_id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`date_placed` timestamp ON UPDATE CURRENT_TIMESTAMP() NOT NULL DEFAULT CURRENT_TIMESTAMP()
	);