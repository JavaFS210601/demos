package com.revature.models;

//Associate extends the Person abstract class. 
//Think of it like a more specific implementation of the generic abstract class
public class Associate extends Person {

	public String batchId;
	
	
	@Override //The @Override annotation implies to the JVM that you're changing the functionality of a method
	public void move(int distance) {
		System.out.println(name + " moved " + distance + " " + unitOfMeasurement);
	}
	

	@Override
	public void jump(int inches) {
		System.out.println(name + " jumped " + inches + " inches!");
	}	
	
	
	public Associate(String batchId, String name, int age) {
		super(name, age); //this will call the all args constructor of the Person abstract class
		this.batchId = batchId;
	}








	
	
	
	
}
