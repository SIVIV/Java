DELIMITER ??
CREATE PROCEDURE usp_count_employees_from_Sofia()
BEGIN

SELECT COUNT(e.employee_id)
FROM employees AS e
INNER JOIN addresses AS a ON e.address_id = a.address_id
INNER JOIN towns AS t ON t.town_id = a.town_id
WHERE t.name = 'Sofia';

END ??