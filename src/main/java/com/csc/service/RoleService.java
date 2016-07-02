/*
 *
 * author : Nguyen Dong Hung 
 * 
 * 
*/
package com.csc.service;

import java.util.List;

import com.csc.model.TBL_Role;

public interface RoleService {

	public List<TBL_Role> getAllRole();
	
	public TBL_Role getRoleById(Integer role_id);
	
	public TBL_Role getRoleByName(String role_name);
}
