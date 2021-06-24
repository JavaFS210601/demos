package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.models.Menu;
import com.revature.utils.ConnectionUtil;

public class Launcher {

	public static void main(String[] args) {
		
		//here we're just testing whether our connection (from the ConnectionUtil Class) is successful
		try(Connection conn = ConnectionUtil.getConnection()) {
			System.out.println("connection successful");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		
		//Instantiate a Menu object so we can use the display() method
		Menu menu = new Menu();
		
		//run the display method, delivering the user's options
		menu.display();
		
		
	}

}