/*
 *
 * author : Nguyen Dong Hung 
 * 
 * 
*/
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
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	@Qualifier("typeService")
	private TypeService typeService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String IndexHome(ModelMap model) {
		List<TBL_Type> listType = typeService.getallType();
		
		model.put("listType", listType);
		model.put("title", "Ecommer Home Page");
		return "index";
	}
}