package com.blog.service.impl;

import java.util.Date;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blog.dao.UserMapper;
import com.blog.pojo.User;
import com.blog.service.UserService;
import com.blog.utils.MD5Util;
import com.blog.utils.DateUtil;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	//登录验证
	@Override
	public User checkPassword(String username,String password) {
		password = MD5Util.string2MD5(password);
		User user = userMapper.checkUsername(username);			
		if (user!=null&&user.getPasswordHash().equals(password)) {
			return user;
		}else
			return null;	
	}

	//添加用户
	@Override
	public void addUser(User user) {
		user.setPasswordHash(MD5Util.string2MD5(user.getPasswordHash()));
		user.setCreatedAt(DateUtil.dateToStamp(new Date()));
		user.setUpdatedAt(DateUtil.dateToStamp(new Date()));
		userMapper.insertSelective(user);

	}

	//判断用户是否有权限操作
	@Override
	public void checkStatus(String username) {
		// TODO Auto-generated method stub
		short status = userMapper.checkStatus(username);
		if(status==1) {
			System.out.println("允许操作");
		}else if(status==0) {
			System.out.println("不允许操作");
		}
	}

}
