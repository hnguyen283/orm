package com.csc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.csc.dao.ItemDAO;
import com.csc.model.TBL_Item;
import com.csc.model.TBL_Type;

public class ItemServiceImpl implements ItemService{

	@Autowired
	@Qualifier("itemDAO")
	private ItemDAO itemDAO;
	
	public ItemDAO getItemDAO() {
		return itemDAO;
	}

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	@Override
	public List<TBL_Item> getAllItem() {
		return itemDAO.getAllItem();
	}

	@Override
	public List<TBL_Item> getPaginationItem(int start, int size) {
		return itemDAO.getPaginationItem(start, size);
	}
	
	@Override
	public void updateItem(TBL_Item item) {
		itemDAO.updateItem(item);
	}

	@Override
	public void insertItem(TBL_Item item) {
		itemDAO.insertItem(item);
	}

	@Override
	public String deleteItem(long item_id) {
		return itemDAO.deleteItem(item_id);
	}

	@Override
	public TBL_Item getItemByID(long item_id) {
		return itemDAO.getItemByID(item_id);
	}

	@Override
	public List<TBL_Item> getItemsByType(TBL_Type type) {
		return itemDAO.getItemByType(type);
	}

	@Override
	public int getSizeItem() {
		return itemDAO.getSizeItem();
	}

}
