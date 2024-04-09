-- CREATE DATABASE ParkingSystem;

USE ParkingSystem;
SET SQL_SAFE_UPDATES = 0;

CREATE TABLE Accounts(
	username VARCHAR(255) NOT NULL PRIMARY KEY,
	password VARCHAR(255) NOT NULL
);

CREATE TABLE Users(
	username VARCHAR(255) NOT NULL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    credit_number VARCHAR(255) NOT NULL,
    coin INT,
    phone_number VARCHAR(255) NOT NULL,
    vehicle_number INT
);

CREATE TABLE ContractTransportation( -- we still do not create primary key
	username VARCHAR(255) NOT NULL,
    code VARCHAR(255) NOT NULL,
    day_contract DATETIME,
    transportation_type VARCHAR(255)
);

CREATE TABLE Parking(
	username VARCHAR(255) NOT NULL,
    code VARCHAR(255) NOT NULL,
    spot VARCHAR(255) NOT NULL,
    start_time datetime,
    end_time DATETIME, 
    type_transportation VARCHAR(255) NOT NULL,
    interval_time INT,
    cost INT,
    PRIMARY KEY( username, code)
);

UPDATE Parking
SET interval_time = TIMESTAMPDIFF(SECOND, start_time, end_time);

