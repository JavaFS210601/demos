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
			System.out.println("add -> add a new employee ");
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
				
				//Print out each Employee from the List one by one for the user see
				for(Employee e : employees) {
					System.out.println(e);
				}
				
				break;
			}
			
			case "add": {
				
				//we need to prompt the user for the employee's name, and their role id
				//we'll have to come up with some functionality to get the current date for the hire_date field
				System.out.println("Enter Employee First Name:");
				String f_name = scan.nextLine();
				
				System.out.println("Enter Employee Last Name:");
				String l_name = scan.nextLine();
				
				System.out.println("Enter Role Id: 1)Manager 2)Fry Cook 3)Cashier 4)Marketing 5)Nepotism");
				int roleId = scan.nextInt();
				scan.nextLine(); //because without any nextLine, your enter keystroke will be grabbed as the next input
				
				//Given all this information, we'll create a new Employee object to send to a DAO method
				//This is using the all-args minus employee_id constructor
				Employee newEmployee = new Employee(f_name, l_name, "xxx", roleId); //placeholder for hire_date, will be changed
				
				//Put the new Employee into the addEmployee() method in the EmployeeDao
				ed.addEmployee(newEmployee);
				
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
