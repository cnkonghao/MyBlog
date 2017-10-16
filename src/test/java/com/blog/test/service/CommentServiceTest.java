package com.blog.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blog.pojo.Comment;
import com.blog.service.impl.CommentServiceImpl;

@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@Service
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CommentServiceTest {

	@Autowired
	private CommentServiceImpl commentServiceImpl;
	
	@Test
	public void addCommentTest(){
		commentServiceImpl.addComment(new Comment(20,22,22,"22","22"));
	}
	
	@Test
	public void getCommentByPostIdTest(){
		System.out.println(commentServiceImpl.getCommentByPostId(111));
	}
}
