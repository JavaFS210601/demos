package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	//note the method signature of the following doGet/Post methods. They will ALWAYS be the same
	//you'll be expected to know this method signature ;)
	
	
	//overriding the doGet method
	//this is the method that will execute if our HelloServlet receives a GET request
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw = res.getWriter(); //this is how we write to our Response Object
		
		pw.print("<h1>Hello from your doGet method</h1>"); //use the PrintWriter to write some HTML
		
		res.setStatus(200); //successful status code - optional, but good to show it working in postman/in general
		
	}
	
	//Now we have our first servlet!! 
	//We now have to map the servlet in the web.xml so that tomcat can acknowledge its existence 
	
	
	//overriding the doPost method
	//this is the method that will execute if our HelloServlet receives a POST request
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw = res.getWriter(); //this is how we write to our Response Object
		
		pw.print("<h1>Hello from your doPost method</h1>"); //use the PrintWriter to write some HTML
		
		res.setStatus(200); //successful status code - optional, but good to show it working in postman/in general
		
	}
	
	
}
