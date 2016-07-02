/*
 *
 * author : Nguyen Dong Hung 
 * 
 * 
*/
package com.csc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.csc.model.TBL_User;

@Repository
public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;

	@Override
	public List<TBL_User> getAllUser() {
		Session session = getSessionFactory().openSession();
		List<TBL_User> list = session.createQuery("from TBL_User ORDER BY TBL_User.user_id DESC").list();
		session.close();
		return list;
	}

	@Override
	public List<TBL_User> getByPaging(int start, int size) {
		Session session = getSessionFactory().openSession();
		List<TBL_User> list = session.createQuery("from TBL_User user ORDER BY user.user_id DESC").setFirstResult(start)
				.setMaxResults(size).list();
		session.close();
		return list;
	}

	@Override
	public int getSizeUser() {
		Session session = getSessionFactory().openSession();
		Integer size = (int) (long) session.createQuery("select count(*) from TBL_User").uniqueResult();
		session.close();
		return size;
	}

	@Override
	public void updateUser(TBL_User user) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(user);
		tx.commit();
		session.close();
	}

	@Override
	public Long insertUser(TBL_User user) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		try {

			Long user_id = ((TBL_User) session.createQuery(
					"from TBL_User us where (us.user_email = '" + user.getUser_email() + "' or  us.user_name = '"
							+ user.getUser_name() + "') and us.user_password = '" + user.getUser_password() + "'")
					.uniqueResult()).getUser_id();

			return user_id;
		} catch (org.hibernate.NonUniqueResultException e) {
			e.printStackTrace();
			List<TBL_User> users = session.createQuery(
					"from TBL_User us where (us.user_email = '" + user.getUser_email() + "' or  us.user_name = '"
							+ user.getUser_name() + "') and us.user_password = '" + user.getUser_password() + "'")
					.list();
			return users.get((users.size() - 1)).getUser_id();
		} finally {
			tx.commit();
			session.close();
		}
	}

	@Override
	public String deleteUser(Long user_id) {
		try {
			Session session = getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			TBL_User user = (TBL_User) session.get(TBL_User.class, user_id);
			session.delete(user);
			tx.commit();
			session.close();
			return "Done";
		} catch (org.hibernate.exception.ConstraintViolationException e) {
			return "Please make sure delete the order" ;
		}
	}

	@Override
	public TBL_User getUserByID(Long user_id) {
		Session session = getSessionFactory().openSession();
		TBL_User user = (TBL_User) session.get(TBL_User.class, user_id);
		session.close();
		return user;
	}

	@Override
	public TBL_User checkAccount(String account, String password) {
		try{
			Session session = getSessionFactory().openSession();
			List<TBL_User> users = session.createQuery("from TBL_User us where (us.user_email = '" + account
					+ "' or  us.user_name = '" + account + "') and us.user_password = '" + password + "'").list();
			
			if (users != null || users.size() != 0) {
				TBL_User user = users.get(0);
				System.out.println(user.toString());
				return user;
			} else {
				return null;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
