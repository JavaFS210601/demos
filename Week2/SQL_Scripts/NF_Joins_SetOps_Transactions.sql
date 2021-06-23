--This script will demonstrate Normal Forms 0-3

--I also want to go over Joins and Set Operations

--I ALSO want to fit in a Transaction in here (TCL and the ACID Properties)


--ONF
--We have a table. No other rules, it's anarchy

CREATE TABLE avengers (
	hero_name TEXT,
	hero_power TEXT,
	real_name TEXT,
	home_base TEXT,
	home_address TEXT 
);

--This is a horrible table! No Primary Key, columns aren't atomic, 
--and there are columns that should be separate tables

INSERT INTO avengers (hero_name, hero_power, real_name, home_base, home_address)
			VALUES ('Spiderman', 'Webby Boi', 'Peter Parker', 'Queens', '225, his Aunt''s house'),
			--we use two apostrophes to put on apostrophe inside single quotes
				   ('Iron Man', 'Rich Big Brain Metal Guy', 'Tony Stark', 'Manhattan', 'Stark Tower');

SELECT * FROM avengers;

--This 0NF table is fine if we just want to insert and read our data
--But we will encounter insurmountable adversity if we try to do more complex stuff like establish relationships


--1NF 
--Tables must have a Primary Key (can be a composite key)
--Columns must be atomic

DROP TABLE IF EXISTS avengers;

--Let's have a composite primary key, using hero_name and hero_power to uniquely identify each avenger
--Let's also make each column atomic (as small as they can be)
CREATE TABLE avengers (
	hero_name TEXT,
	hero_power TEXT,
	first_name TEXT,
	last_name TEXT,
	home_base TEXT,
	street_address TEXT,
	city TEXT,
	state char(2),
	zip char(5)
);

--Remember, ALTER is part of DDL, lets you change your columns
ALTER TABLE avengers ADD PRIMARY KEY (hero_name, hero_power); --this is our compositite key


INSERT INTO avengers (hero_name, hero_power, first_name, last_name, home_base, street_address, city, state, zip)
			VALUES ('Spiderman', 'Webby Boi', 'Peter', 'Parker', 'His House', '123 Street st', 'Queens', 'NY', '22151'),
			('Iron Man', 'Rich Big Brain Guy', 'Tony', 'Stark', 'Stark Tower', '455 Street st', 'Manhattan', 'NY', '22151');

SELECT * FROM avengers;	


--2NF
--Need to be in 1NF to achieve this
--Remove partial dependencies (by having a single column PK)

DROP TABLE IF EXISTS avengers;

CREATE TABLE avengers (
	hero_id serial PRIMARY KEY, --We insert one dedicated primary key. Remember serial auto-increments
	hero_name TEXT,
	hero_power TEXT,
	first_name TEXT,
	last_name TEXT,
	home_base TEXT,
	street_address TEXT,
	city TEXT,
	state char(2),
	zip char(5)
);

--Since serial data types are an auto-incrementing int4, we don't need to specify in the insert command
INSERT INTO avengers (hero_name, hero_power, first_name, last_name, home_base, street_address, city, state, zip)
			VALUES ('Spiderman', 'Webby Boi', 'Peter', 'Parker', 'His House', '123 Street st', 'Queens', 'NY', '22151'),
			('Iron Man', 'Rich Big Brain Guy', 'Tony', 'Stark', 'Stark Tower', '455 Street st', 'Manhattan', 'NY', '22151'),
			('Spiderman', 'Webby Boi', 'Miles', 'Morales', 'His House', '123 Street st', 'Queens', 'NY', '22151');

SELECT * FROM avengers;


--3NF 
--Have to be in 2NF to achieve this
--remove transitive dependencies (the only columns depended on should be the primary key!)

DROP TABLE IF EXISTS avengers;


CREATE TABLE homes (
	home_base TEXT PRIMARY KEY, --example of a non-serial PK. We're assuming that every home base will be uniquely named
								--we usually just prefer a serial id PK, but there are times where this is fine
	street_address TEXT,
	city TEXT,
	state char(2),
	zip char(5)
);

INSERT INTO homes (home_base, street_address, city, state, zip)
			VALUES ('Aunt May''s House', '123 Street st', 'Queens', 'NY', '22151'),
				   ('Stark Tower', '455 Street st', 'Manhattan', 'NY', '22151');

