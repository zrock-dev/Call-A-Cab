create schema `Call-a-Cab`;

-- tables
-- Table: Driver
USE `Call-a-Cab`;

CREATE TABLE Driver (
    CI integer NOT NULL,
    first_name varchar(125) NOT NULL,
    last_name varchar(125) NOT NULL,
    phone integer NOT NULL,
    gender varchar(15) NOT NULL,
    experience integer DEFAULT 0,
    PRIMARY KEY (CI)
);

-- Table: Taxi
CREATE TABLE Taxi (
    Plate varchar(50) NOT NULL,
    Driver_Id integer,
    taxi_specs_id integer NOT NULL,
    Availability boolean default true NOT NULL,
    Rating integer, # Has to be a random value
    PRIMARY KEY (Plate),
    FOREIGN KEY (Driver_Id) REFERENCES Driver(CI)
);

-- Table: Taxi_specs
CREATE TABLE Taxi_specs (
    id integer NOT NULL AUTO_INCREMENT, # Actual value=1
    model varchar(120) NOT NULL,
    color varchar(50) NOT NULL,
    type varchar(50),
    PRIMARY KEY (id)
);

-- Table: Taxi_trips
CREATE TABLE Taxi_trips (
    ID integer NOT NULL AUTO_INCREMENT,
    Taxi_Plate varchar(50),
    Customer_location varchar(255) NOT NULL,
    arrive_destination varchar(255) NOT NULL,
    no_passengers integer NOT NULL,
    total_price integer NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (Taxi_Plate) REFERENCES Taxi(Plate)
);

ALTER TABLE Taxi_specs AUTO_INCREMENT = 1;
ALTER TABLE Taxi_trips AUTO_INCREMENT = 500;

-- End of file.
