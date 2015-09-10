/*
*@author Nidhi Sharma
* Date: 10 september,2015
*Description: An E-Commerce application, where there are Categories and products under those categories. 
*/

CREATE DATABASE E_Commerce;

USE E_Commerce;
/*The table structure for these Product categories*/
CREATE TABLE category
(
    category_id INTEGER AUTO_INCREMENT,
    category_name VARCHAR(20),
    category_parent_id INTEGER,
    Primary Key (category_id)
);
DESCRIBE category;

CREATE TABLE product
(
    product_id INTEGER AUTO_INCREMENT,
    product_name VARCHAR(20),
    product_parent_id INTEGER,
    category_id INTEGER,
    FOREIGN KEY(category_id) REFERENCES category(category_id) ON DELETE CASCADE ON UPDATE CASCADE,
    Primary Key (product_id,category_id)
);
DESCRIBE product;

ALTER TABLE product AUTO_INCREMENT = 100;

/*Insertion in tables*/
INSERT INTO category(category_name) VALUES('Mobiles & Tablets');
INSERT INTO category(category_name) VALUES('Computers');
INSERT INTO category(category_name) VALUES('Home Appliances');

INSERT INTO category(category_parent_id,category_name) 
VALUES
(1,'Mobliles'),
(1,'Tablets'),
(1,'Accessories'),
(1,'Cases & Covers'),
(2,'Desktop'),
(2,'Laptop'),
(2,'Laptop Accessories'),
(2,'Printers'),
(3,'TVs'),
(3,'Air Conditioners'),
(3,'Washing Machines');

SELECT * FROM category;

INSERT INTO product(category_id,product_name) VALUES(4,'Smart Phones');
INSERT INTO product(category_id,product_name) VALUES(4,'Featured Phones');
INSERT INTO product(category_id,product_name) VALUES(5,'2G');
INSERT INTO product(category_id,product_name) VALUES(5,'3G');
INSERT INTO product(category_id,product_name) VALUES(10,'Keyboard');
INSERT INTO product(category_id,product_name) VALUES(10,'Mouse');
INSERT INTO product(category_id,product_name) VALUES(10,'Headphones');
INSERT INTO product(category_id,product_name) VALUES(11,'Inkjet');
INSERT INTO product(category_id,product_name) VALUES(11,'Laser');
INSERT INTO product(category_id,product_name) VALUES(12,'LED');
INSERT INTO product(category_id,product_name) VALUES(12,'LCD');
INSERT INTO product(category_id,product_name) VALUES(12,'Plasma');
INSERT INTO product(category_id,product_name) VALUES(14,'Full Automatic');
INSERT INTO product(category_id,product_name) VALUES(14,'Semi Automatic');

INSERT INTO product(category_id,product_name,product_parent_id) VALUES(14,'Top Load',112);
INSERT INTO product(category_id,product_name,product_parent_id) VALUES(14,'Front Load',112);

/*
*a SQL query
**************To display all the categories along with its Parent category.
**************Sorted result on Parent Category.
**************If category is top category then it should display “Top Category” in Parent category. 
*/
SELECT c1.category_name, 
IFNULL(c2.category_name, 'TOP Category') AS Parent_Category
FROM category AS c1
LEFT JOIN category AS c2 ON c1.category_parent_id=c2.category_id
ORDER BY Parent_Category ASC;

/*SQL query to display only Top Categories*/
SELECT category_name
FROM category
WHERE category.category_parent_id IS NULL;

