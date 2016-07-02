package com.csc.model;

import java.util.HashSet;
import java.util.Set;


public class TBL_Item {

	private Long item_id;
	private String item_owner;
	private String item_name;
	private String item_description;
	private String item_describe;

	
	private TBL_Type tbl_type;
	
	private Set<TBL_Deal> tbl_deals = new HashSet<TBL_Deal>();
	
	public Set<TBL_Deal> getTbl_deals() {
		return tbl_deals;
	}

	public void setTbl_deals(Set<TBL_Deal> tbl_deals) {
		this.tbl_deals = tbl_deals;
	}

	public TBL_Item() {
	}

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}

	public String getItem_owner() {
		return item_owner;
	}

	public void setItem_owner(String item_owner) {
		this.item_owner = item_owner;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_description() {
		return item_description;
	}

	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}

	public String getItem_describe() {
		return item_describe;
	}

	public void setItem_describe(String item_describe) {
		this.item_describe = item_describe;
	}

	public TBL_Type getTbl_type() {
		return tbl_type;
	}

	public void setTbl_type(TBL_Type tbl_type) {
		this.tbl_type = tbl_type;
	}

}
