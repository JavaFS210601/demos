package com.revature.singleton;

//Using a singleton makes it so that only one instance of the Class can ever exist
//This ensures that all objects of the Class will be exactly the same

//A big difference between a normal Class and a Singleton Class is....
//To instantiate normal classes, we use the constructor
//TO instantiate Singletons, we use the getInstance() method

public class Singleton {

	//static variable of type Singleton that will get returned by the getInstance() method
	private static Singleton singleton = null;
	
	//for clarity, we'll have a String to help us demonstrate that there can only be one instance of this Class.
	public String singletonMessage;
	

	//public static method to create a SINGLE instance of our Singleton Class
	public static Singleton getInstance() {
		
		if(singleton == null) { //if there is no current instance of the Singleton Class
			singleton = new Singleton(); //we can instantiate a new one
		}
		return singleton; //if there IS already an instance of Singleton, return that same Singleton instance
	}
	//In this way, we make it impossible to create a different instance for this Class.
	
	
	//private constructor (so only the Singleton Class can see it)
	private Singleton() {
		super();
		singletonMessage = "I'm the only possible instance of this Singleton Class";
	}
	
	
}
