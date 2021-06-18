package com.revature.factory;

//Factories make it a lot easier to create objects and hide the object-creation code away

public class CookieFactory {

	//create a getCookie method to get an object of type Cookie (which is anything that implements the Cookie interface)
	public Cookie getCookie(String cookieType) {
		
		//user input an argument to tell the method what kind of Cookie they want to make
		
		//the method takes that arguments and throws it into the creation logic below
		
		//control flow to determine what kind of Cookie to make (again, this is creation logic)
		if(cookieType == "SNICKERDOODLE") {
			return new Snickerdoodle();
		} else if (cookieType == "ROCKYROAD") {
			return new RockyRoad();
		} else if (cookieType == "THINMINT") {
			return new ThinMints();
		} else {
			return null; //in case the cookieType argument doesn't match any of the if/else if statements
		}
	
		
	}
	
	
}
