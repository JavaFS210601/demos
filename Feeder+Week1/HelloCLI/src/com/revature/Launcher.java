package com.revature;

import com.revature.models.Menu;

//We're going to create a CLI (command line interface) application
//the user can enter inputs into a menu displayed onto the console, and make stuff happen
public class Launcher {

	public static void main(String[] args) {
		
		//Instantiate a Menu object
		Menu menu = new Menu();
		
		
		//use the Menu object's display() method to display a menu
		menu.display();
		
		//really clean main method! All the complicated logic will be abstracted away from us in different classes
		//power of abstraction! We only need to know what the display() method does, not how it does it..
		
	}
	
}
