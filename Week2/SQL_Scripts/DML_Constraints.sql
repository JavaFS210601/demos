--Let's create two tables that are related to each other (using primary/foreign keys)

--owner table
CREATE TABLE owners(
	owner_id serial PRIMARY KEY, --serial is an auto-incrementing int type. Convenient! We don't include it in insert statments
						 --great for Primary Keys, so that we can have a unique id for each record
	owner_name TEXT NOT NULL --every owner will be forced to have a name
);


--dogs table
CREATE TABLE dogs(
	dog_id serial PRIMARY KEY,
	dog_name TEXT NOT null,
	dog_breed TEXT,
	dog_age int NOT NULL CHECK (dog_age > 2),
	dog_weight decimal(5, 2) NOT NULL,
	
	--This is how we establish a primary/foreign key relationship
	--This foreign in the dogs table references the primary key of the owners table 
	owner_id_fk int REFERENCES owners (owner_id)
);


--If you check the ERD (right clicking the schema, and selecting view schema) you'll see the fk/pk relationship

--Since the dogs table has a reference to the owner table, there's a relationship
--In this case, one owner can have many dogs. A "one to many" relationship
--We'll talk about multiplicity later. (one-to-one, one-to-many, many-to-many).


------------------------------------------------------------------------------------------------------


--let's use some Data Manipulation Language (DML): Select, Insert, Update, Delete

--INSERT some owners into the owner table, and dogs into the dogs table
--After each insert statement, we'll SELECT to show that the tables have been populated

--"Insert the following values for the name field of the owners table"
INSERT INTO owners (owner_name) VALUES ('Ryan'), ('Chris'), ('Chani'), ('Marsha');

SELECT * FROM owners; --returns all the owners records (rows) in the owners table

--Insert some dog values
INSERT INTO dogs (DOG_NAME, dog_breed, dog_age, dog_weight, owner_id_fk)
			VALUES ('Sparky', 'Terrier', 13, 15.50, 1),
				   ('Sadie', 'Black Lab', 7, 60.0, 2),
				   ('Chad', 'Corgi', 5, 20.25, 3),
				   ('Quincy', 'Mutt', 7, 35.75, 1);

SELECT * FROM dogs; --returns all the records in the dogs table


--We can also select data from specific columns instead of the entire record

SELECT dog_name FROM dogs; --return all the dog names

SELECT dog_name, dog_age, owner_id_fk FROM dogs; --this would return the values from these three columns


--Let's explore using the WHERE clause, which lets us filter the data we select
--There are lots of operators we can use, all of which filter data differently----------------------------------------(WHERE) 

--select dogs who are terriers (=)
SELECT * FROM dogs WHERE dog_breed = 'Terrier';

--select dogs who are NOT terriers (!=)
SELECT * FROM dogs WHERE dog_breed != 'Terrier';

--select dogs younger than 8 (<)
SELECT * FROM dogs WHERE dog_age < 8;


--dogs names starting with "S" (like with %)
SELECT * FROM dogs WHERE dog_name LIKE 'S%';

--dogs names ending with "y" (like with %)
SELECT * FROM dogs WHERE dog_name LIKE '%y';


--dogs who weigh between 10-30 (between with and)
SELECT * FROM dogs WHERE dog_weight BETWEEN 10 AND 30;


--dogs who are Corgis or Mutts (or)
SELECT * FROM dogs WHERE dog_breed = 'Corgi' OR dog_breed = 'Mutt';
--you can do this same thing with less typing if you use (in)
SELECT * FROM dogs WHERE dog_breed IN ('Corgi', 'Mutt');

--dogs who are not Corgis or Mutts (not in)
SELECT * FROM dogs WHERE dog_breed NOT IN ('Corgi', 'Mutt');


--Also important is the ORDER BY clause---------------------------------------------------------(ORDER BY)
--ORDER BY lets us order our selected data

SELECT * FROM dogs ORDER BY dog_age; --ascending by default, but can specify asc if you want 
--SELECT * FROM dogs ORDER BY dog_age ASC;


SELECT * FROM dogs ORDER BY dog_weight DESC; 


--We can also UPDATE values in our tables---------------------------------------------------------(UPDATE)

--update Quincy's age to be 8. 
UPDATE dogs SET dog_age = 8 WHERE dog_name = 'Quincy'; --happy birthday!

--another way to perform the same age update functionality
UPDATE dogs SET dog_age = dog_age + 1 WHERE dog_name = 'Sparky'; --happy birthday!

--Be careful!! You should ALWAYS use a where clause, or every row will change.


--Finally, can also DELETE records. I usually don't do this, it can be dangerous for data integrity.-------------------(DELETE)
--Like with update, remember to alwasy use the where clause, or everything will go.

DELETE FROM dogs WHERE dog_name = 'Sparky'; --this would delete sparky :(






