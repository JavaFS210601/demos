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

