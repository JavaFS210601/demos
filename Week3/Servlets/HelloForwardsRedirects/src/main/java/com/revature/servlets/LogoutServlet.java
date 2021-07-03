package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {
	
	//we'll use a redirect here instead of a forward	
	
	//btw, what's IOException?
	//IOException happens when there is a failure during reading, writing, and searching file or directory operations
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.sendRedirect(""); //here, we redirect to the homepage with ""
												//aka the base URL.
												//But you could really put any URL!
		
		//don't forget, all servlets must be declared and mapped in the web.xml.
	}

}
