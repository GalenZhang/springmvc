package com.achievo.springmvc.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.achievo.springmvc.entity.UserInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:springmvc-servlet.xml", "classpath:mybatisDaoSource.xml" })
public class MyBatisTestBySpringTestFramework {

	@Autowired
	private UserInfoService service;
	
	@Test
	public void testAddUser() {
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername("zhangsan");
		userInfo.setPassword("12346");
		service.addUser(userInfo);
	}
}
