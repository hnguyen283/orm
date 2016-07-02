package com.csc.model;

import java.io.Serializable;
import java.util.Date;

public class TBL_Deal implements Serializable{

	private Long deal_id;
	private String deal_owner;
	private String deal_description;
	private Date deal_begin;
	private Date deal_end;
	private double deal_price;
	private Float deal_discount;
	private Double deal_amount;
	private Float deal_acceptable;
	private String deal_status;
	
	private TBL_Item tbl_item;
	private TBL_User tbl_user;

	public TBL_Deal() {
	}

	
	public String getDeal_status() {
		return deal_status;
	}


	public void setDeal_status(String deal_status) {
		this.deal_status = deal_status;
	}


	public Long getDeal_id() {
		return deal_id;
	}

	public void setDeal_id(Long deal_id) {
		this.deal_id = deal_id;
	}

	public String getDeal_owner() {
		return deal_owner;
	}

	public void setDeal_owner(String deal_owner) {
		this.deal_owner = deal_owner;
	}

	public String getDeal_description() {
		return deal_description;
	}

	public void setDeal_description(String deal_description) {
		this.deal_description = deal_description;
	}

	public Date getDeal_begin() {
		return deal_begin;
	}

	public void setDeal_begin(Date deal_begin) {
		this.deal_begin = deal_begin;
	}

	public Date getDeal_end() {
		return deal_end;
	}

	public void setDeal_end(Date deal_end) {
		this.deal_end = deal_end;
	}

	public double getDeal_price() {
		return deal_price;
	}


	public void setDeal_price(double deal_price) {
		this.deal_price = deal_price;
	}


	public Float getDeal_discount() {
		return deal_discount;
	}

	public void setDeal_discount(Float deal_discount) {
		this.deal_discount = deal_discount;
	}

	public Double getDeal_amount() {
		return deal_amount;
	}

	public void setDeal_amount(Double deal_amount) {
		this.deal_amount = deal_amount;
	}

	public Float getDeal_acceptable() {
		return deal_acceptable;
	}

	public void setDeal_acceptable(Float deal_acceptable) {
		this.deal_acceptable = deal_acceptable;
	}

	

	public TBL_Item getTbl_item() {
		return tbl_item;
	}

	public void setTbl_item(TBL_Item tbl_item) {
		this.tbl_item = tbl_item;
	}
	
	public TBL_User getTbl_user() {
		return tbl_user;
	}


	public void setTbl_user(TBL_User tbl_user) {
		this.tbl_user = tbl_user;
	}


	@Override
	public boolean equals(Object arg0) {		
		return this.getDeal_id() == ((TBL_Deal) arg0).getDeal_id();
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getDeal_id() + " / " + this.getDeal_owner() + " / " + this.getDeal_begin();
	}
	
		
}
