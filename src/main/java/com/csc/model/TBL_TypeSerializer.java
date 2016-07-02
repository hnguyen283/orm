package com.csc.model;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class TBL_TypeSerializer implements JsonSerializer<TBL_Type>{

	@Override
	public JsonElement serialize(TBL_Type type, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject jsonObject = new JsonObject();
		
		jsonObject.addProperty("type_id", type.getType_id());
		jsonObject.addProperty("type_name", type.getType_name());
		jsonObject.addProperty("type_description", type.getType_description());
		jsonObject.addProperty("type_icon", type.getType_icon());
		
		return jsonObject;
	}

}
