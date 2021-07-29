package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.models.Flashcard;
import com.revature.models.Quiz;
import com.revature.repositories.QuizRepository;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizRepository quizDao;
	
	//RestTemplate (talked about last week) is used in Spring MVC to receive JSON from an external API (in this case, Flashcard_Service)
	//In this way, OUR MICROSERVICES CAN COMMUNICATE WITH EACH OTHER!!
	@Bean //@Bean is NOT a stereotype annotation! It simply specifies that this method will return a bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	//^^now, we have a RestTemplate that we can use to send/recieve HTTP requests.
	
	@GetMapping
	public ResponseEntity<List<Quiz>> findAll() {
		List<Quiz> all = quizDao.findAll();
		
		if(all.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(all);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Quiz> findById(@PathVariable("id") int id) {
		Optional<Quiz> optional = quizDao.findById(id);
		
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Quiz> insert(@RequestBody Quiz quiz) {
		int id = quiz.getId();
		
		if(id != 0) {
			return ResponseEntity.badRequest().build();
		}
		
		quizDao.save(quiz);
		return ResponseEntity.status(201).body(quiz);
	}
	
	@GetMapping("/cards")
	public ResponseEntity<List<Flashcard>> getCards() {
		
		//we need to make a request to the Gateway_Service , sending in the URL that reaches the FlashcardController
		List<Flashcard> all = this.restTemplate.getForObject("http://localhost:8092/flashcard", List.class);
		
		//What are we doing on line 78? sending a GET request to our gateway service, which send a request to get all flashcards
		
		//More in-detail explanation: (pre-gateway service)
		//We're using our RestTemplate object to make an HTTP GET request to the flashcard service method which takes /flashcard
		//Then we take the results of that HTTP GET request, and put them into a List of flashcards.
		//JSON -> Java parsing happens under our nose thanks to the @RestController annotation above the Class declaration
		
		if(all.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(all);
	}
}
