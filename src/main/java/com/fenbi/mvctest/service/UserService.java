package com.fenbi.mvctest.service;

import java.util.List;

import com.fenbi.mvctest.entity.User;


public interface UserService {
	
	public void insert(User user);
	
	public List<User> select();
	
	public User selectBynameandpwd(String username,String password);
	
}
