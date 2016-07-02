package com.csc.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class TBL_Role implements Serializable {

	private Integer role_id;
	private Set<TBL_User> tbl_users = new HashSet<TBL_User>();
	private String role_name;	


	public TBL_Role() {
		
	}


	public Integer getRole_id() {
		return role_id;
	}


	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}



	public Set<TBL_User> getTbl_users() {
		return tbl_users;
	}


	public void setTbl_users(Set<TBL_User> tbl_users) {
		this.tbl_users = tbl_users;
	}


	public String getRole_name() {
		return role_name;
	}


	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}


	
}
