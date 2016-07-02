package com.csc.api;

import java.io.PrintWriter;
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
import com.csc.model.TBL_Comment;
import com.csc.model.TBL_User;
import com.csc.service.CommentService;
import com.csc.service.DealService;
import com.csc.service.UserService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/api/comment")
public class CommentAPIController {

	@Autowired
	@Qualifier("commentService")
	private CommentService commentService;
	
	@Autowired
	@Qualifier("dealService")
	private DealService dealService;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void createComment(HttpServletRequest req, HttpServletResponse resp){
		PrintWriter writter;
		Gson gson;
		HttpSession session = req.getSession();
		
		String deal_id = req.getParameter("deal_id");
		String comment_content = req.getParameter("comment_content");
		
		TBL_Comment comment = new TBL_Comment();
		try {
			writter = resp.getWriter();
			gson = new Gson();
			
			Long user_id = (Long) session.getAttribute("user_id");
			TBL_User user = (TBL_User) userService.getUserByID(user_id);
			
			comment.setComment_content(comment_content);
			comment.setTbl_deal(dealService.getDealById(Long.parseLong(deal_id)));
			comment.setTbl_user(user);
			
			commentService.insertComment(comment);
			
			resp.setCharacterEncoding("UTF-8");
			
			ResultObject object = new ResultObject("success insert comment", comment.getComment_id());
			writter.write(gson.toJson(object));
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				writter = resp.getWriter();
				gson = new Gson();
				ResultObject result = new ResultObject("failed", ex.getMessage());
				writter.write(gson.toJson(result));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public void getComment(HttpServletRequest req, HttpServletResponse resp){
		PrintWriter writter;
		Gson gson;
		try {
			gson = new Gson();
			String deal_id = (String) req.getParameter("deal_id");
			List<TBL_Comment> listComment = commentService.getAllComment(Long.parseLong(deal_id));
			
			for(TBL_Comment comment : listComment){
				comment.getTbl_user().getTbl_role().setTbl_users(null);
				comment.getTbl_user().setTbl_orders(null);
				comment.getTbl_user().setTbl_items(null);

				comment.getTbl_deal().setTbl_item(null);
			}
			
			resp.setCharacterEncoding("UTF-8");
			writter = resp.getWriter();

			 ResultObject result = new ResultObject("success", listComment);
			 writter.write(gson.toJson(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
