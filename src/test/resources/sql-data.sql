INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('Jordan', 'Harrison');

INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('Simon', 'Powell');

INSERT INTO `ims`.`items` (`name`, `price`) VALUES ('Football', 9.99);

INSERT INTO `ims`.`items` (`name`, `price`) VALUES ('Rugby Ball', 8.99);

insert into `ims`.`orders`(`order_id`, `customer_id`) VALUES (1, 1);

insert into `ims`.`order_line`(`order_id`, `product_id`) VALUES (1, 1);