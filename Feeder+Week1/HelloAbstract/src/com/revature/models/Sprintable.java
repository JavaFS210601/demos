package com.revature.models;

public interface Sprintable {

	//abstract method - no method body! AKA not implemented
	void move(int distance);
	
	//default concrete method 
	default void trip() {
		System.out.println("Oh no you fell REAL HARD! :O");
	}
	
}
