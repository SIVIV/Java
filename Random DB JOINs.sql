SELECT e.first_name, e.last_name, t.name, a.address_text
FROM employees AS e
JOIN addresses AS a ON e.address_id = a.address_id
JOIN towns AS t ON a.town_id = t.town_id
ORDER BY e.first_name, e.last_name;


SELECT e.employee_id, e.first_name, p.name
FROM employees AS e
LEFT JOIN employees_projects AS ep ON e.employee_id = ep.employee_id
JOIN projects AS p ON ep.project_id = p.project_id
WHERE p.end_date IS NULL AND DATE(p.start_date) > '2002-08-13'
ORDER BY e.first_name, p.name
LIMIT 5;





SELECT e1.employee_id, e1.first_name, e2.employee_id AS `manager_id`, e2.first_name
FROM employees AS e1
JOIN employees AS e2
ON e1.manager_id = e2.employee_id
WHERE e1.manager_id IN (3,7)
ORDER BY e1.first_name; 



SELECT e1.employee_id, 
CONCAT(e1.first_name, ' ', e1.last_name) AS `Employee Name`, 
CONCAT(e2.first_name, ' ', e2.last_name) AS `Manager Name`,
d.name AS `Department`
FROM employees AS e1
JOIN employees AS e2
ON e1.manager_id = e2.employee_id
JOIN departments AS d
ON e1.department_id = d.department_id
ORDER BY e1.employee_id
LIMIT 5;










