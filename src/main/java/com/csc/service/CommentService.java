package com.csc.service;

import java.util.List;

import com.csc.model.TBL_Comment;

public interface CommentService {
	public void insertComment(TBL_Comment comment);
	
	public List<TBL_Comment> getAllComment(long deal_id);
	
	public TBL_Comment getCommentById(long comment_id);
}
