create schema `Call-a-Cab`;

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
CREATE TABLE Travel_information (
    id integer NOT NULL AUTO_INCREMENT,
    customer_location varchar(255) NOT NULL,
    arrive_destination varchar(255) NOT NULL,
    no_passengers integer NOT NULL,
    PRIMARY KEY (ID)
);
ALTER TABLE Travel_information AUTO_INCREMENT = 30;

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE Trips;
SET FOREIGN_KEY_CHECKS = 1;

-- Table: Trips
CREATE TABLE Trips (
    id integer not null AUTO_INCREMENT,
    car_id integer not null,
    driver_id integer not null,
    travel_information_id integer not null,
    total_price integer not null,
    PRIMARY KEY (id),
    FOREIGN KEY (car_id) REFERENCES Car(id),
    FOREIGN KEY (driver_id) REFERENCES Driver(id),
    FOREIGN KEY (travel_information_id) REFERENCES Travel_information(id)
);
ALTER TABLE Trips AUTO_INCREMENT = 40;

DESCRIBE Trips;
-- End of file.
