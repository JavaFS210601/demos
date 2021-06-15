package com.revature;

import com.revature.models.Associate;
import com.revature.models.Person;

public class Launcher {

	public static void main(String[] args) {
		
		//BTW, we can auto import things with ctrl + shift + o
		
		//Instantiate a Associate object
		//This is an example of UPCASTING! Which is considered good practice
		//This gives us access to the members of the Person class,
		//But it hides members of the Associate class (only Overridden methods are visible)
		Person ryan = new Associate("111111", "Ryan", 22);

		ryan.juggle();
		
		ryan.jump(700);
		
		ryan.move(500);
		
		//ryan.batchId; Java doesn't recognize the field of the Associate class because we upcasted 
		
		//Notice how this trip functionality is the trip functionality found ALL the way in the Sprintable Interface
		//The associate class never mentions it, but it extends Person, which implements Sprintable
		//Inheritance is super powerful!
		ryan.trip();
		
	}

}
