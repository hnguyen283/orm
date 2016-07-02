package com.csc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.csc.model.TBL_Item;
import com.csc.model.TBL_Type;

public class ItemDAOImpl implements ItemDAO{

	private SessionFactory sessionFactory;
	
	@Override
	public List<TBL_Item> getAllItem() {
		Session session = getSessionFactory().openSession();
		List<TBL_Item>listItem = session.createQuery("from TBL_Item item ORDER BY item.item_id DESC").list();
		session.close();
		return listItem;
	}

	@Override
	public List<TBL_Item> getPaginationItem(int start, int size) {
		Session session = getSessionFactory().openSession();
		List<TBL_Item>listItem = session.createQuery("from TBL_Item item ORDER BY item.item_id DESC")
											.setFirstResult(start)
											.setMaxResults(size)
											.list();
		session.close();
		return listItem;
	}
	
	@Override
	public int getSizeItem() {
		Session session = getSessionFactory().openSession();
		Integer sizeItem = (int) (long) session.createQuery("select count(*) from TBL_Item").uniqueResult();
		session.close();
		return sizeItem;
	}
	
	@Override
	public void updateItem(TBL_Item item) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(item);
		tx.commit();
		session.close();
	}

	@Override
	public void insertItem(TBL_Item item) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(item);
		tx.commit();
		session.close();
	}

	@Override
	public String deleteItem(long item_id) {
		try{
			Session session = getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			TBL_Item item = (TBL_Item) session.get(TBL_Item.class, item_id);
			session.delete(item);
			tx.commit();
			session.close();
			return "Done";
		}catch(org.hibernate.exception.ConstraintViolationException e){
			return "Can't delete product";
		}
	}

	@Override
	public TBL_Item getItemByID(long item_id) {
		Session session = getSessionFactory().openSession();
		TBL_Item item = (TBL_Item) session.get(TBL_Item.class, item_id);
		session.close();
		return item;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<TBL_Item> getItemByType(TBL_Type type) {
		Session session = getSessionFactory().openSession();
		List<TBL_Item> items = session.createQuery("from TBL_Item i where i.type_id = " + type.getType_id()).list();
		session.close();
		return items;
	}

}
