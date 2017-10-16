package com.blog.test.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blog.dao.Post_extendsMapper;
import com.blog.pojo.Post_extends;

@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@Service
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Post_extendsMapperTest {
	@Autowired
	private Post_extendsMapper post_extendsMapper;
	@Test
	public void updateBrowserByPostIdTest() {
		System.out.println(post_extendsMapper.updateBrowserByPostId(22));
		Assert.assertTrue(post_extendsMapper.updateBrowserByPostId(22));
	}
	@Test
	public void updateCollectByPostIdTest() {
		Assert.assertTrue(post_extendsMapper.updateCollectByPostId(22));
	}
	@Test
	public void updatePraiseByPostIdTest() {
		Assert.assertTrue(post_extendsMapper.updatePraiseByPostId(22));	
	}
		
	@Test
	public void updateCommentByPostIdTest() {
		Assert.assertTrue(post_extendsMapper.updateCommentByPostId(22));
	}
	@Test
	public void insertTest() {
		System.out.println(post_extendsMapper.insert(new Post_extends()));
		
		System.out.println(post_extendsMapper.insert(new Post_extends(59,2,2,2,2,2)));
	}
	@Test
	public void insertSelectiveTest() {
		System.out.println(post_extendsMapper.insertSelective(new Post_extends(60,1,2,3,4,5)));
	}
	@Test
	public void selectByPrimaryKeyTest() {
		System.out.println(post_extendsMapper.selectByPrimaryKey(44));
	}
	@Test
	public void deleteByPrimaryKeyTest() {
		System.out.println(post_extendsMapper.deleteByPrimaryKey(61));
	}
	@Test
	public void deleteByPostIdTest() {
		System.out.println(post_extendsMapper.deleteByPostId(2));
	}		
}
