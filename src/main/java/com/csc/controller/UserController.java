/*
 *
 * author : Nguyen Dong Hung 
 * 
 * 
*/
package com.csc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csc.model.ResultObject;
import com.csc.model.TBL_Item;
import com.csc.model.TBL_Role;
import com.csc.model.TBL_RoleSerializer;
import com.csc.model.TBL_User;
import com.csc.service.ItemService;
import com.csc.service.RoleService;
import com.csc.service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/admin")
public class UserController {

	@Autowired
	@Qualifier("userService")
	UserService userService;

	@Autowired
	@Qualifier("roleService")
	RoleService roleService;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String AdminUser(ModelMap model) {
		
		List<TBL_Role> roles = roleService.getAllRole();		
		
		model.addAttribute("roles", roles);
		model.put("title", "User Management");
		return "admin/user";
	}

}
