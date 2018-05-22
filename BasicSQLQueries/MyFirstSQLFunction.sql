DELIMITER $$
CREATE FUNCTION uf_count_employees_by_town(town_name VARCHAR(255)) 
RETURNS INT
 
BEGIN 
DECLARE the_count INT; 
SET the_count := (SELECT COUNT(e.employee_id)
FROM employees AS e
INNER JOIN addresses AS a ON e.address_id = a.address_id
INNER JOIN towns AS t ON t.town_id = a.town_id
WHERE t.name = town_name);

RETURN the_count;
END $$

DELIMITER ;

SELECT uf_count_employees_by_town('Sofia');


