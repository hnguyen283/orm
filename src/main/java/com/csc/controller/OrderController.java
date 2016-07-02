package com.csc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.csc.model.TBL_Order;
import com.csc.service.OrderService;

@Controller
@RequestMapping("/admin/order")
public class OrderController {
	@Autowired
	@Qualifier("orderService")
	private OrderService service;
	
	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public String showOder(ModelMap model){
		model.put("title", "Order Management");
		
		List<TBL_Order> listOrder = service.getOrder();
		model.put("listOrder", listOrder);
		
		return "admin/order";
	}
}
