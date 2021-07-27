package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.daos.PokemonDAO;
import com.revature.models.Pokemon;

@RestController
@RequestMapping(value="/pokemon")
public class PokemonController {

	private PokemonDAO pDAO; //need an instance of PokemonDAO to use its methods.

	
	//Using constructor injection to inject the PokemonDAO
	@Autowired
	public PokemonController(PokemonDAO pDAO) {
		super();
		this.pDAO = pDAO;
	}
	
	
	//This method will return a list of all our Pokemon. No need for us to write a dao method :)
	@GetMapping
	public ResponseEntity<List<Pokemon>> getAllPokemon() {
		return ResponseEntity.status(200).body(pDAO.findAll());
	}
	
	//This method will take an endpoint after /pokemon and look for any Pokemon with a name matching that endpoint
	@GetMapping("/{name}")//the value of the URL endpoint will be the parameter in this method - hence @PathVariable
	public ResponseEntity<List<Pokemon>> findByName(@PathVariable String name){
		
		//Remember, Optional is an object that MAY have whatever the generic is, or it may be null. Avoids NullPointerException
		Optional<List<Pokemon>> opt = pDAO.findByName(name); //populate a List of Pokemon from the DAO method
		
		List<Pokemon> pokeList = null; //instantiate an empty List of Pokemon, to get filled if data is successfully returned.
		
		//control flow based on the value of our Optional "opt" variable
		if(opt.isPresent()) { //if my optional exists...
			pokeList = opt.get(); //get the contents of the Optional object and put it into our pokeList
		}
		
		return ResponseEntity.status(200).body(pokeList); //the contents of pokeList will be sent as JSON (thanks to @RestController)
		
	}
	
	
	@PostMapping
	public ResponseEntity addPokemon(@RequestBody Pokemon p) { //The body of the Post Request is JSON, @ResponseBody will make it a POJO
		pDAO.save(p);
		return ResponseEntity.status(201).build(); //.build() because we don't care to return any data (contrary to .body())
		//201 = created - your resource was successfully created/persisted
	}
	
	
}
