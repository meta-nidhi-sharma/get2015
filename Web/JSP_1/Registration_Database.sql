DROP DATABASE Registration;
CREATE DATABASE Registration;

USE Registration;

CREATE TABLE User
(
    userName VARCHAR(10),
    email VARCHAR(20),
    password VARCHAR(15)
);

SELECT * FROM User;