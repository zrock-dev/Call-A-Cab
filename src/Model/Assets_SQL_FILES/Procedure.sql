USE `Call-a-Cab`;

# Create procedure to check if the taxi_id exists
CREATE PROCEDURE checkTaxiPlate(taxi_Plate varchar(50), OUT plateValidity tinyint(1))
BEGIN
    SELECT IF(taxi_Plate IN (SELECT Plate FROM Taxi), true, false) INTO plateValidity;
END;


# To get driver status
CREATE PROCEDURE checkDriver(
    IN taxi_Plate varchar(50),
    OUT plateValidity boolean)
BEGIN
    DECLARE driver varchar(20);
    SET driver = (SELECT Driver_Id FROM Taxi WHERE Plate=taxi_Plate);
    SELECT IF(driver IS NOT NULL, true, false) INTO plateValidity;
END;

# CALL checkTaxiPlate('2G00D');
# CALL checkDriver('200D');
# CALL getCarInformation('2G00D');