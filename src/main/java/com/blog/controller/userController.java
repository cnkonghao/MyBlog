package com.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.blog.pojo.Admin;
import com.blog.pojo.User;
import com.blog.service.impl.UserServiceImpl;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

/**
 * 用户登陆注册
 * @author Administrator
 *
 */

@Controller
@SessionAttributes({"loginUser","username"})
public class userController {
	
	@Autowired
	private UserServiceImpl UserServiceImpl;

	@RequestMapping("/lands")
	public String login() {
		return "land";
	}
	
	//登录界面
	@RequestMapping("/dolands")
	public String dologin(User user,Model model){
		User user2 = UserServiceImpl.checkPassword(user.getUsername(),user.getPasswordHash());
		if (user2==null) {
			return "error";
		}else{
			model.addAttribute("loginUser",user2);
			model.addAttribute("username",user2.getUsername());
			return "redirect:/feels";
		}
	}
	
	//注册界面
	@RequestMapping("/enrolls")
	public String doroll() {	
		return "enroll";
	}
	
	//注册操作
	@RequestMapping(value="/doenroll",method=RequestMethod.POST)
	public String doenroll(User user,SessionStatus sessionStatus,Model model) {
		UserServiceImpl.addUser(user);
		model.addAttribute("loginUser",user);
		model.addAttribute("username",user.getUsername());
		return "redirect:/feels";
	}
	//退出
	@RequestMapping("/landout")
	public String landout(HttpSession session,SessionStatus sessionStatus) {
		session.removeAttribute("loginadmin");
		session.removeAttribute("username");
		sessionStatus.setComplete();
		return "redirect:/feels";
	}

}
