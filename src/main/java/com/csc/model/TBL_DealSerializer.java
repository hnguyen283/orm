/*
 *
 * author : Nguyen Dong Hung 
 * 
 * 
*/
package com.csc.model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class TBL_DealSerializer implements JsonSerializer<TBL_Deal> {

	public static HttpServletRequest getRequest() {
		return request;
	}

	public static void setRequest(HttpServletRequest request) {
		TBL_DealSerializer.request = request;
	}

	private static HttpServletRequest request;

	@Override
	public JsonElement serialize(TBL_Deal deal, Type typeOfSrc, JsonSerializationContext context) {

		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("deal_id", String.valueOf(deal.getDeal_id()));
		jsonObject.addProperty("deal_owner", deal.getDeal_owner());
		jsonObject.addProperty("deal_description", deal.getDeal_description());
		jsonObject.addProperty("deal_begin", String.valueOf(deal.getDeal_begin().toString()));
		jsonObject.addProperty("deal_end", String.valueOf(deal.getDeal_end().toString()));
		jsonObject.addProperty("deal_price", String.valueOf(deal.getDeal_price()));
		jsonObject.addProperty("deal_discount", String.valueOf(deal.getDeal_discount()));
		jsonObject.addProperty("deal_amount", String.valueOf(deal.getDeal_amount()));
		jsonObject.addProperty("deal_acceptable", String.valueOf(deal.getDeal_acceptable()));
		jsonObject.addProperty("deal_status", deal.getDeal_status());

		Date date = new Date();
		Long days = TimeUnit.DAYS.convert(deal.getDeal_end().getTime() - date.getTime(), TimeUnit.MILLISECONDS);
		System.out.println(days);
		jsonObject.addProperty("day_left", String.valueOf(days));

		ImageDeal imageDeal = new ImageDeal();
		File folder = new File(
				request.getSession().getServletContext().getRealPath("/") + "resources\\image\\" + deal.getDeal_id());
		if (!folder.exists()) {
			System.out.println(folder.getPath());
			jsonObject.add("image_deal", null);
		} else {
			String[] nameOfFiles = folder.list();
			int[] witdhOfImages = new int[nameOfFiles.length];
			int[] heightOfImages = new int[nameOfFiles.length];

			System.out.println(deal.getDeal_id());
			for (int i = 0; i < nameOfFiles.length; i++) {
				BufferedImage img = null;
				try {
					img = ImageIO.read(new File(folder + "\\" + nameOfFiles[i]));
				} catch (IOException e) {
					e.printStackTrace();
				}
				witdhOfImages[i] = img.getWidth();
				heightOfImages[i] = img.getHeight();

			}
			imageDeal.setDeal_id(deal.getDeal_id());
			imageDeal.setNumber(nameOfFiles.length);
			imageDeal.setImage_name(nameOfFiles);
			imageDeal.setImage_witdh(witdhOfImages);
			imageDeal.setImage_height(heightOfImages);
			JsonElement jsonImage = context.serialize(imageDeal);
			jsonObject.add("image_deal", jsonImage);
		}		

		JsonElement jsonItem = context.serialize(deal.getTbl_item());
		jsonObject.add("tbl_item", jsonItem);

		return jsonObject;
	}

}
