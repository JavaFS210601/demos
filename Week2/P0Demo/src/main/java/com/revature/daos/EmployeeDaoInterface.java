package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;

//Remember, Interfaces provide methods with no body (abstract methods) meant to be implemented in another class
//Basically just a good way to lay out the functionality we want to have
public interface EmployeeDaoInterface {

	public List<Employee> getEmployees(); //return a List of all employees
	
	public void addEmployee(Employee emp); //take a new Employee object, add it to the database
	
	public void changeRole(int empId, int roleId); //change an employee's role_id given their employee_id
	
	public void removeEmployee(int empId); //delete an employee
	
	public List<Employee> getEmployeesByRole(String role); //return a List of employees of a certain role
	
}
