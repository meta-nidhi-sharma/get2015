/*
*@author Nidhi Sharma
*Date: 8 september,2015
*To drop members table fro database dropping related foreign keys
*/
USE library;

ALTER TABLE book_issue
DROP FOREIGN KEY bookIssue_Fkey1;

ALTER TABLE book_return
DROP FOREIGN KEY bookReturn_Fkey2;

DROP TABLE members;
