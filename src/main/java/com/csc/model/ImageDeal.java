/*
 *
 * author : Nguyen Dong Hung 
 * 
 * 
*/
package com.csc.model;

public class ImageDeal {

	
	private Long deal_id;
	private int number;
	private String [] image_name; 
	private int [] image_witdh;
	private int [] image_height;
	private TBL_Deal deal;
	
	public ImageDeal() {
	}
	
	public TBL_Deal getDeal() {
		return deal;
	}

	public void setDeal(TBL_Deal deal) {
		this.deal = deal;
	}



	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public Long getDeal_id() {
		return deal_id;
	}
	public void setDeal_id(Long deal_id) {
		this.deal_id = deal_id;
	}
	public String[] getImage_name() {
		return image_name;
	}
	public void setImage_name(String[] image_name) {
		this.image_name = image_name;
	}
	public int[] getImage_witdh() {
		return image_witdh;
	}
	public void setImage_witdh(int[] image_witdh) {
		this.image_witdh = image_witdh;
	}
	public int[] getImage_height() {
		return image_height;
	}
	public void setImage_height(int[] image_height) {
		this.image_height = image_height;
	}
	
	@Override
	public String toString() {
		return this.getNumber() + " / " + this.getImage_name()[0];
	}
	
}
