package com.revature.models;

import java.util.Objects;

import org.springframework.stereotype.Repository;

@Repository //All stereotype annotations make a class a bean... @Repository is usually for DAO classes though!
public class Account {

	private double balance;
	private String type;
	
	
	
	
	//boilerplate code----------------------------------------------
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Account(double balance, String type) {
		super();
		this.balance = balance;
		this.type = type;
	}


	@Override
	public String toString() {
		return "Account [balance=" + balance + ", type=" + type + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(balance, type);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Objects.equals(type, other.type);
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	
}
