SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS brands;
DROP TABLE IF EXISTS cart;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS images;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS product_status;
DROP TABLE IF EXISTS reviews;
DROP TABLE IF EXISTS wish_lists;




/* Create Tables */

-- brands
CREATE TABLE brands
(
	id int NOT NULL AUTO_INCREMENT COMMENT 'id',
	name varchar(255) NOT NULL COMMENT 'name',
	insert_date datetime DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT 'insert_date',
	update_date datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  NOT NULL COMMENT 'update_date',
	insert_user varchar(255) NOT NULL COMMENT 'insert_user',
	update_user varchar(255) NOT NULL COMMENT 'update_user',
	PRIMARY KEY (id)
) COMMENT = 'brands';


-- cart
CREATE TABLE cart
(
	id int NOT NULL AUTO_INCREMENT COMMENT 'id',
	user_id int NOT NULL COMMENT 'user_id',
	product_id int NOT NULL COMMENT 'product_id',
	quantity int DEFAULT 1 NOT NULL COMMENT 'quantity',
	insert_date datetime DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT 'insert_date',
	update_date datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  NOT NULL COMMENT 'update_date',
	insert_user varchar(255) NOT NULL COMMENT 'insert_user',
	update_user varchar(255) NOT NULL COMMENT 'update_user',
	PRIMARY KEY (id)
) COMMENT = 'cart';


-- categories
CREATE TABLE categories
(
	id int NOT NULL COMMENT 'id',
	name varchar(255) NOT NULL COMMENT 'name',
	parent_id int COMMENT 'parent_id',
	insert_date datetime DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT 'insert_date',
	update_date datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  NOT NULL COMMENT 'update_date',
	insert_user varchar(255) NOT NULL COMMENT 'insert_user',
	update_user varchar(255) NOT NULL COMMENT 'update_user',
	PRIMARY KEY (id)
) COMMENT = 'categories';


-- users
CREATE TABLE users
(
	id int NOT NULL AUTO_INCREMENT COMMENT 'id',
	first_name varchar(255) NOT NULL COMMENT 'first_name',
	last_name varchar(255) NOT NULL COMMENT 'last_name',
	address01 varchar(255) NOT NULL COMMENT 'address01',
	address02 varchar(255) COMMENT 'address02',
	address03 varchar(255) COMMENT 'address03',
	tel int NOT NULL COMMENT 'tel',
	email varchar(255) NOT NULL COMMENT 'email',
	zip int NOT NULL COMMENT 'zip',
	img01 varchar(255) COMMENT 'img01',
	img02 varchar(255) COMMENT 'img02',
	img03 varchar(255) COMMENT 'img03',
	status int(1) DEFAULT 1 NOT NULL COMMENT 'status',
	insert_date datetime DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT 'insert_date',
	update_date datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  NOT NULL COMMENT 'update_date',
	insert_user varchar(255) NOT NULL COMMENT 'insert_user',
	update_user varchar(255) NOT NULL COMMENT 'update_user',
	PRIMARY KEY (id)
) COMMENT = 'users';


-- images
CREATE TABLE images
(
	id int NOT NULL AUTO_INCREMENT COMMENT 'id',
	product_serial varchar(255) NOT NULL COMMENT 'product_serial',
	main varchar(255) COMMENT 'main',
	sub1 varchar(255) COMMENT 'sub1',
	sub2 varchar(255) COMMENT 'sub2',
	sub3 varchar(255) COMMENT 'sub3',
	sub4 varchar(255) COMMENT 'sub4',
	insert_date datetime DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT 'insert_date',
	update_date datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  NOT NULL COMMENT 'update_date',
	insert_user varchar(255) NOT NULL COMMENT 'insert_user',
	update_user varchar(255) NOT NULL COMMENT 'update_user',
	PRIMARY KEY (id)
) COMMENT = 'images';


-- products
CREATE TABLE products
(
	serial_num varchar(255) NOT NULL COMMENT 'serial_num',
	name varchar(255) NOT NULL COMMENT 'name',
	category_id int NOT NULL COMMENT 'category_id',
	description text COMMENT 'description',
	price double(12,2) NOT NULL COMMENT 'price',
	brand_id int COMMENT 'brand_id',
	status int DEFAULT 1 NOT NULL COMMENT 'status',
	rating int(3) DEFAULT 0 COMMENT 'rating',
	main varchar(50) NOT NULL COMMENT 'main',
	sub1 varchar(50) NOT NULL COMMENT 'sub1',
	sub2 varchar(50) NOT NULL COMMENT 'sub2',
	sub3 varchar(50) NOT NULL COMMENT 'sub3',
	insert_date datetime DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT 'insert_date',
	update_date datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  NOT NULL COMMENT 'update_date',
	insert_user varchar(255) NOT NULL COMMENT 'insert_user',
	update_user varchar(255) NOT NULL COMMENT 'update_user',
	PRIMARY KEY (serial_num)
) COMMENT = 'products';


-- product_status
CREATE TABLE product_status
(
	id int NOT NULL AUTO_INCREMENT COMMENT 'id',
	status varchar(50) NOT NULL COMMENT 'status',
	insert_date datetime DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT 'insert_date',
	update_date datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  NOT NULL COMMENT 'update_date',
	insert_user varchar(255) NOT NULL COMMENT 'insert_user',
	update_user varchar(255) NOT NULL COMMENT 'update_user',
	PRIMARY KEY (id)
) COMMENT = 'product_status';


-- reviews
CREATE TABLE reviews
(
	id int NOT NULL AUTO_INCREMENT COMMENT 'id',
	product_serial varchar(255) NOT NULL COMMENT 'product_serial',
	name varchar(255) NOT NULL COMMENT 'name',
	email varchar(255) NOT NULL COMMENT 'email',
	review varchar(255) COMMENT 'review',
	rating int(3) NOT NULL COMMENT 'rating',
	review_date datetime DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT 'review_date',
	insert_date datetime DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT 'insert_date',
	update_date datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  NOT NULL COMMENT 'update_date',
	insert_user varchar(255) NOT NULL COMMENT 'insert_user',
	update_user varchar(255) NOT NULL COMMENT 'update_user',
	PRIMARY KEY (id)
) COMMENT = 'reviews';


-- wish_lists
CREATE TABLE wish_lists
(
	user_id int NOT NULL COMMENT 'user_id',
	product_id int NOT NULL COMMENT 'product_id',
	insert_date datetime DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT 'insert_date',
	update_date datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  NOT NULL COMMENT 'update_date',
	insert_user varchar(255) NOT NULL COMMENT 'insert_user',
	update_user varchar(255) NOT NULL COMMENT 'update_user',
	UNIQUE (user_id, product_id)
) COMMENT = 'wish_lists';
