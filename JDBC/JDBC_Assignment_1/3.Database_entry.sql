/*
*@author Nidhi Sharma
*Date: 13 september,2015
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
INSERT INTO members  VALUES (101,'Nidhi','Gandhi Nagar Mode', 'Jaipur', 'S'),
(102,'Richa','Gopalpura', 'Chennai', 'F'),
(103,'Shubham','Malviya_Nagar','Jaipur', 'S'),
(104,'Riddhi','Ajmeri gate','Jaipur', 'F'),
(105,'Chetna','Jothwara','Ajmer', 'S'),
(106,'Yatharth','Lalkothi','Jaipur', 'S'),
(107,'Akshat','Malviya_Nagar','Alwar', 'O'),
(108,'Shishir','Durgapura','Jaipur', 'F'),
(109,'Anjita','Sanganer','Jaipur', 'S'),
(110,'Suman','Riddhi-Siddhi', 'Jodhpur', 'F'),
(111,'Piyush','Riddhi-Siddhi', 'Gangtok', 'O');

/*Inserting data into publishers table*/
INSERT INTO publishers VALUES (30001, 'ABC Journals');
INSERT INTO publishers VALUES (30105, 'Academe Research Journals');
INSERT INTO publishers VALUES (30115, 'Academia Publishing');
INSERT INTO publishers VALUES (30005, 'Academia Scholarly Journals (ASJ)');
INSERT INTO publishers VALUES (30018, 'British Journal');

/*Inserting data into subjects table*/
INSERT INTO subjects  VALUES (1, 'Science');
INSERT INTO subjects  VALUES (2, 'Math');
INSERT INTO subjects  VALUES (3, 'Social_Science');
INSERT INTO subjects  VALUES (4, 'General_Knowledge');
INSERT INTO subjects  VALUES (5, 'English');


/*Inserting data into titles table*/
INSERT INTO titles  VALUES (1001, "General Science", 1, 30115);
INSERT INTO titles  VALUES (1003, "BAsic Maths", 2, 30001);
INSERT INTO titles  VALUES (1006, "English Literature", 5, 30018);
INSERT INTO titles  VALUES (1015, "SS with History", 3, 30105);
INSERT INTO titles  VALUES (1008, "Rajasthan_GK", 4, 30005);
INSERT INTO titles  VALUES (1009, "Sciencea", 1, 30115);
INSERT INTO titles  VALUES (1007, "History", 4, 30018);
INSERT INTO titles  VALUES (1005, "Comprehension", 5, 30001);

/*Inserting data into title_author table*/
INSERT INTO title_author  VALUES (1001, 100108);
INSERT INTO title_author  VALUES (1006, 100112);
INSERT INTO title_author  VALUES (1015, 100105);
INSERT INTO title_author  VALUES (1008, 100106);
INSERT INTO title_author  VALUES (1003, 100110);
INSERT INTO title_author  VALUES (1007, 100108);
INSERT INTO title_author  VALUES (1005, 100112);
INSERT INTO title_author  VALUES (1009, 100105);

/*Inserting data into books table*/
INSERT INTO books VALUES (3023012, 1006, '2004-07-05', 500, 'NOT_Issued');
INSERT INTO books VALUES (1034835, 1003, '2004-07-05', 500, 'Issued');
INSERT INTO books VALUES (9873492, 1015, '2006-11-12', 500, 'Issued');
INSERT INTO books VALUES (7874365, 1008, '2005-01-02', 500, 'Issued');
INSERT INTO books VALUES (0935482, 1001, '2003-11-23', 500, 'Issued');
INSERT INTO books VALUES (9847535, 1005, '2012-07-08', 100, 'NOT_Issued');
INSERT INTO books VALUES (7652311, 1007, '2013-05-02', 700, 'NOT_Issued');
INSERT INTO books VALUES (7521446, 1009, '2015-09-10', 1000, 'NOT_Issued');

/*Inserting data into book_issue table*/
INSERT INTO book_issue (issue_date,accession_no, member_id,due_dt) VALUES ('2012-01-12', 7874365, 110,'2012-01-27');
INSERT INTO book_issue (issue_date,accession_no, member_id,due_dt) VALUES ('2012-03-04', 9873492, 101,'2012-04-19');
INSERT INTO book_issue (issue_date,accession_no, member_id,due_dt) VALUES ('2012-03-14', 3023012, 108,'2012-03-29');
INSERT INTO book_issue (issue_date,accession_no, member_id,due_dt) VALUES ('2013-05-15', 0935482, 107,'2013-05-30');

INSERT INTO book_issue (issue_date,accession_no, member_id,due_dt) VALUES ('2013-06-12', 7874365, 108,'2013-06-27');

INSERT INTO book_issue (issue_date,accession_no, member_id,due_dt) VALUES ('2013-06-13', 1034835, 106,'2013-06-28');
INSERT INTO book_issue (issue_date,accession_no, member_id,due_dt) VALUES ('2013-07-03', 3023012, 102,'2013-07-18');
INSERT INTO book_issue (issue_date,accession_no, member_id,due_dt) VALUES ('2013-11-05', 9873492, 101,'2013-11-20');
INSERT INTO book_issue (issue_date,accession_no, member_id,due_dt) VALUES ('2014-01-10', 1034835, 104,'2014-01-25');
INSERT INTO book_issue (issue_date,accession_no, member_id,due_dt) VALUES ('2014-05-12', 3023012, 103,'2014-05-27');
INSERT INTO book_issue (issue_date,accession_no, member_id,due_dt) VALUES ('2014-12-01', 9873492, 102,'2014-12-16');
INSERT INTO book_issue (issue_date,accession_no, member_id,due_dt) VALUES ('2015-06-02', 0935482, 101,'2015-06-17');

INSERT INTO book_issue (issue_date,accession_no, member_id,due_dt) VALUES ('2015-07-03', 9873492, 102,'2015-07-18');
INSERT INTO book_issue (issue_date,accession_no, member_id,due_dt) VALUES ('2015-09-09', 3023012, 104,'2015-09-24');
INSERT INTO book_issue (issue_date,accession_no, member_id,due_dt) VALUES ('2015-09-10', 0935482, 102,'2015-09-25');
INSERT INTO book_issue (accession_no, member_id) VALUES (1034835, 101);


/*Inserting data into book_return table*/
INSERT INTO book_return VALUES 
('2012-01-13', 7874365, 110,'2012-01-12'),
('2012-05-20', 9873492, 101,'2012-03-04'),
('2012-03-15', 3023012, 108,'2012-03-14'),
('2013-05-16', 0935482, 107,'2013-05-15'),
('2013-08-01', 1034835, 106,'2013-06-13'),
('2013-09-11', 3023012, 102,'2013-07-03'),
('2013-11-22', 9873492, 101,'2013-11-05'),
('2014-03-24', 1034835, 104,'2014-01-10'),
('2014-05-27', 3023012, 103,'2014-05-12'),
('2014-12-18', 9873492, 102,'2014-12-01'),
('2015-07-17', 0935482, 101,'2015-06-02'),
('2015-09-11', 3023012, 104,'2015-09-09');
