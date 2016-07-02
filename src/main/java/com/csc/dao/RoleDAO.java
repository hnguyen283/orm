/*
 *
 * author : Nguyen Dong Hung 
 * 
 * 
*/
package com.csc.dao;

import java.util.List;

import com.csc.model.TBL_Role;

public interface RoleDAO {
	public List<TBL_Role> getAllRole();

	public void updateRole(TBL_Role role);

	public void insertRole(TBL_Role role);

	public void deleteRole(Integer role_id);

	public TBL_Role getRoleByID(Integer role_id);
	
	public TBL_Role getRoleByName(String role_name);

}
