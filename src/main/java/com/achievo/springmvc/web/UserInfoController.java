package com.achievo.springmvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.achievo.springmvc.entity.UserInfo;
import com.achievo.springmvc.service.UserInfoService;

@Controller
public class UserInfoController {

	private final String LIST = "redirect:/user/detail";

	@Autowired
	private UserInfoService service;

	/**
	 * 跳转至添加页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/user/toAdd", method = RequestMethod.GET)
	public ModelAndView toAdd() {
		return new ModelAndView("user/add");
	}

	/**
	 * 保存
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public ModelAndView add(UserInfo user) throws Exception {
		service.addUser(user);
		return new ModelAndView("user/add");
	}

	/**
	 * 根据ID删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/user/delete/{id}")
	public ModelAndView delete(@PathVariable int id) throws Exception {
		service.deleteUser(id);
		return new ModelAndView(LIST);
	}
}
