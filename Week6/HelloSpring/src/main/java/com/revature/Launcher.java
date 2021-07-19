package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.config.Config;
import com.revature.models.User;

public class Launcher {

	public static void main(String[] args) {
		
		//Creating an Application Context Spring Container in order to use our Beans
		//All you need to know is that this longggg method takes our XML and makes an ApplicationContext (to store beans)
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
		
		
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
		
		System.out.println("=========================");
		
		//Recall bean scopes - Beans are singletons by default
		//If we made our User bean "prototype" scopes, this would return a different user from User u
		User u2 = (User) ac.getBean("user");
		System.out.println(u2);
		u2.setName("Chani");
		System.out.println(u2);
		System.out.println(u);
		
		//since we never set account to change off of singleton scope, every User still has the same Account
		
	}
	
}
