package com.blog.dao;

import java.util.List;

import com.blog.pojo.Posts;

public interface PostsMapper {

	Posts selectByPrimaryKey(Integer id); //根据主键id查询
	
	Posts selectByTitle(String title); //根据主键id查询

	Posts selectByCreated(Integer created_at);//根据创建时间查询
	
	Posts selectInfoByPostId(Integer id);//根据文章id查找文章概要信息

	List<Posts> selectByCatId(Integer catId);//根据分类id查询
	
	List<Posts> selectAll();//查询全部合法和不合法文章

	List<Posts> selectAllInfo();  //查询首页的文章

	List<Posts> selectValid();//查询所有合法文章

	List<Posts> selectNewPosts();//查询最新的六篇文章

	List<Posts> selectTopBrowserPost();//查询浏览量最多前三的文章

	int insert(Posts record);//添加（可为空）

	int insertSelective(Posts record);//添加（不可为空）

	int deleteByPrimaryKey(Integer id);//根据id删除

	int updateByPrimaryKeySelective(Posts record);

	int updateByPrimaryKeyWithBLOBs(Posts record);

	int updateByPrimaryKey(Posts record);

	int update(Posts record);//修改

}