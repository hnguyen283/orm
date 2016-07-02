/*
 *
 * author : Nguyen Dong Hung 
 * 
 * 
*/
package com.csc.model;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class ImageDealSerializer implements JsonSerializer<ImageDeal> {

	@Override
	public JsonElement serialize(ImageDeal image, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("number", String.valueOf(image.getNumber()));

		JsonArray jsonImageName = new JsonArray();
		for (String image_name : image.getImage_name()) {
			JsonPrimitive jsonitem = new JsonPrimitive(image_name);
			jsonImageName.add(jsonitem);
		}
		jsonObject.add("image_name", jsonImageName);

		JsonArray jsonImageWitdh = new JsonArray();
		for (int image_witdh : image.getImage_witdh()) {
			JsonPrimitive jsonitem = new JsonPrimitive(image_witdh);
			jsonImageWitdh.add(jsonitem);
		}
		jsonObject.add("image_witdh", jsonImageWitdh);

		JsonArray jsonImageHeight = new JsonArray();
		for (int image_height : image.getImage_height()) {
			JsonPrimitive jsonitem = new JsonPrimitive(image_height);
			jsonImageHeight.add(jsonitem);
		}
		jsonObject.add("image_height", jsonImageHeight);
		
		return jsonObject;
	}

}
