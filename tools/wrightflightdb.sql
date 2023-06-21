-- Comment the lines out in between the # if creating the database for the first time
-- ######################################
--DROP TABLE airports;
--DROP TABLE planes;
--DROP TABLE flights;
--DROP TABLE users;
--DROP TABLE baggages;
--DROP DATABASE wrightflight;
-- ######################################

-- Create database and enter it
CREATE DATABASE wrightflight;
USE wrightflight;

-- Create tables
CREATE TABLE airports
(airportcode VARCHAR(3) NOT NULL, 
airportname VARCHAR(128), 
CONSTRAINT airport_pk PRIMARY KEY(airportcode));

CREATE TABLE planes
(planetypeid VARCHAR(64) NOT NULL, 
numberoffirstclassseats INT, 
numberofcoachseats INT,
CONSTRAINT plane_pk PRIMARY KEY(planetypeid));

CREATE TABLE flights
(flightnumber INT NOT NULL,
originairport VARCHAR(3) NOT NULL,
destinationairport VARCHAR(3) NOT NULL,
planetypeid VARCHAR(64) NOT NULL,
planneddeparture DATE,
plannedarrival DATE,
actualdeparture DATE,
actualarrival DATE,
departuregate VARCHAR(3),
arrivalgate VARCHAR(3),
firstclassseatsfilled INT,
coachseatsfilled INT,
CONSTRAINT flights_pk PRIMARY KEY(flightnumber),
CONSTRAINT originfl_fk FOREIGN KEY(originairport) REFERENCES 
airports(airportcode),
CONSTRAINT destfl_fk FOREIGN KEY(destinationairport) REFERENCES 
airports(airportcode),
CONSTRAINT planefl_fk FOREIGN KEY(planetypeid) REFERENCES 
planes(planetypeid));

CREATE TABLE roles
(roleid INT NOT NULL,
roletitle VARCHAR(64) NOT NULL,
CONSTRAINT role_pk PRIMARY KEY(roleid));

CREATE TABLE users
(username VARCHAR(128) NOT NULL,
passwordhash VARCHAR(128) NOT NULL,
passwordsalt VARCHAR(128) NOT NULL,
roleid INT NOT NULL,
firstname VARCHAR(64) NOT NULL,
lastname VARCHAR(64) NOT NULL,
streetaddress VARCHAR(64) NOT NULL,
city VARCHAR(64) NOT NULL,
state VARCHAR(64) NOT NULL,
zip VARCHAR(64) NOT NULL,
CONSTRAINT users_pk PRIMARY KEY(username),
CONSTRAINT usrrole_fk FOREIGN KEY(roleid) REFERENCES roles(roleid));

CREATE TABLE baggage
(bagid INT AUTO_INCREMENT,
username VARCHAR(128) NOT NULL,
originairport VARCHAR(3) NOT NULL,
destinationairport VARCHAR(3) NOT NULL,
timecheckedin DATE,
weightinpounds DECIMAL(4,2),
CONSTRAINT bag_pk PRIMARY KEY(bagid),
CONSTRAINT bagusr_fk FOREIGN KEY(username) REFERENCES users(username),
CONSTRAINT bagorig_fk FOREIGN KEY(originairport) REFERENCES 
airports(airportcode),
CONSTRAINT bagdest_fk FOREIGN KEY(destinationairport) REFERENCES 
airports(airportcode));

-- Initialize data for database
INSERT INTO airports VALUES ('CVG', 'Cincinnati/Northern Kentucky International Airport');
INSERT INTO airports VALUES ('DAY', 'Dayton International Airport');
INSERT INTO airports VALUES ('CMH', 'John Glenn International Airport');
INSERT INTO airports VALUES ('LCK', 'Rickenbacker International Airport');
INSERT INTO airports VALUES ('ATL', 'Hartsfield-Jackson Atlanta International Airport');
INSERT INTO airports VALUES ('DFW', 'Dallas/Fort Worth International Airport');
INSERT INTO airports VALUES ('DEN', 'Denver International Airport');
INSERT INTO airports VALUES ('ORD', 'OHare International Airport');
INSERT INTO airports VALUES ('LAX', 'Los Angeles International Airport');
INSERT INTO airports VALUES ('CLT', 'Charlotte Douglas International Airport');
INSERT INTO airports VALUES ('MCO', 'Orlando International Airport');
INSERT INTO airports VALUES ('LAS', 'Harry Reid International Airport');
INSERT INTO airports VALUES ('PHX', 'Phoenix Sky Harbor International Airport');
INSERT INTO airports VALUES ('MIA', 'Miami International Airport');
INSERT INTO airports VALUES ('SEA', 'Seattle-Tacoma International Airport');
INSERT INTO airports VALUES ('IAH', 'George Bush Intercontinental Airport');
INSERT INTO airports VALUES ('JFK', 'John F. Kennedy International Airport');
INSERT INTO airports VALUES ('EWR', 'Newark Liberty International Airport');
INSERT INTO airports VALUES ('FLL', 'Fort Lauderdale-Hollywood International Airport');
INSERT INTO airports VALUES ('MSP', 'Minneapolis-Saint Paul International Airport');
INSERT INTO airports VALUES ('SFO', 'San Francisco International Airport');
INSERT INTO airports VALUES ('DTW', 'Detroit Metropolitan Airport');
INSERT INTO airports VALUES ('BOS', 'Logan International Airport');
INSERT INTO airports VALUES ('SLC', 'Salt Lake City International Airport');
INSERT INTO airports VALUES ('PHL', 'Philadelphia International Airport');
INSERT INTO airports VALUES ('BWI', 'Baltimore/Washington International Airport');
INSERT INTO airports VALUES ('TPA', 'Tampa International Airport');
INSERT INTO airports VALUES ('SAN', 'San Diego International Airport');
INSERT INTO airports VALUES ('LGA', 'LaGuardia Airport');
INSERT INTO airports VALUES ('MDW', 'Midway International Airport');
INSERT INTO airports VALUES ('BNA', 'Nashville International Airport');
INSERT INTO airports VALUES ('IAD', 'Washington Dulles International Airport');
INSERT INTO airports VALUES ('DCA', 'Ronald Reagan Washington International Airport');
INSERT INTO airports VALUES ('AUS', 'Austin-Bergstrom International Airport');