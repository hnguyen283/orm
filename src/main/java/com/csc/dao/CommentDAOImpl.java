package com.csc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.csc.model.TBL_Comment;

public class CommentDAOImpl implements CommentDAO{
	
	private SessionFactory sessionFactory;
	
	@Override
	public void insertComment(TBL_Comment comment) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(comment);
		tx.commit();
		session.close();
	}
	
	@Override
	public List<TBL_Comment> getAllComment(long deal_id) {
		Session session = getSessionFactory().openSession();
		List<TBL_Comment> listComment = session.createQuery("from TBL_Comment where deal_id = " + deal_id).list();
		session.close();
		return listComment;
	}
	
	@Override
	public TBL_Comment getCommentById(long comment_id) {
		Session session = getSessionFactory().openSession();
		TBL_Comment comment = (TBL_Comment) session.get(TBL_Comment.class, comment_id);
		session.close();
		return comment;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
