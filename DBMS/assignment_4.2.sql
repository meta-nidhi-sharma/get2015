/*
*@author Nidhi Sharma
*Date: 13 september,2015
* Executing Queries
*/

USE library;

/* VIEW to Display member name and
all issue details of the member*/
CREATE VIEW BOOK_ISSUE_INFO
AS 
SELECT m.member_name,bi.accession_no,bi.issue_date,bi.due_dt,b.status,br.return_dt
From members AS m
LEFT JOIN book_issue AS bi ON m.member_id=bi.member_id
LEFT JOIN books AS b ON bi.accession_no=b.accession_no
LEFT JOIN book_return AS br ON br.issue_date=bi.issue_date;

SELECT * FROM BOOK_ISSUE_INFO;



/*View which contains three columns, member name,
member id and full description of category, i.e., Faculty, Students
and Others instead of F,S and O*/
CREATE VIEW CATEGORY_DESCRIPTION
AS 
SELECT m.member_name,m.member_id,
CASE(m.category)
WHEN 'F' then 'Faculty'
WHEN 'S' then 'Student'
WHEN 'O' then 'Other'
ELSE 'INVALID'
END 
From members AS m;

SELECT * FROM CATEGORY_DESCRIPTION;


/*A View which contains the information – subject name,
title, member name, category, issue date, due date and return
date. If the books have not been returned, NULL should be
displayed instead of return date*/
CREATE VIEW books_info
AS 
SELECT s.subject_name,t.title_name, m.member_name, m.category, bi.issue_date, bi.due_dt,br.return_dt
FROM book_issue AS bi
LEFT JOIN book_return AS br ON bi.accession_no IN (SELECT accession_no FROM book_return) AND bi.issue_date=br.issue_date
INNER JOIN members AS m ON m.member_id=bi.member_id
INNER JOIN books AS b ON b.accession_no=bi.accession_no
INNER JOIN titles AS t ON t.title_id = b.title_id 
INNER JOIN subjects AS s ON s.subject_id =t.subject_id;

SELECT * FROM books_info;
