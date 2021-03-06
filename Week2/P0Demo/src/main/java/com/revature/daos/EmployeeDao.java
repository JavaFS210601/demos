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
	public List<Employee> getEmployees() { //this is SELECT functionality
		
		try(Connection conn = ConnectionUtil.getConnection()){ //try to establish a DB connection, so we can run a query
			
			//initialize an empty ResultSet that will store the results of our query 
			ResultSet rs = null; //we need this for select statements, so that the returned data can get stored
			
			//write the query, assign it to a String variable
			String sql = "SELECT * FROM Krusty_Krab.employees;";
			
			//creating an object to send the query to our DB using our Connection object's createStatement() method
			Statement s = conn.createStatement(); 
			
			//execute the query (sql) using our Statement object (s), put it in our ResultSet (rs) 
			rs = s.executeQuery(sql); //again, the ResultSet just holds all the data we get back from the select statement
			
			
			List<Employee> employeeList = new ArrayList<>(); //create a List that will be populated with the returned employees
			
			
			while(rs.next()) { //while there are results left in the ResultSet (rs)
				
				//Create a new Employee Object from each returned record
				//This is the Employee Class's all args constructor
				//And we're filling it with each column of the Employee record
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
	public void addEmployee(Employee emp) { //This is INSERT functionality (with complicated date functionality if you dare...)
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			//This is the way I want to get the current date in the appropriate format
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //date formatter formats dates 
			
			Date date = new Date(); //new date from java.util package
			
			String currentDate = dateFormat.format(date); //make a String that represents today's date in the format we want (line 69)
			
			//we're going to create a SQL statement using parameters to insert a new Employee
			String sql = "INSERT INTO employees (f_name, l_name, hire_date, role_id) " //creating a line break for readability
					+ "VALUES (?, ?, ?, ?);"; //these are parameters!!! We have to now specify the value of each "?"
			
			
			PreparedStatement ps = conn.prepareStatement(sql); //we use PreparedStatements for SQL commands with parameters
			
			//use the PreparedStatement object's methods to insert values into the SQL query's ?s
			//the values will come from the Employee object we sent in
			//this requires two arguments, the number of the "?", and the value to give it
			ps.setString(1, emp.getF_name());
			ps.setString(2, emp.getL_name());
			ps.setDate(3, java.sql.Date.valueOf(currentDate)); //this takes our Java Date, and turns it into a SQL Date.
			ps.setInt(4, emp.getRole_id());
			
			//this method actually sends and executes the SQL command that we built
			ps.executeUpdate(); //we use executeUpdate for inserts, updates, and deletes. 
			
			//send confirmation to the console if successful
			System.out.println("Employee " + emp.getF_name() + " created. Welcome Aboard!");
			
		} catch(SQLException e) {
			System.out.println("Add employee failed!");
			e.printStackTrace();
		}
		
	}

	@Override
	public void changeRole(int empId, int roleId) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			//notice how there are no ResultSet object in methods that don't include select statements...
			//because we aren't returning anything! Only changing stuff in the DB, not getting data from it.
			
			String sql = "UPDATE employees SET role_id = ? WHERE employee_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql); //make a PreparedStatement using the SQL String we made 
			
			//adding values to the wildcard parameters based on the user's input
			ps.setInt(1, roleId);
			ps.setInt(2, empId);
			
			ps.executeUpdate(); //Run the PreparedStatement now that we've given values to its parameters
			
			System.out.println("Employee role_id changed to: " + roleId);
			
		} catch (SQLException e) {
			System.out.println("Change role failed!");
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeEmployee(int empId) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "DELETE FROM employees WHERE employee_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, empId);
			
			ps.executeUpdate();
			
			System.out.println("GEt out of here employee #" + empId);
			
		} catch (SQLException e) {
			System.out.println("Delete employee failed!");
			e.printStackTrace();
		}
		
	}

		//Bit more complicated query, takes a parameter in order to have a more flexible menu option
		@Override
		public List<Employee> getEmployeesByRole(String title) {

			try(Connection conn = ConnectionUtil.getConnection()){
				ResultSet rs = null;
				
				String sql = "select * from employees join roles "
						+ "on employees.role_id = roles.role_id where roles.role_title = ?;";

				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, title); //insert the method's argument as the first (and only) variable in the query
				
				rs = ps.executeQuery();	
				
				List<Employee> employeeList = new ArrayList<>();
				
				while(rs.next()) { //while there are results in the result set...
					
					Employee e = new Employee( //create a new Employee Object from each returned row..
							rs.getInt("employee_id"),
							rs.getString("f_name"),
							rs.getString("l_name"),
							rs.getString("hire_date"),
							rs.getInt("role_id")
							);
					
					employeeList.add(e); //and populate the ArrayList with each created Role Object
				}
				
				return employeeList; //Finally, return the populated List of Roles.
				
				
				
			} catch (SQLException e) {
				System.out.println("Something went wrong with your SQL!");
				e.printStackTrace();
			}
			
			return null;
		}

	
	
}
