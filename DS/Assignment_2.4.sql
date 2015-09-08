/*
*@author Nidhi Sharma
*Date: 8 september,2015
* Recreating members table and adding foreign keys again in required or related tables
*/
USE library;

CREATE TABLE members
	(
		member_id INTEGER,
		member_name VARCHAR(50),
		addressline1 VARCHAR(20),
		addressline2 VARCHAR(20),
		category CHAR(1) CHECK (category IN ('M', 'F')),
		PRIMARY KEY(member_id)              
	);
	DESCRIBE members;                /* To show  table*/
    
ALTER TABLE book_issue
ADD CONSTRAINT bookIssue_Fkey1 FOREIGN KEY(member_id) REFERENCES members(member_id);

ALTER TABLE book_return
ADD CONSTRAINT bookReturn_Fkey1 FOREIGN KEY(member_id) REFERENCES members(member_id);

