/*
*@author Nidhi Sharma
* Date: 10 september,2015
*Library DATABASE with some queries
*/

USE library;

/*Select command to display all column of members table*/
SELECT * FROM members;          

/*Select command to display specified column of members table*/
SELECT member_name, member_id, category
FROM members;

/*Select command to display specified column with specified condition of members table*/
SELECT member_name, member_id, category
FROM members
WHERE category='F';

/*Select command to display  distinct values from specified column of members table*/
SELECT DISTINCT category
FROM members;

/*Select command to display specified column in sorted order of members table*/
SELECT member_name, category
FROM members
ORDER BY member_name DESC;

/*Select command to display specified column of different tables linked using foreign key*/
SELECT title_name,subject_name,publisher_name FROM titles
INNER JOIN subjects ON titles.subject_id = subjects.subject_id
INNER JOIN publishers ON titles.publisher_id = publishers.publisher_id;

/*Select command to display count of values in column grouped by category*/
SELECT category,COUNT(*)  
FROM members
GROUP BY category;      

/*Select command to display distinct name with specified condition using inner join*/
SELECT DISTINCT m1.member_name
FROM members AS m1
JOIN members AS m2 ON m1.category IN (SELECT category FROM members WHERE member_name='Nidhi');

/*Select command to display specified column from different tables using Left join*/
SELECT I.accession_no AS BOOK,I.issue_date AS Issued_on,I.member_id AS Issued_to,R.return_dt AS Returned_on
FROM book_issue AS I
LEFT JOIN book_return AS R ON (I.issue_date = R.issue_date) AND (I.accession_no = R.accession_no);

