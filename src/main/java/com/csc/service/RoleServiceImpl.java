/*
 *
 * author : Nguyen Dong Hung 
 * 
 * 
*/
package com.csc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.csc.dao.RoleDAO;
import com.csc.model.TBL_Role;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	@Qualifier("roleDAO")
	RoleDAO roleDAO;

	@Override
	public List<TBL_Role> getAllRole() {
		return roleDAO.getAllRole();
	}

	@Override
	public TBL_Role getRoleById(Integer role_id) {
		return roleDAO.getRoleByID(role_id);
	}

	@Override
	public TBL_Role getRoleByName(String role_name) {
		return roleDAO.getRoleByName(role_name);
	}
	
	

}
