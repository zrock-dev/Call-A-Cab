DROP SCHEMA IF EXISTS `Call-a-Cab`;
CREATE SCHEMA `Call-a-Cab`;
-- tables
-- Table: Driver
USE `Call-a-Cab`;

CREATE TABLE Driver (
    id integer NOT NULL AUTO_INCREMENT, # value = 10
    first_name varchar(125) NOT NULL,
    last_name varchar(125) NOT NULL,
    phone integer NOT NULL,
    gender varchar(15) NOT NULL,
    experience integer DEFAULT 0,
    PRIMARY KEY (id)
);
ALTER TABLE Driver AUTO_INCREMENT = 10;

-- Table: Car
CREATE TABLE Car (
    id integer NOT NULL AUTO_INCREMENT, #Value = 20
    model varchar(120) NOT NULL,
    color varchar(50) NOT NULL,
    type varchar(50),
    licence_plate varchar(50) NOT NULL,
    PRIMARY KEY (id)
);
ALTER TABLE Car AUTO_INCREMENT = 20;


-- Table: Travel_information
CREATE TABLE Travel_details (
    id integer NOT NULL AUTO_INCREMENT,
    customer_location varchar(255) NOT NULL,
    arrive_destination varchar(255) NOT NULL,
    no_passengers integer NOT NULL,
    total_price double,
    PRIMARY KEY (ID)
);
ALTER TABLE Travel_details AUTO_INCREMENT = 30;

DROP TABLE Trips;
-- Table: Trips
CREATE TABLE Trips (
    id integer not null AUTO_INCREMENT,
    car_id integer,
    driver_id integer,
    travel_details_id integer,
    PRIMARY KEY (id),
    FOREIGN KEY (car_id) REFERENCES Car(id),
    FOREIGN KEY (driver_id) REFERENCES Driver(id),
    FOREIGN KEY (travel_details_id) REFERENCES Travel_details(id)
);
ALTER TABLE Trips AUTO_INCREMENT = 40;

-- Procedure
DELIMITER //
# Procedure to get the number of drivers in the data base.
--
CREATE PROCEDURE getDriversQuantity(OUT driversAmount int)
BEGIN
    SELECT COUNT(Driver.id) FROM Driver INTO driversAmount;
END;

CREATE PROCEDURE generateTicket(OUT tripsIdentifier int)
BEGIN
    INSERT INTO Trips VALUES ();
    SELECT id FROM Trips ORDER BY id DESC LIMIT 1 INTO tripsIdentifier;
END;
// DELIMITER ;


-- Initial data
-- Driver data
INSERT INTO Driver (first_name, last_name, phone, gender) value
    (
    'Shizuko',
    'Stiefel',
    72545582,
    'Female'
    );

INSERT INTO Driver (first_name, last_name, phone, gender) value
    (
    'Malia',
    'Platek',
    70918536,
    'Male'
    );

INSERT INTO Driver (first_name, last_name, phone, gender) value
    (
    'Rudy',
    'Guevera',
    71917719,
    'Male'
    );


-- Car Data
INSERT INTO Car(model, color, type, licence_plate)
VALUES (
        'Hyundai Santa Fe Sport',
        'Blue',
        'Gasoline',
        '8EZE048'
       );

INSERT INTO Car(model, color, type, licence_plate)
VALUES (
        'Mitsubishi Gallant Es / Se',
        'Red',
        'Electric',
        'BFZ4261'
       );

INSERT INTO Car(model, color, type, licence_plate)
VALUES (
        'DodgeCharger SXT Rally',
        'White',
        'GNLP',
        'HJW6803'
       );

INSERT INTO Car(model, color, type, licence_plate)
VALUES (
        'Toyota Camry Ce / Le / Xle',
        'Gray',
        'Hydrogen Fueled',
        'VCN7013'
       );

INSERT INTO Car(model, color, type, licence_plate)
VALUES (
        'Fusion Se Hybrid',
        'Brown',
        'Green Fuel',
        '2530WT'
       );

-- End of file.
