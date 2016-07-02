package com.csc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String indexLogin(ModelMap model){
		model.put("title", "User Login");
		return "login";
	}
}
