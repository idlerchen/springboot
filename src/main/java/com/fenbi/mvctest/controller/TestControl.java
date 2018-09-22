package com.fenbi.mvctest.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fenbi.mvctest.entity.Course;
import com.fenbi.mvctest.entity.FenbiResult;
import com.fenbi.mvctest.entity.User;
import com.fenbi.mvctest.mapper.UserMapper;
import com.fenbi.mvctest.service.CourseService;
import com.fenbi.mvctest.service.UserService;

@Controller
public class TestControl {
	
	@Autowired   //将会从spring容器中找到合适的javabean对象直接注入该属性中
	private CourseService courseService;
	@Autowired
	private UserService userService;
	
//	@RequestMapping("/list")
//	@ResponseBody
//	public FenbiResult list (Model model){
//		List<Course> courses = courseService.findAll();
//		return new FenbiResult(0,"OK",courses);
//	}
	
	/**
	 * 测试响应重定向
	 * @return
	 */
	@RequestMapping("/baidu")
	public String redirect() {
		return "redirect:/listNames.do";
	}
	
	/**
	 * 测试请求转发
	 * @param model
	 * @return
	 */
	@RequestMapping("/listNames")
	public String listNames(Model model) {
		List<String> names = new ArrayList<>();
		names.add("Tom");
		names.add("Jerry");
		names.add("Lily");
		names.add("Lucy");
		names.add("Hanmeimei");
		//使用springmvc自带的Model机制，在转发过程中进行数据的传递：
		model.addAttribute("list", names);
		return "names";
	}
	
	@RequestMapping("/register.do")
	@ResponseBody
	public FenbiResult insert(User user) {
		
		userService.insert(user);
		return new FenbiResult(0, "OK", null);
	}
	
	@RequestMapping("/login.do")
	@ResponseBody
	public FenbiResult select(String username,String password) {
		
		User user1 = userService.selectBynameandpwd(username,password);
		if(user1!=null)
			return new FenbiResult(0, "OK", null);
		return new FenbiResult(1, "fail", null);
	}
	
//	@RequestMapping(value="/hello.do",produces="text/html;charset=utf-8")
//	@ResponseBody
//	public String insert(User user) {
//		
//		InputStream is = TestControl.class.getClassLoader().getResourceAsStream("mybatis.xml");
//		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
//		SqlSession sql = fac.openSession();
//		UserMapper userMapper = sql.getMapper(UserMapper.class);
//		userMapper.insert(user);
//		sql.commit();
//		sql.close();
//		return "注册成功";
//	}
//	
//	@RequestMapping(value="/login.do",produces="text/html;charset=utf-8")
//	@ResponseBody
//	public String select(String username,String password) {
//		
//		InputStream is = TestControl.class.getClassLoader().getResourceAsStream("mybatis.xml");
//		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
//		SqlSession sql = fac.openSession();
//		UserMapper userMapper = sql.getMapper(UserMapper.class);
//		User user1 = userMapper.selectBynameandpwd(username,password);
//		System.out.println(user1);
//		sql.close();
//		if(user1!=null)
//			return "登录成功";
//		return "fail";
//	}

}
