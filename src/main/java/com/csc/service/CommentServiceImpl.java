package com.csc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.csc.dao.CommentDAO;
import com.csc.model.TBL_Comment;

public class CommentServiceImpl implements CommentService{

	@Autowired
	@Qualifier("commentDAO")
	private CommentDAO commentDAO;
	
	@Override
	public void insertComment(TBL_Comment comment) {
		commentDAO.insertComment(comment);
	}

	@Override
	public List<TBL_Comment> getAllComment(long deal_id) {
		return commentDAO.getAllComment(deal_id);
	}

	@Override
	public TBL_Comment getCommentById(long comment_id) {
		return commentDAO.getCommentById(comment_id);
	}

}
