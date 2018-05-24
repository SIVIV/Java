DELIMITER %%
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(tb DECIMAL(10,4))
BEGIN

SELECT ah.id, ah.first_name, ah.last_name, SUM(a.balance) AS `Total Balance`
FROM account_holders AS ah
INNER JOIN accounts AS a
ON a.account_holder_id = ah.id
GROUP BY ah.id
HAVING `Total Balance` > tb
ORDER BY `Total Balance` DESC;

END %%

DELIMITER ;

CALL usp_get_holders_with_balance_higher_than(7000);