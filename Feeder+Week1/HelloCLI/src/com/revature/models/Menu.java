package com.revature.models;

import java.util.Scanner;

import com.revature.daos.LegoCollection;

public class Menu {

	//Instantiate a LegoCollection object, so that we can use its methods.
	//We'll call different LegoCollection methods depending on what menu option the user chooses
	LegoCollection lc = new LegoCollection();
	
	
	//All of the menu display options and control flow are contained in this method
	//We'll call different methods that access our mock database depending on what option the user choose
	public void display() {
		
		boolean displayMenu = true; //this will toggle whether the menu options continue to display to the user 
		Scanner scan = new Scanner(System.in); //a Scanner object to parse user input
		
		//let's actually start construction the menu-----------
		
		//greet the user
		System.out.println("Welcome to your Lego Collection Management Application!");
		System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
		
		
		//display the menu options as long as displayMenu is true
		while(displayMenu) {
			
			System.out.println("----------------");
			System.out.println("CHOOSE AN OPTION");
			System.out.println("----------------");
			
			
			//menu options (the thing the user can say -> the action it causes)
			System.out.println("hi -> get greeted");
			System.out.println("getAllLegos -> show every LegoSet in the database");
			System.out.println("LegoSetById -> get a LegoSet by its Id");
			
			
			//parse the user input after they ponder the menu options
			//.toLowerCase so the user doesn't have to worry about case-sensitivity
			String input = scan.nextLine().toLowerCase();
			
		
			//switch statement that will take the value of the user input, and execute the appropriate functionality
			//this is long ugly functionality... Better here than in the main method!
			switch(input) {
			
			case "hi": {
				System.out.println("Um... Hello?");
				break;
			}
			
			case "getalllegos": {
				LegoSet[] legoArray = lc.getAllLegoSets(); //get all LegoSets
				
				for(LegoSet legos : legoArray) { //for every LegoSet we get in the Array...
					System.out.println(legos); //print it out 
				}
				break;
			}
			
			case "legosetbyid": {
				System.out.println("Enter a LegoSet id to search for");
				int idInput = scan.nextInt(); //get the user's input for LegoSet Id
				scan.nextLine(); //we have to use .nextLine, since nextInt doesn't do it for us :/
				
				LegoSet legoSet = lc.getLegoSetById(idInput); //find a LegoSet by id
				System.out.println(legoSet); //print that LegoSet out to the user
				break;
			}
			
			
			
			
			
			}
			
			
		}
		
		
	}
	
}
