/*
 *
 * author : Nguyen Dong Hung 
 * 
 * 
*/
package com.csc.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TBL_User implements Serializable {
	
	private Long user_id;
	private String user_name;
	private String user_password;
	private String user_address;
	private String user_email;
	private String user_phone;
	private String user_email2;
	private String user_phone2;
	private String user_status;

	private TBL_Role tbl_role;

	private Set<TBL_Order> tbl_orders = new HashSet<TBL_Order>();

	private Set<TBL_Item> tbl_items = new HashSet<TBL_Item>();

	public TBL_User() {
		
	}

	@Override
	public String toString() {
		return getUser_name() + " " + getUser_password() + " " + getUser_address() + " " + getUser_email() + " "
				+ getUser_phone() + " " + getTbl_role().getRole_name();
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_email2() {
		return user_email2;
	}

	public void setUser_email2(String user_email2) {
		this.user_email2 = user_email2;
	}

	public String getUser_phone2() {
		return user_phone2;
	}

	public void setUser_phone2(String user_phone2) {
		this.user_phone2 = user_phone2;
	}
	
	
	public String getUser_status() {
		return user_status;
	}

	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}

	public TBL_Role getTbl_role() {
		return tbl_role;
	}

	public void setTbl_role(TBL_Role tbl_role) {
		this.tbl_role = tbl_role;
	}

	public Set<TBL_Order> getTbl_orders() {
		return tbl_orders;
	}

	public void setTbl_orders(Set<TBL_Order> tbl_orders) {
		this.tbl_orders = tbl_orders;
	}

	public Set<TBL_Item> getTbl_items() {
		return tbl_items;
	}

	public void setTbl_items(Set<TBL_Item> tbl_items) {
		this.tbl_items = tbl_items;
	}

	
}