--adding an extra home to help demonstrate set operations
INSERT INTO homes (home_base, street_address, city, state, zip)
			VALUES ('A Box', '13 Street st', 'Queens', 'NY', '22151');

SELECT * FROM homes;


CREATE TABLE avengers(
	hero_id serial PRIMARY KEY, 
	hero_name TEXT,
	hero_power TEXT,
	first_name TEXT,
	last_name TEXT,
	home_base_fk TEXT REFERENCES homes (home_base)
);


INSERT INTO avengers (hero_name, hero_power, first_name, last_name, home_base_fk)
			VALUES ('Spiderman', 'Webby Boi', 'Peter', 'Parker', 'Aunt May''s House'),
			('Iron Man', 'Rich Big Brain Guy', 'Tony', 'Stark', 'Stark Tower');

--adding one more avenger so we can better understand how joins work
INSERT INTO avengers (hero_name, hero_power, first_name, last_name)
			VALUES ('Black Widow', 'she cute and she kill', 'Scarlett', 'Johanneson');

SELECT hero_name FROM avengers; 


--Cool, fully normalized (or actually just up to 3NF).


--Joins------------------------------------------------------------------------------------------

--Rememeber, joins are how we can query from more than one table at a time
--Multi-table queries!!

--We'll be doing joins on the homes and avengers tables that we created above.

--INNER JOIN (aka NATURAL JOIN)
--returns all rows with matching data in both tables (so black widow won't show up - she has no home_base_fk)
SELECT * FROM avengers INNER JOIN homes ON home_base_fk = home_base; 


--FULL OUTER JOIN (you can also just say FULL JOIN)
--returns all rows from both tables, regardless of matches 
SELECT * FROM avengers FULL OUTER JOIN homes ON home_base_fk = home_base; 
SELECT * FROM avengers FULL JOIN homes ON home_base_fk = home_base;


--LEFT OUTER JOIN 
--return everything in the left table, and any matches on the right table
SELECT * FROM avengers LEFT OUTER JOIN homes ON home_base_fk = home_base;
--Returns all avengers, regardless of if they have a home or not


--RIGHT OUTER JOIN 
--return everything in the right table, and any matches on the left table
SELECT * FROM avengers RIGHT OUTER JOIN homes ON home_base_fk = home_base;
--Returns all homes, and leave out avengers with no home_base_fk (so no black widow)


--CROSS JOIN 
--Returns the cartesian product (all possible combos) of each table
SELECT * FROM avengers CROSS JOIN homes;


CREATE TABLE justice_leaguers (
	hero_id serial PRIMARY KEY,
	hero_name TEXT,
	hero_power TEXT
);

INSERT INTO justice_leaguers (hero_name, hero_power)
			VALUES ('Superman', 'up down up down left right a b Lister'),
				   ('The Flash', 'he fas');

--more interesting cross join, using two unrelated tables
SELECT * FROM avengers CROSS JOIN justice_leaguers;



--Set Operations-----------------------------------------------------------------------------

--We use set operations to combine multiple queries
	--Don't confuse them with joins (remember: joins -> tables, set ops -> queries)
	

--UNIONS
--All distinct rows from both queries, no duplicates
SELECT home_base_fk FROM avengers UNION SELECT home_base FROM homes;
--There are 4 total options for homes (including null)
--one of them (null) is only found in the avengers table
--one of them (A box) is only found in the homes table
--with Unions, we can get them all returned


--UNION ALL
--All distinct rows from each query, including duplicates
SELECT home_base_fk FROM avengers UNION ALL SELECT home_base FROM homes;
--Note how we see the duplicates! Main difference between UNION and UNION ALL


--INTERSECT
--Return unique rows that IS FOUND IN BOTH queries
SELECT home_base_fk FROM avengers INTERSECT SELECT home_base FROM homes;
--Only Stark Tower and Aunt May's House will get returned, cause they're found in both queries


--EXCEPT 
--Return unique rows found in the first query that don't appear in the second query
SELECT home_base_fk FROM avengers EXCEPT SELECT home_base FROM homes;
--every home base foudn in avengers exists in homes (besides null
SELECT home_base FROM homes EXCEPT SELECT home_base_fk FROM avengers;
--The 'A Box' home_base is the only hame_base taht doesn't appear in the avengers table



