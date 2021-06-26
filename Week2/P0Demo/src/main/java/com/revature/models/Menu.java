package com.revature.models;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.EmployeeDao;

public class Menu {
	
	EmployeeDao ed = new EmployeeDao();
	
	//All of the menu display options and control flow are contained in this method
	public void display() {
		
		boolean displayMenu = true; //this toggles whether the menu continues after user input
		Scanner scan = new Scanner(System.in); //Scanner object to parse user input		
		final Logger log = LogManager.getLogger(Menu.class);
		
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
			System.out.println("changerole -> change an employee's role");
			System.out.println("fire -> fire an employee");
			System.out.println("exit -> exit the application");
			
			
			//parse the user input after they choose a menu option, and move to the next line
			String input = scan.nextLine().toLowerCase();
			
			
			//switch statement that takes the user input, and does some logic depending on that input
			switch(input) {
			
			case "employees": {
				log.info("User select all employees");
				System.out.println("Gathering all employees...");

				//List of Employees that gets populated by the getEmployees method in our EmployeeDao
				List<Employee> employees = ed.getEmployees(); 
				
				//Print out each Employee from the List one by one for the user to see
				for(Employee e : employees) {
					//a prettier way to return all employees (instead of relying on the toString method, seen in the other cases)
					//making use of a getter and String concatenation
					System.out.println(e.getEmployee_id() + ") " + e.getF_name() + " " + e.getL_name() + ", Hired on " + e.getHire_date());
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
				Employee newEmployee = new Employee(f_name, l_name, "placeholder", roleId); //placeholder for hire_date, will be changed
				
				//Put the new Employee into the addEmployee() method in the EmployeeDao
				ed.addEmployee(newEmployee);
				
				break;
			}
			
			case "changerole" : {
				
				System.out.println("These are the employees on the roster: ");
				
				//this is using the already existing getEmployees() method
				List<Employee> employees = ed.getEmployees(); 
				
				//Print out each Employee from the List one by one for the user to see
				for(Employee e : employees) {
					System.out.println(e);
				}
				
				System.out.println("----------------------------------------------------");
				
				System.out.println("Enter the ID of the employee who's role is changing:");
				int idInput = scan.nextInt(); //the user enters the ID of the employee to change the role of
				scan.nextLine();
				
				System.out.println("Enter the new Role ID: 1)Manager 2)Fry Cook 3)Cashier 4)Marketing 5)Nepotism");
				int roleInput = scan.nextInt();
				scan.nextLine();
				
				ed.changeRole(idInput, roleInput); //we're going to supply the user inputs as arguments to this DAO method
				
				break;
			}
			
			case "fire": {
				
				System.out.println("These are the employees on the roster... who will you fire?");
				
				//this is using the already existing getEmployees() method
				List<Employee> employees = ed.getEmployees(); 
				
				//Print out each Employee from the List one by one for the user to see
				for(Employee e : employees) {
					System.out.println(e);
				}
				
				System.out.println("------------------------------");
				
				System.out.println("Enter the employee id of the employee to fire:");
				
				int idInput = scan.nextInt();
				scan.nextLine();
				
				//example of some foolproofing, in this case we don't want employees with id = 1 (aka managers) 
				if(idInput == 1) {
					System.out.println("can't fire managers!!!");
					log.warn("User attempted to delete manager");
				} else {
					ed.removeEmployee(idInput);		
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
