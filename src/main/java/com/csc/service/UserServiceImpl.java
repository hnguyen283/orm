/*
 *
 * author : Nguyen Dong Hung 
 * 
 * 
*/
package com.csc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.csc.dao.RoleDAO;
import com.csc.dao.UserDAO;
import com.csc.model.TBL_Role;
import com.csc.model.TBL_User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userDAO")
	private UserDAO userDao;

	@Autowired
	@Qualifier("roleDAO")
	private RoleDAO roleDao;

	@Override
	public List<TBL_User> getAllUser() {
		return userDao.getAllUser();
	}
	
	

	@Override
	public List<TBL_User> getByPaging(int start, int size) {
		return userDao.getByPaging(start, size);
	}

	@Override
	public int getSizeUser() {
		return userDao.getSizeUser();
	}


	@Override
	public void updateUser(TBL_User user) {
		userDao.updateUser(user);
	}

	@Override
	public Long insertUser(TBL_User user) {
		return userDao.insertUser(user);
	}

	@Override
	public String deleteUser(Long user_id) {
		return userDao.deleteUser(user_id);
	}

	@Override
	public TBL_User getUserByID(Long user_id) {
		// TODO Auto-generated method stub
		return userDao.getUserByID(user_id);
	}

	@Override
	public TBL_User checkAccount(String account, String password) {
		// TODO Auto-generated method stub
		return userDao.checkAccount(account, password);
	}

	
}
