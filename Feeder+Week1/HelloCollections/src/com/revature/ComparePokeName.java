package com.revature;

import java.util.Comparator;

import com.revature.models.Pokemon;

//We need to specify that it's a Comparator for Pokemon Objects!!!
//Otherwise it'll just compare the plain old Object type
public class ComparePokeName implements Comparator<Pokemon> { 

	//@Override
	public int compare(Pokemon p1, Pokemon p2) {
		System.out.println("The compare method is running for " + p1.getName() + " and " + p2.getName());

		//I want to sort the Pokemon by alphabetical order
		return p1.getName().compareTo(p2.getName());
	}

	
	
}
