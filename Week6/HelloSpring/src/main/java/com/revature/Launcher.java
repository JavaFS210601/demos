package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.models.User;

public class Launcher {

	public static void main(String[] args) {
		
		//Creating an Application Context Spring Container in order to use our Beans
		//All you need to know is that this longggg method takes our XML and makes an ApplicationContext (to store beans)
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//so now that we have a Spring Container that is storing our User and Account beans, we can make some! 
		
		//in the getBean() method, we give the name of the bean that we want to create
		//A cast is required because the ApplicationContext isn't sure what kind of object will be returned
		//Why? Because getBean returns a generic object, you have to specify what kind of object you want
		User u = (User) ac.getBean("user");
		
		//Let's look at what this Bean looks like!
		System.out.println(u);
		//Notice that we used getBean() to get a User object that we created
		//But nowhere did I create and Account object to attach to it!
			//Magic of autowiring!
		
		//Let's assign some values to our User bean
		u.setId(1);
		u.setName("Noah");
		u.getAccount().setBalance(500000);
		u.getAccount().setType("Savings");
		
		System.out.println(u); //we now have a User object with an Account object, all fully initialized with values
		
	}
	
}
