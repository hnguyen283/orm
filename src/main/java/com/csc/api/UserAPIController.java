/*
 *
 * author : Nguyen Dong Hung 
 * 
 * 
*/
package com.csc.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csc.model.ResultObject;
import com.csc.model.TBL_Role;
import com.csc.model.TBL_RoleSerializer;
import com.csc.model.TBL_User;
import com.csc.model.TBL_UserSerializer;
import com.csc.service.RoleService;
import com.csc.service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@Controller
@RequestMapping("/api/user")
public class UserAPIController {

	@Autowired
	@Qualifier("userService")
	UserService userService;

	@Autowired
	@Qualifier("roleService")
	RoleService roleService;

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public void getUser(HttpServletRequest request, HttpServletResponse response) {
		Gson gson = new Gson();
		List<TBL_User> listUser = userService.getAllUser();
		PrintWriter writter;
		try {
			response.setCharacterEncoding("UTF-8");
			writter = response.getWriter();

			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(TBL_User.class, new TBL_UserSerializer());
			gsonBuilder.registerTypeAdapter(TBL_Role.class, new TBL_RoleSerializer());
			gsonBuilder.setPrettyPrinting();
			gson = gsonBuilder.create();

			java.lang.reflect.Type typeOfSrc = new TypeToken<Collection<TBL_User>>() {
			}.getType();

			writter.write(gson.toJson(listUser, typeOfSrc));

			writter.flush();
			writter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/getuserpaging", method = RequestMethod.POST)
	public void getUserPaging(HttpServletRequest request, HttpServletResponse response) {
		Gson gson = new Gson();
		List<TBL_User> listUser = userService.getByPaging(Integer.parseInt(request.getParameter("startid")),
				Integer.parseInt(request.getParameter("sizepage")));
		PrintWriter writter;
		try {
			response.setCharacterEncoding("UTF-8");
			writter = response.getWriter();

			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(TBL_User.class, new TBL_UserSerializer());
			gsonBuilder.registerTypeAdapter(TBL_Role.class, new TBL_RoleSerializer());
			gsonBuilder.setPrettyPrinting();
			gson = gsonBuilder.create();

			java.lang.reflect.Type typeOfSrc = new TypeToken<Collection<TBL_User>>() {
			}.getType();

			writter.write(gson.toJson(listUser, typeOfSrc));

			writter.flush();
			writter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/getNumberPage", method = RequestMethod.POST)
	public void getNumberPage(HttpServletRequest request, HttpServletResponse response) {
		Gson gson = new Gson();
		String size = request.getParameter("sizePagination");
		int sizePagination = Integer.parseInt(size);
		int numberPage = userService.getSizeUser() % sizePagination == 0 ? userService.getSizeUser() / sizePagination
				: userService.getSizeUser() / sizePagination + 1;
		PrintWriter writter;
		try {
			response.setCharacterEncoding("UTF-8");
			writter = response.getWriter();

			writter.write(gson.toJson(new ResultObject("numberpage", numberPage)));

			writter.flush();
			writter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/getnumberuser", method = RequestMethod.POST)
	public void getNumberUser(HttpServletRequest request, HttpServletResponse response) {
		Gson gson = new Gson();
		int numberUser = userService.getSizeUser();
		PrintWriter writter;
		try {
			response.setCharacterEncoding("UTF-8");
			writter = response.getWriter();

			writter.write(gson.toJson(new ResultObject("numberuser", numberUser)));

			writter.flush();
			writter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@RequestMapping(value = "/getbyid", method = RequestMethod.POST)
	public void getUserById(HttpServletRequest request, HttpServletResponse response) {
		Gson gson = new Gson();
		TBL_User user = userService.getUserByID(Long.parseLong(request.getParameter("user_id")));
		PrintWriter writter;
		try {
			response.setCharacterEncoding("UTF-8");
			writter = response.getWriter();

			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(TBL_User.class, new TBL_UserSerializer());
			gsonBuilder.registerTypeAdapter(TBL_Role.class, new TBL_RoleSerializer());
			gsonBuilder.setPrettyPrinting();
			gson = gsonBuilder.create();

			writter.write(gson.toJson(user));

			writter.flush();
			writter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void deleleOrder(HttpServletRequest request, HttpServletResponse response) {
		String[] listUser = request.getParameterValues("listUserId");
		if (listUser != null) {
			String [] temp = new String[listUser.length];
			for (int i = 0; i < listUser.length;i++) {
				temp[i] = userService.deleteUser(Long.parseLong(listUser[i]));
			}

			Gson gson = new Gson();
			PrintWriter writter;
			try {
				writter = response.getWriter();
//				ResultObject result = new ResultObject("success", "delete successflly!");
				writter.write(gson.toJson(temp));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			Gson gson = new Gson();
			PrintWriter writter;
			try {
				writter = response.getWriter();
				ResultObject result = new ResultObject("success", "Have not anything to delete!");
				writter.write(gson.toJson(result));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public void addUser(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter writter;
		Gson gson = new Gson();
		try {
			TBL_User user = new TBL_User();

			String role_name = request.getParameter("role_name_input");
			TBL_Role role = roleService.getRoleByName(role_name);
			user.setTbl_role(role);

			user.setUser_name(request.getParameter("user_name"));
			user.setUser_password(request.getParameter("user_password"));
			user.setUser_address(request.getParameter("user_address"));
			user.setUser_email(request.getParameter("user_email"));
			user.setUser_phone(request.getParameter("user_phone"));
			user.setUser_status(request.getParameter("user_status_input"));
			user.setUser_email2(request.getParameter("user_email2"));
			user.setUser_phone2(request.getParameter("user_phone2"));

			user.setUser_id(userService.insertUser(user));

			response.setCharacterEncoding("UTF-8");
			writter = response.getWriter();

			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(TBL_Role.class, new TBL_RoleSerializer());
			gson = gsonBuilder.create();

			ResultObject result = new ResultObject("success", user);

			writter.write(gson.toJson(result));

		} catch (Exception e) {
			e.printStackTrace();
			try {
				writter = response.getWriter();
				ResultObject result = new ResultObject("failed", e.getMessage());
				writter.write(gson.toJson(result));

			} catch (IOException ec) {
				// TODO Auto-generated catch block
				ec.printStackTrace();
			}
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void updateUser(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter writter;
		Gson gson = new Gson();
		try {

			TBL_User user = new TBL_User();

			String role_name = request.getParameter("role_name_input");
			TBL_Role role = roleService.getRoleByName(role_name);
			user.setTbl_role(role);

			user.setUser_id(Long.valueOf(request.getParameter("user_id")));
			user.setUser_name(request.getParameter("user_name"));
			user.setUser_password(request.getParameter("user_password"));
			user.setUser_address(request.getParameter("user_address"));
			user.setUser_email(request.getParameter("user_email"));
			user.setUser_phone(request.getParameter("user_phone"));
			user.setUser_status(request.getParameter("user_status_input"));
			user.setUser_email2(request.getParameter("user_email2"));
			user.setUser_phone2(request.getParameter("user_phone2"));

			userService.updateUser(user);

			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(TBL_Role.class, new TBL_RoleSerializer());
			gson = gsonBuilder.create();

			response.setCharacterEncoding("UTF-8");
			writter = response.getWriter();

			ResultObject result = new ResultObject("success", user);

			writter.write(gson.toJson(result));

		} catch (Exception e) {
			e.printStackTrace();
			try {
				writter = response.getWriter();

				ResultObject result = new ResultObject("failed", e.getMessage());
				writter.write(gson.toJson(result));
			} catch (IOException ec) {
				// TODO Auto-generated catch block
				ec.printStackTrace();
			}
		}

	}

	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	public void checkLogin(HttpServletRequest req, HttpServletResponse resp) {
		try {
			Gson gson = new Gson();
			PrintWriter writter = resp.getWriter();

			HttpSession session = req.getSession();
			Long user_id = (Long) session.getAttribute("user_id");
			if (user_id == null) {
				ResultObject result = new ResultObject("fail", "not yet");
				writter.write(gson.toJson(result));
			} else {
				ResultObject result = new ResultObject("success", "logined");
				writter.write(gson.toJson(result));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(HttpServletRequest req, HttpServletResponse resp) {
		try {
			Gson gson = new Gson();
			String account = req.getParameter("account");
			String password = req.getParameter("password");

			TBL_User user = userService.checkAccount(account, password);

			ResultObject result = new ResultObject();
			if (user != null) {
				TBL_Role role = new TBL_Role();
				role.setRole_id(user.getTbl_role().getRole_id());
				role.setRole_name(user.getTbl_role().getRole_name());

				user.setTbl_role(role);
				user.setTbl_items(null);
				user.setTbl_orders(null);
				result.setResult("success");
				result.setDetail(user);
				HttpSession session = req.getSession();
				session.setAttribute("userId", user.getUser_id());
				session.setAttribute("userName", user.getUser_name());
				session.setAttribute("userRole", user.getTbl_role().getRole_name());
				session.setAttribute("user_id", user.getUser_id());
			} else {
				result.setResult("failed");
				result.setDetail("Account and Password mismatch");
			}

			resp.setCharacterEncoding("UTF-8");
			PrintWriter writter = resp.getWriter();
			writter.write(gson.toJson(result));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout(HttpServletRequest req, HttpServletResponse resp) {
		Gson gson = new Gson();
		ResultObject result = new ResultObject();
		PrintWriter writter;
		try {
			HttpSession session = req.getSession();

			session.invalidate();

			result.setResult("success");
			result.setDetail("done for log-out");
			resp.setCharacterEncoding("UTF-8");
			writter = resp.getWriter();

			writter.write(gson.toJson(result));

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
