package com.csc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TBL_Order {

	private Long order_id;
	private Date order_date;
	private String customer_name;
	private String customer_address;
	private String customer_phone ;
	private String customer_phone2 ;
	private String customer_email;
	private String customer_email2;
	private String order_comment;
	private Double order_total;
	private String order_status;
	private Double order_money_receive;
	private Double order_money_chances;
	
	private Set<TBL_OrderDetail> listOrderDetail = new HashSet<TBL_OrderDetail>();
	
	private TBL_User tbl_user;
	
	public TBL_Order() {
	}
	
	public Long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_address() {
		return customer_address;
	}
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	public String getCustomer_phone() {
		return customer_phone;
	}
	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}
	public String getCustomer_phone2() {
		return customer_phone2;
	}
	public void setCustomer_phone2(String customer_phone2) {
		this.customer_phone2 = customer_phone2;
	}
	public String getCustomer_email() {
		return customer_email;
	}
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	public String getCustomer_email2() {
		return customer_email2;
	}
	public void setCustomer_email2(String customer_email2) {
		this.customer_email2 = customer_email2;
	}
	public String getOrder_comment() {
		return order_comment;
	}
	public void setOrder_comment(String order_comment) {
		this.order_comment = order_comment;
	}
	public Double getOrder_total() {
		return order_total;
	}
	public void setOrder_total(Double order_total) {
		this.order_total = order_total;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public Double getOrder_money_receive() {
		return order_money_receive;
	}
	public void setOrder_money_receive(Double order_money_receive) {
		this.order_money_receive = order_money_receive;
	}
	public Double getOrder_money_chances() {
		return order_money_chances;
	}
	public void setOrder_money_chances(Double order_money_chances) {
		this.order_money_chances = order_money_chances;
	}
	public Set<TBL_OrderDetail> getListOrderDetail() {
		return listOrderDetail;
	}
	public void setListOrderDetail(Set<TBL_OrderDetail> listOrderDetail) {
		this.listOrderDetail = listOrderDetail;
	}
	public TBL_User getTbl_user() {
		return tbl_user;
	}
	public void setTbl_user(TBL_User tbl_user) {
		this.tbl_user = tbl_user;
	}
}
