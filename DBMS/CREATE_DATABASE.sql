/*
*@author Nidhi Sharma
*Date: 13 september,2015
* Creating database by creating different tables
*/
DROP DATABASE library;
CREATE DATABASE library;                    /*Creating Database*/
USE library;                                                /*Enter into library*/

	/*
	*Create table "members"
	*/
	CREATE TABLE members
	(
		member_id INTEGER,
		member_name VARCHAR(50),
		addressline1 VARCHAR(20),
		addressline2 VARCHAR(20),
		category CHAR(1) CHECK (category IN ('S', 'F','O')),
		PRIMARY KEY(member_id)
	);
	DESCRIBE members;                   /* To show  table*/

	/*
	*Create table "subjects"
	*/
	CREATE TABLE subjects
	(
		subject_id INTEGER,
		subject_name VARCHAR(30),
		PRIMARY KEY(subject_id)
	);
	DESCRIBE subjects;               /* To show  table*/

	/*
	*Create table "publishers"
	*/
	CREATE TABLE publishers
	(
		publisher_id INTEGER,
		publisher_name VARCHAR(50),
		PRIMARY KEY(publisher_id)
	);
	DESCRIBE publishers;                    /* To show  table*/

	/*
	*Create table "titles"
	*/
	CREATE TABLE titles
	(
		title_id INTEGER,
		title_name VARCHAR(30),
		subject_id INTEGER,
		FOREIGN KEY(subject_id) REFERENCES subjects(subject_id) ON DELETE CASCADE ON UPDATE CASCADE ,
		publisher_id INTEGER,
		FOREIGN KEY(publisher_id) REFERENCES publishers(publisher_id) ON DELETE CASCADE ON UPDATE CASCADE ,
		PRIMARY KEY(title_id)
	);
	DESCRIBE titles;                         /* To show  table*/

	/*
	*Create table "books"
	*/	
	CREATE TABLE books
	(
		accession_no INTEGER,
		title_id INTEGER,
		FOREIGN KEY(title_id) REFERENCES titles(title_id) ON DELETE CASCADE ON UPDATE CASCADE ,
		purchase_dt DATE,
		price INTEGER,
		status VARCHAR(10),
		PRIMARY KEY(accession_no)
	);
	DESCRIBE books;                      /* To show  table*/

	/*
	*Create table "book_issue"
	*/	
	CREATE TABLE book_issue
	(
		issue_date TIMESTAMP,
		accession_no INTEGER,
		FOREIGN KEY(accession_no) REFERENCES books(accession_no) ON DELETE CASCADE ON UPDATE CASCADE ,
		member_id INTEGER,
		CONSTRAINT bookIssue_Fkey1 FOREIGN KEY(member_id) REFERENCES members(member_id) ON DELETE CASCADE ON UPDATE CASCADE,
		due_dt DATE,
		PRIMARY KEY(issue_date,accession_no)
	);
	DESCRIBE book_issue;                     /* To show  table*/

	/*
	*Create table "book_return"
	*/	
	CREATE TABLE book_return
	(
		return_dt DATE,
		accession_no INTEGER,
		FOREIGN KEY(accession_no) REFERENCES books(accession_no) ON DELETE CASCADE ON UPDATE CASCADE ,
		member_id INTEGER,
		CONSTRAINT bookReturn_Fkey2 FOREIGN KEY(member_id) REFERENCES members(member_id) ON DELETE CASCADE ON UPDATE CASCADE ,
		issue_date TIMESTAMP,
		FOREIGN KEY(issue_date) REFERENCES book_issue(issue_date) ON DELETE CASCADE ON UPDATE CASCADE ,
		PRIMARY KEY(return_dt,accession_no)
	);
	DESCRIBE book_return;                    /* To show  table*/

	/*
	*Create table "authors"
	*/	
	CREATE TABLE authors
	(
		author_id INTEGER,
		author_name VARCHAR(50),
		PRIMARY KEY(author_id)
	);
	DESCRIBE authors;                        /* To show  table*/

	/*
	*Create table "title_author"
	*/	
	CREATE TABLE title_author
	(
		title_id INTEGER,
		FOREIGN KEY(title_id) REFERENCES titles(title_id) ON DELETE CASCADE ON UPDATE CASCADE ,
		author_id INTEGER,
		FOREIGN KEY(author_id) REFERENCES authors(author_id) ON DELETE CASCADE ON UPDATE CASCADE ,
		PRIMARY KEY(title_id,author_id)
	);
	DESCRIBE title_author;                   /* To show  table*/

SHOW TABLES;			/* To show all the tables available in Database*/


