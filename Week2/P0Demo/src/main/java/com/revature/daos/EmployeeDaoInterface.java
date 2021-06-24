package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;

//Remember, Interfaces provide methods with no body (abstract methods) meant to be implemented in another class
//Basically juts a good way to lay out the functionality we want to have
public interface EmployeeDaoInterface {

	public List<Employee> getEmployees(); //return a List of all employees
	
	public void addEmployee(Employee emp);
	
}
