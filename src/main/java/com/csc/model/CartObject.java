package com.csc.model;

public class CartObject {
	@Override
	public boolean equals(Object arg0) {
		return (this.deal.getDeal_id() == ((CartObject) arg0).getDeal().getDeal_id());
	}
	private TBL_Deal deal;
	private int amount;
	public TBL_Deal getDeal() {
		return deal;
	}
	public void setDeal(TBL_Deal deal) {
		this.deal = deal;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public CartObject(TBL_Deal deal, int amount) {
		super();
		this.deal = deal;
		this.amount = amount;
	}
	public CartObject() {
		super();
	}
	
	
	
}
