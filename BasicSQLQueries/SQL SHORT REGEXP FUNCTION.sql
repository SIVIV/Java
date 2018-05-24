DELIMITER %%

CREATE FUNCTION ufn_is_word_comprised(letters VARCHAR(50), word VARCHAR(50))
RETURNS BIT

BEGIN
RETURN word REGEXP(CONCAT('^[', letters, ']+$'));

END %%

DELIMITER ;

