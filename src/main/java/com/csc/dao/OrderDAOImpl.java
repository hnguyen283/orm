package com.csc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.csc.model.*;

public class OrderDAOImpl implements OrderDAO {
	private SessionFactory sessionFactory;

	@Override
	public void create(TBL_Order order) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(order);
		tx.commit();
		session.close();
		
	}

	@Override
	public void update(TBL_Order order) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(order);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(long order_id) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		TBL_Order order = (TBL_Order) session.get(TBL_Order.class, order_id);
		for (TBL_OrderDetail orderDetail : order.getListOrderDetail()) {
			session.delete(orderDetail);
		}
		session.delete(order);
		tx.commit();
		session.close();
	}

	@Override
	public List<TBL_Order> get() {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		
		List<TBL_Order> result = session.createQuery("from TBL_Order").list();
		session.close();
		return result;
	}

	@Override
	public TBL_Order select(long order_id) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		TBL_Order order = (TBL_Order) session.get(TBL_Order.class, order_id);
		session.close();
		
		return order;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}
