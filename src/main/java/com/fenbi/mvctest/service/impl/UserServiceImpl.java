package com.fenbi.mvctest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenbi.mvctest.entity.User;
import com.fenbi.mvctest.mapper.UserMapper;
import com.fenbi.mvctest.service.UserService;


/**
 * 当前Service将会被加入Spring容器
 * @author durh
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper usermapper;

	@Override
	public void insert(User user) {
		usermapper.insert(user);
		
	}

	@Override
	public List<User> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectBynameandpwd(String username, String password) {
		return usermapper.selectBynameandpwd(username, password);
	}
	

}







