/*
*@author Nidhi Sharma
* Date: 10 september,2015
*Description: A form where providing a Zip Code populates associated City and State. 

*/
CREATE DATABASE Zip_Code_Info;

USE Zip_Code_Info;
/*Creating tables*/
CREATE TABLE state_info
(
    state_id INTEGER AUTO_INCREMENT,
    state_name VARCHAR(15),
    PRIMARY KEY(state_id)
);
DESCRIBE state_info;

CREATE TABLE city_info
(
    city_id INTEGER AUTO_INCREMENT,
    city_name VARCHAR(15),
    state_id INTEGER,
    FOREIGN KEY (state_id) REFERENCES state_info(state_id) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY(city_id)
);
DESCRIBE city_info;

ALTER TABLE city_info AUTO_INCREMENT=100;

CREATE TABLE zipcode_info
(
    zipcode INTEGER,
    city_id INTEGER,
    FOREIGN KEY (city_id) REFERENCES city_info(city_id) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY(zipcode)
);
DESCRIBE zipcode_info;

/*Insertion in tables*/
INSERT INTO state_info(state_name) VALUES
('Assam'),
('Bihar'),
('Gujarat'),
('Maharastra'),
('Punjab'),
('Rajasthan');

SELECT* FROM state_info;

INSERT INTO city_info(city_name,state_id) VALUES
('Silpukhuri',1),
('Patna',2),
('Bombay',4),
('Chattisgarh',5),
('Dispur',1),
('Surat',3),
('Jaipur',6),
('Alwar',6);

SELECT* FROM city_info;

INSERT INTO zipcode_info(zipcode,city_id) VALUES
(874573,101),
(345365,103),
(563242,102),
(563313,105),
(789546,104),
(253465,100),
(987522,107),
(984752,106);

SELECT* FROM zipcode_info;

 /*A SQL query for that returns a Resultset containing Zip Code, City Names and States ordered by State Name and City Name*/
SELECT zipcode, city_name, state_name
FROM zipcode_info AS z
JOIN city_info AS c ON z.city_id=c.city_id
JOIN state_info AS s ON c.state_id=s.state_id
ORDER BY state_name, city_name;



