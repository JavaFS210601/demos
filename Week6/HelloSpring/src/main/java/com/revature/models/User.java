package com.revature.models;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //generic stereotype annotation - this makes the class a bean!
@Scope("prototype")
public class User {

	private int id;
	private String name;
	
	//@Autowired //Autowiring beans using FIELD INJECTION (1 of the 3 types of dependency injection)
	//This method of dependency injection is considered bad practice because it skips encapsulation
	private Account account; //the User class has an Account field. Thus we can say Account is a dependency here


	
	
	//boiler plate code--------------------------------
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, Account account) {
		super();
		this.id = id;
		this.name = name;
		this.account = account;
	}

	public User(String name, Account account) {
		super();
		this.name = name;
		this.account = account;
	}

	//we're adding a new constructor for only Users, cause we need it for the Config class bean creation method
	@Autowired //Autowiring beans using CONSTRUCTOR INJECTION (1 of the 3 types of dependency injection)
	public User(Account account2) {
		this.account = account2;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", account=" + account + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(account, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(account, other.account) && id == other.id && Objects.equals(name, other.name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return account;
	}

	//@Autowired //Autowiring beans using SETTER INJECTION (1 of the 3 types of dependency injection)
	public void setAccount(Account account) {
		this.account = account;
	}
	
}
