/*
 *
 * author : Nguyen Dong Hung 
 * 
 * 
*/
package com.csc.model;

import java.lang.reflect.Type;

import javax.management.relation.Role;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class TBL_UserSerializer implements JsonSerializer<TBL_User> {

	@Override
	public JsonElement serialize(TBL_User user, Type typeUser, JsonSerializationContext context) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("user_id", String.valueOf(user.getUser_id()));
		jsonObject.addProperty("user_name", user.getUser_name());
		jsonObject.addProperty("user_password", user.getUser_password());
		jsonObject.addProperty("user_address", user.getUser_address());
		jsonObject.addProperty("user_email", user.getUser_email());
		jsonObject.addProperty("user_phone", user.getUser_phone());
		jsonObject.addProperty("user_email2", user.getUser_email2());
		jsonObject.addProperty("user_phone2", user.getUser_phone2());
		jsonObject.addProperty("user_status", user.getUser_status());		
		JsonElement jsonRole = context.serialize(user.getTbl_role());
		jsonObject.add("tbl_role", jsonRole);

		return jsonObject;
	}

}
