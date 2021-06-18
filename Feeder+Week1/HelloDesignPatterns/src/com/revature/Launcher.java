package com.revature;

import com.revature.factory.Cookie;
import com.revature.factory.CookieFactory;
import com.revature.singleton.Singleton;

public class Launcher {

	public static void main(String[] args) {
		
		
		System.out.println("=========================================================(Using the Singleton");
		
		//creating 3 different instances of our Singleton Class
		Singleton x = Singleton.getInstance();
		Singleton y = Singleton.getInstance();
		Singleton z = Singleton.getInstance();
		
		
		//print the singletonMessage String field
		System.out.println("x: " + x.singletonMessage);
		System.out.println("y: " + y.singletonMessage);
		System.out.println("z: " + z.singletonMessage);
		
		//changing the singletonMessage variable of instance x
		x.singletonMessage = (x.singletonMessage).toUpperCase();
		
		
		//print the singletonMessage of each instance after changing instance x
		System.out.println("x: " + x.singletonMessage);
		System.out.println("y: " + y.singletonMessage);
		System.out.println("z: " + z.singletonMessage);
		
		
		//we see that changing the singletonMessage field of one instance changes it for all instances! wow!
		//what's the point of this?
		
		//This allows a global point of access to the Class.
		//Every instance of the Singleton will refer to the same Object. This allows for behavioral consistency!
		
		//We'll never make our own Singleton again... 
		//but there are lots of Java classes that implement this design pattern.
		
		System.out.println("=========================================================(Using the Factory");
		
		
		CookieFactory cf = new CookieFactory();
		
		//use the getCookie method of the CookieFactory to get new Objects of type Cookie
		
		Cookie cookie1 = cf.getCookie("SNICKERDOODLE");
		Cookie cookie2 = cf.getCookie("THINMINT");
		Cookie cookie3 = cf.getCookie("ROCKYROAD");
		
		//use the getBaked method of each new Cookie object, notice how they're all of their respective Cookie types
		cookie1.getBaked();
		cookie2.getBaked();
		cookie3.getBaked();
		
		//Thanks to the power of Abstraction (In this case our Factory)... Making cookie objects is way cleaner!
		//We hid ugly decision making code in the CookieFactory class, and can now just use the getCookie() method
		
	}
	
}
