package com.varxyz.jv300.mod010;

import java.util.List;


public class UserService {
	public UserDao userDao;
	
	public UserService(UserDao userDao) {
		this.userDao = userDao;		
	}

	public void addUser(User user) {
		userDao.userUpload(user);
	}
	
	public List<User> findUser() {
		return userDao.findAllUsers();
	}


	public boolean isValidUser(String userId, String passwd) {
		return userDao.isValidUser(userId, passwd);
	}

}
