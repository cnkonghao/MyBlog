package com.blog.service;

import java.util.List;

import com.blog.pojo.Feeds;
import com.blog.pojo.Posts;
import com.github.pagehelper.PageInfo;

public interface PostService {

	public Posts getPostById(int id); //根据文章ID查出合法文章全部信息
	
	public List<Posts> listAll();//查询所有文章
	
	public List<Posts> listFirstAll();//查询首页的合法文章
	
	public List<Posts> listValidPosts();//查询全部的合法和不合法文章
	
	public List<Posts> listNewPosts();//查询最新的六篇文章
	
	public List<Posts> listTopPosts();//查询可见的浏览量最多的三篇文章
	
	public int changeValid(int id);//将合法文章修改成不合法，不可读
	
	public void addPost(Posts posts); //添加文章
	
	public boolean deletePost(int id); //删除文章
	
	public List<Posts> getPostByTagId(int id);//根据标签查出文章
	
	/**
	 * 分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Posts> queryByPage(Integer pageNo,Integer pageSize);
	
}
