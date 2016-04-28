package com.achievo.springmvc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.achievo.springmvc.dao.UserInfoDao;
import com.achievo.springmvc.entity.UserInfo;
import com.achievo.springmvc.service.UserInfoService;

@Component
public class UserInfoServiceImpl implements UserInfoService {
	
	@Resource
	private UserInfoDao dao;

	@Override
	public void addUser(UserInfo user) {
		this.dao.addUser(user);
	}

	@Override
	public UserInfo getUserById(int userId) {
		return this.dao.getUserById(userId);
	}

	@Override
	public void deleteUser(int userId) {
		this.dao.deleteUser(userId);
	}

}
