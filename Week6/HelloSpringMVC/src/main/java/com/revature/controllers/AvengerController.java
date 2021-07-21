package com.revature.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.daos.AvengerDAO;
import com.revature.models.Avenger;

@RestController //This annotation does everything @Controller and @ResponseBody do. Convenient!
//@Controller //indicates that the class will handle HTTP requests from DispatcherServlet
//@ResponseBody //Adds @ResponseBody to every method, which will make them all return JSON
@CrossOrigin //This acts as a CORS filter, allows all requests in if given no attributes
@RequestMapping(value="/avengers") //so now all requests ending in /avengers will be directed here
public class AvengerController {

	private AvengerDAO dao; //this class has an AvengerDAO field (so it's a dependency!)

	@Autowired //We want a constructor with only the AvengerDAO so we can use constructor injection
	public AvengerController(AvengerDAO dao) {
		super();
		this.dao = dao;
	}
	
	@RequestMapping(method=RequestMethod.GET) //Ensures that and GET requests to /avengers uses this method
	//@ResponseBody //This will parse any Java object into JSON to send back as the response
	public List<Avenger> getAllAvenger() {
		return Arrays.asList(dao.getAll()); //we're returning the array that gets returned, but as a list
	}
	
	@GetMapping("/{id}") //GetMapping will specify that GET requests with this endpoint go here
	//@PathVariable allows you to get the path variable you specified in the mapping
	//Spring has an Class called ResponseEntity that lets us set things like the status code of our response
	public ResponseEntity<Avenger> getOneAvenger(@PathVariable("id") int id) {
		
		Avenger a = dao.getById(id);
		
		if(a==null) {
			//Returning a ResponseEntity with an empty body with a no content status code
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); //build is for when we send nothing back
		} 
		
		//If an Avenger is returned, sned it back in the body of the response, and 200 status code
		return ResponseEntity.status(HttpStatus.OK).body(a); //body is for when you send something back
		
	}
	
	@PutMapping //PutMapping will specify that PUT requests with this endpoint go here
												//@RequestBody turns the incoming JSON into Java
	public ResponseEntity<Avenger> updateAvenger(@RequestBody Avenger a){
		a = dao.update(a);
		if(a==null) {
			//If an invalid Avenger is sent, return a ResponseEntity with an empty body with a no content status code
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); //build is for when we send nothing back
		} 
		
		//If a valid Avenger is sent, send it back in the body of the response, and 200 status code
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(a); //body is for when you send something back
	}
	
	
	
}
