/*
 *
 * author : Nguyen Dong Hung 
 * 
 * 
*/
package com.csc.model;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class TBL_ItemSerializer implements JsonSerializer<TBL_Item>{

	@Override
	public JsonElement serialize(TBL_Item item, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("item_id", item.getItem_id());
		jsonObject.addProperty("item_name", item.getItem_name());
		jsonObject.addProperty("item_owner", item.getItem_owner());
		jsonObject.addProperty("item_description", item.getItem_description());
		jsonObject.addProperty("item_describe", item.getItem_describe());

		JsonElement jsonType = context.serialize(item.getTbl_type());
		jsonObject.add("tbl_type", jsonType);
		
		return jsonObject;
	}

}
