package com.revature.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.revature.models.Account;
import com.revature.models.User;

//this is how we declare and wire beans using a JAVA CONFIG class (also not preferable to Annotation driven)!!

//@Configuration //we need this annotation to specify that this Class configures beans
//@ComponentScan("com.revature") //one other way to do annotation driven autowiring - scans com.revature for annotations
public class Config {
	
//	@Bean(name = "user")
//	@Scope("prototype")
//	public User getUser() {
//		return new User(getAccount()); //this is how we autowire in the Config class.
//	}
//	
//	@Bean(name = "account")
//	public Account getAccount() {
//		return new Account();
//	}
	
}
