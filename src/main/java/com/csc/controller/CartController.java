package com.csc.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csc.model.CartObject;
import com.csc.model.TBL_User;
import com.csc.service.UserService;

@Controller
@RequestMapping(value = "/cart")
public class CartController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String indexCart(ModelMap model, HttpServletRequest req){
		model.put("title", "your cart");
		
		if(req.getSession().getAttribute("userId") != null){
			long id = Long.parseLong(req.getSession().getAttribute("userId").toString());
			
			TBL_User user = userService.getUserByID(id);
			model.put("user", user);
		}
		
		if(req.getSession().getAttribute("cart") != null){
			List<CartObject> listItem = (ArrayList<CartObject>) req.getSession().getAttribute("cart");
			
			model.put("listItem", listItem);
		}
		
		return "cart";
	}
}
