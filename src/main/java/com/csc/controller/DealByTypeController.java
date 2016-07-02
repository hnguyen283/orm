package com.csc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping ("/dealByType")
public class DealByTypeController {
	@RequestMapping(value = "/type/{id}", method = RequestMethod.GET)
	public String selectDeal(@PathVariable long id, ModelMap model){
		model.put("typeid",id);
		return "dealbytype";
	}
}
