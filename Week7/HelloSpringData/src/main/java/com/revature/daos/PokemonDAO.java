package com.revature.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Pokemon;

//JpaRepository takes 2 generics. The first is the entity that is being persisted
//The second is the data type of the primary key
public interface PokemonDAO extends JpaRepository<Pokemon, Integer> {

	
	
}
