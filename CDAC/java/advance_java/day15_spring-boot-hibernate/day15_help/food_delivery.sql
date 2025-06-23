CREATE TABLE `restaurants` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_on` date DEFAULT NULL,
  `last_updated` datetime(6) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKhs57n29k4u6jfc5t978bq7wg9` (`name`)
);


CREATE TABLE `food_items` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_on` date DEFAULT NULL,
  `last_updated` datetime(6) DEFAULT NULL,
  `is_veg` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `item_name` varchar(100) DEFAULT NULL,
  `price` int NOT NULL,
  `restaurant_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK2rfgs3f6dt809vpr5ct5bb8ea` (`item_name`),
  KEY `FK1f3re9f14rtkoyghyuhx3cv9l` (`restaurant_id`),
  CONSTRAINT `FK1f3re9f14rtkoyghyuhx3cv9l` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`id`)
);

INSERT INTO restaurants (created_on, last_updated, address, city, description, name) VALUES
('2024-05-01', '2024-05-01 11:00:00', '123 FC Road', 'Pune', 'Traditional Maharashtrian meals', 'Shree Misal House'),
('2024-05-02', '2024-05-02 14:00:00', '88 JM Road', 'Pune', 'Popular North Indian and tandoor dishes', 'Tandoor Junction'),
('2024-05-03', '2024-05-03 17:30:00', '42 Baner Road', 'Pune', 'Modern vegetarian café with fusion food', 'Green Leaf Café');


INSERT INTO food_items (created_on, last_updated, is_veg, description, item_name, price, restaurant_id) VALUES
('2024-05-01', '2024-05-01 11:10:00', b'1', 'Spicy misal topped with farsan and onions', 'Puneri Misal', 70, 1),
('2024-05-01', '2024-05-01 11:15:00', b'1', 'Sabudana khichdi with peanuts and lemon', 'Sabudana Khichdi', 60, 1),

('2024-05-02', '2024-05-02 14:15:00', b'0', 'Char-grilled chicken with Indian spices', 'Tandoori Chicken', 180, 2),
('2024-05-02', '2024-05-02 14:30:00', b'1', 'Soft naan stuffed with spiced potatoes', 'Aloo Kulcha', 90, 2),

('2024-05-03', '2024-05-03 17:45:00', b'1', 'Millet-based pizza with paneer topping', 'Desi Paneer Pizza', 150, 3),
('2024-05-03', '2024-05-03 18:00:00', b'1', 'Chilled kokum-based beverage', 'Kokum Cooler', 50, 3);

