package com.csc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.csc.model.TBL_Rate;

public class RateDAOImpl implements RateDao{

	private SessionFactory sessionFactory;

	@Override
	public void insertRate(TBL_Rate rate) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(rate);
		tx.commit();
		session.close();
	}

	@Override
	public TBL_Rate getRate(long user_id, long deal_id) {
		Session session = getSessionFactory().openSession();
		TBL_Rate rate = (TBL_Rate) session.createQuery("from TBL_Rate where user_id=" + user_id + " and " + "deal_id=" + deal_id).uniqueResult();
		session.close();
		return rate;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Object> getNumberOfEachPoint(long deal_id) {
		Session session = getSessionFactory().openSession();
		List<Object> numberOfEachPoint = (List<Object>) session.createSQLQuery(
							"select rate_point, count(*)" 
									+ " from tbl_rate as rate" 
									+ " where deal_id=" + deal_id 
									+ " group by rate.deal_id, rate.rate_point").list();
		session.close();
		return numberOfEachPoint;
	}
}
