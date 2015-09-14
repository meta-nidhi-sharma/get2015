/*
*@author Nidhi Sharma
*Date: 13 september,2015
* Executing Queries
*/

USE library;


/*display name of those members
who belong to the category as to which member
“Shubham” belongs*/
SELECT m1.member_name
FROM members AS m1
WHERE m1.category IN (SELECT category FROM members WHERE member_name='Shubham');


/*display information on the books
that have not been returned till date*/
SELECT bi.issue_date,t.title_name,m.member_name,bi.due_dt,bi.accession_no
FROM book_issue AS bi,titles AS t,members AS m
WHERE member_name=(SELECT member_name FROM members AS m WHERE m.member_id = bi.member_id) 
  AND t.title_name=(SELECT title_name FROM titles AS ti WHERE ti.title_id=
      (SELECT title_id FROM books WHERE books.accession_no=bi.accession_no))
  AND (bi.issue_date NOT IN (SELECT issue_date FROM book_return AS br 
WHERE accession_no=bi.accession_no));


/*display information on the books
that have been returned after their due dates*/
SELECT bi.issue_date,bi.accession_no, t.title_name, m.member_name, bi.due_dt
FROM book_issue AS bi,titles AS t,members AS m
WHERE member_name=(SELECT member_name FROM members AS m WHERE m.member_id = bi.member_id) 
  AND t.title_name=(SELECT title_name FROM titles AS ti WHERE ti.title_id=
      (SELECT title_id FROM books WHERE books.accession_no=bi.accession_no))
  AND bi.due_dt<(SELECT return_dt FROM book_return AS br WHERE br.accession_no=bi.accession_no AND bi.issue_date=br.issue_date);


/*display information of those books
whose price is equal to the most expensive book purchase so far*/
SELECT t.title_name,s.subject_name,a.author_name,MAX(b.price) AS price
FROM books AS b
INNER JOIN titles AS t 
  ON t.title_id=b.title_id
INNER JOIN subjects AS s 
  ON s.subject_id=t.subject_id
INNER JOIN authors AS a ON a.author_id=(SELECT author_id FROM title_author AS ta WHERE ta.title_id=t.title_id)
WHERE b.price = (SELECT MAX(price) FROM books);


/*display the second maximum price
of a book*/
SELECT t.title_name,s.subject_name,a.author_name,MAX(b.price) AS price
FROM books AS b
INNER JOIN titles AS t ON t.title_id=b.title_id
INNER JOIN subjects AS s ON s.subject_id=t.subject_id
INNER JOIN authors AS a ON a.author_id=(SELECT author_id FROM title_author AS ta WHERE ta.title_id=t.title_id)
WHERE b.price = (SELECT MAX(price) FROM books WHERE price < (SELECT MAX(books.price) FROM books));