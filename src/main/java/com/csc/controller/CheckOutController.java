package com.csc.controller;

import java.util.ArrayList;
import java.util.List;

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
@RequestMapping("/checkout")
public class CheckOutController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@RequestMapping(value = {"/", ""} , method = RequestMethod.GET)
	public String indexCheckOut(ModelMap model, HttpServletRequest req){
		if(req.getSession().getAttribute("userId") != null){
			Long userId = Long.parseLong(req.getSession().getAttribute("userId").toString());
			TBL_User user = userService.getUserByID(userId);
			
			model.put("tbl_user", user);
		}
		
		if(req.getSession().getAttribute("cart") != null){
			List<CartObject> cart = (ArrayList<CartObject>) req.getSession().getAttribute("cart");
			model.put("cart", cart);
		}
		
		return "checkout";
	}
}
