use ecomdb;

CREATE TABLE `e_cart` (
  `cart_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `total` decimal(10,0) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `e_items` (
  `item_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `quantity` int(3) NOT NULL,
  `item_name` varchar(10) DEFAULT NULL,
  `total_price` decimal(10,0) NOT NULL,
  `cart_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`item_id`),
  KEY `cart_id` (`cart_id`),
  CONSTRAINT `items_ibfk_1` FOREIGN KEY (`cart_id`) REFERENCES `e_cart` (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;