package com.csc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csc.service.ItemService;

@Controller
@RequestMapping("/admin")
public class AdminIndex {
	
	@Autowired
	@Qualifier("itemService")
	ItemService itemService;
	
	@RequestMapping(value = {"/", ""})
	public String index(ModelMap model){
		model.put("title", "Dashboard");
		return "admin/index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(ModelMap model){
		model.put("title", "Login Administrator");
		return "admin/login";
	}
}
