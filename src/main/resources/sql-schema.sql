drop schema ims;
CREATE SCHEMA IF NOT EXISTS `ims`;
USE `ims`;
CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
    `product_id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(40)  DEFAULT NULL,
    `price` DECIMAL(40, 2) NOT NULL,
    PRIMARY KEY (`product_id`)
);

CREATE TABLE IF NOT EXISTS	`ims`.`orders` (
	`order_id` INT(11) NOT NULL AUTO_INCREMENT,
	`customer_id` INT(11) NOT NULL
	PRIMARY KEY (order_id),
	FOREIGN KEY (`customer_id`) 
	REFERENCES `ims`.`customers` (`id`),
);

CREATE TABLE IF NOT EXISTS `ims`.`order_line` ( 
	`order_line_id` INT NOT NULL AUTO_INCREMENT, 
	`order_id` INT NOT NULL, 
	`product_id` INT NOT NULL, 
	PRIMARY KEY (`order_line_id`), 
	CONSTRAINT `fk_order_line_1` 
	FOREIGN KEY (`order_id`) 
	REFERENCES `ims`.`orders` (`order_id`) 
	ON DELETE CASCADE 
	ON UPDATE CASCADE, 
	CONSTRAINT `fk_order_line_2`
	FOREIGN KEY (`product_id`) 
	REFERENCES `ims`.`items` (`product_id`) 
	ON DELETE CASCADE 
	ON UPDATE CASCADE 
);