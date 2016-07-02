package com.csc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.csc.model.TBL_Type;
import com.csc.service.ItemService;
import com.csc.service.TypeService;


@Controller
@RequestMapping("/admin/product")
public class ProductController {
	@Autowired
	@Qualifier("itemService")
	ItemService itemService;
	
	@Autowired
	@Qualifier("typeService")
	TypeService typeService;

	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public String getProduct(ModelMap model){
		
		model.put("title", "Product Management");
		
		List<TBL_Type> types = typeService.getallType();
		model.put("types", types);
		
		return "admin/product";
	}
	
}
