package com.csc.api;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.csc.service.TypeService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/api/type")
public class TypeAPIController {
	
	@Autowired
	@Qualifier("typeService")
	TypeService typeService;
	
	@RequestMapping(value = "/addtype", method = RequestMethod.POST)
	public void addType(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter writter;
		try {
			TBL_Type type = new TBL_Type();
			type.setType_name(request.getParameter("type_name"));
			type.setType_icon(request.getParameter("type_icon"));
			type.setType_description(request.getParameter("type_description"));
			response.setCharacterEncoding("UTF-8");
			typeService.insertType(type);
			writter = response.getWriter();
			Gson gson = new Gson();
			ResultObject result = new ResultObject("success", type);

			writter.write(gson.toJson(result));		

		} catch (Exception e) {
			e.printStackTrace();
			try {
				writter = response.getWriter();
				ResultObject result = new ResultObject("failed", e.getMessage());
			} catch (IOException ec) {
				// TODO Auto-generated catch block
				ec.printStackTrace();
				ResultObject result = new ResultObject("failed",
						"error1: " + e.getMessage() + "; error2: " + ec.getMessage());
			}
			}
		}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void updateType(HttpServletRequest req, HttpServletResponse resp) {
		PrintWriter writter;
		Gson gson;
		try {
			writter = resp.getWriter();
			gson = new Gson();
			
			if (req.getParameter("type_id") != null && !req.getParameter("type_id").isEmpty()) {
				TBL_Type type = typeService.gettypeByID(Long.parseLong(req.getParameter("type_id")));

				type.setType_name(req.getParameter("type_name"));
				type.setType_icon(req.getParameter("type_icon"));
				type.setType_description(req.getParameter("type_description"));
				
				typeService.updateType(type);

				ResultObject result = new ResultObject("success", type);
				writter.write(gson.toJson(result));
			}else {
				ResultObject result = new ResultObject("failed", "No type ID");
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
	public void deleleType(HttpServletRequest req, HttpServletResponse resp) {
		String[] listType = req.getParameterValues("listTypeId");

		for (String type : listType) {
			typeService.deleteType(Long.parseLong(type));
		}

		Gson gson = new Gson();
		PrintWriter writter;
		try {
			writter = resp.getWriter();

			ResultObject result = new ResultObject("success", "delete successfully!");
			writter.write(gson.toJson(result));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public void getType(HttpServletRequest req, HttpServletResponse resp) {
		resp.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		List<TBL_Type> listType = typeService.getallType();
		
		
		PrintWriter writter;
		try {
			writter = resp.getWriter();
			resp.setCharacterEncoding("UTF-8");
			writter.write(gson.toJson(listType));
			writter.flush();
			writter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
	public void selectType(@PathVariable long id, HttpServletRequest req, HttpServletResponse resp){
		TBL_Type type = typeService.gettypeByID(id);
		Gson gson = new Gson();
		ResultObject result = new ResultObject();
		resp.setCharacterEncoding("UTF-8");
		if(type != null){
			result.setResult("success");
			result.setDetail(type);
		}else {
			result.setResult("FAILED");
			result.setDetail("Error on select Type");
		}
		
		try {
			PrintWriter writter = resp.getWriter();
			
			writter.write(gson.toJson(result));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
