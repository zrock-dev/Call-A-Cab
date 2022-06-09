

DELIMITER //
# Procedure to get the number of drivers in the data base.
--
CREATE PROCEDURE getDriversQuantity(OUT driversAmount int)
BEGIN
    SELECT COUNT(Driver.id) FROM Driver INTO driversAmount;
END;
// DELIMITER ;

DELIMITER //
# Procedure to get a random identifier
CREATE PROCEDURE provideIdentifier(IN table_name varchar(50), OUT identifier integer)
BEGIN
    SET @TableName = table_name;
    SELECT id FROM @TableName  ORDER BY rand() LIMIT 1 INTO identifier;
END;
// DELIMITER ;

CALL provideIdentifier('Driver', 2);
