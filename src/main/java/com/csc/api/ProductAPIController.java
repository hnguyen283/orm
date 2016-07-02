package com.csc.api;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csc.model.ResultObject;
import com.csc.model.TBL_Item;
import com.csc.model.TBL_ItemSerializer;
import com.csc.model.TBL_Type;
import com.csc.model.TBL_TypeSerializer;
import com.csc.service.ItemService;
import com.csc.service.TypeService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@Controller
@RequestMapping("/api/product")
public class ProductAPIController {
	
	@Autowired
	@Qualifier("itemService")
	private ItemService itemService;
	
	@Autowired
	@Qualifier("typeService")
	private TypeService typeService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void createProduct(HttpServletRequest req, HttpServletResponse resp){
		PrintWriter writter;
		Gson gson;
		try {
			TBL_Item item = new TBL_Item();
			if(req.getParameter("item_name") != null)
				item.setItem_name(req.getParameter("item_name"));
			if(req.getParameter("item_owner") != null)
				item.setItem_owner(req.getParameter("item_owner"));
			item.setItem_description(req.getParameter("item_description"));
			item.setItem_describe(req.getParameter("item_describe"));
			if(req.getParameter("tbl_type") != ""){
				Long id = Long.parseLong(req.getParameter("tbl_type"));
				item.setTbl_type(typeService.gettypeByID(id));
				
				itemService.insertItem(item);
			}
		
			gson = new Gson();
		
			resp.setCharacterEncoding("UTF-8");
			writter = resp.getWriter();

			 ResultObject result = new ResultObject("add", "create product");
			 writter.write(gson.toJson(result));
		} catch (Exception ex) {
			// TODO Auto-generated catch block
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
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void updateProduct(HttpServletRequest req, HttpServletResponse resp){
		PrintWriter writter;
		Gson gson;
		
		try {
			resp.setCharacterEncoding("UTF-8");
			writter = resp.getWriter();
			gson = new Gson();
			if(req.getParameter("item_id") != null){
				TBL_Item item = itemService.getItemByID(Long.parseLong(req.getParameter("item_id")));
				if(req.getParameter("item_name") != null)
					item.setItem_name(req.getParameter("item_name"));
				if(req.getParameter("item_owner") != null)
					item.setItem_owner(req.getParameter("item_owner"));
				item.setItem_description(req.getParameter("item_description"));
				item.setItem_describe(req.getParameter("item_describe"));
				
				if(req.getParameter("tbl_type") != ""){
					Long id = Long.parseLong(req.getParameter("tbl_type"));
					item.setTbl_type(typeService.gettypeByID(id));
				}
				itemService.updateItem(item);
				
				ResultObject result = new ResultObject("update", "update product");
				writter.write(gson.toJson(result));
			}else {
				ResultObject result = new ResultObject("failed", "No Product ID");
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
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void deleleProduct(HttpServletRequest req, HttpServletResponse resp){
		String[] listItem = req.getParameterValues("listItemId");
		if(listItem != null){
			String[] listTemp = new String[listItem.length];
			for(int i = 0; i < listItem.length; i++)
				listTemp[i] = itemService.deleteItem(Long.parseLong(listItem[i]));
			Gson gson = new Gson();
			PrintWriter writter;
			try {
				writter = resp.getWriter();
				writter.write(gson.toJson(listTemp));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			Gson gson = new Gson();
			PrintWriter writter;
			try {
				writter = resp.getWriter();
	
				 ResultObject result = new ResultObject("fail", "not item is chose");
				 writter.write(gson.toJson(result));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public void getProduct(HttpServletRequest req, HttpServletResponse resp){
		Gson gson = new Gson();
		List<TBL_Item> listItem = itemService.getAllItem();
		PrintWriter writter;
		
		try {
			resp.setCharacterEncoding("UTF-8");
			writter = resp.getWriter();
			
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(TBL_Item.class, new TBL_ItemSerializer());
			gsonBuilder.registerTypeAdapter(TBL_Type.class, new TBL_TypeSerializer());
			gsonBuilder.setPrettyPrinting();
			gson = gsonBuilder.create();
			
			java.lang.reflect.Type typeOfSrc = new TypeToken<Collection<TBL_Item>>(){}.getType();
			
			writter.write(gson.toJson(listItem, typeOfSrc));
			
			writter.flush();
			writter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/getPagination", method = RequestMethod.GET)
	public void getPaginationProduct(HttpServletRequest req, HttpServletResponse resp){
		Gson gson = new Gson();
		
		String start = req.getParameter("start");
		String sizePagination = req.getParameter("sizePagination");
		List<TBL_Item> listItem = itemService.getPaginationItem(Integer.parseInt(start), Integer.parseInt(sizePagination));
		PrintWriter writter;
		
		try {
			resp.setCharacterEncoding("UTF-8");
			writter = resp.getWriter();
			
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(TBL_Item.class, new TBL_ItemSerializer());
			gsonBuilder.registerTypeAdapter(TBL_Type.class, new TBL_TypeSerializer());
			gsonBuilder.setPrettyPrinting();
			gson = gsonBuilder.create();
			
			java.lang.reflect.Type typeOfSrc = new TypeToken<Collection<TBL_Item>>(){}.getType();
			
			writter.write(gson.toJson(listItem, typeOfSrc));
			
			writter.flush();
			writter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/getNumberPage", method = RequestMethod.GET)
	public void getNumberPage(HttpServletRequest req, HttpServletResponse resp){
		String size = req.getParameter("sizePagination");
		int sizePagination = Integer.parseInt(size);
		Gson gson = new Gson();
		PrintWriter writter;
		try {
			writter = resp.getWriter();
			int sizeReal = itemService.getSizeItem() % sizePagination == 0 ? itemService.getSizeItem() / sizePagination : itemService.getSizeItem() / sizePagination + 1;
			ResultObject result = new ResultObject("numberPage", sizeReal);
			writter.write(gson.toJson(result));
			
			writter.flush();
			writter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
	public void selectProduct(@PathVariable long id ,HttpServletRequest req, HttpServletResponse resp){
		Gson gson = new Gson();
		
		TBL_Item item = itemService.getItemByID(id);
		
		PrintWriter writter;
		try {
			resp.setCharacterEncoding("UTF-8");
			writter = resp.getWriter();
			
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(TBL_Item.class, new TBL_ItemSerializer());
			gsonBuilder.registerTypeAdapter(TBL_Type.class, new TBL_TypeSerializer());
			gsonBuilder.setPrettyPrinting();
			gson = gsonBuilder.create();
			
			writter.write(gson.toJson(item));
			writter.flush();
			writter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
