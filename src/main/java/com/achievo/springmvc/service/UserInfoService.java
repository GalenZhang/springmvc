package com.achievo.springmvc.service;

import com.achievo.springmvc.entity.UserInfo;

public interface UserInfoService {

	void addUser(UserInfo user);
	
	UserInfo getUserById(int userId);
	
	void deleteUser(int userId);
}
