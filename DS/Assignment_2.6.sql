/*
*@author Nidhi Sharma
*Date: 8 september,2015
* Updating tables and adding data into table using substitution variables and also deleting some data with specified conditions
*/
USE library;

/*Updating address line 2 with "Jaipur"*/
SET SQL_SAFE_UPDATES = 0;
update members
set addressline2 ='Jaipur';

/*Updating address line 1 with "EPIP,Sitapura"*/
UPDATE members
SET addressline1 = 'EPIP,Sitapura'
WHERE category = 'F';

DELETE FROM publishers;             /* Deleting publishers table*/

/*Inserting data into publishers table using substitution variables*/
SET @publisher_id=30018, @publisher_name= 'British Journal';
INSERT INTO publishers VALUES (@publisher_id, @publisher_name);
SET @publisher_id=30105, @publisher_name= 'Academe Research Journals';
INSERT INTO publishers VALUES (@publisher_id, @publisher_name);
SET @publisher_id=30115, @publisher_name= 'Academia Publishing';
INSERT INTO publishers VALUES (@publisher_id, @publisher_name);
SET @publisher_id=30005, @publisher_name= 'Academia Scholarly Journals (ASJ)';
INSERT INTO publishers VALUES (@publisher_id, @publisher_name);
SET @publisher_id=30001, @publisher_name= 'ABC Journals';
INSERT INTO publishers VALUES (@publisher_id, @publisher_name);

/*reinserting data in table which was deleted due to foreign key*/
INSERT INTO titles  VALUES (1001, "Title", 1, 30115);
INSERT INTO titles  VALUES (1003, "Title", 2, 30001);
INSERT INTO titles  VALUES (1006, "Title", 5, 30018);
INSERT INTO titles  VALUES (1015, "Title", 3, 30105);
INSERT INTO titles  VALUES (1008, "Title", 4, 30005);

/*Deleting rows with particular_ID*/
DELETE FROM titles 
WHERE publisher_id=30018;
