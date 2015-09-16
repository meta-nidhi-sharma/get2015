/*
*@author Nidhi Sharma
*Date: 13 september,2015
* To set issue date as current_date using NOW() function and to set due date as current_date +15 days using NOW() function
*/
USE library;

/* To set issue date as current_date using NOW() function*/
ALTER TABLE book_issue MODIFY COLUMN issue_date TIMESTAMP DEFAULT NOW();

/* To set due date as current_date +15 days using NOW() function*/
DELIMITER //

CREATE TRIGGER Book
BEFORE INSERT ON book_issue
FOR EACH ROW 
BEGIN
SET NEW.due_dt = IFNULL(NEW.due_dt, now() + INTERVAL 15 day);
END; //

DELIMITER ;