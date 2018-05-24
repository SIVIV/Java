DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(salary DECIMAL(10,2)) 
RETURNS VARCHAR(10) 

BEGIN 

DECLARE output VARCHAR(10);
IF(salary < 30000) THEN SET output := 'Low'; 
ELSEIF(salary <= 50000) THEN SET output := 'Average';
ELSE SET output := 'High';
END IF;
RETURN output;

END $$

DELIMITER ;


SELECT ufn_get_salary_level(55555);