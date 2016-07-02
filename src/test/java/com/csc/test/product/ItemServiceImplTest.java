package com.csc.test.product;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.csc.dao.ItemDAO;
import com.csc.model.TBL_Item;
import com.csc.model.TBL_Type;
import com.csc.service.ItemService;
import com.csc.service.ItemServiceImpl;


public class ItemServiceImplTest {

	ItemDAO itemDAO;
	ItemService itemService;
	
	@Before
	public void setUp(){
		itemDAO = Mockito.mock(ItemDAO.class);
		
		ItemServiceImpl itemServiceImpl = new ItemServiceImpl();
		itemServiceImpl.setItemDAO(itemDAO);
		itemService = itemServiceImpl;
	}
	
	@Test
	public void testGetAllItem() {
		List<TBL_Item> items = new ArrayList<TBL_Item>();
		
		TBL_Item item1 = new TBL_Item();
		item1.setItem_id(1l);
		item1.setItem_name("A");
		
		TBL_Item item2 = new TBL_Item();
		item2.setItem_id(2l);
		item2.setItem_name("B");
		
		items.add(item1);
		items.add(item2);
		
		Mockito.when(itemDAO.getAllItem()).thenReturn(items);
		
		List<TBL_Item> listItem = itemService.getAllItem();
		Assert.assertEquals(2, listItem.size());
	}

	@Test
	public void testGetPaginationItem() {
		List<TBL_Item> items = new ArrayList<TBL_Item>();
		
		TBL_Item item1 = new TBL_Item();
		item1.setItem_id(1l);
		item1.setItem_name("A");
		
		TBL_Item item2 = new TBL_Item();
		item2.setItem_id(2l);
		item2.setItem_name("B");
		
		TBL_Item item3 = new TBL_Item();
		item2.setItem_id(3l);
		item2.setItem_name("C");
		
		items.add(item1);
		items.add(item2);
		items.add(item3);
		
		Mockito.when(itemDAO.getPaginationItem(0, 3)).thenReturn(items);
		
		List<TBL_Item> listItem = itemService.getPaginationItem(0, 3);
		Assert.assertEquals(3, listItem.size());
	}

	@Test
	public void testGetItemByID() {
		
		TBL_Item item1 = new TBL_Item();
		item1.setItem_id(1l);
		item1.setItem_name("A");

		Mockito.when(itemDAO.getItemByID(1l)).thenReturn(item1);
		
		TBL_Item item =itemService.getItemByID(1l);
		
		Assert.assertEquals("A", item.getItem_name());
	}

	@Test
	public void testGetItemsByType() {
		TBL_Type type = new TBL_Type();
		type.setType_id(1l);
		type.setType_name("BK");
		
		List<TBL_Item> items = new ArrayList<TBL_Item>();
		TBL_Item item1 = new TBL_Item();
		item1.setItem_id(1l);
		item1.setItem_name("A");
		
		TBL_Item item2 = new TBL_Item();
		item2.setItem_id(2l);
		item2.setItem_name("B");
		
		TBL_Item item3 = new TBL_Item();
		item2.setItem_id(3l);
		item2.setItem_name("C");
		
		items.add(item1);
		items.add(item2);
		items.add(item3);
		
		Mockito.when(itemDAO.getItemByType(type)).thenReturn(items);
		
		List<TBL_Item> listItem = itemService.getItemsByType(type);
		
		Assert.assertEquals(3, listItem.size());
	}

	@Test
	public void testGetSizeItem() {
		Mockito.when(itemDAO.getSizeItem()).thenReturn(6);
		
		int size = itemService.getSizeItem();
		Assert.assertEquals(6, size);
	}

}
