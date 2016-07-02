package com.csc.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.csc.service.OrderDetailService;

@Controller
@RequestMapping("/api/orderdetail/")
public class OrderDetailAPIController {
	
	@Autowired
	@Qualifier("orderDetailService")
	private OrderDetailService orderDetailService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void CreateOrderDetail(HttpServletRequest request, HttpServletResponse response){
		
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void UpdateOrderDetail(HttpServletRequest request, HttpServletResponse response){
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void DeleteOrderDetail(HttpServletRequest request, HttpServletResponse response){
		
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public void GetOrderDetail(HttpServletResponse response){
		
	}
	
	@RequestMapping(value = "/select/{id}", method = RequestMethod.POST)
	public void SelectOrderDetail(@RequestParam long id ,HttpServletResponse response){
		
	}
}
