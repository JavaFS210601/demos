package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Flashcard;
import com.revature.repositories.FlashcardRepository;

@RestController
@RequestMapping("flashcard")
public class FlashcardController {
	
	@Autowired
	private FlashcardRepository flashcardDao;
	
	@Autowired
	private Environment env; //Environment object - Represents the environment we're in... lets us get things like the port we're in!

	@GetMapping
	public ResponseEntity<List<Flashcard>> findAll() {
		List<Flashcard> all = flashcardDao.findAll();
		
		return ResponseEntity.ok(all);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Flashcard> findById(@PathVariable("id") int id) {
		Optional<Flashcard> optional = flashcardDao.findById(id);
		
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Flashcard> insert(@RequestBody Flashcard flashcard) {
		int id = flashcard.getId();
		
		if(id != 0) {
			return ResponseEntity.badRequest().build();
		}
		
		flashcardDao.save(flashcard);
		return ResponseEntity.status(201).body(flashcard);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Flashcard> delete(@PathVariable("id") int id) {
		Optional<Flashcard> option = flashcardDao.findById(id);

		if(option.isPresent()) {
			flashcardDao.delete(option.get());
			return ResponseEntity.accepted().body(option.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/port")
	public String getPort() {
		
		String serverPort = env.getProperty("local.server.port");
		
		return "Hello, I'm coming from port: " + serverPort;
		
	}
	
	
}
