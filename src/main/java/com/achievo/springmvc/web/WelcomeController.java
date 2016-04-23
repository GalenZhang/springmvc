package com.achievo.springmvc.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.achievo.springmvc.entity.Admin;
import com.achievo.springmvc.entity.User;
import com.achievo.springmvc.entity.UserListForm;
import com.achievo.springmvc.entity.UserMapForm;
import com.achievo.springmvc.entity.UserSetForm;
import com.achievo.springmvc.service.HelloWorldService;

@Controller
public class WelcomeController {

	private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
	private final HelloWorldService helloWorldService;

	@Autowired
	public WelcomeController(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {

		logger.debug("index() is executed!");

		model.put("title", helloWorldService.getTitle(""));
		model.put("msg", helloWorldService.getDesc());

		return "index";
	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		logger.debug("hello() is executed - $name {}", name);

		ModelAndView model = new ModelAndView();
		model.setViewName("index");

		model.addObject("title", helloWorldService.getTitle(name));
		model.addObject("msg", helloWorldService.getDesc());

		return model;

	}

	@RequestMapping(value = "/baseType.do", method = RequestMethod.GET)
	@ResponseBody
	public String baseType(int age) {
		return "age: " + age;
	}
	
	@RequestMapping(value = "/baseType2.do", method = RequestMethod.GET)
	@ResponseBody
	public String baseType2(Integer age) {
		return "age: " + age;
	}

//	http://localhost:8080/spring4/array.do?name=Lucky&name=James
	@RequestMapping(value = "/array.do")
	@ResponseBody
	public String array(String[] name) {
		StringBuilder sb = new StringBuilder();
		for (String item : name) {
			sb.append(item).append(" ");
		}
		return sb.toString();
	}
	
//	http://localhost:8080/spring4/object.do?name=Lucky&age=20
//	http://localhost:8080/spring4/object.do?name=Lucky&age=20&contactInfo.address=ShenZhen
//	http://localhost:8080/spring4/object.do?name=Lucky&age=20
//	http://localhost:8080/spring4/object.do?user.name=Lucky&age=20&admin.name=James
	@RequestMapping(value = "/object.do")
	@ResponseBody
	public String object(User user, Admin admin) {
		return user.toString() + "  " + admin.toString();
	}
	
	@InitBinder("user")
	public void initUser(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("user.");
	}
	
	@InitBinder("admin")
	public void initAdmin(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("admin.");
	}
	
//	http://localhost:8080/spring4/list.do?users[0].name=Lucky&users[0].age=20&users[1].name=James&users[1].age=25
//	http://localhost:8080/spring4/list.do?users[0].name=Lucky&users[0].age=20&users[10].name=James&users[10].age=25
	@RequestMapping(value = "/list.do")
	@ResponseBody
	public String list(UserListForm userListForm) {
		return "listSize:" + userListForm.getUsers().size() + "; " +userListForm.toString();
	}
	
//	http://localhost:8080/spring4/set.do?users[0].name=Lucky&users[1].name=James
	@RequestMapping(value = "/set.do")
	@ResponseBody
	public String set(UserSetForm userSetForm) {
		return userSetForm.toString();
	}
	
//	http://localhost:8080/spring4/map.do?users['X'].name=Lucky&users['Y'].name=James
	@RequestMapping(value = "/map.do")
	@ResponseBody
	public String map(UserMapForm userMapForm) {
		return userMapForm.toString();
	}
	
//	{
//		"name":"Jim",
//		"age":25,
//		"contactInfo":{
//			"address":"beijing",
//			"phone":"10010"
//		}
//	}
	@RequestMapping(value = "/json.do")
	@ResponseBody
	public String json(@RequestBody User user) {
		return user.toString();
	}
	
//	<admin>
//		<name>Jim</name>
//		<age>25</age>
//	</admin>
	@RequestMapping(value = "/xml.do")
	@ResponseBody
	public String xml(@RequestBody Admin admin) {
		return admin.toString();
	}
	
//	http://localhost:8080/spring4/converter.do?bool=yes
//	http://localhost:8080/spring4/converter.do?bool=on
//	http://localhost:8080/spring4/converter.do?bool=1
	@RequestMapping(value = "/converter.do")
	@ResponseBody
	public String converter(Boolean bool) {
		return bool.toString();
	}
	
//	http://localhost:8080/spring4/date1.do?date1=2016-05-01
	@RequestMapping(value = "/date1.do")
	@ResponseBody
	public String date1(Date date1) {
		return date1.toString();
	}
	
	@InitBinder("date1")
	public void initDate1(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, 
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
//	http://localhost:8080/spring4/book
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	@ResponseBody
	public String book(HttpServletRequest request) {
		String contentType = request.getContentType();
		String result = "book.default";
		if ("txt".equals(contentType)) {
			result = "book.txt";
		} else if ("html".equals(contentType)) {
			result = "book.html";
		}
		return result;
	}
	
	@RequestMapping(value = "/subject/{subjectId}", method = RequestMethod.GET)
	@ResponseBody
	public String subjectGet(@PathVariable("subjectId") String subjectId) {
		return "this is a get method, subjectId: " + subjectId;
	}
	
	@RequestMapping(value = "/subject/{subjectId}", method = RequestMethod.POST)
	@ResponseBody
	public String subjectPost(@PathVariable("subjectId") String subjectId) {
		return "this is a post method, subjectId: " + subjectId;
	}
	
	@RequestMapping(value = "/subject/{subjectId}", method = RequestMethod.PUT)
	@ResponseBody
	public String subjectPut(@PathVariable("subjectId") String subjectId) {
		return "this is a put method, subjectId: " + subjectId;
	}
	
	@RequestMapping(value = "/subject/{subjectId}", method = RequestMethod.DELETE)
	@ResponseBody
	public String subjectDelete(@PathVariable("subjectId") String subjectId) {
		return "this is a delete method, subjectId: " + subjectId;
	}
}
