package com.csc.model;

import java.util.HashSet;
import java.util.Set;

public class TBL_Type {

	private Long type_id;
	private String type_name;
	private String type_description;
	private String type_icon;
	
	public TBL_Type() {
	}


	public Long getType_id() {
		return type_id;
	}


	public void setType_id(Long type_id) {
		this.type_id = type_id;
	}


	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public String getType_description() {
		return type_description;
	}


	public void setType_description(String type_description) {
		this.type_description = type_description;
	}


	public String getType_icon() {
		return type_icon;
	}


	public void setType_icon(String type_icon) {
		this.type_icon = type_icon;
	}
	
}
