DELIMITER $$
CREATE PROCEDURE usp_add_numbers(n1 INT, n2 INT, OUT result INT)
BEGIN
SET result = n1 + n2;
END $$
DELIMITER ;

SET @answer = 0;
CALL usp_add_numbers(3, 7, @answer);
SELECT @answer;