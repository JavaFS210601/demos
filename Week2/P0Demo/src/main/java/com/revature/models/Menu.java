package com.revature.models;

import java.util.List;
import java.util.Scanner;

import com.revature.daos.EmployeeDao;

public class Menu {
	
	EmployeeDao ed = new EmployeeDao();
	
	//All of the menu display options and control flow are contained in this method
	public void display() {
		
		
		boolean displayMenu = true; //this toggles whether the menu continues after user input
		Scanner scan = new Scanner(System.in); //Scanner object to parse user input
		
		
		//greeting
		System.out.println("*====================================================*");
		System.out.println("Welcome to the Krusty Krab Employee Management System");
		System.out.println("*====================================================*");
		
		
		//display the menu options as long as displayMenu is true
		while(displayMenu) {
			
			System.out.println("----------------");
			System.out.println("CHOOSE AN OPTION");
			System.out.println("----------------");
			
			
			//menu options
			System.out.println("employees -> show all employees");
			System.out.println("TBD -> ");
			System.out.println("TBD -> ");
			System.out.println("TBD -> ");
			System.out.println("exit -> exit the application");
			
			
			//parse the user input after they choose a menu option, and move to the next line
			String input = scan.nextLine().toLowerCase();
			
			
			//switch statement that takes the user input, and does some logic depending on that input
			switch(input) {
			
			case "employees": {
				System.out.println("Gathering all employees...");

				//List of Employees that gets populated by the getEmployees method in our EmployeeDao
				List<Employee> employees = ed.getEmployees(); 
				
				for(Employee e : employees) {
					System.out.println(e);
				}
				
				break;
			}
			
			case "exit": {
				System.out.println("byeeee");
				displayMenu = false;
				break;
			}
			
			default: {
				System.out.println("Didn't catch that... try again"); //in case user input doesn't match any cases
				break;
			}
			
			
			
			}
			
		}
		
		
	}
	
	
}
