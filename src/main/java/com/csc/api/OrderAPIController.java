package com.csc.api;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import javax.servlet.http.*;


import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.google.gson.*;

import com.csc.service.*;
import com.csc.model.*;

@Controller
@RequestMapping("/api/order")
public class OrderAPIController {
	
	@Autowired
	@Qualifier("dealService")
	private DealService dealService;
	
	@Autowired
	@Qualifier("orderService")
	private OrderService orderService;
	
	@Autowired
	@Qualifier("orderDetailService")
	private OrderDetailService orderDetailService;

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void createOrder(HttpServletRequest req, HttpServletResponse resp) {
		PrintWriter writter;
		Gson gson;
		try {
			writter = resp.getWriter();
			gson = new Gson();
			
			TBL_Order order = new TBL_Order();

			order.setOrder_date(new Date());
			order.setCustomer_name(req.getParameter("customer_name"));
			order.setCustomer_address(req.getParameter("customer_address"));
			order.setCustomer_phone(req.getParameter("customer_phone"));
			order.setCustomer_email(req.getParameter("customer_email"));
			order.setCustomer_phone2(req.getParameter("customer_phone2"));
			order.setCustomer_email2(req.getParameter("customer_email2"));
			order.setOrder_total(0D);
			order.setOrder_comment(req.getParameter("order_comment"));
			
			if (req.getSession().getAttribute("userId") != null) {
				TBL_User user = userService.getUserByID(Long.parseLong(req.getSession().getAttribute("userId").toString()));
				order.setTbl_user(user);
			}
			
			String[] listDealParam = req.getParameterValues("deals");
			String[] listAmountParam = req.getParameterValues("amounts");
			
			for(int i =0 ;i < listDealParam.length; i++){
				TBL_Deal deal = dealService.getDealById(Long.parseLong(listDealParam[i]));
				TBL_OrderDetail detail = new TBL_OrderDetail();
				detail.setTbl_order(order);
				detail.setTbl_deal(deal);
				detail.setOrderdetail_amount(Integer.parseInt(listAmountParam[i]));
				order.getListOrderDetail().add(detail);
				
				double detailTotal = Integer.parseInt(listAmountParam[i]) * deal.getDeal_price();
				order.setOrder_total(order.getOrder_total() + detailTotal);
			}

			orderService.CreateOrder(order);
			
			order.setListOrderDetail(null);
			order.setTbl_user(null);

			resp.setCharacterEncoding("UTF-8");
			ResultObject result = new ResultObject("success", order);
			req.getSession().setAttribute("cart", null);
			writter.write(gson.toJson(result));
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				writter = resp.getWriter();
				gson = new Gson();
				ResultObject result = new ResultObject("failed", ex.getMessage());
				
				resp.setCharacterEncoding("UTF-8");
				writter.write(gson.toJson(result));
				writter.flush();
				writter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void updateOrder(HttpServletRequest req, HttpServletResponse resp) {
		PrintWriter writter;
		Gson gson;
		resp.setCharacterEncoding("UTF-8");
		try {
			writter = resp.getWriter();
			gson = new Gson();
			
			if (req.getParameter("order_id") != null && !req.getParameter("order_id").isEmpty()) {
				TBL_Order order = orderService.selectOrder(Long.parseLong(req.getParameter("order_id")));

				order.setOrder_date(new Date());
				order.setCustomer_name(req.getParameter("customer_name"));
				order.setCustomer_address(req.getParameter("customer_address"));
				order.setCustomer_phone(req.getParameter("customer_phone"));
				order.setCustomer_email(req.getParameter("customer_email"));
				order.setCustomer_phone2(req.getParameter("customer_phone2"));
				order.setCustomer_email2(req.getParameter("customer_email2"));
				order.setOrder_total(Double.parseDouble(req.getParameter("order_total").isEmpty() ? "0" : req.getParameter("order_total")));
				order.setOrder_comment(req.getParameter("order_comment"));

				if (req.getParameter("user_id") != null) {
					TBL_User user = userService.getUserByID(Long.parseLong(req.getParameter("user_id")));
					order.setTbl_user(user);
				}

				orderService.UpdateOrder(order);

				
				ResultObject result = new ResultObject("success", order);
				writter.write(gson.toJson(result));
			}else {
				ResultObject result = new ResultObject("failed", "No Order ID");
				writter.write(gson.toJson(result));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				writter = resp.getWriter();
				gson = new Gson();
				ResultObject result = new ResultObject("failed", ex.getMessage());

				writter.write(gson.toJson(result));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void deleleOrder(HttpServletRequest req, HttpServletResponse resp) {
		String[] listOrder = req.getParameterValues("listOrderId");
		resp.setCharacterEncoding("UTF-8");
		for (String order : listOrder) {
			orderService.DeleteOrder(Long.parseLong(order));
		}

		Gson gson = new Gson();
		PrintWriter writter;
		try {
			writter = resp.getWriter();

			ResultObject result = new ResultObject("success", "delete successflly!");
			writter.write(gson.toJson(result));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public void getOrder(HttpServletRequest req, HttpServletResponse resp) {
		Gson gson = new Gson();
		resp.setCharacterEncoding("UTF-8");
		List<TBL_Order> listOder = orderService.getOrder();
		PrintWriter writter;
		try {
			writter = resp.getWriter();
			writter.write(gson.toJson(listOder));
			writter.flush(); 
			writter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
	public void selectOrder(@PathVariable long id, HttpServletRequest req, HttpServletResponse resp) {
		Gson gson = new Gson();
		resp.setCharacterEncoding("UTF-8");
		TBL_Order order = orderService.selectOrder(id);
		for(TBL_OrderDetail detail : order.getListOrderDetail()){
			detail.setTbl_order(null);		
			
		}
		order.setTbl_user(null);
		
		PrintWriter writter;
		try {
			writter = resp.getWriter();
			writter.write(gson.toJson(order));
			writter.flush();
			writter.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
