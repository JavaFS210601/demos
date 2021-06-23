CREATE TABLE babies( 
	baby_id serial PRIMARY KEY,
	baby_name TEXT,
	baby_age int,
	bib_color text
);


CREATE TABLE bottles ( 
	bottle_id serial PRIMARY KEY,
	bottle_color TEXT,
	baby_id_fk int REFERENCES babies (baby_id) ON DELETE CASCADE --SORRY FORGOT WE DIDN'T SEE THIS YET :(
);


INSERT INTO babies (baby_name, baby_age, bib_color) 
			VALUES ('Charleston', 2, 'Magenta'),
				   ('Chadwick', 1.12, 'Burlywood'),
				   ('Smeefington', 1.5, 'Chartreuse');
				   
INSERT INTO bottles (bottle_color, baby_id_fk)
			VALUES ('Red', 1),
				   ('White', 3),
				   ('Blue', 2);
	
				  
SELECT * FROM babies;

SELECT * FROM bottles;

SELECT baby_age FROM babies;

SELECT * FROM babies ORDER BY baby_age DESC;
				  
SELECT * FROM babies WHERE baby_name = 'Chadwick';

UPDATE babies SET baby_age = 15 WHERE baby_id = 1;

SELECT * FROM babies; --just to show that my update was successful
				  
DELETE FROM babies WHERE baby_age = 15;	


--to show that the baby, and its bottle is gone (due to ON DELETE CASCADE)
SELECT * FROM babies;

SELECT * FROM bottles;
	  
				  
