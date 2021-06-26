package com.revature.daos;

import java.util.List;

import com.revature.models.Role;

public interface RoleDaoInterface {
	
	public List<Role> getRoleByTitle(String title); 
	
	public void updateRoleSalary(int newSalary, String roleTitle);
	
}
