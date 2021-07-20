package com.revature.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.daos.AvengerDAO;
import com.revature.models.Avenger;

@Controller //indicates that the class will handle HTTP requests from DispatcherServlet
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
	@ResponseBody //This will parse any Java object into JSON to send back as the response
	public List<Avenger> getAllAvenger() {
		return Arrays.asList(dao.getAll()); //we're returning the array that gets returned, but as a list
	}
	
	
	
}
