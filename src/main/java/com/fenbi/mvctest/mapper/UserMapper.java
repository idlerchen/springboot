package com.fenbi.mvctest.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fenbi.mvctest.entity.User;


public interface UserMapper {
	
	
	public void insert(User user);
	
	public List<User> select();
	
	public User selectBynameandpwd(@Param("username")String username,@Param("password")String password);

	

}
