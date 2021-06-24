package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

	@Override
	public void addEmployee(Employee emp) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			//This is the way I want to get the current date in the appropriate format
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //date formatter formats dates 
			
			Date date = new Date(); //new date from java.util package
			
			String currentDate = dateFormat.format(date); //make a String that represents today's date in the format we want (line 69)
			
			//we're going to create a SQL statement using parameters to insert a new Employee
			String sql = "INSERT INTO employees (f_name, l_name, hire_date, role_id)"
					+ "VALUES (?, ?, ?, ?);"; //these are parameters!!! We have to now specify the value of each "?"
			
			
			PreparedStatement ps = conn.prepareStatement(sql); //we use PreparedStatements for SQL commands with parameters
			
			//use the PreparedStatement object to insert values into the SQL query
			//the values will come from the Employee object we sent in
			//this requires two arguments, the number of the "?", and the value to give it
			ps.setString(1, emp.getF_name());
			ps.setString(2, emp.getL_name() );
			ps.setDate(3, java.sql.Date.valueOf(currentDate)); //this takes our Java Date, and turns it into a SQL Date.
			ps.setInt(4, emp.getRole_id());
			
			//this method actually executes the SQL command that we built
			ps.executeUpdate(); //we use executeUpdate for inserts, updates, and deletes. 
			
			//send confirmation to the console if successful
			System.out.println("Employee " + emp.getF_name() + " created. Welcome Aboard!");
			
		} catch(SQLException e) {
			System.out.println("Add employee failed!");
			e.printStackTrace();
		}
		
	}



}
