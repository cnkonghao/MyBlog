package com.blog.test.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blog.dao.CommentMapper;
import com.blog.pojo.Comment;

@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@Service
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CommentMapperTest {
	@Autowired
	private CommentMapper commentMapper;
	@Test
	public void selectByPrimaryKeyTest() {
		System.out.println(commentMapper.selectByPrimaryKey(10));
		Assert.assertNotNull(commentMapper.selectByPrimaryKey(10));
	}
	@Test
	public void selectByPostIdTest(){
		System.out.println(commentMapper.selectByPostId(26));
		Assert.assertNotNull(commentMapper.selectByPostId(26));
	}
	@Test
	public void insertSelectiveTset(){
		System.out.println(commentMapper.insert(new Comment(15,123,321,"123","123")));
		
		System.out.println(commentMapper.insert(new Comment()));
	}
	@Test
	public void deleteByPrimaryKeyTset(){
		System.out.println(commentMapper.deleteByPrimaryKey(16));
	}
	@Test
	public void insertTset(){
		System.out.println(commentMapper.insertSelective(new Comment(18,111,222,"333","444")));
	}
	@Test
	public void updateTset(){
		System.out.println(commentMapper.updateByPrimaryKeySelective(new Comment(17,444,555,"666","777")));
		
		System.out.println(commentMapper.updateByPrimaryKey(new Comment(17,444,555,"777")));
		
		System.out.println(commentMapper.updateByPrimaryKeyWithBLOBs(new Comment(17,999,555,"666","777")));
	}
}
