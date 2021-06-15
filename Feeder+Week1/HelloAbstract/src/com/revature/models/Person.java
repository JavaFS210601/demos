package com.revature.models;

//This is an abstract class (notice the abstract keyword). 
//It also implements our two interfaces (Hence inheriting their functionality).
public abstract class Person implements Walkable, Sprintable {

	public String name;
	public int age;
	
	
	//concrete method
	public void juggle() {
		System.out.println(name + " is jugglin'");
	}
	
	//abstract method
	public abstract void jump(int inches); 
	
	
	//This abstract class also has access to the abstract move() method in Walkable
	//But since it's an Abstract class, Java won't yell at me for leaving it abstract
	
	
	//Let's explore the problems that can arise when we have duplicate methods
	
	//Java will force you to specify which trip() method to Override
	//since they're identical in the two interfaces we're implementing.
	
	@Override
	public void trip() {
		// TODO Auto-generated method stub
		Sprintable.super.trip();
	}
	

	
	
	
	
	
	
	//constructors below---------------------------------------------------------------
	
	//alt + shift + s to bring up auto generation options - in this case we built our constructors with it
	
	//no args constructor (constructor from super class)
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all args constructor
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	} 
	
	
	
	
	
}
