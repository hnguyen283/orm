/*
 *
 * author : Nguyen Dong Hung 
 * 
 * 
*/

package com.csc.test.user;

import static org.junit.Assert.assertEquals;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.csc.dao.UserDAOImpl;
import com.csc.model.TBL_User;

public class UserDAOTest {
	static UserDAOImpl userDAO = null;
	static SessionFactory sessionFactory = null;
	static Session session = null;
	static Query query = null;
	static List<TBL_User> listUser = null;
	static TBL_User user1 = null;
	static TBL_User user2 = null;
	

	@BeforeClass
	public static void beforeTestUserDAO() {
		System.out.println("Before UserDAO Test");
		sessionFactory = Mockito.mock(SessionFactory.class);
		session = Mockito.mock(Session.class);
		query = Mockito.mock(Query.class);
		
		listUser = new ArrayList<TBL_User>();
		user1 = new TBL_User();
		user1.setUser_id(1l);
		user1.setUser_name("admin");
		user1.setUser_password("admin");
		user1.setUser_phone("01643991604");
		user1.setUser_address("HCM");
		user1.setUser_email("admin@csc.com");

		user2 = new TBL_User();
		user2.setUser_id(2l);
		user2.setUser_name("admin2");
		user2.setUser_password("admin2");
		user2.setUser_phone("01643991605");
		user2.setUser_address("DN");
		user2.setUser_email("admin2@csc.com");

		listUser.add(user1);
		listUser.add(user2);

		userDAO = new UserDAOImpl();
		userDAO.setSessionFactory(sessionFactory);		
	}

	@AfterClass
	public static void afterTestUserDAO() {
		System.out.println("Tested UserDAO Test");
	}

	@Test
	public void testGetAllUser() {
		
		Mockito.when(sessionFactory.openSession()).thenReturn(session);
		Mockito.when(session.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(query.list()).thenReturn(listUser);

		userDAO = new UserDAOImpl();
		userDAO.setSessionFactory(sessionFactory);
		
		// Excute
		List<TBL_User> result = userDAO.getAllUser();

		// check

		Assert.assertEquals(2, result.size());
		Assert.assertEquals("admin", result.get(0).getUser_name());
		Assert.assertEquals("admin2", result.get(1).getUser_name());
	}
	
	@Test
	public void testGetByPaging() {
		int start = 0;
		int size = 1;
		
		Mockito.when(sessionFactory.openSession()).thenReturn(session);
		Mockito.when(session.createQuery(Mockito.anyString())).thenReturn(query);		
		Mockito.when(query.setFirstResult(start)).thenReturn(query);
		Mockito.when(query.setFirstResult(start).setMaxResults(size)).thenReturn(query);
		Mockito.when(query.setFirstResult(start).setMaxResults(size).list()).thenReturn(listUser.subList(start, size));
		// Excute
		List<TBL_User> result = userDAO.getByPaging(start, size);

		// check

		Assert.assertEquals(1, result.size());
		Assert.assertEquals("admin", result.get(0).getUser_name());
	}

	@Test
	public void testGetSizeUser() {
		long size = listUser.size();
		
		Mockito.when(sessionFactory.openSession()).thenReturn(session);
		Mockito.when(session.createQuery(Mockito.anyString())).thenReturn(query);		
		Mockito.when(query.uniqueResult()).thenReturn(size);
		// Excute
		int result = userDAO.getSizeUser();

		// check

		Assert.assertEquals(2, result);
	}
	
}
