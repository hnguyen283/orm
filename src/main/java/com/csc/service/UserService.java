/*
 *
 * author : Nguyen Dong Hung 
 * 
 * 
*/
package com.csc.service;

import java.util.List;

import com.csc.model.TBL_User;

public interface UserService {

	public List<TBL_User> getAllUser();
	
	public List<TBL_User> getByPaging(int start, int size);

	public void updateUser(TBL_User user);

	public Long insertUser(TBL_User user);

	public String deleteUser(Long user_id);

	public TBL_User getUserByID(Long user_id);
	
	public TBL_User checkAccount(String account, String password);

	int getSizeUser();
}
