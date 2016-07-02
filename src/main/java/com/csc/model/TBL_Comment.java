package com.csc.model;

public class TBL_Comment {
	private long comment_id;
	private String comment_content;
	
	private TBL_User tbl_user;
	private TBL_Deal tbl_deal;
	
	public long getComment_id() {
		return comment_id;
	}
	public void setComment_id(long comment_id) {
		this.comment_id = comment_id;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
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
