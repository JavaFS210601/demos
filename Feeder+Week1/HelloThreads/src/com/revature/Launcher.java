package com.revature;

public class Launcher {

	public static void main(String[] args) {
		
		CoolThread ct1 = new CoolThread();
		ct1.setPriority(1); //Priority is a value between 1-10
							//The higher the number the more priority
		
		CoolThread ct2 = new CoolThread();
		ct2.setPriority(2);
		
		//These don't actually create new threads since we never used the start() method
		//Hence "main is working"
		
//		ct1.run();
//		ct2.run();
		
		ct2.start();
		ct1.start();
		
		CoolThread ct3 = new CoolThread();
		ct3.setPriority(8);
		
		ct3.start();
		
		//Thread priority helps suggest priority, but it's not a strict configuration. 
		
	}
	
}
