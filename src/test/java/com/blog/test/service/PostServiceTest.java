package com.blog.test.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blog.pojo.Posts;
import com.blog.service.impl.PostServiceImpl;

@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@Service
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class PostServiceTest {
	
	@Autowired
	private PostServiceImpl postServiceImpl;
	
	@Test
	public void getPostByIdTest() {
		System.out.println(postServiceImpl.getPostById(24));
	}
	
	@Test
	public void listAllTest() {
		System.out.println(postServiceImpl.listAll());
	}
	
	@Test
	public void listFirstAllTest() {
		System.out.println(postServiceImpl.listFirstAll());
	}
	
	@Test
	public void listValidPostsTest() {
		System.out.println(postServiceImpl.listValidPosts());
	}
	
	@Test
	public void listNewPostsTest() {
		System.out.println(postServiceImpl.listNewPosts());
	}
	
	@Test
	public void changeValidTest() {
		System.out.println(postServiceImpl.changeValid(31));
	}
	
	@Test
	public void addPostTest() {
		postServiceImpl.addPost(new Posts(34,"32222","1","1",1,1,"1",true,"1","1","1"));
	}
	
	@Test
	public void deletePostTest() {
		postServiceImpl.deletePost(34);
	}
	
	@Test
	public void getPostByTagIdTest(){
		System.out.println(postServiceImpl.getPostByTagId(14));
	}
}
