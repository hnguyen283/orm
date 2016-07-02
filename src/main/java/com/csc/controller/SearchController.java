/*
 *
 * author : Nguyen Dong Hung 
 * 
 * 
*/
package com.csc.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.csc.model.ImageDeal;
import com.csc.model.TBL_Deal;
import com.csc.model.TBL_User;
import com.csc.service.DealService;
import com.google.gson.Gson;

//import model.Student;

@Controller
@RequestMapping("/search")
public class SearchController {

	@Autowired
	@Qualifier("dealService")
	DealService dealService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String search(ModelMap model, HttpServletRequest request, @RequestParam("search_content") String value) {
		String[] searchString = value.split(" ");
		List<TBL_Deal> deals = new ArrayList<TBL_Deal>();
		for(String element : searchString){
			System.out.println("element : " + element);
			List<TBL_Deal> dealsTemp = dealService.searchDealByName(element);
			System.out.println(dealsTemp.size());
			for(TBL_Deal deal : dealsTemp){
				System.out.println(deal.getDeal_id() + " / " + deals.contains(deal));
				if(!deals.contains(deal)){
					deals.add(deal);
				}
			}
		}
		List<ImageDeal> images = new ArrayList<ImageDeal>();

		for (TBL_Deal deal : deals) {
			ImageDeal imageDeal = new ImageDeal();
			File folder = new File(request.getSession().getServletContext().getRealPath("/") + "resources\\image\\"
					+ deal.getDeal_id());
			String[] nameOfFiles = folder.list();
			imageDeal.setDeal_id(deal.getDeal_id());
			imageDeal.setImage_name(nameOfFiles);
			imageDeal.setDeal(deal);
			images.add(imageDeal);
		}

		model.addAttribute("images", images);
		return "searchresult";
	}
}
