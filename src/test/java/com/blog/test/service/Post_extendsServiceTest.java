package com.blog.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blog.pojo.Post_extends;
import com.blog.service.impl.Post_extendsServiceImpl;

@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@Service
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Post_extendsServiceTest {

	@Autowired
	private Post_extendsServiceImpl post_extendsServiceImpl;
	
	@Test
	public void postBrowserAddTest(){
		post_extendsServiceImpl.postBrowserAdd(1);
	}
	
	@Test
	public void postCollectAddTest(){
		post_extendsServiceImpl.postCollectAdd(1);
	}
	
	@Test
	public void postPraiseAddTest(){
		post_extendsServiceImpl.postPraiseAdd(1);
	}
	
	@Test
	public void postCommentAddTest(){
		post_extendsServiceImpl.postCommentAdd(1);
	}
	
	@Test
	public void getPostextendsByIdTest(){
		System.out.println(post_extendsServiceImpl.getPostextendsById(43));
	}
	
	@Test
	public void addPostextendsByIdTest(){
		post_extendsServiceImpl.addPostextends(new Post_extends(61,1,2,3,4,5));
	}
	
	@Test
	public void deletePostextendsByIdTest(){
		post_extendsServiceImpl.deletePostextends(61);
	}
}
