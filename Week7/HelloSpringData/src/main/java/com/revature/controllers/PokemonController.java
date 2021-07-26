package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
}
