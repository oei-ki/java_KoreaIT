package com.varxyz.jv300.mod009;

import java.util.List;

public class UserService {
	private static UserService service = new UserService();//싱글톤
	public UserDao userDao;
	
	public UserService(UserDao userDao) {
		this.userDao = userDao;		
	}
	
	public UserService() {
	
	}

	public void addUser(User user) {
		userDao.userUpload(user);
	}
	
	public List<User> findUser() {
		return userDao.findAllUsers();
	}
	
	public static UserService getInstance() {
		return service;
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


}
