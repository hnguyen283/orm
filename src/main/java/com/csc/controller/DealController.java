package com.csc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csc.model.TBL_Deal;
import com.csc.model.TBL_Item;
import com.csc.service.DealService;
import com.csc.service.ItemService;

@Controller
@RequestMapping ("/admin")
public class DealController {
	@Autowired
	@Qualifier ("dealService")
		DealService dealService ;
	
	@Autowired
	@Qualifier("itemService")
	private ItemService itemService;
	
	@RequestMapping(value = {"/deal"}, method = RequestMethod.GET)
	public String indexAdminDeal(ModelMap map){
		List<TBL_Deal> listDeal = dealService.allDeal();
		map.put("listDeal", listDeal);
		List<TBL_Item> listItem = itemService.getAllItem();
		map.put("listItem", listItem);
		return "admin/deal";
	}
	
	@RequestMapping ("/checkdeal")
	public String AdminDeal (ModelMap model)
	{
		List<TBL_Deal> deal = dealService.allDeal();
		model.put("deal", deal);
		model.put("title", "Deal Report");
		return "admin/checkdeal";
		
	}
	
}
