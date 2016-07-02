package com.csc.api;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csc.model.ImageDeal;
import com.csc.model.ImageDealSerializer;
import com.csc.model.ResultObject;
import com.csc.model.TBL_Deal;
import com.csc.model.TBL_DealSerializer;
import com.csc.model.TBL_Item;
import com.csc.model.TBL_ItemSerializer;
import com.csc.model.TBL_Type;
import com.csc.model.TBL_TypeSerializer;
import com.csc.model.TBL_User;
import com.csc.service.DealService;
import com.csc.service.ItemService;
import com.csc.service.TypeService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
@Controller
@RequestMapping("/api/dealbytype")
public class DealByTypeAPIController {
	@Autowired
	@Qualifier("dealService")
	private DealService dealService;
	@Autowired
	@Qualifier("itemService")
	private ItemService itemService;
	@Autowired
	@Qualifier("typeService")
	private TypeService typeService;
	
	
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public void getallDeal(HttpServletRequest req, HttpServletResponse resp) {
		Gson gson = new Gson();
		List<TBL_Deal> list = dealService.allDeal();

		PrintWriter writter;
		try {
			for (TBL_Deal tbl_Deal : list) {
				tbl_Deal.getTbl_item().setTbl_deals(null);
				tbl_Deal.getTbl_item().setTbl_type(null);
				tbl_Deal.getTbl_user().setTbl_items(null);
				tbl_Deal.getTbl_user().setTbl_orders(null);
				tbl_Deal.getTbl_user().setTbl_role(null);
			}

			resp.setCharacterEncoding("UTF-8");
			writter = resp.getWriter();

			writter.write(gson.toJson(list));

			writter.flush();
			writter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/getnumberdeal/{id}", method = RequestMethod.GET)
	public void getNumberDeal(@PathVariable Long id, HttpServletRequest req, HttpServletResponse resp) {
		Gson gson = new Gson();
		int size = dealService.getSizeDealByType(id);

		PrintWriter writter;
		try {
			resp.setCharacterEncoding("UTF-8");
			writter = resp.getWriter();

			writter.write(gson.toJson(new ResultObject("size", size)));

			writter.flush();
			writter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/getbybegintime/{id}", method = RequestMethod.GET)
	public void getallDealSortByBT(@PathVariable Long id,HttpServletRequest req, HttpServletResponse resp) {
		TBL_DealSerializer.setRequest(req);
		Gson gson = new Gson();
		List<TBL_Deal> list = dealService.allDealSortByType("deal_begin", Integer.parseInt(req.getParameter("start")),
				Integer.parseInt(req.getParameter("numberget")), req.getParameter("sort"), id);
		System.out.println(list.get(0).toString());

		PrintWriter writter;
		try {
			resp.setCharacterEncoding("UTF-8");
			writter = resp.getWriter();

			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(TBL_Deal.class, new TBL_DealSerializer());
			gsonBuilder.registerTypeAdapter(ImageDeal.class, new ImageDealSerializer());
			gsonBuilder.registerTypeAdapter(TBL_Item.class, new TBL_ItemSerializer());
			gsonBuilder.registerTypeAdapter(TBL_Type.class, new TBL_TypeSerializer());
			gsonBuilder.setPrettyPrinting();
			gson = gsonBuilder.create();

			java.lang.reflect.Type typeOfSrc = new TypeToken<Collection<TBL_Deal>>() {
			}.getType();

			JsonElement el = gson.toJsonTree(list, typeOfSrc);
			writter.write(gson.toJson(list, typeOfSrc));

			writter.flush();
			writter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}


