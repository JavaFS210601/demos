package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

public class RoleDao implements RoleDaoInterface {

	@Override
	public List<Role> getRoleByTitle(String title) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			//initialize an empty ResultSet that will store the results of our query 
			ResultSet rs = null; //we need this for select statements, so that the returned data can get stored
			
			//write the query, assign it to a String variable
			String sql = "SELECT * FROM roles where role_title = ?;"; 
			
			//creating an object to send the query to our DB using our Connection object's createStatement() method
			PreparedStatement ps = conn.prepareStatement(sql); 
			
			//set the wildcard to the title the user inputs
			ps.setString(1, title);
			
			//execute the query (sql) using our PreparedStatement object (ps), put it in our ResultSet (rs) 
			rs = ps.executeQuery(); //again, the ResultSet just holds all the data we get back from the select statement
			
			
			List<Role> returnedRole = new ArrayList<>(); //create a List that will be populated with the returned role

			
			while(rs.next()) { //while there are results left in the ResultSet (rs)
				
				//Create a new Employee Object from each returned record
				//This is the Employee Class's all args constructor
				//And we're filling it with each column of the Employee record
				Role role = new Role(
						rs.getInt("role_id"),
						rs.getString("role_title"),
						rs.getInt("role_salary")
					);
				
				//add the newly created Employee object into the ArrayList of Employees
				returnedRole.add(role);

			}
			
			return returnedRole; //Finally, if successful, return the List of Employees
			
			
			
		} catch(SQLException e) {
			System.out.println("get role by title failed");
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public void updateRoleSalary(int newSalary, String roleTitle) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "update roles set role_salary = ? where role_title = ?;"; //write out the SQL query
			
			PreparedStatement ps = conn.prepareStatement(sql); //put the SQL query into a PreparedStatement
			
			//set the values in the prepared statement with the values inputted by the user
			ps.setInt(1, newSalary);
			ps.setString(2, roleTitle);
			ps.executeUpdate(); 
		
			
		} catch (SQLException e) {
			System.out.println("you BROKE IT you messed up it's all ruined because of YOU >:(");
			e.printStackTrace();
		}
			
	}

}
