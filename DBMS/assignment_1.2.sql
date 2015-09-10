/*
*@author Nidhi Sharma
* Date: 10 september,2015
*Description: Display results in ascending order of issue date and within issue date in ascending order of members name
*/

USE library;

SELECT I.issue_date,I.accession_no,I.member_id,R.return_dt
FROM book_issue AS I
LEFT JOIN book_return AS R ON (I.issue_date = R.issue_date) AND (I.accession_no = R.accession_no)
ORDER BY I.issue_date ASC, (Select member_name FROM members WHERE member_id=I.member_id) ASC;
