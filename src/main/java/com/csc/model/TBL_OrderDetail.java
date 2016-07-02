package com.csc.model;

public class TBL_OrderDetail {

	private Long orderdetail_id;
	private Integer orderdetail_amount;

	private TBL_Order tbl_order;
	private TBL_Deal tbl_deal;

	public TBL_OrderDetail() {
	}

	public Long getOrderdetail_id() {
		return orderdetail_id;
	}

	public void setOrderdetail_id(Long orderdetail_id) {
		this.orderdetail_id = orderdetail_id;
	}

	public Integer getOrderdetail_amount() {
		return orderdetail_amount;
	}

	public void setOrderdetail_amount(Integer orderdetail_amount) {
		this.orderdetail_amount = orderdetail_amount;
	}

	public TBL_Order getTbl_order() {
		return tbl_order;
	}

	public void setTbl_order(TBL_Order tbl_order) {
		this.tbl_order = tbl_order;
	}

	public TBL_Deal getTbl_deal() {
		return tbl_deal;
	}

	public void setTbl_deal(TBL_Deal tbl_deal) {
		this.tbl_deal = tbl_deal;
	}

}
