package com.blog.test.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blog.dao.PostsMapper;
import com.blog.pojo.Posts;

@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@Service
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class PostMapperTest {
	@Autowired
	private PostsMapper postsMapper;
	@Test
	public void selectByPrimaryKeyTest() {
		System.out.println(postsMapper.selectByPrimaryKey(24));
		Assert.assertNotNull(postsMapper.selectByPrimaryKey(24));
	}
	@Test
	public void selectByCreatedTest() {
		System.out.println(postsMapper.selectByCreated(1491456245));
		Assert.assertNotNull(postsMapper.selectByCreated(1491456245));
	}
	@Test
	public void selectByCatIdTest() {
		System.out.println(postsMapper.selectByCatId(1));
	}
	@Test
	public void selectInfoByPostIdTest() {
		System.out.println(postsMapper.selectInfoByPostId(25));
	}
	@Test
	public void selectValidTest() {
		System.out.println(postsMapper.selectValid());
	}
	@Test
	public void insertTest() {
		System.out.println(postsMapper.insert(new Posts(28,"1","1","1",1,1,"1",true,"1","1","1")));
	}
	@Test
	public void insertSelectiveTest() {
		System.out.println(postsMapper.insertSelective(new Posts(33,"2","1","1",1,1,"1",true,"1","1","1")));
	}	
	@Test
	public void deleteByPrimaryKeyTest() {
		System.out.println(postsMapper.deleteByPrimaryKey(30));
		Assert.assertNotNull(postsMapper.deleteByPrimaryKey(30));
	}	
	@Test
	public void updateTest() {
		System.out.println(postsMapper.updateByPrimaryKey(new Posts(29,"33","33","1",1,1,"1",true,"1","1","1")));
		
		System.out.println(postsMapper.updateByPrimaryKeySelective(new Posts(31,"22222")));

		System.out.println(postsMapper.update(new Posts(31, "55555","1","1",1,1,"1",true,"1","1","1")));	
	}	
	@Test
	public void selectAllInfoTest() {
		System.out.println(postsMapper.selectAllInfo());
	}	
	@Test
	public void selectNewPostsTest() {
		System.out.println(postsMapper.selectNewPosts());
	}
	@Test
	public void selectTopBrowserPostTest() {
		System.out.println(postsMapper.selectTopBrowserPost());
	}	
	@Test
	public void selectByTitleTest(){
		Assert.assertNotNull(postsMapper.selectByTitle("2222"));
	}

}
