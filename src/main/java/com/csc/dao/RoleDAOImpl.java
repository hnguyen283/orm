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
import org.springframework.stereotype.Repository;

import com.csc.model.TBL_Rate;
import com.csc.model.TBL_Role;
import com.csc.model.TBL_User;

@Repository
public class RoleDAOImpl implements RoleDAO {

	private SessionFactory sessionFactory;
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<TBL_Role> getAllRole() {
		Session session = getSessionFactory().openSession();
		List<TBL_Role> list = session.createQuery("from TBL_Role").list();
		session.close();
		return list;
	}

	@Override
	public void updateRole(TBL_Role role) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertRole(TBL_Role role) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteRole(Integer role_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public TBL_Role getRoleByID(Integer role_id) {
		Session session = getSessionFactory().openSession();
		TBL_Role role = (TBL_Role) session.get(TBL_Role.class, role_id);
		session.close();
		return role;
	}

	@Override
	public TBL_Role getRoleByName(String role_name) {
		Session session = getSessionFactory().openSession();
		TBL_Role role = (TBL_Role) session.createQuery("from TBL_Role where role_name='" + role_name + "'" ).uniqueResult();
		session.close();
		return role;
	}
	
	

}
