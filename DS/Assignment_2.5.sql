/*
*@author Nidhi Sharma
*Date: 8 september,2015
* Inserting data into tables
*/
USE library;

/*Inserting data into authors table*/
INSERT INTO authors  VALUES (100105, 'Yashvant');
INSERT INTO authors  VALUES (100108, 'Henry');
INSERT INTO authors  VALUES (100106, 'John');
INSERT INTO authors  VALUES (100110, 'Richard');
INSERT INTO authors  VALUES (100112, 'Rihaan');

/*Inserting data into members table*/
INSERT INTO members  VALUES (101,'Nidhi','Gandhi Nagar Mode', 'Jaipur', 'F');
INSERT INTO members  VALUES (102,'Richa','Gopalpura', 'Chennai', 'F');
INSERT INTO members  VALUES (103,'Shubham','Gandhi Nagar Mode','Jaipur', 'M');
INSERT INTO members  VALUES (104,'Suman','Riddhi-Siddhi', 'Jodhpur', 'F');

/*Inserting data into publishers table*/
INSERT INTO publishers VALUES (30001, 'ABC Journals');
INSERT INTO publishers VALUES (30105, 'Academe Research Journals');
INSERT INTO publishers VALUES (30115, 'Academia Publishing');
INSERT INTO publishers VALUES (30005, 'Academia Scholarly Journals (ASJ)');
INSERT INTO publishers VALUES (30018, 'British Journal');

/*Inserting data into subjects table*/
INSERT INTO subjects  VALUES (1, 'Science');
INSERT INTO subjects  VALUES (2, 'Math');
INSERT INTO subjects  VALUES (3, 'Social;_Science');
INSERT INTO subjects  VALUES (4, 'General_Knowledge');
INSERT INTO subjects  VALUES (5, 'English');

/*Inserting data into titles table*/
INSERT INTO titles  VALUES (1001, "Title", 1, 30115);
INSERT INTO titles  VALUES (1003, "Title", 2, 30001);
INSERT INTO titles  VALUES (1006, "Title", 5, 30018);
INSERT INTO titles  VALUES (1015, "Title", 3, 30105);
INSERT INTO titles  VALUES (1008, "Title", 4, 30005);

/*Inserting data into title_author table*/
INSERT INTO title_author  VALUES (1001, 100108);
INSERT INTO title_author  VALUES (1006, 100112);
INSERT INTO title_author  VALUES (1015, 100105);
INSERT INTO title_author  VALUES (1008, 100106);
INSERT INTO title_author  VALUES (1003, 100110);

/*Inserting data into books table*/
INSERT INTO books VALUES (3023012, 1006, '2004-07-05', 500, 'Not_Issued');
INSERT INTO books VALUES (1034835, 1003, '2004-07-05', 500, 'Not_Issued');
INSERT INTO books VALUES (9873492, 1015, '2006-11-12', 500, 'Issued');
INSERT INTO books VALUES (7874365, 1008, '2005-01-02', 500, 'Not_Issued');
INSERT INTO books VALUES (0935482, 1001, '2003-11-23', 500, 'Not_Issued');

/*Inserting data into book_issue table*/
INSERT INTO book_issue  VALUES ('2015-09-03', 9873492, 102, ' 2015-09-18');
INSERT INTO book_issue (accession_no, member_id) VALUES (0935482, 101);

/*Inserting data into book_return table*/
INSERT INTO book_return VALUES ('2015-09-11', 9873492, 102, '2015-09-03');








