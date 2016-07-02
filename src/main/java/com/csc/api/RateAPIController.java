package com.csc.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csc.model.ResultObject;
import com.csc.model.TBL_Rate;
import com.csc.model.TBL_User;
import com.csc.service.DealService;
import com.csc.service.RateService;
import com.csc.service.UserService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/api/rate")
public class RateAPIController {
	
	@Autowired
	@Qualifier("dealService")
	private DealService dealService;
	
	@Autowired
	@Qualifier("rateService")
	private RateService rateService;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void createRate(HttpServletRequest req, HttpServletResponse resp){
		PrintWriter writter;
		Gson gson;
		HttpSession session = req.getSession();
		try{
			String point = req.getParameter("point");
			String deal_id = req.getParameter("dealid");
			Long user_id = (Long) session.getAttribute("user_id");
			TBL_User user = (TBL_User) userService.getUserByID(user_id);
			
			TBL_Rate rate = rateService.getRate(user.getUser_id(), Long.parseLong(deal_id));
			
			if(rate == null){
				rate = new TBL_Rate();
				rate.setTbl_user(user);
				rate.setRate_point(Integer.parseInt(point));
				rate.setTbl_deal(dealService.getDealById(Long.parseLong(deal_id)));
			}else{
				rate.setRate_point(Integer.parseInt(point));
			}
			
			rateService.insertRate(rate);
			
			resp.setCharacterEncoding("UTF-8");
			writter = resp.getWriter();
			gson = new Gson();
			ResultObject result = new ResultObject("success", rate.getRate_id());
			writter.write(gson.toJson(result));
			
		}catch(Exception ex){
			ex.printStackTrace();
			try {
				writter = resp.getWriter();
				gson = new Gson();
				ResultObject result = new ResultObject("failed", ex.getMessage());
				writter.write(gson.toJson(result));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public void getRate(HttpServletResponse resp, HttpServletRequest req){
		PrintWriter writter;
		Gson gson;
		List<Object> numberOfEachPoint = new ArrayList<Object>();
		try {
			String deal_id = req.getParameter("deal_id");
			numberOfEachPoint = rateService.getNumberOfEachPoint(Long.parseLong(deal_id));
			writter = resp.getWriter();
			gson = new Gson();
			ResultObject result = new ResultObject("success", numberOfEachPoint);
			writter.write(gson.toJson(result));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
