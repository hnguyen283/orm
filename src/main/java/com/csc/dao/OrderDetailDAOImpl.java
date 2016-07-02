package com.csc.dao;

import java.util.List;

import org.hibernate.*;

import com.csc.model.TBL_OrderDetail;

public class OrderDetailDAOImpl implements OrderDetailDAO {
	private SessionFactory sessionFactory;

	@Override
	public void create(TBL_OrderDetail odDetail) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(odDetail);
		tx.commit();
		session.close();
	}

	@Override
	public void update(TBL_OrderDetail odDetail) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(odDetail);
		tx.commit();
		session.close();
	}
	
	

	@Override
	public void delete(long orderDetail_id) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		TBL_OrderDetail odd = (TBL_OrderDetail) session.get(TBL_OrderDetail.class, orderDetail_id);
		session.delete(odd);
		tx.commit();
		session.close();
	}

	@Override
	public List<TBL_OrderDetail> get(long orderId) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		List<TBL_OrderDetail> result = session.createQuery("from TBL_OrderDetail odD where odD.order_detail = "+orderId).list();
		session.close();
		return result;
	}

	@Override
	public TBL_OrderDetail select(long orderdetail_id) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		TBL_OrderDetail odd = (TBL_OrderDetail)session.get(TBL_OrderDetail.class, orderdetail_id);
		
		return odd;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}
