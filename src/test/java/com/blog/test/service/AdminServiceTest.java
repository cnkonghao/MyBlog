package com.blog.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blog.pojo.Admin;
import com.blog.service.impl.AdminServiceImpl;

@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@Service
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AdminServiceTest {

	@Autowired
	private AdminServiceImpl adminService;
	
	@Test
	public void checkPasswordTest(){
		Admin admin = new Admin();
		admin.setUsername("yuchu");
		admin.setPasswordHash("123456");
	
		System.out.println(adminService.checkPassword(admin));
	}
}
