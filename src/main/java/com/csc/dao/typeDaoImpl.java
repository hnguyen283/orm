package com.csc.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.csc.model.TBL_Type;
import com.csc.service.ItemService;
import com.csc.model.TBL_Item;



public class typeDaoImpl implements typeDAO {
	
    ItemService item;
	private SessionFactory sessionFactory;
	
	
	@Override
	public int numberOfProduct(Long id) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		TBL_Type type = (TBL_Type) session.get(TBL_Type.class, id);
		List<TBL_Item> count = item.getItemsByType(type);
		session.close();
		return count.size();
	}
	
	
	@Override
	public TBL_Type gettypeByID(Long id) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		TBL_Type type = (TBL_Type) session.get(TBL_Type.class, id);
		session.close();
		return type;
		
		
	}
	@Override
	public void deleteType(Long id) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		TBL_Type type = (TBL_Type) session.get(TBL_Type.class, id);
		session.delete(type);
		tx.commit();
		session.close();
	}

	@Override
	public List<TBL_Type> getallType() {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
        List<TBL_Type> list = session.createQuery("from TBL_Type").list();
        session.close();
        return list;
		
	}

	@Override
	public void updateType(TBL_Type type) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(type);
        tx.commit();
        session.close();
	}

	@Override
	public void insertType(TBL_Type type) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(type);
        tx.commit();
        session.close();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
