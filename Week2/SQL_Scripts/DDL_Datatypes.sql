--This is a comment


--Data Definition Language (DDL): create, alter, truncate, drop

CREATE TABLE users( --create will CREATE your tables (you can also use this to create schemas and databases)
	user_name text
);


ALTER TABLE users ADD user_age int; --alter lets you change the columns of a table
--in this case, we added a column to track the user's age.


DROP TABLE users; --will drop the table 


--not shown: truncate - drop all RECORDS in a table (didn't use because we didn't input any data)
--TRUNCATE users;

--This is a very rudimentary table, they're going to be more complicated than this
--but this was just a DDL runthrough


-----------------------------------------------------------------------------------

--Let's talk datatypes


--This is a horribly designed table (No Primary Key, not particularly normalized)
--We won't use it, it'll just help us list some datatypes


CREATE TABLE datatypes(
	numbers_small int2, --this is your small int data type
	numbers_normal int, --this is a normal int, we'll usually use this
	numbers_also_normal int4, --this is the defult int, so when you say int, it's an int4
	numbers_large int8, --for extremely large numbers
	number_with_decimal_place decimal(10, 2), --2 parameters here: (total digits, total decimal places)
	
	currency_value money,
	
	"boolean" boolean, --double quotes let you use reserved keywords (such as boolean) as column names 
	
	fixed_length_text char(2), --fixed in length text type, will be 2 characters. Not the best practice.
	variable_length_char varchar(10), --variable in length 0-10 characters. ok practice
	unlimited_length_char TEXT, --best practice, unlimited length, the possiblities are endless
	
	"date" date, --YYYY-MM-DD
	"timestamp" timestamp --YYYY-MM-DD HH-MM-SS
	
	--This is NOT all of the datatypes... There are so many 
	--But... most of the time, our data will just be numbers and text
	
);

