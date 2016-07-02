package com.csc.model;

public class TBL_Rate {
	
	private long rate_id;
	private int rate_point;
	private TBL_User tbl_user;
	private TBL_Deal tbl_deal;
	
	public long getRate_id() {
		return rate_id;
	}
	public void setRate_id(long rate_id) {
		this.rate_id = rate_id;
	}
	public int getRate_point() {
		return rate_point;
	}
	public void setRate_point(int rate_point) {
		this.rate_point = rate_point;
	}
	public TBL_User getTbl_user() {
		return tbl_user;
	}
	public void setTbl_user(TBL_User tbl_user) {
		this.tbl_user = tbl_user;
	}
	public TBL_Deal getTbl_deal() {
		return tbl_deal;
	}
	public void setTbl_deal(TBL_Deal tbl_deal) {
		this.tbl_deal = tbl_deal;
	}
	
}
