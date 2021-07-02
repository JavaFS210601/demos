package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SuccessServlet extends HttpServlet {

	//This is bad practice... but I should show you that it's possible.
	//We're going to override service() directly (instead of the doGet/doPost methods)
	//So any request that comes in will be handled by this one method
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html"); //this will set the response to be HTML! (Since we're returning a success page)
		//In the future, we'll see how to set the response to be JSON
		//You'll be expected to use servlets to send and receive JSON in your P1
		
		PrintWriter pw = res.getWriter(); 
		//This res object will be forwarded. It'll have the request that was originall sent with the login
		
		pw.print("<h2> Welcome " + req.getParameter("userId") + "!"); //greet the user using the userId that was forwarded
		
		pw.print("<a href='https://purple.com'> Click here to go to purple.com</a>"); 
		//when clicked, it'll redirect the user to purple.com 
		//note how the href attribute works - you can send the user anywhere!!! 
		//Even make a new servlet for some logout functionality
		
	}
	
}
