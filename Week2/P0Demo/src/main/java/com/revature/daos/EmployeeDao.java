package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

public class EmployeeDao implements EmployeeDaoInterface {

	
	@Override
	public List<Employee> getEmployees() {
		
		try(Connection conn = ConnectionUtil.getConnection()){ //try to establish a DB connection, so we can run a query
			
			ResultSet rs = null; //initialize an empty ResultSet that will store the results of our query 
			
			String sql = "SELECT * FROM employees;"; //write the query, assign it to a String variable
			
			Statement s = conn.createStatement(); //creating an object to send the query to our DB
			
			rs = s.executeQuery(sql); //execute the query (sql) using our Statement object (s), put it in our ResultSet (rs) 
			
			
			List<Employee> employeeList = new ArrayList<>(); //create a List that will be populated with the returned employees
			
			
			while(rs.next()) { //while there are results left in the ResultSet (rs)
				
				//Create a new Employee Object from each returned record
				Employee employee = new Employee(
						rs.getInt("employee_id"),
						rs.getString("f_name"),
						rs.getString("l_name"),
						rs.getString("hire_date"),
						rs.getInt("role_id")
					);
				
				//add the newly created Employee object into the ArrayList of Employees
				employeeList.add(employee);

			}
			
			return employeeList; //Finally, if successful, return the List of Employees
			
		} catch (SQLException e) { //if something goes wrong accessing our data, it will get caught
			System.out.println("Something went wrong when trying to access your DB");
			e.printStackTrace();
		}
		
		
		return null; //java will yell if we don't have this, cause the try isn't guaranteed to succeed
	}

}
