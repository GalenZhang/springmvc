package com.achievo.springmvc.dao;

import org.springframework.stereotype.Repository;

import com.achievo.springmvc.entity.UserInfo;

@Repository
public interface UserInfoDao {
	void addUser(UserInfo user);

	UserInfo getUserById(int userId);
	
	void deleteUser(int userId);
}
