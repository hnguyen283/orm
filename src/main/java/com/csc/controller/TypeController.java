package com.csc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csc.model.TBL_Type;
import com.csc.service.TypeService;


@Controller
@RequestMapping("/admin")
public class TypeController {
	@Autowired
	@Qualifier("typeService")
	TypeService typeService ;
	 
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public String AdminType (ModelMap model)
	{
		List<TBL_Type> type = typeService.getallType();
	
		model.addAttribute("type",type);
		
		model.put("title" , "Type Managerment");
		
		return "admin/categories";	
	}
	
}
