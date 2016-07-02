/*
 *
 * author : Nguyen Dong Hung, Nguyen Hong Nhut
 * 
 * 
*/
package com.csc.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;

import com.csc.model.ResultObject;
import com.csc.model.TBL_Deal;
import com.csc.model.TBL_Item;
import com.csc.model.TBL_Type;
import com.csc.model.TBL_User;
import com.csc.service.ItemService;

public class DealDAOImpl implements DealDAO {

	private SessionFactory sessionFactory;
	private String STATUS_ACTIVE = "where deal.deal_status = 'ACTIVE'";

	@Override
	public List<TBL_Deal> allDealSort(String element, int start, int size, String sortBy, String status) {
		String sqlWhere = "";
		if (status != null) {
			switch (status) {
			case "ACTIVE":
				sqlWhere = this.STATUS_ACTIVE;
				break;
			default:
				sqlWhere = "";
				break;
			}
		} else {
			sqlWhere = "";
		}
		Session session = getSessionFactory().openSession();
		List<TBL_Deal> listDeal = session
				.createQuery("from TBL_Deal deal " + sqlWhere + " ORDER BY deal." + element + " " + sortBy)
				.setFirstResult(start).setMaxResults(size).list();
		session.close();
		return listDeal;
	}

	@Override
	public List<TBL_Deal> getDealbyType(Long id) {
		// TODO Auto-generated method stub
		String q2 = "SELECT deal From TBL_Deal as deal INNER JOIN deal.tbl_item as item INNER JOIN item.tbl_type as type where type.type_id = "
				+ id;
		Session session = getSessionFactory().openSession();
		List<TBL_Deal> list = session.createQuery(q2).list();
		session.close();
		return list;
	}

	@Override
	public int getSizeDeal() {
		Session session = getSessionFactory().openSession();
		Integer size = (int) (long) session.createQuery("select count(*) from TBL_Deal").uniqueResult();
		session.close();
		return size;
	}

	@Override
	public int getSizeDealByType(Long id) {
		Session session = getSessionFactory().openSession();
		Integer size = (int) (long) session.createQuery(
				"select count(*) from TBL_Deal as deal INNER JOIN deal.tbl_item as item INNER JOIN item.tbl_type as type where type.type_id = "
						+ id)
				.uniqueResult();
		session.close();
		return size;
	}

	@Override
	public List<TBL_Deal> getDealbyItem(Long item_id) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		List<TBL_Deal> list = session.createQuery("From TBL_Deal where item_id = " + item_id).list();
		session.close();
		return list;
	}

	@Override
	public List<TBL_User> getListUser(TBL_Deal deal) {
		// TODO Auto-generated method stub
		String q = "SELECT user From TBL_User as user " + " INNER JOIN user.tbl_orders as order1 "
				+ " INNER JOIN order1.listOrderDetail as orderdetail " + " INNER JOIN orderdetail.tbl_deal as deal"
				+ " where deal.deal_id  = " + deal.getDeal_id();

		Session session = getSessionFactory().openSession();
		List<TBL_User> list = session.createQuery(q).list();
		session.close();
		return list;

	}

	@Override
	public TBL_Deal insertDeal(TBL_Deal deal) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(deal);
		tx.commit();
		session.close();

		return deal;
	}

	@Override
	public void deleteDeal(long dealId) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		TBL_Deal deal = (TBL_Deal) session.get(TBL_Deal.class, dealId);
		session.delete(deal);
		tx.commit();
		session.close();
	}

	@Override
	public void updateDeal(TBL_Deal deal) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(deal);
		tx.commit();
		session.close();
	}

	@Override
	public List<TBL_Deal> allDeal() {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		List<TBL_Deal> list = session.createQuery("from TBL_Deal").list();
		session.close();
		return list;

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public TBL_Deal getDealById(Long id) {
		Session session = getSessionFactory().openSession();
		TBL_Deal deal = (TBL_Deal) session.get(TBL_Deal.class, id);
		session.close();
		return deal;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<TBL_Deal> searchDealByName(String name) {
		Session session = getSessionFactory().openSession();

		String hql = "from TBL_Deal where deal_description like :keyword";

		Query query = session.createQuery(hql);
		query.setParameter("keyword", "%" + name + "%");

		List<TBL_Deal> list = query.list();
		session.close();
		return list;
	}

	@Override
	public List<TBL_Deal> getPaginationDeal(int start, int size) {
		Session session = getSessionFactory().openSession();
		List<TBL_Deal> listDeal = session.createQuery("from TBL_Deal deal order by deal.deal_id DESC")
				.setFirstResult(start).setMaxResults(size).list();
		session.close();
		return listDeal;
	}

	@Override
	public List<TBL_Deal> allDealSortByType(String element, int start, int size, String sortBy, Long id) {
		Session session = getSessionFactory().openSession();
		List<TBL_Deal> listDeal = session
				.createQuery(
						"select deal from TBL_Deal as deal INNER JOIN deal.tbl_item as item INNER JOIN item.tbl_type as type where type.type_id = "
								+ id + " ORDER BY deal." + element + " " + sortBy)
				.setFirstResult(start).setMaxResults(size).list();
		session.close();
		return listDeal;
	}

	@Override
	public List<ResultObject> getDataDraw(String labels, String type) {
		Session session = getSessionFactory().openSession();
		ArrayList<ResultObject> listData = new ArrayList<ResultObject>();
		// List<Object[]> results = session.createSQLQuery("SELECT * FROM
		// tbl_deal JOIN tbl_item on tbl_deal.item_id = tbl_item.item_id JOIN
		// tbl_type on tbl_item.type_id = tbl_type.type_id GROUP BY
		// tbl_item.type_id").addEntity("tbl_deal",TBL_Deal.class).addEntity("tbl_type",TBL_Type.class).addEntity("tbl_item",TBL_Item.class).list();
		List<Object[]> results = session
				.createSQLQuery(
						"SELECT tbl_type.type_name,count(tbl_deal.deal_id) FROM tbl_deal JOIN tbl_item on tbl_deal.item_id = tbl_item.item_id  JOIN tbl_type on tbl_item.type_id = tbl_type.type_id  GROUP BY tbl_item.type_id")
				.list();
		results.stream().forEach((record) -> {
			String typeName = (String) record[0];
			BigInteger count = (BigInteger) record[1];
			System.out.println(typeName + " / " + count.intValue());
			listData.add(new ResultObject(typeName, count.intValue()));
		});
		System.out.println(listData.size());
		session.close();
		return listData;
	}

}
