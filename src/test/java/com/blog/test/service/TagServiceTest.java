package com.blog.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blog.service.impl.TagsServiceImpl;

@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@Service
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TagServiceTest {

	@Autowired
	private TagsServiceImpl tagsServiceImpl;
	
	@Test
	public void selectByTagNameTest(){
		tagsServiceImpl.selectByTagName("java");
	}
}
