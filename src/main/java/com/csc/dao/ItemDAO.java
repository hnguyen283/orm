package com.csc.dao;

import java.util.List;

import com.csc.model.TBL_Item;
import com.csc.model.TBL_Type;

public interface ItemDAO {
	public List<TBL_Item> getAllItem();
	
	public List<TBL_Item> getPaginationItem(int start, int size);
	
	public int getSizeItem();
	
	public void updateItem(TBL_Item item);
	
	public void insertItem(TBL_Item item);
	
	public String deleteItem(long item_id);
	
	public TBL_Item getItemByID(long item_id);
	
	public List<TBL_Item> getItemByType(TBL_Type type);
}
