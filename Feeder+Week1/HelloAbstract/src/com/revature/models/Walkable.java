package com.revature.models;

public interface Walkable {

	//Interfaces fields are public, static, final by default
	String unitOfMeasurement = "miles";
	
	//abstract method - no method body! AKA not implemented
	void move(int distance);
	
	//default concrete method (which we won't usually use on Interfaces, might as well use an Abstract class)
	default void trip() {
		System.out.println("Oh no you fell! :(");
	}
	
}
