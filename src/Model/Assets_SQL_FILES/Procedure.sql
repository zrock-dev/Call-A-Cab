

DELIMITER //
# Procedure to get the number of drivers in the data base.
--
CREATE PROCEDURE getDriversQuantity(OUT driversAmount int)
BEGIN
    SELECT COUNT(Driver.id) FROM Driver INTO driversAmount;
END;
// DELIMITER ;

