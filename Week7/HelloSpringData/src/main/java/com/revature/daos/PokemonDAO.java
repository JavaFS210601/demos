package com.revature.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Pokemon;

//JpaRepository takes 2 generics. The first is the entity that is being persisted
//The second is the data type of the primary key
public interface PokemonDAO extends JpaRepository<Pokemon, Integer> {

	//I want a method that finds Pokemon by name, but that doesn't exist in JpaRepository... 
	//Gotta define a method signature here! 
	
	//An Optional is an object that MAY have whatever the generic is, or it may be null. Avoids NullPointerExceptions!
	public Optional<List<Pokemon>> findByName(String name); //for this method to work, the name must include the field name in camel case
	
	//We had to define this method signature on our own...
	//BUT Spring Data will create this method body for us!
	
	
	//will explore if this works...
	//public Optional<List<Pokemon>> findByNameType(String name, String type);
	
}
