package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//get the user inputs from the HTML form, and turn them into Java variables
		String username = req.getParameter("userId"); 
		String password = req.getParameter("password");
		
		//setting up some objects to do a forward
		RequestDispatcher rd = null;
		PrintWriter pw = res.getWriter(); //create a PrintWriter object so that we can write things to our page
		
		//normally, checking the user credentials against a Database would be done in the "service layer".
		//but for now, we're just going to hardcode a username and password to check the user login.
		if(username.equals("username") && password.equals("wasspord")) { 
			rd = req.getRequestDispatcher("success"); //if the username/password are good, initialize our RequestDispatcher
			//this "success" parameter is going to be appended to the end of our base URL - to go to SuccessServlet
			//The SuccessServlet will be the servlet to forward to upon successful login
			rd.forward(req, res); //we forward the request and response objects to another servlet 
		} else {
			rd = req.getRequestDispatcher("index.html"); //if login fails, don't forward, resend the index.html
			rd.include(req, res); //"this is the request you sent me, this is the page I want to display as a result"
			pw.print("<p style='color:red'>LOGIN FAILED!</p>"); 
			//using PrintWriter.print() method to populate HTML in our index.html
		}
		
		
	}
	
}
