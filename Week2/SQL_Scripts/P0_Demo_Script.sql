--create schema P0_demo

--just gonna paste the DDL and insert script to save time, we can still talk about it tho



CREATE TABLE roles (role_id serial PRIMARY KEY,	
					role_title TEXT, 
					role_salary INT
					);

CREATE TABLE employees (employee_id serial PRIMARY KEY,	
						f_name TEXT,	
						l_name TEXT,	
						hire_date date, --YYYY-MM-DD	
						role_id INT REFERENCES Roles (role_id) --foreign key
						);
						
INSERT INTO roles (role_title, role_salary)		
			VALUES ('Supreme Leader', 100000),			   
					('Fry Cook', 50000),			   
					('Cashier', 40000),			   
					('Marketing Director', 100000),			   
					('Nepotism', 100000);			  

SELECT * FROM roles;  			  

INSERT INTO employees (f_name, l_name, hire_date, role_id)
			VALUES ('Eugene', 'Krabs', '1998-01-01', 1),		   
			('Spongebob', 'Squarepants', '1998-09-20', 2),			   
			('Pete', 'Fishman', '1998-01-15', 2),   
			('Squidward', 'Tentacles', '1998-01-15', 3),		   
			('Sheldon', 'Plankton', '1998-01-01', 4),		   
			('Pearl', 'Krabs', '1998-01-01', 5);		   

SELECT * FROM employees;

--TRUNCATE employees RESTART IDENTITY;


-------------------------------------------------------------------------------------------------

--some scalar functions-----------------(UPPER, ROUND, NOW)

SELECT UPPER(f_name) FROM employees; --UPPER() returns values in all caps

SELECT ROUND (12.42); --rounds decimals to an interger, or a decimal place if you give the second parameter
SELECT ROUND (12.42, 1);

SELECT now(); --now() will return the current time and date


--some aggregate functions-----------------(AVG, MIN, MAX, SUM, COUNT)

SELECT avg(role_salary) FROM roles; --returns the average of all the data in the role_salary column

SELECT min(role_salary) FROM roles; --returns the minimum salary from the role_salay column

SELECT max(hire_date) FROM employees; --using max/min on a date, will return the latest/earliest date, respectively

SELECT sum(role_salary) FROM roles; --returns the sum of the role_salary column

SELECT count(employee_id) FROM employees; --how many employees are there?

SELECT count(employee_id) FROM employees WHERE hire_date = '1998-01-01'; --how many employees hired on this date?

--count all employees hired on this date, group by their last name
--remember, group by smushse rows together based on equivalent columns
SELECT count(employee_id), l_name FROM employees WHERE hire_date = '1998-01-01' GROUP by l_name; 


--USER DEFINED FUNCTION----------------------------------

--Kind of arbitrary function, mostly wanted to show syntax
--Usually you'd put a bunch of specific complex logic in these
CREATE OR REPLACE FUNCTION kill_pete() RETURNS TABLE (
	f_name TEXT,
	l_name TEXT,
	hire_date date
)

AS '

	delete from employees where f_name = ''Pete'';
	select f_name, l_name, hire_date from employees;

' LANGUAGE SQL;
 --function has been created!!! But we need to actually call it now

DROP FUNCTION kill_pete(); --if "OR REPLACE" isn't strong enough

SELECT kill_pete(); --Pete has been vanished >:0


--PREPARED STATEMENTS---------------------------------------------------
--prepared statements feel like parameterized functions, a bit more power/flexibility

PREPARE create_employee AS 
INSERT INTO employees (f_name, l_name, hire_date, role_id)
			VALUES ($1, $2, $3, $4);
		
--to delete a prepared statement you use DEALLOCATE
DEALLOCATE create_employee;

--Let's use our prepared statement to bring Pete back to life and make another employee
--Very convenient!!! Now every time we want a new employee, we can just run statements like below
EXECUTE create_employee('Pete', 'Fishman', '1998-01-15', 2); 
EXECUTE create_employee('New', 'Guy', '1998-01-25', 3); 

SELECT * FROM employees; --pete lives!!!!!


