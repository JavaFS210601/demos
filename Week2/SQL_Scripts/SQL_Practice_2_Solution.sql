--My solutions to the business case

--(There is no specific correct answer, but there ARE ways to do it wrong)


create table managers (
	manager_id serial primary key,
	f_name text,
	l_name text,
	salary int
);


create table robots (
	robot_id serial primary key,
	name text,
	color text,
	manager_id_fk int references managers (manager_id) UNIQUE --this establishes our 1-1 relationship
);

create table employees (
	employee_id serial primary key,
	f_name text,
	l_name text,
	salary int,
	manager_id_fk int references managers(manager_id) --this is our 1-to-many relationship
);

create table projects (
	project_id serial primary key,
	project_name text,
	start_date date 
);

--this join table represents our many-to-many relationship between employees and projects
create table project_assignments (
	project_assignment_id serial primary key,
	employee_id_fk int references employees(employee_id),
	project_id_fk int references projects(project_id)
);


alter table employees add age int;


insert into managers (f_name, l_name, salary) 
			values ('Bob', 'Ross', 100000),
				   ('Rob', 'Boss', 80000);


insert into robots (name, color, manager_id_fk)
			values ('coolbot', 'fuschia', 1),
				   ('funkybot', 'vermilion', 2);

insert into robots (name, color, manager_id_fk)
			values ('coolerbot', 'grey', 2); --this won't work, the manager_id_fk has unique constraint!
											 --for the sake of 1-to-1 functionality

		
insert into employees (f_name, l_name, salary, age, manager_id_fk)
			values ('Ben', 'Petruzziello', 30000, 22, 1),
				   ('Bon', 'Potruzziello', 40000, 23, 1);
				  
insert into projects (project_name, start_date)	
			values ('automatic cereal bowl', '1990-05-09'),
				   ('manual cereal bowl', '1992-06-14');
				  
insert into project_assignments (employee_id_fk, project_id_fk)	
			values (1,1),
				   (2,1);
				  
	  
				  
select * from managers order by salary asc; 


update managers set salary = salary/2 where salary = 100000;


--the bonus queries:

select avg(salary) from employees; --avg function


select f_name ||' is age '|| age as "Age Info" from employees; --concatenation with alias
