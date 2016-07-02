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

public class TBL_RoleSerializer implements JsonSerializer<TBL_Role>{

	@Override
	public JsonElement serialize(TBL_Role role, Type typeRole, JsonSerializationContext arg2) {
		 JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("role_id", role.getRole_id());
        jsonObject.addProperty("role_name", role.getRole_name());

        return jsonObject;
	}
	
	

}
