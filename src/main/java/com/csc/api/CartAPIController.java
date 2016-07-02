package com.csc.api;

import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csc.model.*;
import com.csc.service.*;
import com.google.gson.*;

@Controller
@RequestMapping("/api/cart")
public class CartAPIController {

	@Autowired
	@Qualifier("dealService")
	private DealService dealService;

	@RequestMapping(value = { "/add", "/add/" }, method = RequestMethod.POST)
	public void addCart(HttpServletRequest req, HttpServletResponse resp) {
		Gson gson = new Gson();
		ResultObject result = new ResultObject();
		try {
			List<CartObject> cart = new ArrayList<CartObject>();
			if (req.getSession().getAttribute("cart") != null) {
				cart = (ArrayList<CartObject>) req.getSession().getAttribute("cart");
			}

			String deal = req.getParameter("dealId");
			String amount = req.getParameter("amount");

			
			CartObject c = new CartObject(dealService.getDealById(Long.parseLong(deal)), Integer.parseInt(amount));
			if(cart.contains(c)){
				int index = cart.indexOf(c);
				cart.get(index).setAmount(c.getAmount() + cart.get(index).getAmount());
			}else{
				cart.add(c);	
			}		

			req.getSession().setAttribute("cart", cart);
			result.setResult("success");
			result.setDetail("add success item: " + deal);
			
			resp.getWriter().write(gson.toJson(result));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void updateCart(HttpServletRequest req, HttpServletResponse resp) {
		resp.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		ResultObject result = new ResultObject();
		try {
			List<CartObject> cart = new ArrayList<CartObject>();
			String[] listDeal = req.getParameterValues("deals");
			String[] listAmount = req.getParameterValues("amounts");

			for (int i = 0; i < listDeal.length; i++) {
				CartObject c = new CartObject();
				
				TBL_Deal deal = dealService.getDealById(Long.parseLong(listDeal[i]));
				c.setDeal(deal);
				c.setAmount(Integer.parseInt(listAmount[i]));
				
				cart.add(c);
			}
			
			req.getSession().setAttribute("cart", cart);
			
			result.setResult("success");
			result.setDetail("Cart updated!");
			
			resp.getWriter().write(gson.toJson(result));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.POST)
	public void deleteCart(@PathVariable long id, HttpServletRequest req, HttpServletResponse resp) {
		resp.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		ResultObject result = new ResultObject();
		try {
			if (req.getSession().getAttribute("cart") != null) {
				List<CartObject> cart = (ArrayList<CartObject>) req.getSession().getAttribute("cart");

				for (CartObject c : cart) {
					if (c.getDeal().getDeal_id() == id) {
						cart.remove(cart.indexOf(c));
						break;
					}
				}

				req.getSession().setAttribute("cart", cart);

				result.setResult("success");
				result.setDetail("success delete item: " + id);
			} else {
				result.setResult("failed");
				result.setDetail("no cart");
			}

			resp.getWriter().write(gson.toJson(result));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@RequestMapping(value = { "/clear" }, method = RequestMethod.GET)
	public void clearCart(HttpServletRequest req, HttpServletResponse resp) {
		resp.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		ResultObject result = new ResultObject();
		try {
			if (req.getSession().getAttribute("cart") != null) {
				req.getSession().setAttribute("cart", null);

				result.setResult("success");
				result.setDetail("Clear cart successfully!");

			} else {
				result.setResult("failed");
				result.setDetail("cart have nothing");
			}

			resp.getWriter().write(gson.toJson(result));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public void getCart(HttpServletRequest req, HttpServletResponse resp) {
		resp.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		ResultObject result = new ResultObject();
		result.setResult("failed");
		result.setDetail("no data");
		try {
			if (req.getSession().getAttribute("cart") != null) {
				List<CartObject> listDeal = (ArrayList<CartObject>) req.getSession().getAttribute("cart");
				
				if(listDeal.size() > 0){
					for(CartObject c : listDeal){
						c.getDeal().getTbl_item().setTbl_deals(null);
						c.getDeal().getTbl_item().setTbl_type(null);
						c.getDeal().setTbl_user(null);
					}
					
					result.setResult("success");
					result.setDetail(listDeal);
				}
			}
			resp.getWriter().write(gson.toJson(result));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	@RequestMapping(value = {"/detail"}, method = RequestMethod.GET)
	public void detailCart(HttpServletRequest req, HttpServletResponse resp){
		resp.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		ResultObject result = new ResultObject();
		try{
			if(req.getSession().getAttribute("cart") != null){
				List<CartObject> cart = (ArrayList<CartObject>) req.getSession().getAttribute("cart");
				
				double total = 0;
				for(CartObject c : cart){
					total += c.getAmount() * c.getDeal().getDeal_price();
				}
				
				
				JsonObject json = new JsonObject();
				json.addProperty("items", cart.size());
				json.addProperty("total", total);
				
				result.setResult("success");
				result.setDetail(json);
			}else{
				result.setResult("failed");
				result.setDetail("No cart");
			}
			
			resp.getWriter().write(gson.toJson(result));
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
